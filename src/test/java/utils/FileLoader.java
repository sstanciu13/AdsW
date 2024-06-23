package utils;

import java.io.File;

public class FileLoader {
    static final String root = System.getProperty("user.dir");
    static final String fileSeparator = System.getProperty("file.separator");

    public static File loadFile(String fileName) {
        String path = ("_src_test_resources_" + fileName).replace("_", fileSeparator);
        return new File(root + path);
    }
}
