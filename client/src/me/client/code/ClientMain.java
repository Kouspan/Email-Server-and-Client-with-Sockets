package me.client.code;

import me.client.gui.View;

public class ClientMain {

    public static void main(String[] args) {
        int port;
        String ip;
        switch (args.length) {
            case 0 -> {
                port = 4444;
                ip = "127.0.0.1";
            }
            case 1 -> {
                ip = args[0];
                port = 4444;
            }
            case 2 -> {
                ip = args[0];
                try {
                    port = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    port = 4444;
                }
            }
            default -> {
                System.err.println("Invalid Arguments: \n");
                for (String str : args) {
                    System.err.println(str);
                }
                return;
            }
        }
        View view = new View();
        Client client = new Client(ip, port);
        Controller controller = new Controller(view, client);
        controller.launchAuth();

    }
}
