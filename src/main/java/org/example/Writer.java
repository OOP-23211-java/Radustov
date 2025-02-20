package org.example;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;

public class Writer {

    public void Write(Frequency_Counter frequency_counter) {
        try (PrintWriter writer = new PrintWriter("output.csv")) {
            TreeMap<String, Integer> MyMap = frequency_counter.getMap();
            int size = frequency_counter.getSize();

            // Записываем заголовок CSV
            writer.println("Слово,Частота,Частота в %");

            for (Map.Entry<String, Integer> entry : MyMap.entrySet()) {
                String word = entry.getKey();      // Слово
                int count = entry.getValue();      // Количество повторений
                double frequency = (count * 100.0) / size; // Частота в %

                // Записываем в CSV: слово, частота, частота в процентах
                writer.printf("%s,%d,%.2f%%%n", word, count, frequency);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
