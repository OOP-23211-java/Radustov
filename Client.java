package org.radustov.nsu.labChat;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true)
        ) {
            // Считаем приветствие от сервера
            System.out.println(in.readLine());
            String name = console.readLine();
            out.println(name); // Отправим имя на сервер

            // Отображаем подтверждение
            System.out.println(in.readLine());

            // Поток для чтения сообщений от сервера
            new Thread(() -> {
                try {
                    String response;
                    while ((response = in.readLine()) != null) {
                        System.out.println(response);
                    }
                } catch (IOException e) {
                    System.err.println("Сервер отключился.");
                }
            }).start();

            // Основной ввод пользователя
            String userInput;
            while ((userInput = console.readLine()) != null) {
                out.println(userInput);
            }

        } catch (IOException e) {
            System.err.println("Ошибка клиента: " + e.getMessage());
        }
    }
}
