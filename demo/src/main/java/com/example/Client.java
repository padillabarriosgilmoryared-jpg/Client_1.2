package com.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
       try {
            Socket s = new Socket("127.0.0.1", 8080);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            Scanner input = new Scanner(System.in);
            System.out.println("Scrivi il messaggio di conferma per cominciare (accept) o il messaggio per uscire (exit):");
            String message = "";
            do{
                message = input.nextLine();
            }while(!message.equals("accept") && !message.equals("exit"));
            if(message.equals("exit")){
                s.close();
            }else{
                System.out.println("Scrivi la prima cifra:");
                double n1 = input.nextDouble();
                input.nextLine();
                System.out.println("Scrivi la seconda cifra:");
                double n2 = input.nextDouble();
                input.nextLine();
                System.out.println("Scrivi l'operatore (+;-;/;*):");
                String operatore = input.nextLine();

                out.println(message);
                out.println(n1);
                out.println(n2);
                out.println(operatore);
                
                String risposta = in.readLine();
                System.out.println(risposta);
            }
            s.close();
       } catch (IOException e) {
        e.printStackTrace();
       }
    }
}