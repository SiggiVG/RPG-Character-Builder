package com.deadvikingstudios.characterbuilder.controller;

import javafx.stage.Screen;
import javafx.stage.Window;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame
{
    public static final String APP_NAME = "RPG Character Builder";
    public static final String VERSION = "0.0.1";

    public Application()
    {
        super(APP_NAME + ' ' + VERSION);
        Dimension dem = new Dimension(600,480);
        this.setPreferredSize(dem);
        this.setSize(dem);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public static void main(String args[])
    {
        JFrame app = new Application();
        JPanel panel = new JPanel();
        app.add(panel);

    }
}
