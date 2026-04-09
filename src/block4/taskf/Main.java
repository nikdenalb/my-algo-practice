package block4.taskf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89530/problems?id=30404%2F2023_01_18%2FHgDt2DvsLq">
 * Arithmetic expression value (Yandex Contest)
 * </a>
 * <br><br>
 * Constraints (from statement):<br>
 * - expression length is at most 100 characters<br>
 * - allowed tokens: integers, +, -, *, parentheses, spaces<br>
 * - no spaces inside numbers; invalid syntax must produce WRONG<br>
 * - absolute values of numbers and all intermediate results do not exceed 2 x 10<sup>9</sup><br>
 * - time limit 1 s, memory 256 MB<br>
 * <br>
 * Solution idea:<br>
 * - parse the input into tokens, handling unary minus as a dedicated operator marker.<br>
 * - convert infix tokens to postfix (RPN) with an operator stack and precedence rules.<br>
 * - evaluate postfix with an integer stack.<br>
 * <br>
 * If any structural mismatch appears at any stage, output WRONG.<br>
 */
public class Main {

    String solve(List<String> rpn) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String t : rpn) {
            if (Character.isDigit(t.charAt(0))) {
                stack.push(Integer.parseInt(t));

            } else if (t.equals("~")) {
                if (stack.isEmpty()) return null;
                stack.push(-stack.pop());

            } else if (t.equals("+") || t.equals("-") || t.equals("*")) {
                if (stack.size() < 2) return null;
                int b = stack.pop();
                int a = stack.pop();
                if (t.equals("+")) stack.push(a + b);
                else if (t.equals("-")) stack.push(a - b);
                else stack.push(a * b);

            } else return null;
        }

        if (stack.size() != 1) return null;
        return String.valueOf(stack.pop());
    }

    List<String> toRpn(List<String> tokens) {
        List<String> out = new ArrayList<>();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String t : tokens) {
            if (Character.isDigit(t.charAt(0))) {
                out.add(t);

            } else if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("~")) {
                int p = t.equals("+") || t.equals("-") ? 1 : (t.equals("*") ? 2 : 3);

                while (!stack.isEmpty()) {
                    String top = stack.peek();
                    if (top.equals("+") || top.equals("-") || top.equals("*") || top.equals("~")) {
                        int pt = top.equals("+") || top.equals("-") ? 1 : (top.equals("*") ? 2 : 3);

                        if (pt > p || (pt == p && !t.equals("~"))) out.add(stack.pop());
                        else break;

                    } else break;
                }
                stack.push(t);

            } else if (t.equals("(")) stack.push(t);

            else if (t.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) out.add(stack.pop());
                if (stack.isEmpty()) return null;
                stack.pop();

            } else return null;
        }

        while (!stack.isEmpty()) {
            if (stack.peek().equals("(")) return null;
            out.add(stack.pop());
        }

        return out;
    }

    List<String> tokenize(String s) {
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (c == ' ') i++;
            else if (Character.isDigit(c)) {
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) j++;
                tokens.add(s.substring(i, j));
                i = j;
            } else if (c == '+' || c == '*' || c == '(' || c == ')') {
                tokens.add(String.valueOf(c));
                i++;
            } else if (c == '-') {
                String p = tokens.isEmpty() ? "" : tokens.getLast();
                boolean unary = tokens.isEmpty()
                        || p.equals("(")
                        || p.equals("+")
                        || p.equals("-")
                        || p.equals("*")
                        || p.equals("~");
                tokens.add(unary ? "~" : "-");
                i++;
            } else return null;
        }
        return tokens;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Main sol = new Main();
        List<String> tokens = sol.tokenize(reader.readLine());
        if (tokens == null) {
            writer.write("WRONG");
            reader.close();
            writer.close();
            return;
        }

        List<String> rpn = sol.toRpn(tokens);
        if (rpn == null) {
            writer.write("WRONG");
            reader.close();
            writer.close();
            return;
        }

        String out = sol.solve(rpn);
        writer.write(out == null ? "WRONG" : out);

        reader.close();
        writer.close();
    }
}
