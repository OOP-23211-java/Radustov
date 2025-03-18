package ru.nsu.lab0;

import java.util.List;
import java.util.TreeMap;

/**
 * класс для подсчёта частоты слов
 * имеет проперти TreeMap и размер передаваемого в метод этого класса словаря
 */
public class FrequencyCounter {

    private final int size;
    private final TreeMap<String,Integer> frequencyMap;

    /**
     *конструктор прнинимает словарь, подсчитывает в нем слова, записывает в мапу слово и его количество повторений
     * @param dictionary список слов
     * @throws RuntimeException если словарь пустой
     */
    public FrequencyCounter(List<String> dictionary){
        if(dictionary.isEmpty()) {
            throw new RuntimeException("считанный файл пустой");
        }
        frequencyMap = new TreeMap<>();
        for (String word : dictionary) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Общее количество слов
        size = dictionary.size();
    }

    public int size() {
        return size;
    }

    public TreeMap<String,Integer> map()
    {
        return frequencyMap;
    }

}
