package software.ulpgc.imageviewerMVP;

public interface Image {
    String id();
    Image next();
    Image prev();
}
