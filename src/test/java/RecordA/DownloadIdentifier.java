package RecordA;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "client",
        "publisher",
        "podcastId",
        "showId",
        "episodeId",
        "downloadId"
})

public class DownloadIdentifier {
    @JsonProperty("client")
    public String client;
    @JsonProperty("publisher")
    public Integer publisher;
    @JsonProperty("podcastId")
    public String podcastId;
    @JsonProperty("showId")
    public String showId;
    @JsonProperty("episodeId")
    public String episodeId;
    @JsonProperty("downloadId")
    public String downloadId;
}
