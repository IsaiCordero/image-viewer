package software.ulpgc.imageviewerMVP.swing;

import software.ulpgc.imageviewerMVP.ImagePresenter;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        ImagePresenter presenter = new ImagePresenter(frame.getImageDisplay());
        presenter.show();
        frame.setVisible(true);
    }
}
