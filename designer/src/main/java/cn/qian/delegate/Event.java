package cn.qian.delegate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @author: 千里明月
 * @date: 2019/3/29 11:31
 */
public class Event {
    private Object o;
    private String method;
    private Object[] params;
    private Class[] paramTypes;

    public Event(Object o, String method, Object... args) {
        this.o = o;
        this.method = method;
        this.params = args;
        paramTypes = new Class[args.length];
        for (int i = 0; i < params.length; i++) {
            paramTypes[i] = params.getClass();
        }
    }

    public void invoke() {
        try {
            Method method = this.o.getClass().getMethod(this.method, paramTypes);
            method.invoke(o, params);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
