package software.ulpgc.imageviewerMVP;

public class ImageModel {
    private String[] imagePaths;
    private int imageIndex;

    public ImageModel() {
        imagePaths = new String[] {
                "imagenes/imagen1.jpg",
                "imagenes/imagen2.jpeg",
                "imagenes/imagen3.jpg",
        };
        imageIndex = 0;
    }

    public String getPath() {
        return imagePaths[imageIndex];
    }

    public void nextImage() {
        imageIndex = (imageIndex + 1) % imagePaths.length;
    }

    public void lastImage() {
        imageIndex = (imageIndex - 1 + imagePaths.length) % imagePaths.length;
    }

    public String getPreviousPath() {
        int previousIndex = (imageIndex - 1 + imagePaths.length) % imagePaths.length;
        return imagePaths[previousIndex];
    }

    public String getNextPath() {
        int nextIndex = (imageIndex + 1) % imagePaths.length;
        return imagePaths[nextIndex];
    }
}
