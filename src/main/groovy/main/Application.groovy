package main

import groovy.transform.CompileStatic
import perfcomp.java.Child as JChild
import perfcomp.java.Dog as JDog
import perfcomp.java.Parent as JParent
import perfcomp.java.Person as JPerson

import static perfcomp.java.Util.printName as jPrintName

import perfcomp.groovy.Child as GChild
import perfcomp.groovy.Dog as GDog
import perfcomp.groovy.Parent as GParent
import perfcomp.groovy.Person as GPerson

import static perfcomp.groovy.Util.printName as gPrintName

/**
 * Created by rahul on 7/10/15.
 */
class Application {

    public static final int LOOP_SIZE = 300

    @SuppressWarnings("UnnecessaryQualifiedReference")
    public static void main(String[] args) {

        benchmark {
            'JApplication.java' {JApplication.java(LOOP_SIZE)}
            'Application.java' {Application.java(LOOP_SIZE)}
            'Application.javaStatic' {Application.javaStatic(LOOP_SIZE)}
            'Application.groovy' {Application.groovy(LOOP_SIZE)}
            'Application.groovyStatic' {Application.groovyStatic(LOOP_SIZE)}
        }.prettyPrint()

    }

    private static void java(int count) {

        // Create new Parent and Child objects but use Person type reference.
        JPerson parent1 = new JParent('parent1')
        JPerson child1 = new JChild('child1')
        count.times {
            assert 'printName(Person): parent1' == jPrintName(parent1)
            assert 'printName(Child): child1' == jPrintName(child1)  // This is not what Java would do!!
            assert 'printName(Person): child1' == jPrintName(child1 as JPerson)
            // Same as what Java would do with printName(child1)
        }

        // Create objects with type reference is equal to object.
        JParent parent2 = new JParent('parent2')
        JChild child2 = new JChild('child2')

        count.times {
            assert 'printName(Person): parent2' == jPrintName(parent2)
            assert 'printName(Child): child2' == jPrintName(child2)
        }

        // Use class outside Person hierarchy.
        count.times {
            assert 'printName(p): buck' == jPrintName(new JDog('buck'))
        }
    }

    @CompileStatic
    private static void javaStatic(int count) {

        // Create new Parent and Child objects but use Person type reference.
        JPerson parent1 = new JParent('parent1')
        JPerson child1 = new JChild('child1')
        count.times {
            assert 'printName(Person): parent1' == jPrintName(parent1)
            assert 'printName(Child): child1' == jPrintName(child1)  // This is not what Java would do!!
            assert 'printName(Person): child1' == jPrintName(child1 as JPerson)
            // Same as what Java would do with printName(child1)
        }

        // Create objects with type reference is equal to object.
        JParent parent2 = new JParent('parent2')
        JChild child2 = new JChild('child2')

        count.times {
            assert 'printName(Person): parent2' == jPrintName(parent2)
            assert 'printName(Child): child2' == jPrintName(child2)
        }

        // Use class outside Person hierarchy.
        count.times {
            assert 'printName(p): buck' == jPrintName(new JDog('buck'))
        }
    }

    private static void groovy(int count) {

        // Create new Parent and Child objects but use Person type reference.
        GPerson parent1 = new GParent('parent1')
        GPerson child1 = new GChild('child1')
        count.times {
            assert 'printName(Person): parent1' == gPrintName(parent1)
            assert 'printName(Child): child1' == gPrintName(child1)  // This is not what Java would do!!
            assert 'printName(Person): child1' == gPrintName(child1 as GPerson)
            // Same as what Java would do with printName(child1)
        }

        // Create objects with type reference is equal to object.
        GParent parent2 = new GParent('parent2')
        GChild child2 = new GChild('child2')

        count.times {
            assert 'printName(Person): parent2' == gPrintName(parent2)
            assert 'printName(Child): child2' == gPrintName(child2)
        }

        // Use class outside Person hierarchy.
        count.times {
            assert 'printName(p): buck' == gPrintName(new GDog('buck'))
        }
    }

    @CompileStatic
    private static void groovyStatic(int count) {

        // Create new Parent and Child objects but use Person type reference.
        GPerson parent1 = new GParent('parent1')
        GPerson child1 = new GChild('child1')
        count.times {
            assert 'printName(Person): parent1' == gPrintName(parent1)
            assert 'printName(Child): child1' == gPrintName(child1)  // This is not what Java would do!!
            assert 'printName(Person): child1' == gPrintName(child1 as GPerson)
            // Same as what Java would do with printName(child1)
        }

        // Create objects with type reference is equal to object.
        GParent parent2 = new GParent('parent2')
        GChild child2 = new GChild('child2')

        count.times {
            assert 'printName(Person): parent2' == gPrintName(parent2)
            assert 'printName(Child): child2' == gPrintName(child2)
        }

        // Use class outside Person hierarchy.
        count.times {
            assert 'printName(p): buck' == gPrintName(new GDog('buck'))
        }
    }
}
