package block4.taska;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89528/problems?id=175943%2F2016_11_22%2FF1DnicRrIx">
 * Stack with error protection (Yandex Contest)
 * </a>
 * <br><br>
 * Constraints (from statement):<br>
 * - input contains stack commands, one command per line<br>
 * - supported commands: push n, pop, back, size, clear, exit<br>
 * - for empty stack, pop and back must print error<br>
 * - time limit 1 s, memory 64 MB<br>
 * <br>
 * Solution idea:<br>
 * - keep an integer stack (Deque).<br>
 * - process commands in a loop and append protocol lines to output.<br>
 * - for pop/back, check emptiness first; print error if needed, otherwise print value.<br>
 * - stop on exit, print bye, and terminate.<br>
 */
public class Main {

    static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder out = new StringBuilder();
        for (String s = reader.readLine(); ; s = reader.readLine()) {
            String[] cmd = s.split(" ");
            switch (cmd[0]) {
                case "push" -> {
                    stack.push(Integer.parseInt(cmd[1]));
                    out.append("ok").append("\n");
                }
                case "pop" -> {
                    if (stack.isEmpty()) {
                        out.append("error").append("\n");
                        break;
                    }
                    out.append(stack.pop()).append("\n");
                }
                case "back" -> {
                    if (stack.isEmpty()) {
                        out.append("error").append("\n");
                        break;
                    }
                    out.append(stack.peek()).append("\n");
                }
                case "size" -> out.append(stack.size()).append("\n");
                case "clear" -> {
                    stack.clear();
                    out.append("ok").append("\n");
                }
                case "exit" -> {
                    out.append("bye");
                    writer.write(out.toString());
                    reader.close();
                    writer.close();
                    return;
                }
            }
        }
    }
}
