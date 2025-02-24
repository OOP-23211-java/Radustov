package ru.nsu.lab0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;

public class ReaderTest {

    @Test
    public void fileReadScanTest() {
        try {
            Reader.readScan(null);
        } catch (IllegalStateException e) {
            System.out.println("Перехвачено исключение" + e.getMessage());
        }
        try {
            Reader.readScan("2");
        } catch (IllegalStateException e) {
            System.out.println("Перехвачено исключение" + e.getMessage());
        }
        try{
            Reader.readScan("output.txt");
        }
        catch (RuntimeException e){
            System.out.println("Перехвачено исключение"+e.getMessage());
        }
        Reader.readScan("input.txt");
    }
}
