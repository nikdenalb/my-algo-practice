package block1.taskj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89515/problems?id=30404%2F2021_08_19%2FQ28VmrWEnn&contestId=89515">
 * Parallelogram (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Returns whether four points form a parallelogram (opposite sides equal and parallel).
     * <br>
     * Constraints: N 1–10; |X|,|Y| ≤ 100; four points not collinear.<br>
     * <br>
     * Example: (1,1),(4,2),(3,0),(2,3)→YES
     *
     * @param X1 point 1 x
     * @param Y1 point 1 y
     * @param X2 point 2 x
     * @param Y2 point 2 y
     * @param X3 point 3 x
     * @param Y3 point 3 y
     * @param X4 point 4 x
     * @param Y4 point 4 y
     * @return true if parallelogram
     */
    boolean solve(int X1, int Y1, int X2, int Y2, int X3, int Y3, int X4, int Y4) {
        return ((X1 + X2 == X3 + X4 && Y1 + Y2 == Y3 + Y4) ||
                (X1 + X3 == X2 + X4 && Y1 + Y3 == Y2 + Y4) ||
                (X1 + X4 == X2 + X3 && Y1 + Y4 == Y2 + Y3));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());

        Main sol = new Main();

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < N - 1; i++) {
            int[] fCoords = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            if (sol.solve(
                    fCoords[0], fCoords[1],
                    fCoords[2], fCoords[3],
                    fCoords[4], fCoords[5],
                    fCoords[6], fCoords[7])) {
                out.append("YES");
            } else out.append("NO");
            out.append(System.lineSeparator());
        }

        int[] fCoords = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        if (sol.solve(
                fCoords[0], fCoords[1],
                fCoords[2], fCoords[3],
                fCoords[4], fCoords[5],
                fCoords[6], fCoords[7])) {
            out.append("YES");
        } else out.append("NO");

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
