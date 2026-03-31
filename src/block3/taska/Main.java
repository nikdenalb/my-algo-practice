package block3.taska;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89523/problems?id=30404%2F2023_02_12%2FFjysFo4AwB">
 * Prefix sums (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Constraints (from statement):<br>
     * - 1 &lt;= n &lt;= 10<sup>3</sup><br>
     * - absolute value of each element is at most 10<sup>6</sup><br>
     * - time limit 1 s, memory 256 MB<br>
     * <br>
     * Goal: compute prefix sums b where b[j] = a[1] + ... + a[j] for all positions.<br>
     * <br>
     * Approach: build array b left to right; b[0] = a[0], then b[i] = b[i - 1] + a[i].<br>
     *
     * @param n number of elements
     * @param a input sequence
     * @return prefix sums sequence
     */
    int[] solve(int n, int[] a) {
        int[] b = new int[n];
        b[0] = a[0];
        for (int i = 1; i < n; i++) b[i] = a[i] + b[i - 1];
        return b;
    }

    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(Arrays.stream(new Main().solve(n, a)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}
