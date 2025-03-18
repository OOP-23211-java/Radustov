package ru.nsu.lab0;

import java.util.ArrayList;
import java.util.List;

/**
 * Main класс, в котором мы считываем из входного файла слова, подсчитываем их и записываем в выходной файл
 */
public class Main {
    public static void main(String[] args){
        List<String> dictionary=new ArrayList<>();
          dictionary = Reader.readScan("input.txt");
        FrequencyCounter frequencyCounter = new FrequencyCounter(dictionary);
         Writer.write(frequencyCounter,"output.csv");
    }
}
