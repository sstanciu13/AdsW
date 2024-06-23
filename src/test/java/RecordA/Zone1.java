package RecordA;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "maxAds",
        "maxDuration"
})

public class Zone1 {
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("maxAds")
    public Integer maxAds;
    @JsonProperty("maxDuration")
    public Integer maxDuration;
}
