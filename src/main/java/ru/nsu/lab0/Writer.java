package ru.nsu.lab0;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

public class Writer {

    public static void write(FrequencyCounter frequencyСounter, String filename) {

        if (filename == null || filename.trim().isEmpty()) {
            throw new IllegalArgumentException("Ошибка: имя файла не может быть пустым или null.");
        }


        if(  !filename.matches("^[a-zA-Zа-яА-Я0-9]+\\.txt$")){
            throw new IllegalStateException("Ошибка: Имя файла не соответствует допустимому");
        }

        try (PrintWriter writer = new PrintWriter(filename)) {
            System.out.println("Файл успешно открыт");
            writer.println("Слово,Частота,Частота в %");

            for (Map.Entry<String, Integer> entry : frequencyСounter.map().entrySet()) {
                String word = entry.getKey();      // Слово
                int count = entry.getValue();      // Количество повторений
                double frequency = (count * 100.0) / frequencyСounter.size(); // Частота в %

                // Записываем в CSV: слово, частота, частота в процентах
                writer.printf("%s,%d,%.2f%%%n", word, count, frequency);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Файл не найден: " + filename, e);
        }
    }
}
