package filereader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class TxtFileReader implements FileReader {

    private final String SLASH = "/";
    private final String fileName;

    public TxtFileReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getFileContext() {
        return getBufferedReaderFromFile(fileName)
                .lines()
                .collect(
                        Collectors.joining(System.lineSeparator())
                );
    }

    private BufferedReader getBufferedReaderFromFile(String fileName) {
        return new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(SLASH + fileName)));
    }

}
