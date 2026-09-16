package training10.contest2.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97117/problems?id=30404%2F2026_08_02%2FCG0w5tl2xP">
 * Запрещенная сумма (Yandex Contest)
 * </a>
 * <br><br>
 * Solve time 00:12. 1 failed submit (Missed the case 2e == k).<br>
 */
public class Main {

    int solve(int n, int k, int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : a) map.put(e, map.getOrDefault(e, 0) + 1);

        int out = 0;
        Set<Integer> check = new HashSet<>();
        for (Integer e : map.keySet()) {
            if (check.contains(e)) continue;

            if (e == k - e) out += map.get(e) - 1;
            else out += Math.min(map.getOrDefault(e, 0), map.getOrDefault(k - e, 0));

            check.add(e);
            check.add(k - e);
        }

        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nk = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        writer.write(String.valueOf(new Main().solve(nk[0], nk[1], a)));

        reader.close();
        writer.close();
    }
}
