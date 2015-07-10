package perfcomp.java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by rahul on 7/10/15.
 */
public class Util {
    public static String printName(Person person) {
        return "printName(Person): " + person.getName();
    }
    public static String printName(Child person) {
        return "printName(Child): " + person.getName();
    }
    public static String printName(Object person) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method[] methods = person.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().equals("getName")) {
                return "printName(p): " + method.invoke(person);
            }
        }
        return null;
    }
}
