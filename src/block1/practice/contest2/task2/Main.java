package block1.practice.contest2.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * OK<br>
 * 1st try<br>
 * 15 min
 */
public class Main {

    long solve(long n, long m, long h, long w) {
        long cnt = 0, cnt2 = 0;

        long cn = n, cm = m;

        while (cn > h) {
            cnt++;
            cn = (cn + 1) / 2;
        }
        while (cm > w) {
            cnt++;
            cm = (cm + 1) / 2;
        }

        cn = m;
        cm = n;

        while (cn > h) {
            cnt2++;
            cn = (cn + 1) / 2;
        }
        while (cm > w) {
            cnt2++;
            cm = (cm + 1) / 2;
        }


        return Math.min(cnt, cnt2);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] nmhw = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Main sol = new Main();

        writer.write(String.valueOf(sol.solve(nmhw[0], nmhw[1], nmhw[2], nmhw[3]    )));

        reader.close();
        writer.close();
    }
}
