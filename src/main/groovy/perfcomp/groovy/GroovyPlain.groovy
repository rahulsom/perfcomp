package perfcomp.groovy

import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

/**
 * Created by rahul on 7/10/15.
 */
@TupleConstructor
@CompileStatic
class Person {
    String name
}
@CompileStatic
class Parent extends Person {
    Parent(String name) { super(name) }
}
@CompileStatic
class Child extends Person {
    Child(String name) {super(name)}
}
@TupleConstructor
@CompileStatic
class Dog {
    String name

    Dog(String name) {
        this.name = name
    }
}
class Util {
    @CompileStatic
    static String printName(Person person) { "printName(Person): $person.name" }
    @CompileStatic
    static String printName(Child child) { "printName(Child): $child.name" }
    static String printName(p) { "printName(p): $p.name" }
}
