package session03.bean;

public class ComputerBook implements Book{
    @Override
    public void display() {
        System.out.println("Java程式設計：從入門到入土");
    }
}
