package session01.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

@Component
@Scope("prototype")
public class Lotto {
    private Set<Integer> numbers;

    public Lotto() {
        System.out.println("Lotto Constructor");
        // 自動產生 1~ 39 不重複的號碼 5 個 (今彩539)
        Random random = new Random();
        numbers = new LinkedHashSet<>();
        while (numbers.size() < 5) {
            int number = random.nextInt(39) + 1;
            numbers.add(number);    // 自動去除重複
        }
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
