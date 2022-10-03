package BehavioralPatterns.Exercise_Strategy;

public class Main_Strategy {

    /**
     * Strategy Pattern:
     *
     * 1. You define an interface to represent a kind of task or problem:
     * e.g. the task is operating on two numbers, and we represented the task with a binary operator interface
     * 2. Each concrete implementation defines a different "strategy" for solving the task.
     * e.g. adding and subtracting numbers
     * 3. The strategies can be swapped for each other because callers code against the interface.
     *
     * Example: Calculator from Functional Programming: each binary operator defines one way to solve a task
     * 1. Represent the algorithms to solve as an interface: you want to perform operation on two integers,
     * so you define a BinaryOperator interface, with single apply method which takes two ints as parameters
     * 2. For each kind of operations your calculator supports: you defined a separate implementation of the interface
     * Each of these overrides the apply logic with custom code for that specific operator
     *
     * From the client's perspective, they don't have to know anything about how each operator is implemented
     * They just code against the interface and call the apply method, passing in whatever numbers are passes
     * to the calculator as input
     */
}
