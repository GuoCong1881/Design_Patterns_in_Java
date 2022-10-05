public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    /**
     * SOLID: Principles of Good Software Design
     *
     * - Single Responsibility Principle
     * - Open-Closed Principle
     * - Liskov Substitution Principle
     * - Interface Segregation Principle
     * - Dependency Inversion Principle
     *
     * A design pattern is a general solution to certain kinds of common design issues that occur in software development.
     * These patterns provide guidelines for how you can organize and write software.
     * They will not design your code for you — It's still up to you to fill in the blanks and customize
     * each pattern to fit your use case.
     *
     * This lesson covers three broad categories of software design patterns:
     *
     * - Creational patterns: patterns that deal with creating objects
     * - Behavioral patterns: patterns that deal with how different objects interact
     * - Structural patterns: patterns that deal with how different objects fit together
     */

    /**
     * Creational Patterns:
     * - Singleton: i.e. database
     * - Abstract Factory
     * - Builder
     *
     * Behavioral Patterns:
     * - Strategy pattern
     * - Template Method pattern
     *
     * Structural Patterns: involve how objects fit together to form the structure of the software
     * - Adapter pattern
     * - decorator pattern
     *
     * Dependency: anything your code needs to work, such as an external library, an environment variable, a remote webstie, or a database
     * In the context of dependency injection, a dependency usually refers to an object, class, or interface that your code
     * imports, creates, or uses
     *
     * Dependency Injection (DI)
     * is a design pattern that moves the creation of dependencies to outside of your code.
     * Instead of creating objects, you tell the DI framework to create the objects for you, and
     * then you inject those objects into your class
     *
     * DI disadvantages:
     * - requires extra configuration (annotations or XML)
     * - can make code harder to understand and debug
     *
     *
     */
}