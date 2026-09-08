package block3.contest8.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89540/problems?id=30404%2F2026_02_21%2F1KdDEqxsEa">
 * Cafeteria queue (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Constraints (from statement):<br>
     * - multiple test cases; sum of n over all tests is at most 10<sup>6</sup>, cases at most 10<sup>4</sup><br>
     * - 1 &lt;= n &lt;= 10<sup>5</sup>, 1 &lt;= d &lt;= 10<sup>9</sup> (Zhenya's order duration; his patience is unlimited)<br>
     * - person i has patience t<sub>i</sub> and order duration k<sub>i</sub> with 1 &lt;= t<sub>i</sub>, k<sub>i</sub> &lt;= 10<sup>9</sup><br>
     * - waiting time of a person is the total order time of everyone in front; initially no one exceeds their patience<br>
     * - time limit 4 s, memory 256 MB<br>
     * <br>
     * Goal: among insertion positions that keep every patron within their patience after Zhenya joins, return the one
     * closest to the front of the queue; if only standing after everyone works, return n.<br>
     * <br>
     * Approach:<br>
     * - prefK[i] stores the sum of order times of everyone in front of person i before Zhenya is inserted.<br>
     * - if Zhenya is inserted immediately before the person at index p, then every person at index j &gt;= p has prefK[j] + d
     *   as wait time, so we need t<sub>j</sub> - prefK[j] &gt;= d for all j from p through n - 1.<br>
     * - walk indices from n - 1 down while that inequality holds and record the last index visited: that value is the
     *   smallest valid p. If the chain breaks before the start, the result stays n.<br>
     *
     * @param n queue length
     * @param t patience limits in queue order
     * @param k order durations in queue order
     * @param d Zhenya's order duration
     * @return smallest insertion index p with a valid suffix as above, or n if Zhenya must be after all n people
     */
    int solve(int n, int[] t, int[] k, int d) {
        int[] prefK = new int[n];
        int out = n;
        for (int i = 1; i < n; i++) prefK[i] = prefK[i - 1] + k[i - 1];
        for (int i = n - 1; i >= 0 && t[i] - prefK[i] >= d; i--) out = i;
        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder out = new StringBuilder();
        MainRefined sol = new MainRefined();

        int cases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < cases; i++) {
            int[] nd = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] t = new int[nd[0]];
            int[] k = new int[nd[0]];
            for (int j = 0; j < nd[0]; j++) {
                int[] tk = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                t[j] = tk[0];
                k[j] = tk[1];
            }
            out.append(sol.solve(nd[0], t, k, nd[1]) + 1).append("\n");
        }
        out.setLength(out.length() - 1);
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
