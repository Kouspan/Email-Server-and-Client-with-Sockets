package me.common.code;

import java.io.Serializable;
import java.util.ArrayList;

public class MailBox implements Serializable {
    private ArrayList<Email> emails = new ArrayList<Email>();


    public ArrayList<Email> getEmails() {
        return emails;
    }

    public void addEmail(Email email) {
        emails.add(email);

    }

    public void deleteEmail(int index) {
        emails.remove(index);
    }
    public void setEmails(ArrayList<Email> emails){
        this.emails = emails;
    }

}
