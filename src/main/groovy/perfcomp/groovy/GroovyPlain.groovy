package perfcomp.groovy

import groovy.transform.Immutable
import groovy.transform.TupleConstructor

/**
 * Created by rahul on 7/10/15.
 */
@TupleConstructor
class Person {
    String name
}
class Parent extends Person {
    Parent(String name) { super(name) }
}
class Child extends Person {
    Child(String name) {super(name)}
}
@TupleConstructor
class Dog {
    String name
}
class Util {
    static String printName(Person person) { "printName(Person): $person.name" }
    static String printName(Child child) { "printName(Child): $child.name" }
    static String printName(p) { "printName(p): $p.name" }
}