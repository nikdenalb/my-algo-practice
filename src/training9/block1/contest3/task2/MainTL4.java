package block1.contest3.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/** Desperate refinement of old solutions. Slightly faster, TL still on test 50. */
public class MainTL4 {

    long solve(long n) {

        long a = 1;
        while (a * a < n) a++;
        long b = a;

        for (long d = 0; ; d++, b--) {
            while (a * b < n) {
                a++;
                b++;
            }
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
        writer.write(String.valueOf(new MainTL4().solve(n)));

        reader.close();
        writer.close();
    }
}
