package block4.contest11.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89543/problems?id=30404%2F2026_03_01%2FaWLgjLfK6L">
 * Bracket cyclic shift (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Constraints (from statement):<br>
     * - string s has length from 0 to 1000 and consists of (, ), [, ], {, }<br>
     * - time limit 1 s, memory 256 MB<br>
     * <br>
     * Goal: answer whether s is a cyclic shift of some valid bracket sequence (empty string counts as valid).<br>
     * <br>
     * Approach:<br>
     * - try every rotation offset; for each, read characters in cyclic order and validate with a stack like a normal bracket sequence.<br>
     * - return true if any rotation is fully balanced with an empty stack at the end.<br>
     *
     * @param s input bracket string
     * @return true if some cyclic shift is a valid bracket sequence
     */
    boolean solve(String s) {
        if (s.isEmpty()) return true;
        for (int i = 0; i < s.length(); i++) if (shiftCheck(s, i)) return true;
        return false;
    }

    boolean shiftCheck(String s, int shift) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt((i + shift) % s.length());
            if (c == '{' || c == '(' || c == '[') stack.push(c);
            else if (stack.isEmpty()) return false;
            else if (c == ')' && stack.pop() != '(') return false;
            else if (c == '}' && stack.pop() != '{') return false;
            else if (c == ']' && stack.pop() != '[') return false;
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(new MainRefined().solve(reader.readLine()) ? "YES" : "NO");

        reader.close();
        writer.close();
    }
}
