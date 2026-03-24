package block2.taskb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89518/problems?id=175943%2F2016_10_05%2FUMhQ1iX3LS">
 * Has the number been seen before (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * @param arr sequence of numbers
     * @return for each element: "YES" if it appeared earlier, "NO" otherwise (one per line)
     */
    String solve(int[] arr) {
        Set<Integer> set = new HashSet<>();
        StringBuilder out = new StringBuilder();

        for (int i : arr) out.append(set.add(i) ? "NO" : "YES").append("\n");

        if (!out.isEmpty()) out.setLength(out.length() - 1);
        return out.toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        writer.write(new Main().solve(arr));

        reader.close();
        writer.close();
    }
}
