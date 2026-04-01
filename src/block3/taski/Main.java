package block3.taski;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89524/problems?id=30404%2F2021_06_01%2F7yFSb8a0Zt">
 * Beauty above all (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Constraints (from statement):<br>
     * - 1 &lt;= N, K &lt;= 250000<br>
     * - there is at least one tree of each of K types in the whole alley<br>
     * - tree types are positive integers<br>
     * - time limit 2 s, memory 64 MB<br>
     * <br>
     * Goal: find the minimum-length contiguous segment that contains at least one tree
     * of each of K types; output its boundaries.<br>
     * <br>
     * Approach: sliding window with frequency map.
     * Expand right border, and while all K types are present, shrink left border
     * to keep the segment minimal; track the best segment found.<br>
     *
     * @param n number of trees
     * @param k number of types
     * @param t tree types in order
     * @return boundaries [left, right] in 0-based indexing
     */
    int[] solve(int n, int k, int[] t) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] out = new int[2];
        int min = Integer.MAX_VALUE;

        for (int i = 0, j = 0; j < n; j++) {
            map.put(t[j], map.getOrDefault(t[j], 0) + 1);
            while (map.size() == k) {
                int d = j - i + 1;
                if (d < min) {
                    min = d;
                    out[0] = i;
                    out[1] = j;
                }
                int v = map.get(t[i]);

                if (v == 1) map.remove(t[i]);
                else map.put(t[i], v - 1);

                i++;
            }
        }
        return out;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] NK = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] t = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] out = new Main().solve(NK[0], NK[1], t);
        writer.write(out[0] + 1 + " " + (out[1] + 1));

        reader.close();
        writer.close();
    }
}
