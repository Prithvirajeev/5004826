package ProxyPattern;

public class ProxyPatternTest {

    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image will be loaded and displayed from the server
        image1.display();

        // Image is already loaded, so it will be displayed directly
        image1.display();

        // Image will be loaded and displayed from the server
        image2.display();
    }
}

