package software.ulpgc.imageviewerMVC.view;

import software.ulpgc.imageviewerMVC.model.Image;

public interface ImageDisplay {
    Image image();
    void show(Image image);
}
