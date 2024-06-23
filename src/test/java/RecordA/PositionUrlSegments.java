package RecordA;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "aw_0_ais.adBreakIndex",
        "aw_0_ais.nextEventMs"
})

public class PositionUrlSegments {
    @JsonProperty("aw_0_ais.adBreakIndex")
    public List<String> aw0AisAdBreakIndex;
    @JsonProperty("aw_0_ais.nextEventMs")
    public List<String> aw0AisNextEventMs;
}
