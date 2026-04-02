package block3.contest7.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89539/problems?id=30404%2F2026_03_01%2FQbex9H1n9L">
 * Candy subsegment (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Constraints (from statement):<br>
     * - 1 &lt;= n &lt;= 10<sup>6</sup><br>
     * - p<sub>i</sub> are candy types with 1 &lt;= p<sub>i</sub> &lt;= 10<sup>9</sup><br>
     * - time limit 2.5 s, memory 256 MB<br>
     * <br>
     * Goal: maximize the length of a contiguous segment that contains exactly two distinct candy types.<br>
     * If no such segment exists, the answer is 0.<br>
     * <br>
     * Approach:<br>
     * - scan with two pointers i (left) and j (right) and a frequency map for the current window.<br>
     * - extend j by one candy; while more than two distinct types appear, shrink from the left (increment i and
     *   update counts) until at most two types remain.<br>
     * - whenever the window has exactly two distinct types, update the answer with the window length j - i + 1.<br>
     *
     * @param n number of candies (matches array length)
     * @param p types in row order
     * @return maximum segment length with exactly two distinct types
     */
    int solve(int n, int[] p) {
        int out = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; j < n; j++) {
            map.put(p[j], map.getOrDefault(p[j], 0) + 1);

            for (; map.size() > 2; i++) {
                int v = map.get(p[i]);

                if (v == 1) map.remove(p[i]);
                else map.put(p[i], v - 1);
            }

            if (map.size() == 2) out = Math.max(out, j - i + 1);
        }

        return out;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] p = java.util.Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        writer.write(String.valueOf(new MainRefined().solve(n, p)));

        reader.close();
        writer.close();
    }
}
