import com.google.gson.annotations.Expose;

public class Widget {
    // full control for serialize or deserialize the fields with Expose annotation
    @Expose(deserialize = false)
    private String debug;
    @Expose(serialize = false)
    private Window window;
    @Expose
    private Image image;
    @Expose
    private Text text;

    Widget() {

    }

    Widget(String debug, Image image, Window window, Text text){
        this.debug = debug;
        this.window = window;
        this.image = image;
        this.text = text;
    }

    public String getDebug() {
        return debug;
    }

    public void setDebug(String debug) {
        this.debug = debug;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Widget{" +
                "debug='" + debug + '\'' +
                ", image=" + image +
                ", text=" + text +
                '}';
    }
}
