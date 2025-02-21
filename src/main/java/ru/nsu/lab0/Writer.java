package ru.nsu.lab0;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class Writer {

    public static void write(FrequencyCounter frequency_counter, String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            TreeMap<String, Integer> myMap = frequency_counter.map();
            int size = frequency_counter.size();
            // Записываем заголовок CSV
            writer.println("Слово,Частота,Частота в %");

            for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
                String word = entry.getKey();      // Слово
                int count = entry.getValue();      // Количество повторений
                double frequency = (count * 100.0) / size; // Частота в %

                // Записываем в CSV: слово, частота, частота в процентах
                writer.printf("%s,%d,%.2f%%%n", word, count, frequency);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл не найден: " + filename, e);
        }
    }
}
