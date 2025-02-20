package org.example;

import java.util.*;

public class Frequency_Counter {
    private int Size;
    private TreeMap<String,Integer> frequencyMap = new TreeMap<>();

    public int getSize() { // Геттер
        return Size;
    }

    public TreeMap<String,Integer> getMap(){
        return frequencyMap;
    }

    public void сount(List<String> dictionary) {

        // Подсчитываем частоту слов
        frequencyMap = new TreeMap<>();
        for (String word : dictionary) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Общее количество слов
        Size = dictionary.size();
    }
}
