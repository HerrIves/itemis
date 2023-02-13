package de.herrives.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleInputController {

    public static List<String> readLines() throws IOException {
        List<String>lines = readLines(System.in);

        return lines;
    }

    public static List<String> readLines(InputStream in) throws IOException {
        List<String>lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;

        while ((line = reader.readLine()) != null){
            if (line.equals(""))break;
            lines.add(line);
        }
        return lines;
    }

}
