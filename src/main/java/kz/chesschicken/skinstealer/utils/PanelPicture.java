package kz.chesschicken.skinstealer.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PanelPicture extends JPanel {

    private final boolean skinMode;
    private BufferedImage image;

    public PanelPicture(boolean a) {
        this.skinMode = a;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        this.revalidate();
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image != null) {
            g.drawImage(image, 0, 0, this.getWidth(), skinMode ? this.getWidth() : this.getWidth() * 17/22, this);
        }
    }

}
