package block4.contest10.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

/**
 * OK<br>
 * 1st try<br>
 * 26 min
 */
public class Main {

    static Deque<Character>[] wnds;
    static int cur = 0;
    static int k;
    static String buff = "";

    static void doChar(String s) {
        wnds[cur].addLast(s.charAt(0));
    }

    static void doBackspace() {
        if (!wnds[cur].isEmpty()) wnds[cur].removeLast();
    }

    static void doCopy() {
        StringBuilder out = new StringBuilder();
        Iterator<Character> it = wnds[cur].descendingIterator();
        int cnt = 0;
        while (it.hasNext() && cnt < k) {
            out.append(it.next());
            cnt++;
        }
        buff = out.reverse().toString();
    }

    static void doPaste() {
        for (int i = 0; i < buff.length(); i++) {
            wnds[cur].addLast(buff.charAt(i));
        }
    }

    static void doNext(int n) {
        cur = (cur + 1) % n;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nmk = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmk[0];
        int m = nmk[1];
        k = nmk[2];

        wnds = new ArrayDeque[n];
        for (int i = 0; i < n; i++) {
            wnds[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < m; i++) {
            String cmd = reader.readLine();
            switch (cmd) {
                case "Backspace" -> doBackspace();
                case "Copy" -> doCopy();
                case "Paste" -> doPaste();
                case "Next" -> doNext(n);
                default -> doChar(cmd);
            }
        }

        StringBuilder out = new StringBuilder();
        Iterator<Character> it = wnds[cur].descendingIterator();
        int cnt = 0;
        while (it.hasNext() && cnt < k) {
            out.append(it.next());
            cnt++;
        }
        if (out.isEmpty()) {
            writer.write("Empty");
        } else {
            writer.write(out.reverse().toString());
        }

        reader.close();
        writer.close();
    }
}
