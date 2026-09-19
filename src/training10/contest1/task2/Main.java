package training10.contest1.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97742/problems?id=30404%2F2026_08_02%2FrhgbJji1en">
 * Подстроки-поданаграммы
 * </a>
 * <br><br>
 * Solve time 00:35 (00:45 − 00:10). No submit errors.<br>
 * <br>
 * Contest penalty 00:10 + 00:45 = 55.<br>
 */
public class Main {

    long solve(String s, String t) {
        int[] tLts = new int[26];
        for (int i = 0; i < t.length(); i++) tLts[t.charAt(i) - 'a']++;

        int[] cur = new int[26];
        long cnt = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            cur[s.charAt(r) - 'a']++;

            while (cur[s.charAt(r) - 'a'] > tLts[s.charAt(r) - 'a']) {
                cur[s.charAt(l++) - 'a']--;
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
        writer.write(String.valueOf(new Main().solve(s, t)));

        reader.close();
        writer.close();
    }
}
