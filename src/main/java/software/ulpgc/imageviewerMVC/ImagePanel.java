package software.ulpgc.imageviewerMVC;

import software.ulpgc.imageviewerMVC.model.Image;
import software.ulpgc.imageviewerMVC.view.ImageDisplay;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel implements ImageDisplay {
    private Image image;

    public ImagePanel(Image image) {
        this.image = image;
    }

    @Override
    public Image image() {
        return image;
    }

    @Override
    public void show(Image image) {
        this.image = image;
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        if (image != null && image.bitmap() != null) {
            int panelWidth = this.getWidth();
            int panelHeight = this.getHeight();

            java.awt.Image bitmap = image.bitmap();
            int imageWidth = bitmap.getWidth(null);
            int imageHeight = bitmap.getHeight(null);

            double imageAspect = (double) imageWidth / imageHeight;
            double panelAspect = (double) panelWidth / panelHeight;

            int drawWidth, drawHeight;
            if (panelAspect > imageAspect) {
                drawHeight = panelHeight;
                drawWidth = (int) (panelHeight * imageAspect);
            } else {
                drawWidth = panelWidth;
                drawHeight = (int) (panelWidth / imageAspect);
            }

            int x = (panelWidth - drawWidth) / 2;
            int y = (panelHeight - drawHeight) / 2;
            g.drawImage(bitmap, x, y, drawWidth, drawHeight, this);
        }
    }
}
