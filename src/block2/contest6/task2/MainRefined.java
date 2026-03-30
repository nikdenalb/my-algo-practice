package block2.contest6.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89538/problems?id=30404%2F2026_03_01%2F9c8kDjsgHV">
 * Not in your own plate (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Constraints (from statement):<br>
     * - 1 &lt;= n &lt;= 2 · 10<sup>5</sup><br>
     * - a is a permutation of 1..n (all dishes are distinct)<br>
     * - one operation rotates the table clockwise by 1 position<br>
     * - time limit 1 s, memory 256 MB<br>
     * <br>
     * Goal: find the minimum number k of rotations so that for every guest i
     * the dish near i is not i. If no such k exists, return -1.<br>
     * <br>
     * Approach in this implementation:<br>
     * - for each guest position i (0-based), compute a forbidden shift value
     *   where guest i would receive the allergic dish after rotation.<br>
     * - collect all forbidden shifts into a set.<br>
     * - if every shift 0..n-1 is forbidden, answer is -1;
     *   otherwise return the smallest shift that is not forbidden.<br>
     *
     * @param n number of guests and dishes
     * @param a initial dishes by positions, permutation of 1..n
     * @return minimum valid rotation count, or -1 if impossible
     */
    int solve(int n, int[] a) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) set.add((a[i] - i - 1) < 0 ? a[i] - i - 1 + n : a[i] - i - 1);
        if (set.size() == n) return -1;
        for (int i = 0; i < n; i++) if (!set.contains(i)) return i;
        throw new RuntimeException();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        writer.write(String.valueOf(new MainRefined().solve(n, a)));

        reader.close();
        writer.close();
    }
}
