package session06.dyn_proxy;

import java.lang.reflect.Method;
import java.util.Arrays;

// Aspect 切面程式
public class MyPrintArgsAspect {
    // before: 前置通知
    public static void before(Method method, Object[] args) {
        System.out.printf("Method Name is %s, Parameter includes %s%n",
                method.getName(), Arrays.toString(args));
    }
}
