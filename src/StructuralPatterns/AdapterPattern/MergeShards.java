package StructuralPatterns.AdapterPattern;

import java.io.BufferedReader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Objective of the exercise:
 *
 * the original code opens many files at once. In order to increase the cleanliness of the code,
 * we can use the Adapter Pattern to simplify that code and manage the opening and closing of all the shard files.
 */

public final class MergeShards {

    public static void main(String[] args) throws Exception{
        String[] paths = {"E:\\JavaNanodegree\\Design_Patterns_in_Java\\src\\StructuralPatterns\\AdapterPattern\\shards",
                "E:\\JavaNanodegree\\Design_Patterns_in_Java\\src\\StructuralPatterns\\AdapterPattern\\sorted2.txt"};
        merge(paths);
    }

    public static void merge(String[] paths) throws Exception {
        if (paths.length != 2) {
            System.out.println("Usage: MergeShards [input folder] [output file]");
            return;
        }

        List<Path> inputs = Files.walk(Path.of(paths[0]), 1).skip(1).collect(Collectors.toList());
        // TODO: Get rid of this List<BufferedReader> and use a MultiFileReader below instead.
        // List<BufferedReader> readers = new ArrayList<>(inputs.size());
        Path outputPath = Path.of(paths[1]);

        // TODO: Replace this try-finally with a try-with-resources. The "try" statement should create
        //       a MultiFileReader that is used in the "try" block to read from the files.
        try (MultiFileReader readers = new MultiFileReader(inputs)){
            /*
            for (Path input : inputs) {
                readers.add(Files.newBufferedReader(input));
            }
             */
            PriorityQueue<WordEntry> words = new PriorityQueue<>();
            for (BufferedReader reader : readers.getReaders()) {
                String word = reader.readLine();
                if (word != null) {
                    words.add(new WordEntry(word, reader));
                }
            }

            try (Writer writer = Files.newBufferedWriter(outputPath)) {
                while (!words.isEmpty()) {
                    WordEntry entry = words.poll();
                    writer.write(entry.word);
                    writer.write(System.lineSeparator());
                    String word = entry.reader.readLine();
                    if (word != null) {
                        words.add(new WordEntry(word, entry.reader));
                    }
                }
            }
        }
        /*
        finally {
            // TODO: If you are correctly using try-with-resources, this "finally" block is no longer
            //       necessary. Remove it!
            for (BufferedReader reader : readers) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
         */
    }

    private static final class WordEntry implements Comparable<WordEntry> {
        private final String word;
        private final BufferedReader reader;

        private WordEntry(String word, BufferedReader reader) {
            this.word = Objects.requireNonNull(word);
            this.reader = Objects.requireNonNull(reader);
        }

        @Override
        public int compareTo(WordEntry other) {
            return word.compareTo(other.word);
        }
    }
}
