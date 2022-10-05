package StructuralPatterns.DecoratorPattern;

import java.io.*;
import java.util.Objects;

public final class CountReads {

    public static final class CountingReader extends Reader{

        private int count = 0;

        private final Reader delegate;

        CountingReader(Reader delegate) {
            this.delegate = Objects.requireNonNull(delegate);
        }

        public int getCount(){return count;}

        @Override
        public int read(char[] cbuf, int off, int len) throws IOException {
            // count the number of times the reader is called
            count ++;
            return delegate.read(cbuf, off, len);
        }

        @Override
        public void close() throws IOException {
            delegate.close();
        }
    }

    public static void main(String[] args) throws Exception{
        try (FileReader reader = new FileReader(new File("E:\\JavaNanodegree\\Design_Patterns_in_Java\\src" +
                "\\StructuralPatterns\\DecoratorPattern\\unsorted.txt"))){
            /**
            * create countingReaders to decorate these other readers:
            */

            // Reader unbufferedReads = reader;
            // This countingreader will tell us the number of times we read from the FileReader
            CountingReader unbufferedReads = new CountingReader(reader);
            // Reader bufferedReads = new BufferedReader(unbufferedReads);
            // This countingreader will tell us the number of times we read from the BufferedReader
            CountingReader bufferedReads = new CountingReader(new BufferedReader(unbufferedReads));

            char[] data = new char[100];
            while (bufferedReads.read(data) != -1);

            System.out.println("Calls to BufferedReader.read(): " + bufferedReads.getCount());
            // number of times we read from the disk
            System.out.println("Calls to FileReader.read(): " + unbufferedReads.getCount());

        }



    }
}
