import java.util.Stack;

public class BalancedParentheses {

    public static boolean isPair(char open, char close) {
        if (open == '(' && close == ')') {
            return true;
        } else if (open == '{' && close == '}') {
            return true;
        } else if (open == '[' && close == ']') {
            return true;
        }
        return false;
    }

    public static boolean areBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty() || !isPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expression;
        System.out.print("Enter an expression: ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        expression = scanner.nextLine();

        if (areBalanced(expression)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }
}

