package ru.nsu.lab0;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.List;

public class WriterTest {
    @Test
    public void writerTest(){
        List<String> dictionary=new ArrayList<>();
        dictionary.add("dw");
       FrequencyCounter frequencyCounter = new FrequencyCounter(dictionary);
        String filename= "input.txt";
        try{
            Writer.write(frequencyCounter,filename);
        } catch (IllegalArgumentException e) {
            System.out.println("Перехвачено исключение: "+ e.getMessage());
        }
    }
}
