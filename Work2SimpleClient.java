// Клиентское приложение
import java.io.*;
import java.net.*;

public class Work2SimpleClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 7777);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            String response;
            while ((response = in.readLine()) != null) {
                System.out.println("Сервер: " + response);
                if (response.equalsIgnoreCase("До свидания!")) {
                    break;
                }
                String userInputStr = userInput.readLine();
                out.println(userInputStr);
            }
        } catch (UnknownHostException e) {
            System.err.println("Хост недоступен: localhost");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
