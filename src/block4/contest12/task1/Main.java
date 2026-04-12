package block4.contest12.task1;

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
 * 24 min
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] bs = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int cnt = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < bs.length; i++) {
            stack.push(bs[i]);
            while (i + 1 < bs.length && bs[i + 1] == bs[i]) {
                stack.push(bs[i++]);
            }
            Iterator<Integer> it = stack.iterator();
            int[] tail = new int[3];
            Arrays.fill(tail, -1);
            for (int j = 0; it.hasNext() && j <= 2; j++) {
                tail[j] = it.next();
            }
            if (tail[0] == tail[1] && tail[1] == tail[2] && tail[0] != -1) {
                int p = stack.pop();
                cnt++;
                while (!stack.isEmpty() && stack.peek() == p) {
                    cnt++;
                    stack.pop();
                }
            }
        }
        writer.write(String.valueOf(cnt));

        reader.close();
        writer.close();
    }
}
