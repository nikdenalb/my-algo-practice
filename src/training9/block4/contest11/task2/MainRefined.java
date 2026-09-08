package block4.contest11.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89543/problems?id=30404%2F2026_03_01%2Fsmt8Z50leS">
 * Practice tests (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Constraints (from statement):<br>
     * - n questions, 1 ≤ n ≤ 100; answer key is a length-n string over A, B, C, D<br>
     * - m students, 1 ≤ m ≤ 100; each submission is a length-n string over the same alphabet<br>
     * - time limit 1 s, memory 256 MB<br>
     * <br>
     * Two works are similar if, for each of the two submissions, strictly more than half of its correct<br>
     * positions match the other submission on that position, and strictly more than half of its wrong<br>
     * positions match the other submission there (same letter on both).<br>
     * <br>
     * Approach: one linear scan over positions. Track how many answers each student got right (gA, gB), how<br>
     * many wrong (bA, bB), and how many positions fall into the "both correct and agree" and "both wrong and<br>
     * agree" buckets (gAB, bAB). Similarity holds when twice gAB is greater than both gA and gB and twice bAB is greater than both bA and bB.<br>
     *
     * @param ans correct answer string (length n)
     * @param a first student answers
     * @param b second student answers
     * @return true if the two submissions are similar by the statement definition
     */
    static boolean solve(String ans, String a, String b) {
        int gA = 0, gB = 0, gAB = 0, bA = 0, bB = 0, bAB = 0;
        for (int i = 0; i < ans.length(); i++) {
            char ansChar = ans.charAt(i), aChar = a.charAt(i), bChar = b.charAt(i);
            if (aChar == bChar) {
                if (ansChar == aChar) {
                    gA++;
                    gB++;
                    gAB++;
                } else {
                    bA++;
                    bB++;
                    bAB++;
                }
            } else if (ansChar == aChar) {
                gA++;
                bB++;
            } else if (ansChar == bChar) {
                bA++;
                gB++;
            } else {
                bA++;
                bB++;
            }
        }
        return  2 * gAB > gA &&
                2 * gAB > gB &&
                2 * bAB > bA &&
                2 * bAB > bB;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine(); // int n = Integer.parseInt(reader.readLine());
        String ans = reader.readLine();
        int m = Integer.parseInt(reader.readLine());
        String[] wks = new String[m];
        for (int i = 0; i < m; i++) wks[i] = reader.readLine();

        int cnt = 0;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (solve(ans, wks[i], wks[j])) {
                    cnt++;
                    out.append(i + 1).append(" ").append(j + 1).append("\n");
                }
            }
        }
        out.insert(0, cnt + "\n");
        out.setLength(out.length() - 1);
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
