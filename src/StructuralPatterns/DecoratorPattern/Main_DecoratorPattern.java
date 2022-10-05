package StructuralPatterns.DecoratorPattern;

import java.io.IOException;

public class Main_DecoratorPattern {

    /**
     * The decorator pattern:
     *
     * Adds new functionality to an existing object dynamically by "wrapping" it.
     * Favoring composition
     *
     * In addition to the design principles, we already reviewed there are others
     * like "favor composition over inheritance" and decorator pattern comply with it.
     */

    /**
     * Adapter VS Decorator VS Proxy
     *
     * These patterns both wrap another object, called the delegate
     * - An Adapter returns a different interface than the delegate
     * - A decorator returns the same interface, but with added functionality or responsibilities
     * - A proxy is similar to a Decorator, but the proxy usually controls or manages access to the delegate
     *
     * Why is composition import to the Adapter and Decorator patterns?
     * - Both these patterns "wrap" a delegate class instead of inheriting from it
     */
}
