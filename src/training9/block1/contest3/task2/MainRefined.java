package block1.contest3.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89535/problems?id=30404%2F2026_03_01%2FaTLZNKrRRU&contestId=89535">
 * Bunker exam (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * @param n number of students (1 ≤ n ≤ 10<sup>12</sup>)
     * @return minimum |rows − maxStudentsInRow| under seating constraints
     */
    long solve(long n) {
        this.n = n;
        out = n - 1;
        checkDivs(2 * n);
        checkDivs(2 * n - 1);
        checkDivs(2 * n + 1);
        return out;
    }

    long n;
    long out;

    void checkDivs(long num) {
        for (long i = 1; i <= num / i; i++) if (num % i == 0)
            out = Math.min(Math.abs(i - (n + i - 1) / i), out);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(reader.readLine());
        writer.write(String.valueOf(new MainRefined().solve(n)));

        reader.close();
        writer.close();
    }
}
