package block1.practice.contest3.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/** Finds side via binary search. TL on test 16. */
public class MainTL3 {

    long solve(long n) {
        for (long d = 0; ; d++) {
            long a = 1;
            for (long r = n; a < r; ) {
                long m = (a + r) / 2;
                if (m - d > Long.MAX_VALUE / m || m * (m - d) >= n) r = m;
                else a = m + 1;
            }
            long b = a - d;
            if (    a * b == n ||
                    a * (b - 1) + (a + 1) / 2 == n ||
                    a * (b - 1) + (a + 1) / 2 - a % 2 == n ||

                    (a - 1) * b + (b + 1) / 2 == n ||
                    (a - 1) * b + (b + 1) / 2 - b % 2 == n

            ) return d;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(reader.readLine());
        writer.write(String.valueOf(new MainTL3().solve(n)));

        reader.close();
        writer.close();
    }
}
