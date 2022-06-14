package me.client.gui;

import javax.swing.*;

public class Window {
    protected JFrame frame;

    public Window(String name){
        frame = new JFrame(name);
        try {
            UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[1].getClassName());
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void show(JPanel panel){
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public void hide(){
        frame.dispose();
    }

    public JFrame getFrame() {
        return frame;
    }
}
