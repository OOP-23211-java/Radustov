package ru.nsu.lab0;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class Writer {

    public static void write(FrequencyCounter frequencyСounter, String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            // Записываем заголовок CSV
            writer.println("Слово,Частота,Частота в %");

            for (Map.Entry<String, Integer> entry : frequencyСounter.map().entrySet()) {
                String word = entry.getKey();      // Слово
                int count = entry.getValue();      // Количество повторений
                double frequency = (count * 100.0) / frequencyСounter.size(); // Частота в %

                // Записываем в CSV: слово, частота, частота в процентах
                writer.printf("%s,%d,%.2f%%%n", word, count, frequency);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл не найден: " + filename, e);
        }
    }
}
