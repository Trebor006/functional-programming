package filereader;

public class FileReaderFactory {

    private static final String EXTENSION_TXT = ".txt";

    public static FileReader getFileReader(String fileName) {
        if (fileName.endsWith(EXTENSION_TXT)) {
            return new TxtFileReader(fileName);
        }

        return getDefaultFileReader(fileName);
    }

    private static FileReader getDefaultFileReader(String fileName) {
        return new TxtFileReader(fileName);
    }

}
