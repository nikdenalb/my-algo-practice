package block1.practice1.taska;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89513/problems?id=30404%2F2019_04_20%2F0vHYYXV4gG">
 * Tree painting (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Solves the "Tree painting" problem: count how many trees can be painted when two painters
     * start at trees P and Q and paint dries beyond distance V and M respectively.<br>
     * <br>
     * Constraints: all values are integers, |P|,|V|,|Q|,|M| ≤ 10<sup>8</sup>.<br>
     * <br>
     * Example: P=0, V=7, Q=12, M=5 → 25
     *
     * @param P tree where the first painter's bucket is placed
     * @param V max distance the first painter can go from P
     * @param Q tree where the second painter's bucket is placed
     * @param M max distance the second painter can go from Q
     * @return number of trees that can be painted
     */
    int solve(int P, int V, int Q, int M) {
        return (V + M + 1) * 2 - Math.max(Math.min(P + V, Q + M) - Math.max(P - V, Q - M) + 1, 0);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] PV = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] QM = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Main sol = new Main();
        writer.write(String.valueOf(sol.solve(PV[0], PV[1], QM[0], QM[1])));

        reader.close();
        writer.close();
    }
}
