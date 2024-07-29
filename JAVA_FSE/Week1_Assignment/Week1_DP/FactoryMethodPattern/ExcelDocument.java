package FactoryMethodPattern;
public class ExcelDocument implements Document {
    @Override
    public void create() {
        System.out.println("Creating an Excel Document.");
    }
}
