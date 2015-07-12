package main

import groovy.transform.CompileStatic
import perfcomp.groovy.StaticChild
import perfcomp.groovy.StaticDog
import perfcomp.groovy.StaticParent
import perfcomp.groovy.StaticPerson
import perfcomp.java.Child
import perfcomp.java.Dog
import perfcomp.java.Parent
import perfcomp.java.Person

import static perfcomp.groovy.StaticUtil.printName as gsPrintName
import static perfcomp.java.Util.printName as jPrintName

/**
 * Created by rahul on 7/11/15.
 */
@CompileStatic
class GApplication {

    public static void javaStatic(int count) {

        // Create new Parent and Child objects but use Person type reference.
        Person parent1 = new Parent('parent1')
        Person child1 = new Child('child1')
        count.times {
            assert 'printName(Person): parent1' == jPrintName(parent1)
            assert 'printName(Child): child1' == jPrintName(child1)  // This is not what Java would do!!
            assert 'printName(Person): child1' == jPrintName(child1 as Person)
            // Same as what Java would do with printName(child1)
        }

        // Create objects with type reference is equal to object.
        Parent parent2 = new Parent('parent2')
        Child child2 = new Child('child2')

        count.times {
            assert 'printName(Person): parent2' == jPrintName(parent2)
            assert 'printName(Child): child2' == jPrintName(child2)
        }

        // Use class outside Person hierarchy.
        count.times {
            assert 'printName(p): buck' == jPrintName(new Dog('buck'))
        }
    }

    public static void groovyStatic(int count) {

        // Create new Parent and Child objects but use Person type reference.
        StaticPerson parent1 = new StaticParent('parent1')
        StaticPerson child1 = new StaticChild('child1')
        count.times {
            assert 'printName(StaticPerson): parent1' == gsPrintName(parent1)
            assert 'printName(StaticChild): child1' == gsPrintName(child1)  // This is not what Java would do!!
            assert 'printName(StaticPerson): child1' == gsPrintName(child1 as StaticPerson)
            // Same as what Java would do with printName(child1)
        }

        // Create objects with type reference is equal to object.
        StaticParent parent2 = new StaticParent('parent2')
        StaticChild child2 = new StaticChild('child2')

        count.times {
            assert 'printName(StaticPerson): parent2' == gsPrintName(parent2)
            assert 'printName(StaticChild): child2' == gsPrintName(child2)
        }

        // Use class outside Person hierarchy.
        count.times {
            assert 'printName(StaticDog): buck' == gsPrintName(new StaticDog('buck'))
        }
    }

}
