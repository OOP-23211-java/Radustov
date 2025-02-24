package ru.nsu.lab0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    public static List<String> readScan(String filename) {

        if (filename == null || filename.trim().isEmpty()) {
            throw new IllegalStateException("Ошибка: имя файла не может быть пустым или null.");

        }


        if(  !filename.matches("^[a-zA-Zа-яА-Я0-9]+\\.txt$")){
            throw new IllegalStateException("Ошибка: Имя файла не соответствует допустимому");
        }


        List<String> dictionary = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            System.out.println("Файл успешно открыт");
            scanner.useDelimiter("[^a-zA-Zа-яА-Я0-9]+");

            while (scanner.hasNext()) {
                dictionary.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("Ошибка: Файл не найден: " + filename, e);
        }

        return dictionary;
    }
}
