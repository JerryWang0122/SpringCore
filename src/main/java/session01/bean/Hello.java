package session01.bean;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Hello {
    private Date today;

    public Hello() {
        System.out.println("Hello Constructor");
        today = new Date();
    }

    public Date getToday() {
        return today;
    }
}
