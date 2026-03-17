package block1.practice1.taskb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89513/problems?id=56057%2F2015_11_22%2F76mwS29eYw">
 * Ambulance (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Finds entrance P1 and floor N1 of apartment K1 given reference apartment K2 at (P2, N2) in a building
     * with M floors and Q apartments per floor (same on each floor).
     * <p>
     * Constraints: all inputs ≤ 10<sup>6</sup>.<br>
     * Output: (P1, N1); 0 if ambiguous; (-1, -1) if contradictory.<br>
     * <br>
     * Examples: (89,20,41,1,11)→(2,3); (11,1,1,1,1)→(0,1); (3,2,2,2,1)→(-1,-1)
     *
     * @param K1 apartment to find
     * @param M  floors in building
     * @param K2 reference apartment number
     * @param P2 reference entrance
     * @param N2 reference floor
     * @return {P1, N1}, or {0, N1}/{P1, 0}/{0, 0}, or {-1, -1}
     */
    int[] solve(int K1, int M, int K2, int P2, int N2) {
        /*
        Auxiliary representation of the task:

            ----  ----  ----  N=M
            --K-  ----  ----  N=3
            ----  ----  ----  N=2
            ----  ----  ----  N=1
             P      P     P

            |                   |                   |                   |
            |----|----|----|----|----|----|----|----|----|----|----|----|
            |                   |                   |                   |
               Q=?

            (P-1)*M*Q + (N-1)*Q < K <= N*Q + (P-1)*M*Q

            Q*((P-1)*M + N-1) < K <= Q*(N+(P-1)*M)
        */
        if (N2 > M) return new int[]{-1, -1};
        int qMax = (P2 == 1 && N2 == 1)
                ? Math.max(K1, K2)
                : (int) ((K2 - 1) / ((long) (P2 - 1) * M + N2 - 1));

        int qMin = (N2 == 0)
                ? 1
                : (int) ((K2 + N2 + (long) (P2 - 1) * M - 1) / (N2 + (long) (P2 - 1) * M));

        int P1 = -1, N1 = -1;

        for (int Q = qMin; Q <= qMax; Q++) {
            int cN = (K1 - 1) / Q % M + 1;
            int cP = (int) ((K1 - 1) / ((long) Q * M) + 1);

            if (Q * ((long) (cP - 1) * M + cN - 1) >= K1) return new int[]{P1, N1};
            if (K1 > Q * (cN + (long) (cP - 1) * M)) continue;

            if (P1 == -1) P1 = cP;
            else if (P1 != cP) P1 = 0;

            if (N1 == -1) N1 = cN;
            else if (N1 != cN) N1 = 0;

            if (K1 == Q || (N1 == 0 && P1 == 0)) break;
        }

        return new int[]{P1, N1};
    }

    /**
     * Alternative solution: brute-force enumeration of Q.
     */
    long[] solveBrute(long K1, long M, long K2, long P2, long N2) {
        if (N2 > M) return new long[]{-1, -1};
        long P1 = -1, N1 = -1;
        //Q*((P-1)*M + N-1) < K <= Q*(N+(P-1)*M)
        for (long Q = 1; Q <= 1_000_000; Q++) {
            if (K2 <= Q * ((P2 - 1) * M + N2 - 1) || K2 > Q * (N2 + (P2 - 1) * M)) continue;

            long cN = (K1 - 1) / Q % M + 1;
            long cP = ((K1 - 1) / (Q * M) + 1);

            if (P1 == -1) P1 = cP;
            else if (P1 != cP) P1 = 0;

            if (N1 == -1) N1 = cN;
            else if (N1 != cN) N1 = 0;
        }
        return new long[]{P1, N1};
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] K1MK2P2N2 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Main sol = new Main();
        writer.write(Arrays.stream(sol.solve(K1MK2P2N2[0], K1MK2P2N2[1], K1MK2P2N2[2], K1MK2P2N2[3], K1MK2P2N2[4]))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}
