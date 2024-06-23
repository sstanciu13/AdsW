package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecordObjParser<T> {
    private final File file;
    private final ObjectMapper om;
    private final Class<T> type;

    public RecordObjParser(File file, Class<T> type) {
        this.file = file;
        this.type = type;
        this.om = new ObjectMapper();
    }

    public List<T> parseRecordObj() throws IOException {
        List<T> recordObjs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                T recordObj = om.readValue(line, type);
                recordObjs.add(recordObj);
            }
        }
        return recordObjs;
    }
}
