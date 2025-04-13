package org.radustov.nsu.labChat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private static final List<ClientConnection> clients = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Сервер поднят на порту 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился");

            new Thread(() -> handleClient(clientSocket)).start();
        }
    }

    private static void handleClient(Socket socket) {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true
                )

        ) {
            out.println("Введите имя:");
            String name = in.readLine();
            if (name == null || name.isBlank()) name = "Аноним";
            ClientConnection client = new ClientConnection(name, out);
            clients.add(client);

            out.println("Добро пожаловать, " + name + "!");
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(name + ": " + message);
                broadcast(name + ": " + message, client);
            }
        } catch (IOException e) {
            System.err.println("Ошибка клиента: " + e.getMessage());
        } finally {
            clients.removeIf(c -> c.out.checkError());
        }
    }

    private static void broadcast(String message, ClientConnection sender) {
        for (ClientConnection client : clients) {
            if (client != sender) {
                client.out.println(message);
            }
        }
    }
}

