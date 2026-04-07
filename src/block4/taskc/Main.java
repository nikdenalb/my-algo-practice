package block4.taskc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89529/problems?id=175943%2F2016_11_22%2FeSUHFTjBwZ">
 * Valid bracket sequence (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Constraints (from statement):<br>
     * - the input contains at most 100000 bracket characters<br>
     * - allowed brackets: (), [], {}<br>
     * - empty sequence is valid<br>
     * - time limit 1 s, memory 64 MB<br>
     * <br>
     * Goal: decide whether the given bracket sequence is valid under standard matching and nesting rules.<br>
     * <br>
     * Approach:<br>
     * - scan left to right with a stack of opening brackets.<br>
     * - push every opening bracket; for a closing bracket, the stack must be non-empty and its top must be the matching opening type.<br>
     * - if mismatch or premature closing appears, return false immediately; at the end the stack must be empty.<br>
     *
     * @param s bracket sequence
     * @return true if sequence is valid, false otherwise
     */
    boolean solve(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                if (c == ')' || c == ']' || c == '}') return false;
                stack.push(c);
            } else if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                switch (stack.pop()) {
                    case '(' -> {if (c != ')') return false;}
                    case '[' -> {if (c != ']') return false;}
                    case '{' -> {if (c != '}') return false;}
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(new Main().solve(reader.readLine()) ? "yes" : "no");

        reader.close();
        writer.close();
    }
}
