package ru.nsu.lab0;

import java.util.List;
public class Main {
    public static void main(String[] args){
        List<String> dictionary= Reader.readScan("input.txt");
        FrequencyCounter frequencyCounter = new FrequencyCounter(dictionary);
         Writer.write(frequencyCounter,"output.csv");
    }
}
