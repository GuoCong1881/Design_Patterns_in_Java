package StructuralPatterns.AdapterPattern;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * this class implements the Closeable interface.
 *
 * Any object that implements Closeable can be declared as a resource using the try-with-resources idiom.
 */

/**
 * Where does the adapter pattern fit in?
 *
 * In this case, you are adapting your List<Path> of shard files to the Closeable interface to make the readers easier to manage
 */

/**
 * Steps to do:
 *
 * 1. First, implement the MultiFileReader(List<Path> paths) constructor, which should create a
 * list of BufferedReaders from the given paths. If any of the BufferedReaders throws an exception,
 * be sure to close the readers you've already created!
 * 2. Next, implement the MultiFileReader#close() method, which should close all the BufferedReaders.
 * 3. When you are done implementing MultiFileReader, complete all the TODOs in MergeShards.java
 * to use your new adapter! The new main method should look a lot cleaner!
 */
public final class MultiFileReader implements Closeable {

    private final List<BufferedReader> readers;

    public MultiFileReader(List<Path> paths) {
        // TODO: Build the List of BufferedReaders
        readers = new ArrayList<>(paths.size());
        try{
            for (Path path: paths){
                BufferedReader reader = Files.newBufferedReader(path);
                readers.add(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public List<BufferedReader> getReaders() {
        return Collections.unmodifiableList(readers);
    }

    @Override
    public void close() {
        // TODO: Close all the readers.
        for (BufferedReader reader: readers){
            try{
                reader.close();
            } catch (IOException ignore){
            }
        }
    }
}
