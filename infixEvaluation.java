package Stack;

import java.util.*;

public class infixEvaluation {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string");
        String s = sc.nextLine();
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                operators.push(ch);
            } else if (Character.isDigit(ch)) {
                operand.push(ch - '0'); // char to int
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    char optor = operators.pop();
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    int opv = operation(v1, v2, optor);
                    operand.push(opv);
                }
                operators.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '('
                        && precedence(ch) <= precedence(operators.peek())) {
                    char optor = operators.pop();
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    int opv = operation(v1, v2, optor);
                    operand.push(opv);
                }
                operators.push(ch);
            }
        }

        while (operators.size() != 0) {
            char optor = operators.pop();
            int v2 = operand.pop();
            int v1 = operand.pop();
            int opv = operation(v1, v2, optor);
            operand.push(opv);
        }
        System.out.println(operand.peek());
    }

    public static int precedence(char op) {
        if (op == '+') {
            return 1;
        } else if (op == '-') {
            return 1;
        } else if (op == '*') {
            return 2;
        } else {
            return 2;
        }
    }

    public static int operation(int v1, int v2, char op) {
        if (op == '+') {
            return v1 + v2;
        } else if (op == '-') {
            return v1 - v2;
        } else if (op == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }
}
