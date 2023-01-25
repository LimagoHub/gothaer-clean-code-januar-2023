package de.uebung.mittwoch;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

public class TimeMeasurementProxy implements java.lang.reflect.InvocationHandler {

    private Object obj;

    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new TimeMeasurementProxy(obj));
    }

    private TimeMeasurementProxy(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method m, Object[] args)
            throws Throwable
    {
        Object result;
        try {
            var start = Instant.now();
            result = m.invoke(obj, args);
            var end = Instant.now();
            var duration = Duration.between(start,end);
            System.out.println("Duration =" + duration.toMillis() + "ms");
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " +
                    e.getMessage());
        }
        return result;
    }
}