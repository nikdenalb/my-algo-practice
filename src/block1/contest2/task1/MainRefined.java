package block1.contest2.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89534/problems?id=30404%2F2026_03_01%2FlSDcPWTDzA&contestId=89534">
 * Ahaha (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * @param n   string length (1 ≤ n ≤ 10<sup>5</sup>)
     * @param str string of lowercase Latin letters
     * @return maximum length of laughter (alternating "a" and "h" substring)
     */
    int solve(int n, String str) {
        int out = 0;
        int cnt = 0;
        char prev = '*';
        for (int i = 0; i < n; i++) {
            char curr = str.charAt(i);

            if (curr == 'a' && prev == 'h' || curr == 'h' && prev == 'a') {
                cnt++;
                out = Math.max(out, cnt);

            } else if (curr == 'a' || curr == 'h') {
                cnt = 1;
                out = Math.max(out, 1);
            }

            prev = curr;
        }
        return out;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String str = reader.readLine();

        writer.write(String.valueOf(new MainRefined().solve(n, str)));

        reader.close();
        writer.close();
    }
}
