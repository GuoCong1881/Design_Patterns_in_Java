package BehavioralPatterns.Exercise_Strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

/**
 * Client code of the strategy pattern
 *
 * when register a new operator, or applies an existing operator,
 * this code is completely agnostic of which concrete strategy is using
 * this is a great example of the Liskov substitution principle, no matter what concrete implementation
 * is being used under the hood, this client code works. When the client calls the apply method,
 * polymorphism defines which implementation gets called
 */

public class Calculator {

    public static Map<String, BinaryOperator<Integer>> operations = new HashMap<>();
    public Calculator(){}

    public void registerOperation(String sign, BinaryOperator<Integer> operation){
        operations.put(sign, operation);
    }

    public int calculate(int a, String sign, int b){
        return operations.get(sign).apply(a, b);
    }


}
