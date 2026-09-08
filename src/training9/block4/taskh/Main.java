package block4.taskh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89531/problems?id=30404%2F2023_01_18%2FEJ31cTOEJL">
 * Histogram and rectangle (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Constraints (from statement):<br>
     * - N bars, 0 &lt; N ≤ 10<sup>6</sup>; bar widths are 1, heights h<sub>1</sub>, …, h<sub>N</sub> with 0 ≤ h<sub>i</sub> ≤ 10<sup>9</sup><br>
     * - find the maximum area of an axis-aligned rectangle lying on the common baseline and fully covered by the histogram<br>
     * - time limit 1 s, memory 256 MB<br>
     * <br>
     * Approach:<br>
     * - sweep left to right with a stack of (start index, height) blocks forming non-increasing heights.<br>
     * - when the current bar is lower than the stack top, pop and update the answer with width times popped height (width from stored start to current index).<br>
     * - after the sweep, drain the stack using the right end of the histogram as the closing boundary.<br>
     *
     * @param h bar heights in left-to-right order
     * @return maximum rectangle area
     */
    long solve(int[] h) {
        long out = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < h.length; i++) {
            if (stack.isEmpty() || h[i] > stack.peek()[1]) stack.push(new int[]{i, h[i]});
            else {
                int[] pop = null;
                while (!stack.isEmpty() && h[i] < stack.peek()[1]) {
                    pop = stack.pop();
                    out = Math.max(out, (long) (i - pop[0]) * pop[1]);
                }
                if (pop != null) stack.push(new int[]{pop[0], h[i]});
            }
        }
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            out = Math.max(out, (long) (h.length - pop[0]) * pop[1]);
        }
        return out;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(String.valueOf(new Main().solve(
                Arrays.stream(reader.readLine().split(" ")).skip(1).mapToInt(Integer::parseInt).toArray())));

        reader.close();
        writer.close();
    }
}
