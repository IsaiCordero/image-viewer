package software.ulpgc.imageviewerMVC.control;

import software.ulpgc.imageviewerMVC.view.ImageDisplay;

public class PrevCommand implements Command {
    private ImageDisplay display;

    public PrevCommand(ImageDisplay display) {
        this.display = display;
    }

    @Override
    public void execute() {
        display.show(display.image().prev());
    }
}
