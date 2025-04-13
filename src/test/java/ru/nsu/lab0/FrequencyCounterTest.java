package ru.nsu.lab0;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.List;

public class FrequencyCounterTest {
    @Test
    void frequencyCounterTest() {
        List<String> dictionary = new ArrayList<>();
        try {
            new FrequencyCounter(dictionary);
        } catch (RuntimeException e) {
            System.out.println("Перехвачено исключение " + e.getMessage());
        }
    }
}
