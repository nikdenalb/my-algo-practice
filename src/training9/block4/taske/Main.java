package block4.taske;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89530/problems?id=30404%2F2023_01_18%2FqS3OsBniXH">
 * Postfix notation (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Constraints (from statement):<br>
     * - one line with postfix expression tokens separated by spaces<br>
     * - tokens are digits and operations +, -, *<br>
     * - time limit 1 s, memory 256 MB<br>
     * <br>
     * Solution idea:<br>
     * - evaluate postfix expression with an integer stack.<br>
     * - for a digit, push its value; for an operator, pop required operands, apply operation, push result.<br>
     * - after processing all tokens, the stack top is the expression value.<br>
     *
     * @param expr postfix expression without spaces as char array
     * @return evaluated integer value
     */
    int solve(char[] expr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : expr) {
            switch (c) {
                case '+' -> stack.push(stack.pop() + stack.pop());
                case '-' -> {
                    int x2 = stack.pop();
                    int x1 = stack.pop();
                    stack.push(x1 - x2);
                }
                case '*' -> stack.push(stack.pop() * stack.pop());
                default -> stack.push(Integer.parseInt(String.valueOf(c)));
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(String.valueOf(new Main().solve(reader.readLine().replace(" ", "").toCharArray())));

        reader.close();
        writer.close();
    }
}
