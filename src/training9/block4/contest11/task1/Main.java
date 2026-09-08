package block4.contest11.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * OK<br>
 * 1st try<br>
 * 20 min
 */
public class Main {

    boolean solve(String s) {
        if (s == null || s.isEmpty()) return true;
        boolean flag;
        for (int shft = 0; shft < s.length(); shft++) {
            flag = true;
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt((shft + i) % s.length());

                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    switch (c) {
                        case ')' -> {
                            if (stack.isEmpty() || stack.pop() != '(') {
                                flag = false;
                            }
                        }
                        case ']' -> {
                            if (stack.isEmpty() || stack.pop() != '[') {
                                flag = false;
                            }
                        }
                        case '}' -> {
                            if (stack.isEmpty() || stack.pop() != '{') {
                                flag = false;
                            }
                        }
                    }
                }
                if (!flag) break;
            }
            if (flag && stack.isEmpty()) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(new Main().solve(reader.readLine()) ? "YES" : "NO");

        reader.close();
        writer.close();
    }
}
