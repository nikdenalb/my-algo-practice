package block4.contest10.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89542/problems?id=30404%2F2026_03_01%2FiIkWLqxwqb">
 * Telemetry (Yandex Contest)
 * </a>
 * <br><br>
 * Constraints (from statement):<br>
 * - 1 &lt;= n &lt;= 10 windows, 1 &lt;= m, k &lt;= 1000<br>
 * - commands are lowercase letters, Backspace, Copy, Paste, Next<br>
 * - each window shows only the last k symbols of its current document<br>
 * - time limit 1 s, memory 256 MB<br>
 * <br>
 * Solution idea:<br>
 * - keep each window as a character deque and track active window index.<br>
 * - process commands one by one: append letter, remove tail, copy visible suffix to buffer, paste buffer, or switch window.<br>
 * - after all commands, output the visible suffix of the active window; print Empty when it has no visible symbols.<br>
 */
public class MainRefined {

    List<Deque<Character>> wnds;
    int wnd = 0;
    int vsbl;
    StringBuilder buff = new StringBuilder();

    void initWnds(int n) {
        wnds = new ArrayList<>(n);
        while (n-- > 0) wnds.add(new ArrayDeque<>());
    }

    void addChar(String ch) {
        wnds.get(wnd).push(ch.charAt(0));
    }

    void doBackspace() {
        Deque<Character> w = wnds.get(wnd);
        if (!w.isEmpty()) w.pop();
    }

    void doCopy() {
        buff.setLength(0);
        Iterator<Character> it = wnds.get(wnd).iterator();
        int cnt = 0;
        while (it.hasNext() && cnt < vsbl) {
            buff.append(it.next());
            cnt++;
        }
        buff.reverse();
    }

    void doPaste() {
        Deque<Character> w = wnds.get(wnd);
        buff.chars().forEach(c -> w.push((char) c));
    }

    void doNext() {
        wnd = (wnd + 1) % wnds.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nmk = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        MainRefined sol = new MainRefined();
        sol.initWnds(nmk[0]);
        sol.vsbl = nmk[2];

        for (int i = 0; i < nmk[1]; i++) {
            String cmd = reader.readLine();
            switch (cmd) {
                case "Backspace" -> sol.doBackspace();
                case "Copy" -> sol.doCopy();
                case "Paste" -> sol.doPaste();
                case "Next" -> sol.doNext();
                default -> sol.addChar(cmd);
            }
        }

        sol.doCopy();
        writer.write(sol.buff.isEmpty() ? "Empty" : sol.buff.toString());

        reader.close();
        writer.close();
    }
}
