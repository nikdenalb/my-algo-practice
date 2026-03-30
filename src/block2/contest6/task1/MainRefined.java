package block2.contest6.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89538/problems?id=30404%2F2026_03_01%2FGcSoXQkF3S">
 * Big and divisible by three (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Constraints (from statement):<br>
     * - 3 &lt;= length of s &lt;= 10<sup>5</sup><br>
     * - s consists of digits from 0 to 9<br>
     * - time limit 1 s, memory 256 MB<br>
     * <br>
     * Goal: build the largest possible number from the multiset of digits of s.
     * The number can start with leading zeros and must be divisible by 3.<br>
     * <br>
     * Approach:<br>
     * - count occurrences of each digit 0..9 and compute digit-sum = sum of (digit times its frequency).<br>
     * - let r be digit-sum modulo 3.<br>
     * - if r == 0, output all digits in descending order.<br>
     * - if r == 1, we need to reduce the remainder by 1:
     *   try to remove one digit with remainder 1 (1, 4, 7); if not possible, remove two digits with remainder 2 (2, 5, 8).<br>
     * - if r == 2, symmetric:
     *   try to remove one digit with remainder 2 (2, 5, 8); if not possible, remove two digits with remainder 1 (1, 4, 7).<br>
     * - after removals, output the remaining digits in descending order.
     *   The length is maximized because we remove either one digit or two digits (the minimum needed adjustment).<br>
     *
     * @param s input string
     * @return maximum number as a string
     */
    String solve(String s) {
        for (int i = 0; i < s.length(); i++) map.put(s.charAt(i) - '0', map.getOrDefault(s.charAt(i) - '0', 0) + 1);
        int sum = map.keySet().stream().mapToInt(e -> e * map.get(e)).sum();

        switch (sum % 3) {
            case 1 -> {
                if (!remove(rem1)) {
                    remove(rem2);
                    remove(rem2);
                }
            }
            case 2 -> {
                if (!remove(rem2)) {
                    remove(rem1);
                    remove(rem1);
                }
            }
        }

        StringBuilder out = new StringBuilder();
        map.forEach((k, v) -> out.append(String.valueOf(k).repeat(v)));
        return out.reverse().toString();
    }

    Map<Integer, Integer> map = new TreeMap<>();

    int[] rem1 = new int[]{1, 4, 7};
    int[] rem2 = new int[]{2, 5, 8};

    boolean remove(int[] divs) {
        for (int d : divs) {
            if (map.containsKey(d)) {
                int v = map.get(d);
                if (v == 1) map.remove(d);
                else map.put(d, v - 1);
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(new MainRefined().solve(reader.readLine()));

        reader.close();
        writer.close();
    }
}
