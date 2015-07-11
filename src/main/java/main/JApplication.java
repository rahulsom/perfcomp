package main;

import perfcomp.java.Child;
import perfcomp.java.Dog;
import perfcomp.java.Parent;
import perfcomp.java.Person;

import java.lang.reflect.InvocationTargetException;

import static perfcomp.java.Util.printName;

/**
 * Created by rahul on 7/10/15.
 */
public class JApplication {
    public static void java(int count) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        // Create new Parent and Child objects but use Person type reference.
        Person parent1 = new Parent("parent1");
        Person child1 = new Child("child1");

        for (int i = 0; i < count; i++) {
            assert "printName(Person): parent1".equals(printName(parent1));
            assert "printName(Child): child1".equals(printName(child1));  // This is not what Java would do!!
            assert "printName(Person): child1".equals(printName((Person) child1));
            // Same as what Java would do with printName(child1)
        }

        // Create objects with type reference is equal to object.
        Parent parent2 = new Parent("parent2");
        Child child2 = new Child("child2");

        for (int i = 0; i < count; i++) {
            assert "printName(Person): parent2".equals(printName(parent2));
            assert "printName(Child): child2".equals(printName(child2));
        }

        // Use class outside Person hierarchy.
        for (int i = 0; i < count; i++) {
            assert "printName(p): buck".equals(printName(new Dog("buck")));
        }
    }
}
