package kz.chesschicken.skinstealer;

import kz.chesschicken.skinstealer.utils.Utilities;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.add(new PanelMain(frame).getMainPanel());
        frame.setTitle("RuBeta Skin Stealer 0.3");
        frame.setIconImage(Utilities.readNoException("/icon.png"));
        frame.setMinimumSize(new Dimension(380, 160));
        frame.setSize(380, 320);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
