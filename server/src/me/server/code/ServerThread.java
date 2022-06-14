package me.server.code;

import me.common.IRequest;
import me.common.IResponse;
import me.common.ResponseCode;
import me.common.Type;
import me.common.code.Account;
import me.common.code.Email;
import me.common.requests.*;
import me.common.responses.EmailResponse;
import me.common.responses.FetchResponse;
import me.common.responses.LoginResponse;
import me.common.responses.RegisterResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
    private static int threadID = 0;
    private boolean isOn = true;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Account account = null;


    public ServerThread(Socket client) {
        super("Thread" + (threadID++));
        try {
            input = new ObjectInputStream(client.getInputStream());
            output = new ObjectOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @Override
    public void run() {

        IRequest request;
        while (isOn) {
            try {
                request = (IRequest) input.readObject();
                requestHandler(request);

            } catch (Exception e) {
                System.out.println("Client disconnected. Thread"+this.getName()+" terminated");
                isOn = false;
            }
        }
        try {
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void requestHandler(IRequest request) {
        Type requestType = request.getType();
        IResponse response;
        switch (requestType) {
            case LOGIN -> {
                account = Server.login(((LoginRequest) request).getName(), ((LoginRequest) request).getPass());
                response = new LoginResponse(account);
                if (account != null)
                    response.setCode(ResponseCode.SUCCESS);
                else
                    response.setCode(ResponseCode.INVALID_AUTH);
                sendResponse(response);

            }
            case REGISTER -> {
                account = Server.register(((RegisterRequest) request).getName(), ((RegisterRequest) request).getPass());
                response = new RegisterResponse(account);
                if (account != null) {
                    response.setCode(ResponseCode.SUCCESS);
                } else
                    response.setCode(ResponseCode.EMAIL_EXISTS);
                sendResponse(response);

            }
            case SEND -> {
                Email email = ((SendEmailRequest) request).getEmail();
                Account receiverAccount = Server.findAccount(email.getReceiver());
                if (receiverAccount != null)
                    receiverAccount.getMailbox().addEmail(email);

            }
            case FETCH -> {
                ArrayList<Email> emails = account.getMailbox().getEmails();
                IResponse response1 = new FetchResponse();
                IResponse emailResponse;
                response1.setCode(ResponseCode.START);
                sendResponse(response1);
                for(Email email:emails) {
                    emailResponse = new EmailResponse(email);
                    sendResponse(emailResponse);
                }
                IResponse endResponse = new FetchResponse();
                endResponse.setCode(ResponseCode.END);
                sendResponse(endResponse);
            }
            case READ -> {
                int index = ((ReadRequest) request).getIndex();
                account.getMailbox().getEmails().get(index).setNew(false);
            }
            case DELETE -> {
                int row  = ((DeleteRequest) request).getRow();
                account.getMailbox().deleteEmail(row);
            }
        }
    }

    public void sendResponse(IResponse response) {
        try {
            output.writeObject(response);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
