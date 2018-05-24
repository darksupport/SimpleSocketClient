package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Socket socket  = null;
        Scanner sc = new Scanner(System.in);
        try
        {
            socket = new Socket("localhost",7000);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            InputStreamReader stream = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(stream);
            while (true)
            {
                writer.println(sc.nextLine());
                System.out.println(reader.readLine());
            }
        }
        catch (IOException e)
        {
            System.out.println("Connection error." + e.getMessage());
            e.printStackTrace();
            socket.close();
        }

    }
}
