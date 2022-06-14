package me.client.code;

import me.common.IRequest;
import me.common.IResponse;
import me.common.code.Account;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Account account;
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Client(String ip,int port) {
        try {
            socket = new Socket(ip, port);
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
        } catch (UnknownHostException e) {
            System.err.println("Don't know host");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("couldn't get I/O for the connection");
        }
    }

    public void sendRequest(IRequest request){
        try {
            output.writeObject(request);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public IResponse getResponse(){
        try {
            return (IResponse) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}


