package org.example;
import java.util. List;
public class Main {
    public static void main(String[] args){
        List<String> dictionary=Reader.Read();
        Frequency_Counter frequency_counter = new Frequency_Counter();
        frequency_counter.сount(dictionary);
        Writer writer = new Writer();
        writer.Write(frequency_counter);
    }
}
