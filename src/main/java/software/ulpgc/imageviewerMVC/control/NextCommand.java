package software.ulpgc.imageviewerMVC.control;

import software.ulpgc.imageviewerMVC.view.ImageDisplay;

public class NextCommand implements Command {
    private ImageDisplay display;

    public NextCommand(ImageDisplay display) {
        this.display = display;
    }

    @Override
    public void execute() {
        display.show(display.image().next());
    }
}
