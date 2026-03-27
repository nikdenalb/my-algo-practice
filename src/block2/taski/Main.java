package block2.taski;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89521/problems?id=30404%2F2018_03_12%2F2oXhUy1rrL">
 * Palindrome (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * @param s string of uppercase Latin letters (1 <= N <= 100000)
     * @return longest possible palindrome; if several, lexicographically first
     */
    String solve(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        char mid = '*';
        StringBuilder out = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (mid == '*' && entry.getValue() % 2 == 1) mid = entry.getKey();
            out.append(String.valueOf(entry.getKey()).repeat(entry.getValue() / 2));
        }
        out.append(new StringBuilder(out).reverse());
        if (mid != '*') out.insert(out.length() / 2, mid);

        return out.toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine(); //int N = Integer.parseInt(reader.readLine());
        String s = reader.readLine();
        writer.write(new Main().solve(s));

        reader.close();
        writer.close();
    }
}
