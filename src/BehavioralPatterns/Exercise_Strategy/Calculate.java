package BehavioralPatterns.Exercise_Strategy;

public class Calculate {


    public static void main(String[] args){

        Calculator calculator = new Calculator();

        // define four concrete strategies, the code is open to extension but close for modification
        calculator.registerOperation("+", (a, b) -> a + b);
        calculator.registerOperation("-", (a, b) -> a - b);
        calculator.registerOperation("*", (a, b) -> a * b);
        calculator.registerOperation("/", (a, b) -> a / b);

        int a = 10;
        int b = 5;
        String sign = "*";

        System.out.println(calculator.calculate(a, sign, b));


    }
}
