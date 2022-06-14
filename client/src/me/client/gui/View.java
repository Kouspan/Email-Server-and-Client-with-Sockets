package me.client.gui;

public class View {

    private AuthWindow authWindow;
    private HomeWindow homeWindow;
    private NewWindow newWindow;
    private ReadWindow readWindow;


    public View() {
        authWindow = new AuthWindow();
        homeWindow = new HomeWindow();
        readWindow = new ReadWindow();
        newWindow = new NewWindow();

    }

    public AuthWindow getAuthWindow() {
        return authWindow;
    }

    public HomeWindow getHomeWindow() {
        return homeWindow;
    }

    public NewWindow getNewWindow() {
        return newWindow;
    }

    public ReadWindow getReadWindow() {
        return readWindow;
    }

}
