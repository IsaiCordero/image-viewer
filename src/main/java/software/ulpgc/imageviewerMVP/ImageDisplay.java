package software.ulpgc.imageviewerMVP;

public interface ImageDisplay {
    void paint(String var1, int var2);
    int getWidth();
    void clear();
    void on(Shift shift);
    void on(Released released);

    public interface Shift {
        Shift Null = (offset) -> {};
        void offset(int offset);
    }
    public interface Released {
        Released Null = (offset) -> {};
        void offset(int offset);
    }

}
