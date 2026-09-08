package block3.taskf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89524/problems?id=30404%2F2018_11_06%2FiKSicqI2LF">
 * Stylish clothes (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Constraints (from statement):<br>
     * - 1 &lt;= N, M &lt;= 100000<br>
     * - color values are in [1, 10000000]<br>
     * - both arrays are strictly increasing<br>
     * - time limit 1 s, memory 64 MB<br>
     * <br>
     * Goal: choose one T-shirt color and one pants color with minimum absolute difference.
     * If several pairs are optimal, any is acceptable.<br>
     * <br>
     * Approach: two pointers on sorted arrays. Compare current pair, update best answer,
     * then move the pointer on the smaller color to potentially reduce difference.<br>
     *
     * @param n number of T-shirt colors
     * @param a sorted T-shirt colors
     * @param m number of pants colors
     * @param b sorted pants colors
     * @return pair [shirtColor, pantsColor] with minimal difference
     */
    int[] solve(int n, int[] a, int m, int[] b) {
        int[] out = new int[2];
        int i = 0, j = 0, d = Integer.MAX_VALUE;
        while (i < n && j < m) {
            if (Math.abs(a[i] - b[j]) < d) {
                out[0] = a[i];
                out[1] = b[j];
                d = Math.abs(a[i] - b[j]);
            }
            if (a[i] < b[j]) i++;
            else j++;
        }

        return out;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        int[] shorts = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(reader.readLine());
        int[] pants = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        writer.write(Arrays.stream(new Main().solve(N, shorts, M, pants))
                .mapToObj(Integer::toString).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}
