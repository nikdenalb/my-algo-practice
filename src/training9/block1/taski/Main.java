package block1.taski;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89515/problems?id=30404%2F2024_10_19%2FGleLWiHsN0&contestId=89515">
 * T-shirts and socks (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Returns (M, N) such that among M t-shirts and N sock pairs there is a same-color match, and M+N is minimal.
     * <br>
     * Constraints: A,B,C,D ≤ 10<sup>9</sup>; at least one same-color (t-shirt, socks) pair exists.<br>
     * <br>
     * Example: (6,2,7,3)→(3,4)
     *
     * @param A blue t-shirts
     * @param B red t-shirts
     * @param C blue sock pairs
     * @param D red sock pairs
     * @return {M, N}
     */
    int[] solve(int A, int B, int C, int D) {
        if (A == 0) return new int[]{1, C + 1};
        if (B == 0) return new int[]{1, D + 1};
        if (C == 0) return new int[]{A + 1, 1};
        if (D == 0) return new int[]{B + 1, 1};
        int m1 = B + 1;
        int m2 = A + 1;
        int m3 = Math.max(A + 1, B + 1);
        int n1 = D + 1;
        int n2 = C + 1;
        int n3 = Math.max(C + 1, D + 1);

        int v = 1;
        if (m2 + n2 < m1 + n1) v = 2;
        switch (v) {
            case 1 -> {if (m3 + 1 < m1 + n1) v = 3;}
            case 2 -> {if (m3 + 1 < m2 + n2) v = 3;}
        }
        switch (v) {
            case 1 -> {if (1 + n3 < m1 + n1) v = 4;}
            case 2 -> {if (1 + n3 < m2 + n2) v = 4;}
            case 3 -> {if (1 + n3 < m3 + 1) v = 4;}
        }

        return switch (v) {
            case 1 -> new int[]{m1, n1};
            case 2 -> new int[]{m2, n2};
            case 3 -> new int[]{m3, 1};
            default -> new int[]{1, n3};
        };
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(reader.readLine());
        int B = Integer.parseInt(reader.readLine());
        int C = Integer.parseInt(reader.readLine());
        int D = Integer.parseInt(reader.readLine());
        Main sol = new Main();
        writer.write(Arrays.stream(sol.solve(A, B, C, D)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}
