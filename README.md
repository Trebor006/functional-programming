# The problem : # 
TLDR: The program to write must calculate words frequency from a given file.
We will provide you a file with some text on it, and you have to open it and find the frequencies of all words in it
having the following requirements:
Assume a valid UTF-8 input file
All words must be processed in lower case (ignore case) Output must be sorted by word frequency by
descendant order
Output must have one entry per word, having its frequency next to it

## Example input: ##
```
Once upon a midnight dreary, while I pondered weak and we ary,
Over many a quaint and curious volume of forgotten lore ....
```

## Example output: ##
```
a 2
and 1
dreary 1
```

---
---


### Quick summary ###
This project is just a sample of functional programming

### Version ### 
0.1

### How do I get set up? ### 
To run this program we must meet the following environment dependencies
 * Java 1.8.0_241 or greater
 * Maven 3.6.3 or greater

### Deployment instructions ### 
This program can be executed by running the following in the project's root folder:
```
mvn exec:java -Dexec.mainClass="client.Main"
```

Also you can execute with an IDE like intelliJ 
just executing the Main class.


You can add a new txt file to the resource folder and update the main class.
You just have to change the getFileReader method parameter to the txt file name and and run the main class or mvn command.

```
WordsFrequency.printCalculateWordsFrequency(
        FileReaderFactory
                .getFileReader("NEW_FILE_NAME.txt")
                .getFileContext()
);
```

cheers and have fun. 