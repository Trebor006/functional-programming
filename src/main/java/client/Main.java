package client;


import filereader.FileReaderFactory;
import wordfrequency.WordsFrequency;

public class Main {

    public static void main(String[] args) {
        WordsFrequency.printCalculateWordsFrequency(
                FileReaderFactory
                        .getFileReader("words.txt")
                        .getFileContext()
        );
    }

}
