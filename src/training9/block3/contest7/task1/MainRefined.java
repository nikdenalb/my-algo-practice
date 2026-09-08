package block3.contest7.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89539/problems?id=30404%2F2025_06_18%2F36Q7seV1id">
 * Dance school (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Constraints (from statement):<br>
     * - 1 &lt;= n &lt;= 10<sup>6</sup><br>
     * - second line is a string of length n over letters a (girl) and b (boy)<br>
     * - time limit 2 s, memory 256 MB<br>
     * <br>
     * Goal: count contiguous substrings where the number of a and the number of b are equal.<br>
     * <br>
     * Approach:<br>
     * - map a to +1 and b to -1 and scan left to right, keeping the running balance d (prefix sum).<br>
     * - a substring has equal counts exactly when the balance returns to a value seen before:
     *   if the balance after index i equals the balance after index j with j &lt; i, the segment (j+1)..i is valid.<br>
     * - maintain a frequency map of balances, seeded with balance 0 once before the string; at each step add the
     *   previous count for the current balance to the answer, then increment that count.<br>
     *
     * @param n length of the row (redundant with s.length() but matches input format)
     * @param s row description, a and b only
     * @return number of valid contiguous groups
     */
    long solve(int n, String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int d = 0;
        long out = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') d++;
            else d--;

            int bfr = map.getOrDefault(d, 0);
            out += bfr;
            map.put(d, bfr + 1);
        }
        return out;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String s = reader.readLine();
        writer.write(String.valueOf(new MainRefined().solve(n, s)));

        reader.close();
        writer.close();
    }
}
