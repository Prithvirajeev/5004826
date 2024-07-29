package FactoryMethodPattern;

public class WordDocument implements Document {
    @Override
    public void create() {
        System.out.println("Creating a Word Document.");
    }
}
