package warmup.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * OK<br>
 * 1st try<br>
 * 13 min
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < s.length(); ) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                int n = Integer.parseInt(s.substring(i, i + 2));
                out.append((char) ('j' + n - 10));
                i += 3;
            } else {
                int n = Integer.parseInt(String.valueOf(s.charAt(i)));
                out.append((char) ('a' + n - 1));
                i++;
            }
        }
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
