package block2.taskj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89521/problems?id=30404%2F2018_03_13%2F3WMjhWoEpY">
 * Maya writing decryption (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * @param W word glyphs (1 <= g <= 3000)
     * @param S inscription glyphs (g <= |S| <= 3000000)
     * @return number of contiguous substrings of length g that are permutations of W
     */
    int solve(String W, String S) {
        Map<Character, Integer> w = new HashMap<>();
        Map<Character, Integer> c = new HashMap<>();
        for (int i = 0; i < W.length(); i++) {
            w.put(W.charAt(i), w.getOrDefault(W.charAt(i), 0) + 1);
            c.put(S.charAt(i), c.getOrDefault(S.charAt(i), 0) + 1);
        }
        int out = w.equals(c) ? 1 : 0;
        for (int i = 0; i + W.length() < S.length(); i++) {
            if (c.get(S.charAt(i)) == 1) c.remove(S.charAt(i));
            else c.put(S.charAt(i), c.get(S.charAt(i)) - 1);
            c.put(S.charAt(i + W.length()), c.getOrDefault(S.charAt(i + W.length()), 0) + 1);
            if (w.equals(c)) out++;
        }
        return out;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine(); // int[] gS = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String W = reader.readLine();
        String S = reader.readLine();

        writer.write(String.valueOf(new Main().solve(W, S)));

        reader.close();
        writer.close();
    }
}
