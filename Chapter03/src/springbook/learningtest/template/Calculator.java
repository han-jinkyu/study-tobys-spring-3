package springbook.learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
    public int calcSum(String filepath) throws IOException {
        BufferedReaderCallback callback = br -> {
            int sum = 0;
            String line;
            while ((line = br.readLine()) != null) {
                sum += Integer.parseInt(line);
            }
            return sum;
        };
        return fileReadTemplate(filepath, callback);
    }

    public int calcMultiply(String filepath) throws IOException {
        BufferedReaderCallback callback = br -> {
            int multiply = 0;
            String line;
            while ((line = br.readLine()) != null) {
                multiply *= Integer.parseInt(line);
            }
            return multiply;
        };
        return fileReadTemplate(filepath, callback);
    }

    public int fileReadTemplate(String filepath, BufferedReaderCallback callback)
            throws IOException {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filepath));
            int ret = callback.doSomethingWithReader(br);
            return ret;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
