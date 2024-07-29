package FactoryMethodPattern;

public class PdfDocument implements Document {
    @Override
    public void create() {
        System.out.println("Creating a PDF Document.");
    }
}

