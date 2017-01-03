package ru.reeson2003.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by reeson on 03.01.17.
 */
public class MainWindow extends JFrame{
    private JLabel textLabel;
    public MainWindow() {
        this.textLabel = new JLabel();
        this.add(textLabel, BorderLayout.NORTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.setSize(800, 500);
        this.setVisible(true);
    }
    public void showText(String text) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        String txt = text.replaceAll("\n","<br>");
        sb.append(txt);
        sb.append("</html>");
        this.textLabel.setText(sb.toString());
    }
}
