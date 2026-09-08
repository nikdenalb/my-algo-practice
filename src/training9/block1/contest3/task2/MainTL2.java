package block1.contest3.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/** Maintains accumulated a and b for the next d. TL on test 50. */
public class MainTL2 {

    long solve(long n) {
        long a = 1;
        long b = 1;
        long d = 0;
        while (true) {

            while (a * b < n) {
                a++;
                b++;
            }

            if (a * b == n ||
                    a * (b - 1) + (a + 1) / 2 == n ||
                    a * (b - 1) + (a + 1) / 2 - a % 2 == n ||

                    (a - 1) * b + (b + 1) / 2 == n ||
                    (a - 1) * b + (b + 1) / 2 - b % 2 == n

            ) return d;

            b--;
            d++;
            while (a * b >= n) {
                a--;
                b--;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(reader.readLine());
        writer.write(String.valueOf(new MainTL2().solve(n)));

        reader.close();
        writer.close();
    }
}
