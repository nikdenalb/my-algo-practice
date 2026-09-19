package training10.contest4.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97119/problems?id=30404%2F2026_08_02%2FV4RBLfayiX">
 * Изменение графика
 * </a>
 */
public class MainRefined {

    long solve(int[] even, int k) {
        if (k == 0) return cost(even);

        int[] odd = even.clone();

        for (int i = 0; i < even.length; i++) {
            if (i % 2 == 0) even[i] += k;
            else odd[i] += k;
        }

        return Math.min(cost(even), cost(odd));
    }

    long cost(int[] arr) {
        Arrays.sort(arr);
        int m = arr[arr.length / 2];

        long out = 0;
        for (int e : arr) out += Math.abs((long) e - m);

        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nk = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(String.valueOf(new MainRefined().solve(a, nk[1])));

        reader.close();
        writer.close();
    }
}
