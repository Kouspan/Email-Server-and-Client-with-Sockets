package me.server.code;

import me.common.code.Account;
import me.common.code.Email;

import javax.swing.*;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static  ArrayList<Account> accounts;
    private boolean isOn = true;
    private JPanel mainPanel;
    private JTextArea textArea;

    public Server() {
        accounts = new ArrayList<>();
        Account panos = new Account("panos@auth.gr","1234");
        Account beth = new Account("beth@gmail.com","Rt8usCal0");
        Account chris = new Account("chris@auth.gr","password");
        Email email = new Email("123playgames@yahoo.com","panos@auth.gr","Come Play","Sign up now! Free games to play");
        Email email1 = new Email("Burgers@food.com","panos@auth.gr","get food now","get a free 2 for 1 coupon");
        Email email2 = new Email("chris@auth.gr","panos@auth.gr","Group Project","Hello, i am going to be your Project partner.");
        panos.getMailbox().addEmail(email);
        panos.getMailbox().addEmail(email1);
        panos.getMailbox().addEmail(email2);
        Email email3 = new Email("chris@auth.gr","beth@gmail.gr","Chess","Hey Beth, would you like to play chess some day ?");
        Email email4 = new Email("amazon@noreply.com","beth@gmail.gr","ORDER-171","Your order has arrived at the store. Please come pick it up");
        Email email5 = new Email("spotify@payments.com","beth@gmail.gr","Payment Receipt ","Hi Beth, your subscription has benn renewed. Thanks for using Spotify Premium. ");
        beth.getMailbox().addEmail(email3);
        beth.getMailbox().addEmail(email4);
        beth.getMailbox().addEmail(email5);
        Email email6 = new Email("DrLevy@gmail.com","chris@auth.gr","Appointment Reschedule","We will have to reschedule your appointment for the next tuesday. Sorry for the inconvenience.");
        Email email7 = new Email("Steam@shop.com","chris@auth.gr","Wishlist ","There is a 50% discount on a game on your wishlist. The offer lasts till monday 6:00 PM  ");
        Email email8 = new Email("notAScam@money.com","chris@auth.gr","Congratulations!!!!!! ","YOU WON!!! CLICK ON THE FOLLOWING LINK TO COLLECT YOUR PRIZE!!! ");
        chris.getMailbox().addEmail(email6);
        chris.getMailbox().addEmail(email7);
        chris.getMailbox().addEmail(email8);
        accounts.add(panos);
        accounts.add(chris);
        accounts.add(beth);
        show();
        textArea.append("Server is running...\n");
    }

    public void show(){
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JFrame frame = new JFrame("Server");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void run(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            try {
                do {
                    Socket client = serverSocket.accept();
                    ServerThread thread = new ServerThread(client);
                    textArea.append("New connection with client: \n\t"+client.toString()+".\n");
                    thread.start();
                    textArea.append("\tThread "+thread.getName()+" started.\n");

                }
                while (isOn);

            } catch (EOFException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        isOn = false;
    }

    public static Account login(String user, String pass) {
        for (Account account : accounts) {
            if (account.getPassword().equals(pass) && account.getUsername().equals(user)) {
                return account;
            }

        }
        return null;
    }

    public static Account register(String user, String pass) {
        for (Account account : accounts) {
            if (account.getUsername().equals(user))
                return null;
        }
        Account account = new Account(user,pass);
        accounts.add(account);
        return account;
    }

    public static Account findAccount(String user){
        for (Account account : accounts) {
            if (account.getUsername().equals(user)) {
                return account;
            }
        }
        return null;
    }



}
