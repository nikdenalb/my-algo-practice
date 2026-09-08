package block3.taskj;

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
 * <a href="https://new.contest.yandex.ru/contests/89524/problems?id=30404%2F2021_06_01%2FBx8AwMAiv3">
 * Substring (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Constraints (from statement):<br>
     * - 1 &lt;= n &lt;= 100000<br>
     * - 1 &lt;= k &lt;= n<br>
     * - string consists of lowercase Latin letters<br>
     * - time limit 1 s, memory 64 MB<br>
     * <br>
     * Goal: find a longest substring where each character occurs at most k times.
     * Output its length and starting position.<br>
     * <br>
     * Approach: sliding window with character frequencies.
     * Expand right border; when adding character c would break limit k,
     * move left border until one occurrence of c is removed.
     * Track the best window length and its left boundary.<br>
     *
     * @param n string length
     * @param k per-character occurrence limit inside the window
     * @param s input string
     * @return [maximum length, left index] in 0-based indexing
     */
    int[] solve(int n, int k, String s) {
        int[] out = new int[2];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            char c = s.charAt(j);
            int v = map.getOrDefault(c, 0);
            if (v < k) {
                map.put(c, v + 1);
                if (j - i + 1 > out[0]) {
                    out[0] = j - i + 1;
                    out[1] = i;
                }
            } else {
                char ci = s.charAt(i++);
                while (ci != c) {
                    map.put(ci, map.get(ci) - 1);
                    ci = s.charAt(i++);
                }
            }
        }
        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nk = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String s = reader.readLine();
        int[] out = new Main().solve(nk[0], nk[1], s);
        writer.write(out[0] + " " + (out[1] + 1));

        reader.close();
        writer.close();
    }
}
