package perfcomp.groovy

import groovy.transform.CompileStatic
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
class Dog {
    String name
    Dog(String name) {this.name = name}
}
class Util {
    static String printName(Person person) { "printName(Person): $person.name" }
    static String printName(Child child) { "printName(Child): $child.name" }
    static String printName(p) { "printName(p): $p.name" }
}

@CompileStatic
@TupleConstructor
class StaticPerson {
    String name
}
@CompileStatic
class StaticParent extends StaticPerson {
    StaticParent(String name) { super(name) }
}
@CompileStatic
class StaticChild extends StaticParent {
    StaticChild(String name) {super(name)}
}
@CompileStatic
class StaticDog {
    String name
    StaticDog(String name) {this.name = name}
}
@CompileStatic
class StaticUtil {
    static String printName(StaticPerson person) { "printName(StaticPerson): $person.name" }
    static String printName(StaticChild child) { "printName(StaticChild): $child.name" }
    static String printName(StaticDog dog) { "printName(StaticDog): $dog.name" }
}
