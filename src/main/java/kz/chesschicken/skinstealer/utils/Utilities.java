package kz.chesschicken.skinstealer.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Utilities {
    public static class TryResult<T> {
        public final boolean successful;
        public T value;

        public TryResult(boolean a, T t) {
            this.successful = a;
            this.value = t;
        }
    }

    public static TryResult<BufferedImage> downloadImage(String string_url, boolean scream) {
        try {
            URL url = new URL(string_url);
            BufferedImage image = ImageIO.read(url);
            return new TryResult<>(true, image);
        } catch (IOException e) {
            if(scream)
                e.printStackTrace();
            return new TryResult<>(false, null);
        }
    }

    @SuppressWarnings("ConstantConditions")
    public static BufferedImage readNoException(String a) {
        try {
            return ImageIO.read(Utilities.class.getResourceAsStream(a));
        } catch (IOException e) {
            return null;
        }
    }

    public static File operationSave(JFrame home, String defname, boolean skin) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Сохранить " + (skin ? "Скин" : "Плащ") + " игрока " + defname + ".");
        fileChooser.setSelectedFile(new File(defname + ".png"));
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PNG Picture", "png"));
        int userSelection = fileChooser.showSaveDialog(home);

        if (userSelection == JFileChooser.APPROVE_OPTION)
            return fileChooser.getSelectedFile();
        return null;
    }

    public static void commitSaveOperation(JFrame home, boolean skin, String username, BufferedImage image) {
        File getFile = operationSave(home, username, skin);
        if(getFile == null)
            return;
        try {
            ImageIO.write(image, "png", getFile);
        } catch (IOException ignored) {}
    }
}
