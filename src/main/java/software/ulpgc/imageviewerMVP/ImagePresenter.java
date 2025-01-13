package software.ulpgc.imageviewerMVP;

import software.ulpgc.imageviewerMVP.ImageDisplay.*;

public class ImagePresenter {
    private final ImageDisplay display;
    private ImageModel model;

    public ImagePresenter(ImageDisplay display) {
        this.display = display;
        this.model = new ImageModel();
        this.display.on((Shift) this::shift);
        this.display.on((Released) this::released);
    }

    private void shift(int offset) {
        display.clear();

        String currentImagePath = model.getPath();
        display.paint(currentImagePath, offset);

        if (offset > 0) {
            String lastImagePath = model.getPreviousPath();
            if (lastImagePath != null) {
                display.paint(lastImagePath, offset - display.getWidth());
            }
        }

        if (offset < 0) {
            String nextImagePath = model.getNextPath();
            if (nextImagePath != null) {
                display.paint(nextImagePath, offset + display.getWidth());
            }
        }
    }


    private void released(int offset) {
        if(Math.abs(offset) >= display.getWidth() / 2){
            if(offset>0){
                model.lastImage();
            }else{
                model.nextImage();
            }
        }
        repaint();
    }
    public void show(){
        repaint();
    }

    private void repaint() {
        display.clear();
        display.paint(model.getPath(), 0);
    }
}
