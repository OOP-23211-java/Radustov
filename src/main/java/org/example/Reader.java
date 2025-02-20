package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {// объединение логики чтения и записи слов для последующей сортировки
    public static List<String> Read() {//можно во имя инкапсуляции обработку в отдельный файл вынести
        List<String> dictionary = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            scanner.useDelimiter("[^a-zA-Zа-яА-Я0-9]+");

            while (scanner.hasNext()) {
                dictionary.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл не найден: " + "input.txt", e);
        }

        return dictionary;
    }
}
