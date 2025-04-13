package org.radustov.nsu.labChat;

import java.io.PrintWriter;

/**
 * Класс для хранения имени клиента и его потока вывода
 */
public class ClientConnection {
    String name;
    PrintWriter out;

    ClientConnection(String name, PrintWriter out) {
        this.name = name;
        this.out = out;
    }
}
