package block1.practice.contest3.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Failed<br>
 * No Submissions<br>
 * 50 min
 */
public class Main {

    long solve(long n) {
        long b = 0;
        while (true) {
            long a = b + 1;
            while (a * (a - b) < n) {
                a++;
            }
            if (a % 2 == 0) {}

            if (a * (a - b) == n ||
                    (a - 1) * (a - b) + (a - 1) / 2 == n ||
                    (a - 1) * (a - b) + (a - 1) / 2 + (a - 1) % 2 == n ||


                    (a) * (a - b - 1) + (a - b - 1) / 2 == n ||
                    (a) * (a - b - 1) + (a - b - 1) / 2 + (a - b - 1) % 2 == n
            )
                return b;
            b++;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        long n = Long.parseLong(reader.readLine());
        Main sol = new Main();

        writer.write(String.valueOf(sol.solve(n)));

        reader.close();
        writer.close();
    }
}







/*

------
-----
------
-----
------
-----



 */
