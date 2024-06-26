package session01.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session01.bean.Lotto;

public class TestLotto {
    public static void main(String[] args) {
        // 利用 Spring 得到 Lotto 號碼並印出
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
        // 因為 scope="prototype" 所以會實現多例而非預設的單例(singleton)
        Lotto lotto = ctx.getBean(Lotto.class);
        System.out.println(lotto.getNumbers());
        Lotto lotto2 = ctx.getBean(Lotto.class);
        System.out.println(lotto2.getNumbers());
        System.out.println(lotto == lotto2);    // false
    }
}
