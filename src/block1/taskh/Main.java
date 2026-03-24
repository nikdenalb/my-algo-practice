package block1.taskh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89515/problems?id=30404%2F2020_09_26%2FE0bUCqDLBR&contestId=89515">
 * Equation with square root (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Solves √(ax+b) = c in integers; returns solution(s), NO SOLUTION, or MANY SOLUTIONS.
     * <br>
     * Constraints: all intermediate values fit in int.<br>
     * <br>
     * Examples: (1,0,0)→0; (1,2,3)→7; (1,2,-3)→NO SOLUTION
     *
     * @param a coefficient
     * @param b constant
     * @param c right-hand side
     * @return solution(s), NO SOLUTION, or MANY SOLUTIONS
     */
    String solve(int a, int b, int c) {
        if (c < 0) return "NO SOLUTION";
        if (a == 0) {
            if (b == c * c) return "MANY SOLUTIONS";
            return "NO SOLUTION";
        }
        int t = c * c - b;
        if (t % a != 0) return "NO SOLUTION";

        return String.valueOf(t / a);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        Main sol = new Main();
        writer.write(sol.solve(a, b, c));

        reader.close();
        writer.close();
    }
}
