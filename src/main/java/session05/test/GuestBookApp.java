package session05.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import session05.service.GuestBookService;

import java.util.Scanner;

@Component
public class GuestBookApp {

    @Autowired
    @Qualifier("gbService")
    private GuestBookService guestBookService;

    private String username;

    private static Scanner scanner = new Scanner(System.in);

    public void setUsername(String username) {
        this.username = username;
    }

    public void menu() {
        System.out.println("-------------------");
        System.out.println("1. 新增留言");
        System.out.println("2. 修改留言");
        System.out.println("3. 刪除留言");
        System.out.println("4. 查詢留言");
        System.out.println("9. 離開系統");
        System.out.println("-------------------");
        System.out.print("請選擇 => ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                addContent();
                break;
            case 2:
                updateContent();
                break;
            case 3:
                deleteContent();
                break;
            case 4:
                findContent();
                break;
            case 9:
                // status 1 -> 使用者自行退出
                System.exit(1);
                scanner.close();
                break;
            default:
                System.out.println("輸入錯誤，請重新輸入");
                menu();
        }
    }

    public void addContent() {
        System.out.print("請輸入留言內容： ");
        String content = scanner.nextLine();
        guestBookService.add(username, content);
    }

    public void updateContent() {
        System.out.print("請輸入要修改的留言id: ");
        int id = scanner.nextInt();
        System.out.print("請輸入要修改的留言內容: ");
        scanner.nextLine();
        String content = scanner.nextLine();
        guestBookService.updateContent(id, content);
    }

    public void deleteContent() {
        System.out.print("請輸入要刪除的留言id: ");
        int id = scanner.nextInt();
        guestBookService.removeById(id);
    }

    public void findContent() {
        guestBookService.queryAll().forEach(gb -> {
            System.out.printf("%d %s %s %s %s%n", gb.getId(), gb.getUserName(),
                    gb.getContent(), gb.getCreateDate(), gb.getUpdateDate());
        });
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("guestbook-config.xml");
        GuestBookApp app = ctx.getBean(GuestBookApp.class);
        System.out.print("請輸入暱稱: ");
        String username = scanner.next();
        app.setUsername(username);

        while (true) {
            app.menu();
        }
    }
}
