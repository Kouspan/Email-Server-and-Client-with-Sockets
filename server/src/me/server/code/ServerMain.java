package me.server.code;

public class ServerMain {

    public static void main(String[] args){
        int port;
        switch (args.length) {
            case 0 -> port = 4444;
            case 1 -> {
                try {
                    port = Integer.parseInt(args[0]);
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
        Server server = new Server();
        server.run(port);

    }
}
