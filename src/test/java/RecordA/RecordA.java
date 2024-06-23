package RecordA;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "downloadIdentifier",
        "opportunities",
        "agency",
        "deviceType",
        "country",
        "city",
        "listenerId"
})

public class RecordA {
    @JsonProperty("downloadIdentifier")
    public DownloadIdentifier downloadIdentifier;
    @JsonProperty("opportunities")
    public List<Opportunity> opportunities;
    @JsonProperty("agency")
    public Integer agency;
    @JsonProperty("deviceType")
    public String deviceType;
    @JsonProperty("country")
    public String country;
    @JsonProperty("city")
    public String city;
    @JsonProperty("listenerId")
    public String listenerId;
}
