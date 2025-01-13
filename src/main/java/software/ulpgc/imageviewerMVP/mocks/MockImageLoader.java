package software.ulpgc.imageviewerMVP.mocks;

import software.ulpgc.imageviewerMVP.Image;
import software.ulpgc.imageviewerMVP.ImageLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MockImageLoader implements ImageLoader {
    private final File[] files;

    public MockImageLoader(){
        File folder = new File("imagenes");
        this.files = folder.listFiles((dir, name) -> {
            return name.endsWith(".jpg") || name.endsWith(".jpeg");
        });
    }

    public Image load(){
        return this.imageAt(0);
    }

    private Image imageAt(final int i) {
        return new Image() {
            private final BufferedImage image = this.loadImage(i);
            @Override
            public String id() {
                return MockImageLoader.this.files[i].getName();
            }

            @Override
            public Image next() {
                return MockImageLoader.this.imageAt((i+1) % MockImageLoader.this.files.length);
            }

            @Override
            public Image prev() {
                return MockImageLoader.this.imageAt(i > 0 ? i-1 : MockImageLoader.this.files.length);
            }
            private BufferedImage loadImage(int index) {
                try {
                    return ImageIO.read(MockImageLoader.this.files[index]);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
