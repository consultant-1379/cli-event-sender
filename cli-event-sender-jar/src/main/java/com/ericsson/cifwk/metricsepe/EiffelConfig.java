package com.ericsson.cifwk.metricsepe;

import com.ericsson.duraci.configuration.EiffelConfiguration;
import com.ericsson.duraci.datawrappers.Arm;
import com.ericsson.duraci.datawrappers.Credentials;
import com.ericsson.duraci.datawrappers.MessageBus;
import com.ericsson.duraci.datawrappers.MessageSendQueue;

import java.util.Collections;
import java.util.Map;

public class EiffelConfig implements EiffelConfiguration {
    private final String domainId;
    private final String exchangeName;
    private final String messageBusHostName;
    private final MessageSendQueue messageSendQueue;
    private final Credentials credentials;

    public EiffelConfig(String domainId, String exchangeName, String messageBusHostName, Credentials credentials) {
        this.domainId = domainId;
        this.exchangeName = exchangeName;
        this.messageBusHostName = messageBusHostName;
        this.messageSendQueue = new MessageSendQueue((Integer)null);
        this.credentials = credentials;
    }

    public Map<String, Arm> getArms() {
        return Collections.emptyMap();
    }

    public MessageBus getMessageBus() {
        return new MessageBus(this.messageBusHostName, this.exchangeName, null, false, credentials);
    }

    public String getDomainId() {
        return this.domainId;
    }

    public MessageSendQueue getMessageSendQueue() {
        return this.messageSendQueue;
    }

}
