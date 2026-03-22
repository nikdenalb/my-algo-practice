package block1.practice.contest3.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89535/problems?id=30404%2F2026_03_01%2FPbJ66A8D1W&contestId=89535">
 * Rebus (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * @param strs rebus tokens (word + apostrophes); each apostrophe before/after means remove 1 letter from word start/end
     * @return concatenated result (length ≤ 100)
     */
    String solve(String[] strs) {
        StringBuilder out = new StringBuilder();
        for (String str : strs) {
            int len = str.length();
            int cntL = 0;
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) == '\'') {
                    cntL++;
                } else break;
            }
            int cntR = 0;
            for (int i = len; i > 0; i--) {
                if (str.charAt(i - 1) == '\'') {
                    cntR++;
                } else break;
            }
            out.append(str, 2 * cntL, len - 2 * cntR);
        }
        return out.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = reader.readLine().split(" ");

        writer.write(new MainRefined().solve(strs));

        reader.close();
        writer.close();
    }
}
