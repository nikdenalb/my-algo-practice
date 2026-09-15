package training10.contest1.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97742/problems?id=30404%2F2026_08_02%2FrhgbJji1en">
 * Подстроки-поданаграммы (Yandex Contest)
 * </a>
 */
public class MainRefined {

    long solve(String s, String t) {
        int[] target = new int[26];
        for (int i = 0; i < t.length(); i++) target[t.charAt(i) - 'a']++;

        int[] curr = new int[26];
        long cnt = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            curr[s.charAt(r) - 'a']++;

            while (curr[s.charAt(r) - 'a'] > target[s.charAt(r) - 'a']) {
                curr[s.charAt(l++) - 'a']--;
            }

            cnt += r - l + 1;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();
        String t = reader.readLine();
        writer.write(String.valueOf(new MainRefined().solve(s, t)));

        reader.close();
        writer.close();
    }
}
