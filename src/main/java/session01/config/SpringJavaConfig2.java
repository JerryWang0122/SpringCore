package session01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"session01.bean"})
public class SpringJavaConfig2 {
    // 要掃描的類標註 @Compoment，便可以使用ComponentScan掃描路徑下的所有標注類

    /**
     * 目前學習到：
     * 1. 使用.xml直接配置 -> 打錯字不會反映
     * 2. 使用 @Configuration -> 一個類就要打一次，很累
     * 3. 再加上@ComponentScan -> 預告，還會有第四種，即SpringBoot
     */
}
