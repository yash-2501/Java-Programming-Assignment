//Implement TCP Echo Client–Server program

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Program7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select mode: 1 = Server, 2 = Client");
        int mode = sc.nextInt();
        sc.nextLine(); 

        switch (mode) {
            case 1 -> startServer();
            case 2 -> startClient();
            default -> System.out.println("Invalid option.");
        }
    }

    private static void startServer() {
        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("=== TCP Echo Server Started ===");
            System.out.println("Waiting for client on port " + port + "...");

            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received from client: " + message);
                    out.println("Echo: " + message);
                }
            }
            System.out.println("Client disconnected.");
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    private static void startClient() {
        Scanner sc = new Scanner(System.in);
        String serverAddress = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to server: " + serverAddress);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while (true) {
                System.out.print("Enter message (type 'exit' to quit): ");
                message = sc.nextLine();
                if (message.equalsIgnoreCase("exit")) break;

                out.println(message);
                String response = in.readLine();
                System.out.println("Server says: " + response);
            }

            System.out.println("Disconnected from server.");
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}