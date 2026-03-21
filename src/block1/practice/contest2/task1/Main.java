package block1.practice.contest2.task1;

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

    int solve(int n, String str) {

        int cnt = 0;
        int out = 0;
        char curr = 'x';
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'h') {
                if (curr != str.charAt(i)) {
                    cnt++;
                } else {
                    cnt = 1;
                }
            } else {
                cnt = 0;
            }
            out = Math.max(out, cnt);
            curr = str.charAt(i);
        }
        return out;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String str = reader.readLine();

        Main sol = new Main();

        writer.write(String.valueOf(sol.solve(n, str)));

        reader.close();
        writer.close();
    }
}

