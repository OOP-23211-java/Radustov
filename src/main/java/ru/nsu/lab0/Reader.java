package ru.nsu.lab0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * класс для чтения слов
 */

public class Reader {

    /**
     * метод считывает файл и записывает прочитанные слова в список
     * @param filename имя файла
     * @return List<String> список слов, считанных из файла
     * @throws NullPointerException при пустом имени файла
     * @throws IllegalArgumentException при недопустимом имени файла
     * @throws IllegalArgumentException если файл не открылся
     */

    public static List<String> readScan(String filename) {

        if (filename == null || filename.trim().isEmpty()) {
            throw new NullPointerException("Ошибка: имя файла не может быть пустым или null.");

        }


        if(  !filename.matches("^[a-zA-Zа-яА-Я0-9]+\\.txt$")){
            throw new IllegalArgumentException("Ошибка: Имя файла не соответствует допустимому");
        }


        List<String> dictionary = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            System.out.println("Файл успешно открыт");
            scanner.useDelimiter("[^a-zA-Zа-яА-Я0-9]+");

            while (scanner.hasNext()) {
                dictionary.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("Ошибка: Файл не открылся: " + filename, e);
        }

        return dictionary;
    }
}
