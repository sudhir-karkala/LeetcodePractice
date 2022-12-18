package com.leetcode.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Utility class to read input from stdin
 *
 * @author sudhir on 09-Dec-2017
 */
public class FastReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public FastReader() {
        // TODO Auto-generated constructor stub
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = reader.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }

    public void close() {
        try {
            reader.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FastReader fr = new FastReader();
        int i = fr.nextInt();
        double d = fr.nextDouble();
        String word = fr.next();
        String nextWord = fr.next();
        String line = fr.nextLine();
        System.out.println("Integer read: " + i);
        System.out.println("Double read: " + d);
        System.out.println("Line read: " + line);
        System.out.println("Word read: " + word);
        System.out.println("Next Word read: " + nextWord);
        fr.close();
    }
}

