import java.util.Scanner;

public class Main {
    private static int index;
    private static String expression;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the expression: ");
        String input = scanner.nextLine().replaceAll("\\s", ""); // Remove all whitespaces
        scanner.close();

        System.out.println("Expression: " + input);
        double result = evaluateExpression(input);
        if (Double.isNaN(result)) {
            System.out.println("Malformed expression");
        } else {
            System.out.println("Result: " + result);
        }
    }

    public static double evaluateExpression(String exp) {
        expression = exp;
        index = 0;
        double result = evaluate();
        if (index != expression.length()) {
            return Double.NaN; // Malformed expression
        }
        return result;
    }

    private static double evaluate() {
        double term = parseTerm();
        while (index < expression.length()) {
            char operator = expression.charAt(index);
            if (operator != '+' && operator != '-') {
                break;
            }
            index++;
            double nextTerm = parseTerm();
            if (operator == '+') {
                term += nextTerm;
            } else {
                term -= nextTerm;
            }
        }
        return term;
    }

    private static double parseTerm() {
        double factor = parseFactor();
        while (index < expression.length()) {
            char operator = expression.charAt(index);
            if (operator != '*' && operator != '/') {
                break;
            }
            index++;
            double nextFactor = parseFactor();
            if (operator == '*') {
                factor *= nextFactor;
            } else {
                factor /= nextFactor;
            }
        }
        return factor;
    }

    private static double parseFactor() {
        double value;
        int startPos = index;
        if (expression.charAt(index) == '(') {
            index++;
            value = evaluate();
            if (expression.charAt(index) != ')') {
                return Double.NaN; // Malformed expression
            }
            index++;
        } else {
            while (index < expression.length() && (Character.isDigit(expression.charAt(index)) || expression.charAt(index) == '.')) {
                index++;
            }
            if (index > startPos) {
                value = Double.parseDouble(expression.substring(startPos, index));
            } else {
                value = parseFunction();
            }
        }
        return value;
    }

    private static double parseFunction() {
        int startPos = index;
        while (index < expression.length() && Character.isLetter(expression.charAt(index))) {
            index++;
        }
        String function = expression.substring(startPos, index);
        if (index < expression.length() && expression.charAt(index) == '(') {
            index++;
            double argument = evaluate();
            if (expression.charAt(index) != ')') {
                return Double.NaN; // Malformed expression
            }
            index++;
            switch (function) {
                case "cos":
                    return Math.cos(argument);
                case "acos":
                    return Math.acos(argument);
                case "sin":
                    return Math.sin(argument);
                case "asin":
                    return Math.asin(argument);
                case "tan":
                    return Math.tan(argument);
                case "atan":
                    return Math.atan(argument);
                case "sqrt":
                    return Math.sqrt(argument);
                case "pow":
                    return Math.pow(argument, parseFactor());
                default:
                    return Double.NaN; // Unknown function
            }
        } else {
            return Double.NaN; // Malformed expression
        }
    }
}
