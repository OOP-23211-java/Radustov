package ru.nsu.lab0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    public static List<String> readScan(String filename) {//можно во имя инкапсуляции обработку в отдельный файл вынести
        List<String> dictionary = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            scanner.useDelimiter("[^a-zA-Zа-яА-Я0-9]+");

            while (scanner.hasNext()) {
                dictionary.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл не найден: " + filename, e);
        }

        return dictionary;
    }
}
