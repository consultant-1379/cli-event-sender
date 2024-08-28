package com.ericsson.cifwk.metricsepe;


import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cli {
    private String groupId;
    private String artifactId;
    private String version;
    private String team;
    private String drop;
    private String product;
    private String release;
    private String messageBusExchange;
    private String messageBusHost;
    private String messageBusDomain;
    private String confidenceLevel;
    private String confidenceLevelState;
    private String artifactsInGroup;
    private String groupTeam;
    private String queueId;
    private String queueLength;
    private String timeInQueue;
    private String componentType;
    private String componentInstance;
    private String action;
    private String status;
    private String messageType;
    private String endTime;
    private String baseline;
    private String reason;
    private String artifactsInQueue;
    private String testwareInQueue;
    private String testwareInGroup;
    private String ra;
    private String kgbStatus;
    private String missingDependencies;
    private String groupKgbStatus;
    private String modifyCount;
    private String detailedKgbStatus;
    private String testwareGroup;
    private String deliveryGroupAutoCreated;
    private String functionalUser;
    private String functionalUserPassword;



    @JsonCreator
    public Cli(@JsonProperty("ra") String ra, @JsonProperty("kgbStatus") String kgbStatus,@JsonProperty("testwareInQueue") String testwareInQueue,
               @JsonProperty("testwareInGroup") String testwareInGroup,@JsonProperty("reason") String reason,@JsonProperty("endTime") String endTime,
               @JsonProperty("baseline") String baseline,@JsonProperty("messageType") String messageType,@JsonProperty("componentType") String componentType,
               @JsonProperty("componentInstance") String componentInstance,@JsonProperty("action") String action,@JsonProperty("status") String status,
               @JsonProperty("version") String version,@JsonProperty("groupId") String groupId, @JsonProperty("artifactId") String artifactId,
               @JsonProperty("groupTeam") String groupTeam, @JsonProperty("queueId") String queueId, @JsonProperty("queueLength") String queueLength,
               @JsonProperty("timeInQueue") String timeInQueue, @JsonProperty("artifactsInGroup") String artifactsInGroup, @JsonProperty("confidenceLevelState") String confidenceLevelState,
               @JsonProperty("product") String product, @JsonProperty("drop") String drop, @JsonProperty("team") String team,
               @JsonProperty("release") String release, @JsonProperty("confidenceLevel") String confidenceLevel, @JsonProperty("messageBusExchange") String messageBusExchange,
               @JsonProperty("messageBusDomain") String messageBusDomain, @JsonProperty("missingDependencies") String missingDependencies, @JsonProperty("detailedKgbStatus") String detailedKgbStatus,
               @JsonProperty("modifyCount") String modifyCount, @JsonProperty("groupKgbStatus") String groupKgbStatus, @JsonProperty("testwareGroup") String testwareGroup,
               @JsonProperty("deliveryGroupAutoCreated") String deliveryGroupAutoCreated, @JsonProperty("messageBusUser") String functionalUser, @JsonProperty("messageBusPassword") String functionalUserPassword) {
        this.confidenceLevel = confidenceLevel;
        this.messageBusExchange = messageBusExchange;
        this.messageBusDomain = messageBusDomain;
        this.messageBusHost = messageBusHost;
        this.team = team;
        this.drop = drop;
        this.product = product;
        this.release = release;
        this.confidenceLevelState = confidenceLevelState;
        this.artifactsInGroup = artifactsInGroup;
        this.groupTeam = groupTeam;
        this.queueId = queueId;
        this.queueLength = queueLength;
        this.timeInQueue = timeInQueue;
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.messageType = messageType;
        this.componentType = componentType;
        this.componentInstance = componentInstance;
        this.action = action;
        this.status = status;
        this.baseline = baseline;
        this.endTime = endTime;
        this.reason = reason;
        this.artifactsInQueue = artifactsInQueue;
        this.testwareInQueue = testwareInQueue;
        this.testwareInGroup = testwareInGroup;
        this.ra = ra;
        this.kgbStatus = kgbStatus;
        this.groupKgbStatus = groupKgbStatus;
        this.missingDependencies = missingDependencies;
        this.modifyCount = modifyCount;
        this.detailedKgbStatus = detailedKgbStatus;
        this.testwareGroup = testwareGroup;
        this.deliveryGroupAutoCreated = deliveryGroupAutoCreated;
        this.functionalUser = functionalUser;
        this.functionalUserPassword = functionalUserPassword;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getArtifactId() {
        return this.artifactId;
    }

    public String getVersion() {
        return this.version;
    }

    public String getTeam() {
        return this.team;
    }

    public String getDrop() {
        return this.drop;
    }

    public String getProduct() {
        return this.product;
    }

    public String getRelease() {
        return this.release;
    }

    public String getMessageBusDomain() {
        return this.messageBusDomain;
    }

    public String getMessageBusExchange() {
        return this.messageBusExchange;
    }

    public String getMessageBusHost() {
        return this.messageBusHost;
    }

    public String getConfidenceLevel() {
        return this.confidenceLevel;
    }

    public String getConfidenceLevelState() {
        return this.confidenceLevelState;
    }

    public String getArtifactsInGroup() {
        return this.artifactsInGroup;
    }

    public String getGroupTeam() {
        return this.groupTeam;
    }

    public String getQueueId() {
        return this.queueId;
    }

    public String getQueueLength() {
        return this.queueLength;
    }

    public String getTimeInQueue() {
        return this.timeInQueue;
    }

    public String getComponentType() {
        return this.componentType;
    }

    public String getComponentInstance() {
        return this.componentInstance;
    }

    public String getAction() {
        return this.action;
    }

    public String getStatus() {
        return this.status;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getBaseline() {
        return this.baseline;
    }

    public String getReason() {
        return this.reason;
    }

    public String getArtifactsInQueue() {
        return this.artifactsInQueue;
    }
    public String getTestwareInQueue() {
        return this.testwareInQueue;
    }
    public String getTestwareInGroup() {
        return this.testwareInGroup;
    }
    public String getRA() { return this.ra; }
    public String getKgbStatus() { return this.kgbStatus; }
    public String getMissingDependencies() { return this.missingDependencies; }
    public String getGroupKgbStatus() { return this.groupKgbStatus; }
    public String getModifyCount() { return this.modifyCount; }
    public String getDetailedKgbStatus() { return this.detailedKgbStatus; }
    public String getTestwareGroup() { return this.testwareGroup; }
    public String getDeliveryGroupAutoCreated() { return this.deliveryGroupAutoCreated; }

    public String getFunctionalUser() {
        return functionalUser;
    }

    public String getFunctionalUserPassword() {
        return functionalUserPassword;
    }
}
