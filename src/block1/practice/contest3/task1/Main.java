package block1.practice.contest3.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * OK<br>
 * 1st try<br>
 * 10 min
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = reader.readLine().split(" ");

        StringBuilder out = new StringBuilder();

        for (String str : strs) {
            int a = 0;
            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 39) {
                    cnt++;
                } else break;
            }
            a = a + 2 * cnt;

            int b = str.length();
            cnt = 0;
            for (int i = str.length() - 1; i >= 0; i--) {
                if (str.charAt(i) == 39) {
                    cnt++;
                } else break;
            }
            b = b - 2 * cnt;

            out.append(str, a, b);
        }

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
