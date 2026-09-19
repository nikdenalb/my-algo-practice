package training10.contest2.task1;

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
 * <a href="https://new.contest.yandex.ru/contests/97117/problems?id=30404%2F2026_08_02%2FCG0w5tl2xP">
 * Запрещенная сумма
 * </a>
 */
public class MainRefined {

    int solve(int k, int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : a) map.merge(e, 1, Integer::sum);

        int out = 0;
        for (int e : map.keySet()) {
            int p = k - e;

            if (e < p) out += Math.min(map.get(e), map.getOrDefault(p, 0));
            else if (e == p) out += map.get(e) - 1;
        }

        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nk = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        writer.write(String.valueOf(new MainRefined().solve(nk[1], a)));

        reader.close();
        writer.close();
    }
}
