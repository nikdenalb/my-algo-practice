package block4.taskd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89529/problems?id=30404%2F2024_11_02%2FmyVIGk5VNm">
 * Minimum valid bracket sequence (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Constraints (from statement):<br>
     * - 1 &lt;= n &lt;= 100000<br>
     * - w is a permutation of four distinct bracket characters: (, ), [, ]<br>
     * - s is a prefix of the answer, and its length does not exceed n<br>
     * - answer existence is guaranteed<br>
     * - time limit 1 s, memory 64 MB<br>
     * <br>
     * Goal: among all valid bracket sequences of length n over round and square brackets that start with s, build the
     * lexicographically minimal one according to order in w.<br>
     * <br>
     * Approach:<br>
     * - reconstruct the current open-bracket stack after reading prefix s.<br>
     * - append remaining characters greedily: at each step try symbols in w order and pick the first symbol that keeps
     *   completion feasible (closing must match stack top; opening is allowed only if enough positions remain to close all opens).<br>
     * - this produces the minimal lexicographic continuation under the validity constraint.<br>
     *
     * @param n required final length
     * @param w lexicographic order of bracket symbols
     * @param s required prefix
     * @return lexicographically minimal valid sequence of length n with prefix s
     */
    String solve(int n, String w, String s) {
        n -= s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' || s.charAt(i) == ']') stack.pop();
            else stack.push(c);
        }
        StringBuilder out = new StringBuilder(s);
        for (; n > 0; n--) {
            if (stack.isEmpty()) {
                char c = (char) w.chars().filter(e -> e == '(' || e == '[').findFirst().getAsInt();
                stack.push(c);
                out.append(c);
                continue;
            }
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                        out.append(c);
                        break;
                    }
                } else if (c == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                        out.append(c);
                        break;
                    }
                } else if (c == '(') {
                    if (n > stack.size()) {
                        stack.push(c);
                        out.append(c);
                        break;
                    }
                } else {
                    if (n > stack.size()) {
                        stack.push(c);
                        out.append(c);
                        break;
                    }
                }
            }
        }
        return out.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String w = reader.readLine();
        String s = reader.readLine();
        writer.write(new Main().solve(n, w, s));

        reader.close();
        writer.close();
    }
}
