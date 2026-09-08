package block1.taskf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89514/problems?id=175943%2F2016_10_02%2FaTZNpVtH2V">
 * Maximum product of two numbers (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Finds two numbers with maximum product and returns them in non-decreasing order.
     * <br>
     * Constraints: length(arr) ≥ 2; the answer is unique.<br>
     * <br>
     * Examples: [3, 5, 2, 5]→(5, 5); [-4, 3, -5, 2, 5]→(-5, -4)
     *
     * @param arr list of integers (length ≥ 2)
     * @return two integers (a, b) where a ≤ b and a*b is maximal
     */
    int[] solve(int[] arr) {
        int[] four = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int e : arr) {
            if (e < four[0]) {
                four[1] = four[0];
                four[0] = e;
            } else if (e < four[1]) {
                four[1] = e;
            }
            if (e > four[3]) {
                four[2] = four[3];
                four[3] = e;
            } else if (e > four[2]) {
                four[2] = e;
            }
        }

        if ((long) four[0] * four[1] > (long) four[2] * four[3]) return new int[]{four[0], four[1]};

        return new int[]{four[2], four[3]};
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Main sol = new Main();

        writer.write(Arrays.stream(sol.solve(arr)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}
