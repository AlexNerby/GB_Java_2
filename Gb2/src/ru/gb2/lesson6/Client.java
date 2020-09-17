package ru.gb2.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        try {
            Socket socket = new Socket("127.0.0.1", 25111);
            System.out.println("Client connect: " + socket);

            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);

            new Thread(new Runnable() {
                //поток принимает от сервера
                @Override
                public void run() {
                    while (true) {
                        try {
                            String msg = inputStream.readUTF();
                            System.out.println("Server write: " + msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();


            while (true) {
                //мейн поток отправляет на сервер
                String console = scanner.nextLine();
                outputStream.writeUTF(console);
                if (console.equals("exit")) {
                    System.out.println("exit input/output \n disconnect...");
                    break;
                }
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
