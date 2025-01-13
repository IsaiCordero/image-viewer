package software.ulpgc.imageviewerMVC;

import software.ulpgc.imageviewerMVC.model.Image;
import software.ulpgc.imageviewerMVC.view.ImageReader;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileReader implements ImageReader {
    private File folder;
    private File[] files;
    private final String[] extension = {"jpg", "jpeg"};

    public FileReader(String path) {
        this(new File(path));
    }

    public FileReader(File folder) {
        this.files = folder.listFiles(imageType());
    }

    private FilenameFilter imageType() {
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                for(String extension : extension)
                    if(name.toLowerCase().endsWith(extension)) return true;
                return false;
            }
        };
    }

    @Override
    public Image read() {
        return imageAt(0);
    }

    private Image imageAt(int index) {
        return new Image() {
            @Override
            public <T> T bitmap() {
                try {
                    return (T) ImageIO.read(files[index]);
                } catch (IOException e) {
                    return null;
                }
            }

            @Override
            public Image next() {
                return imageAt((index==files.length-1) ? 0 : index+1);
            }

            @Override
            public Image prev() {
                return imageAt((index==0)? files.length-1 : index-1);
            }
        };
    }
}
