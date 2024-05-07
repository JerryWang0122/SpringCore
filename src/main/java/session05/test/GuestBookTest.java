package session05.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session05.service.GuestBookService;

public class GuestBookTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("guestbook-config.xml");
        GuestBookService guestBookService = ctx.getBean("gbService", GuestBookService.class);

        // 新增
        guestBookService.add("Helen", "Hello Spring");

        guestBookService.queryAll().forEach(gb -> {
            // 查詢全部
            System.out.printf("%d %s %s%n", gb.getId(), gb.getUserName(), gb.getContent());
        });
    }
}
