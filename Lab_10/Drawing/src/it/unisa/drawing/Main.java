package it.unisa.drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 300;
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int choice;
        double radius;

        System.out.println("Questo programma permette di disegnare figure!");
        System.out.println("Quale opzione scegli? (1 o 2");
        Scanner in = new Scanner(System.in);
        choice= Integer.parseInt(in.nextLine());
        in.nextLine();

        if(choice == 1)
        {
            System.out.println("Inserire dimensione del raggio:");
            radius = Double.parseDouble(in.nextLine());
        }
    }
}