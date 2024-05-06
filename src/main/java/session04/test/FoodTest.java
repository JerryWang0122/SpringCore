package session04.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session04.bean.ComboMeal;
import session04.config.FoodConfig;

// 使用 java 配置在執行時要加上 VM 參數: --add-opens java.base/java.lang=ALL-UNNAMED
public class FoodTest {
    public static void main(String[] args) {
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("food-config.xml");  // xml配置 auto-scan
        ApplicationContext ctx = new AnnotationConfigApplicationContext(FoodConfig.class); // java配置 auto-scan
        ComboMeal comboMeal = ctx.getBean("comboMeal", ComboMeal.class);
        System.out.println(comboMeal.serveMeal());
    }
}
