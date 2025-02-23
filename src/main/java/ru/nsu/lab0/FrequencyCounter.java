package ru.nsu.lab0;

import java.util.List;
import java.util.TreeMap;

public class FrequencyCounter {

    private int size;
    private TreeMap<String,Integer> frequencyMap;

    public FrequencyCounter(List<String> dictionary){
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
