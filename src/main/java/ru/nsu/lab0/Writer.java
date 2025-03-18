package ru.nsu.lab0;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
/**
 * класс для записи в файл формата csv
 */
public class Writer {

    /**
     * \
     * статический метод для записи данных в файл.
     * Запись производится в формате csv в виде "Слово","Частота","Частота в %". Данные для
     * записи передаются в метод при помощи объекта frequencyCounter
     * @param frequencyСounter объект класса frequencyCounter
     * @param filename имя файла
     * @throws  NullPointerException при передаче в метод пустого имени файла
     * @throws  IllegalArgumentException при передаче некорректного имени файла
     * @throws RuntimeException если не удаётся открыть файл для записи
     */
    public static void write(FrequencyCounter frequencyСounter, String filename) {

        if (filename == null || filename.trim().isEmpty()) {
            throw new NullPointerException("Ошибка: имя файла не может быть пустым или null.");
        }


        if(  !filename.matches("^[a-zA-Zа-яА-Я0-9]+\\.csv$")){
            throw new IllegalArgumentException("Ошибка: Имя файла не соответствует допустимому");
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
            throw new RuntimeException("Не удалось открыть файл: " + filename, e);
        }
    }
}
