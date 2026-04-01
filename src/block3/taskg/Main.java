package block3.taskg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89524/problems?id=30404%2F2021_06_01%2Fw4VP0pHEF6">
 * City Che (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Constraints (from statement):<br>
     * - 2 &lt;= n &lt;= 300000<br>
     * - 1 &lt;= r &lt;= 10<sup>9</sup><br>
     * - monument distances d<sub>i</sub> are distinct and sorted in ascending order<br>
     * - 1 &lt;= d<sub>i</sub> &lt;= 10<sup>9</sup><br>
     * - time limit 1 s, memory 64 MB<br>
     * <br>
     * Goal: count pairs of monuments (i, j), i &lt; j, such that d[j] - d[i] &gt; r
     * (boys cannot see each other).<br>
     * <br>
     * Approach: two pointers on the sorted array.
     * For each left index i, move right pointer j until distance exceeds r;
     * then all indices from j to n - 1 form valid pairs with i.<br>
     *
     * @param n number of monuments
     * @param d sorted monument distances
     * @param r visibility threshold
     * @return number of valid pairs
     */
    long solve(int n, int[] d, int r) {
        long cnt = 0;
        int i = 0;
        int j = 0;
        while (i < n) {
            while (j < n) {
                if (d[j] - d[i] > r) {
                    cnt += n - j;
                    break;
                }
                j++;
            }
            i++;
        }
        return cnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] d = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        writer.write(String.valueOf(new Main().solve(nr[0], d, nr[1])));

        reader.close();
        writer.close();
    }
}
