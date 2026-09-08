package block3.contest9.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89541/problems?id=30404%2F2026_03_01%2F4wKqIj2wx0">
 * Final grade (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Constraints (from statement):<br>
     * - non-empty string of uppercase letters A through Z, length at most 100<br>
     * - A is the best grade, Z the worst; time limit 1 s, memory 256 MB<br>
     * <br>
     * Goal: compute the semester final letter: arithmetic mean of the letters (by their character codes),
     * rounded to the nearest integer code; ties (half-integers) round toward the better grade (smaller code).
     * The result may not be more than one grade level better than the worst mark in the list — take the worse of
     * the rounded average and that ceiling.<br>
     * <br>
     * Approach:<br>
     * - sum character codes; let q and r be quotient and remainder by n. Use q as the base letter code; if 2r &gt; n,
     *   add one (round up to the next code). If 2r = n, leave q (half-integer rounds toward the better, smaller code).<br>
     * - worst letter in the string has the largest code; the allowed best final is one step toward A, i.e. code
     *   one below that maximum. Return whichever letter is worse (larger code) between the rounded average and this cap.<br>
     *
     * @param s semester grades
     * @return final grade letter
     */
    char solve(String s) {
        int sum = s.chars().sum();
        char avg = (char) (sum / s.length() + ((sum % s.length() * 2 > s.length()) ? 1 : 0));
        char max = (char) (s.chars().max().getAsInt() - 1);
        if (max > avg) return max;
        return avg;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(new MainRefined().solve(reader.readLine()));

        reader.close();
        writer.close();
    }
}
