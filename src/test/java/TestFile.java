import RecordA.RecordA;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.FileLoader;
import utils.RecordObjParser;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TestFile {
    List<RecordA> recordObjs;

    @BeforeSuite
    public void beforeSuite() throws IOException {
        File recordFile = FileLoader.loadFile("downloads.txt");

        RecordObjParser<RecordA> recordObjParser = new RecordObjParser<>(recordFile, RecordA.class);
        recordObjs = recordObjParser.parseRecordObj();
    }

    @Test
    public void testMostListenedShowInSanFrancisco() {
        String expectedShow = "Who Trolled Amber";
        int expectedNumberOfDownloads = 24;

        Map<String, Long> showsInSanFrancisco = recordObjs
                .stream()
                .filter(record -> record.city.equals("san francisco"))
                .collect(Collectors.groupingBy(recordA -> recordA.downloadIdentifier.showId, Collectors.counting()));

        Map.Entry<String, Long> mostPopularShowInSanFrancisco = showsInSanFrancisco
                .entrySet().stream()
                .max(Comparator.comparing(entry -> entry.getValue()))
                .orElse(new AbstractMap.SimpleEntry<>("NOT_FOUND", -1L));

        System.out.println("Most popular show is: " + mostPopularShowInSanFrancisco.getKey());
        System.out.println("Number of downloads is: " + mostPopularShowInSanFrancisco.getValue());

        Assert.assertEquals(mostPopularShowInSanFrancisco.getKey(), expectedShow);
        Assert.assertEquals(mostPopularShowInSanFrancisco.getValue(), expectedNumberOfDownloads);
    }

    @Test
    public void testMostUsedDevice() {
        String expectedDevice = "mobiles & tablets";
        int expectedNumberOfDownloads = 60;

        Map<String, Long> devicesUsed = recordObjs
                .stream()
                .collect(Collectors.groupingBy(recordA -> recordA.deviceType, Collectors.counting()));

        Map.Entry<String, Long> mostUsedDevice = devicesUsed
                .entrySet().stream()
                .max(Comparator.comparing(entry -> entry.getValue()))
                .orElse(new AbstractMap.SimpleEntry<>("NOT_FOUND", -1L));

        System.out.println("Most popular device is: " + mostUsedDevice.getKey());
        System.out.println("Number of downloads is: " + mostUsedDevice.getValue());

        Assert.assertEquals(mostUsedDevice.getKey(), expectedDevice);
        Assert.assertEquals(mostUsedDevice.getValue(), expectedNumberOfDownloads);
    }

    @Test
    public void testPrerollOpportunities() {
        Map<String, Long> expectedResults = new HashMap<>() {{
            put("Stuff You Should Know", 40L);
            put("Who Trolled Amber", 40L);
            put("Crime Junkie", 30L);
            put("The Joe Rogan Experience", 10L);
        }};

        Map<String, Long> showIdToPrerollCount = recordObjs.stream()
                .collect(Collectors.groupingBy(
                        record -> record.downloadIdentifier.showId,
                        Collectors.summingLong(record -> record.opportunities.stream()
                                .flatMap(opportunity -> opportunity.positionUrlSegments.aw0AisAdBreakIndex.stream())
                                .filter("preroll"::equals)
                                .count()
                        )
                ));

        List<Map.Entry<String, Long>> showIdToPrerollCountSorted = showIdToPrerollCount
                .entrySet().stream()
                .sorted((el1, el2) -> el2.getValue().compareTo(el1.getValue()))
                .collect(Collectors.toList());

        showIdToPrerollCountSorted.forEach(entry ->
                System.out.println("Show Id: " + entry.getKey() + ", Preroll Opportunity Number: " + entry.getValue())
        );

        Assert.assertEquals(showIdToPrerollCountSorted.size(), expectedResults.size());

        for (int i = 0; i < expectedResults.size() - 1; i++) {
            Assert.assertEquals(
                    expectedResults.get(showIdToPrerollCountSorted.get(i).getKey()),
                    showIdToPrerollCountSorted.get(i).getValue());
        }
    }
}
