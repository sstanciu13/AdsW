package RecordA;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "originalEventTime",
        "maxDuration",
        "zones",
        "positionUrlSegments",
        "insertionRate"
})

public class Opportunity {
    @JsonProperty("originalEventTime")
    public Long originalEventTime;
    @JsonProperty("maxDuration")
    public Integer maxDuration;
    @JsonProperty("zones")
    public Zones zones;
    @JsonProperty("positionUrlSegments")
    public PositionUrlSegments positionUrlSegments;
    @JsonProperty("insertionRate")
    public Integer insertionRate;
}
