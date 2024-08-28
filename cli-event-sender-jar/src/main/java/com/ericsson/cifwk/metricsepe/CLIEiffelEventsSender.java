package com.ericsson.cifwk.metricsepe;

import com.ericsson.duraci.configuration.EiffelConfiguration;
import com.ericsson.duraci.datawrappers.ArtifactGav;
import com.ericsson.duraci.datawrappers.ConfidenceLevels;
import com.ericsson.duraci.datawrappers.Credentials;
import com.ericsson.duraci.eiffelmessage.messages.EiffelEvent;
import com.ericsson.duraci.eiffelmessage.messages.EiffelMessage;
import com.ericsson.duraci.eiffelmessage.messages.events.EiffelConfidenceLevelModifiedEvent;
import com.ericsson.duraci.eiffelmessage.messages.events.EiffelConfigurationNotificationEvent;

import com.ericsson.duraci.eiffelmessage.sending.MessageSender;
import com.ericsson.duraci.eiffelmessage.sending.exceptions.EiffelMessageSenderException;
import com.google.common.base.Throwables;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CLIEiffelEventsSender {

    public static void main(String[] args) throws Exception {

        String arg = Objects.requireNonNull(args[0],"Invalid params for collecting events");
        Cli config = (Cli) JsonParser.getInstance()
                .parseJsonStringToObject(arg, Cli.class);
        System.setProperty("eiffel.net.ssl.enabled", "true");
        Credentials credentials = new Credentials(config.getFunctionalUser(), config.getFunctionalUserPassword());
        EiffelConfig configuration = new EiffelConfig(config.getMessageBusDomain(),
                config.getMessageBusExchange(), config.getMessageBusHost(), credentials);
        Sender sender = new Sender(configuration);
        sender.init();
        switch (config.getMessageType()) {
            case "clme":
                sendCLME(sender, config);
                break;
            case "cne":
                sendCNE(sender, config);
                break;
            default:
                System.exit(0);
                break;
        }
        sender.shutdown();

    }

    private static void sendCLME(Sender sender, Cli config)
            throws InterruptedException {

        ConfidenceLevels confidence = new ConfidenceLevels(
                config.getConfidenceLevel() + ": " + config.getConfidenceLevelState());
        ArtifactGav gav = new ArtifactGav(config.getGroupId(), config.getArtifactId(),
                config.getVersion());

        EiffelConfidenceLevelModifiedEvent clmeEvent = EiffelConfidenceLevelModifiedEvent.Factory
                .create(confidence, gav);
        clmeEvent.setOptionalParameter("team", config.getTeam());
        clmeEvent.setOptionalParameter("ra", config.getRA());
        clmeEvent.setOptionalParameter("kgbStatus", config.getKgbStatus());
        clmeEvent.setOptionalParameter("drop", config.getDrop());
        clmeEvent.setOptionalParameter("product", config.getProduct());
        clmeEvent.setOptionalParameter("release", config.getRelease());
        clmeEvent.setOptionalParameter("artifactsInGroup", config.getArtifactsInGroup());
        clmeEvent.setOptionalParameter("artifactsInQueue", config.getArtifactsInQueue());
        clmeEvent.setOptionalParameter("testwareInGroup", config.getTestwareInGroup());
        clmeEvent.setOptionalParameter("testwareInQueue", config.getTestwareInQueue());
        clmeEvent.setOptionalParameter("groupTeam", config.getGroupTeam());
        clmeEvent.setOptionalParameter("queueId", config.getQueueId());
        clmeEvent.setOptionalParameter("queueLength", config.getQueueLength());
        clmeEvent.setOptionalParameter("timeInQueue", config.getTimeInQueue());
        clmeEvent.setOptionalParameter("missingDependencies", config.getMissingDependencies());
        clmeEvent.setOptionalParameter("deliveryGroupAutoCreated", config.getDeliveryGroupAutoCreated());
        clmeEvent.setOptionalParameter("groupKgbStatus", config.getGroupKgbStatus());
        clmeEvent.setOptionalParameter("modifyCount", config.getModifyCount());
        clmeEvent.setOptionalParameter("detailedKgbStatus", config.getDetailedKgbStatus());
        clmeEvent.setOptionalParameter("testwareGroup", config.getTestwareGroup());
        clmeEvent.setFlowContext(config.getProduct() + "_" + config.getRelease()
                + "_" + config.getDrop());
        sender.send(clmeEvent);

    }

    private static void sendCNE(Sender sender, Cli config)
            throws InterruptedException {

        Map<String, String> configurationMap = new HashMap<String, String>();
        configurationMap.put("product", config.getProduct());
        configurationMap.put("release", config.getRelease());
        configurationMap.put("drop", config.getDrop());
        configurationMap.put("baseline", config.getBaseline());
        configurationMap.put("status", config.getStatus());
        configurationMap.put("endTime", config.getEndTime());
        configurationMap.put("reason", config.getReason());
        EiffelConfigurationNotificationEvent.Action actionEnum = null;
        switch (config.getAction()) {
            case "modified":
                actionEnum = EiffelConfigurationNotificationEvent.Action.MODIFIED;
                break;
            case "new":
                actionEnum = EiffelConfigurationNotificationEvent.Action.NEW;
                break;
            case "deleted":
                actionEnum = EiffelConfigurationNotificationEvent.Action.DELETED;
                break;
            default:
                System.exit(0);
                break;
        }
        EiffelConfigurationNotificationEvent cneEvent = EiffelConfigurationNotificationEvent.Factory.create(config.getComponentType(),config.getComponentInstance(),actionEnum,configurationMap);
        sender.send(cneEvent);

    }

    public static class Sender {

        private final EiffelConfiguration configuration;
        private MessageSender messageSender;

        public Sender(EiffelConfiguration configuration) {
            this.configuration = configuration;
        }

        public void init() {
            messageSender = new MessageSender.Factory(configuration).create();
        }

        public void send(EiffelEvent event) {
            try {
                messageSender.send(createMessage(event));
            } catch (EiffelMessageSenderException e) {
                throw Throwables.propagate(e);
            }
        }

        private EiffelMessage createMessage(EiffelEvent event) {
            String domainId = configuration.getDomainId();
            return EiffelMessage.Factory.create(domainId, event);
        }

        public void shutdown() {
            if (messageSender != null) {
                messageSender.dispose();
            }
        }

    }

}
