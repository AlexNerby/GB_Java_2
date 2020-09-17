package ru.gb2.lesson6;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private boolean exit = true;

    public static void main(String[] args) {
        new Server();
    }

    public Server() {

        try {
            System.out.println("Server is starting up...");
            ServerSocket serverSocket = new ServerSocket(25111);

            System.out.println("Server connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket);

            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                //поток принимает от клиента
                @Override
                public void run() {
                    while (true) {
                        try {
                            String msg = inputStream.readUTF();
                            if (msg.equals("exit")) {
                                System.out.println("Client disconnected");
                                break;
                            } else {
                                System.out.println("Client write: " + msg);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();


            while (true) {
                //мейн поток отправляет клиенту
                Scanner scanner = new Scanner(System.in);
                String in = scanner.nextLine();
                if (in.equals("exit")) {
                    System.out.println("exit input/output \n server is of...");
                    break;
                }
                outputStream.writeUTF(in);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
