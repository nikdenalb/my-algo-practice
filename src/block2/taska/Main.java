package block2.taska;

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
 * <a href="https://new.contest.yandex.ru/contests/89518/problems?id=175943%2F2016_10_05%2FNepkmQOKvw">
 * Number of distinct numbers (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * @param arr list of integers (up to 10<sup>5</sup>)
     * @return number of distinct values
     */
    int solve(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) set.add(i);
        return set.size();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        writer.write(String.valueOf(new Main().solve(arr)));

        reader.close();
        writer.close();
    }
}
