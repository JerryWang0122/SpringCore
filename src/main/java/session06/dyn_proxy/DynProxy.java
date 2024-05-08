package session06.dyn_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 動態代理
public class DynProxy {

    // 被代理的對象
    private Object object;

    public DynProxy(Object object) {
        this.object = object;
    }

    // 取得 Proxy 物件
    public Object getProxy() {
        Object proxyObj = null;

        // 1. 載入類別器
        ClassLoader loader = object.getClass().getClassLoader();

        // 2. 被代理的物件所實作的介面
        Class<?>[] interfaces = object.getClass().getInterfaces();

        // 3. 處理代理的實現
        // handler 幫忙利用反射完成方法的參數帶入，並返回值
        InvocationHandler handler = (Object proxy, Method method, Object[] args) -> {
            Object result = null;   // 被代理物件的業務方法的回傳值

            // before
            MyLoggerAspect.before(args);

            // 調用業務方法
            result = method.invoke(object, args);

            // end
            MyLoggerAspect.end();

            return result;
        };

        // 4. 得到代理物件
        // 結合[類本身、實作類別、實現方法]返回代理物件
        proxyObj = Proxy.newProxyInstance(loader, interfaces, handler);

        return proxyObj;
    }
}
