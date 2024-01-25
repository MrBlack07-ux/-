// Серверное приложение
import java.io.*;
import java.net.*;

public class Work2SimpleServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            System.out.println("Сервер запущен. Ожидание подключений...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Подключение установлено: " + clientSocket);

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println("Привет, я сервер. Чем могу помочь?");
            String response;
            while ((response = in.readLine()) != null) {
                System.out.println("Клиент: " + response);
                if (response.equalsIgnoreCase("Пока")) {
                    out.println("До свидания!");
                    break;
                } else {
                    out.println("Вы сказали: " + response);
                }
            }

            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}