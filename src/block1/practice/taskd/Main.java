package block1.practice.taskd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89514/problems?id=30404%2F2021_05_13%2FrFKSEzJqpU">
 * Air conditioner (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Input: room temp, target temp (AC setting), work mode (freeze|heat|auto|fan).
     * Output: final room temp.
     * <br>
     * <br>
     * Modes: freeze (only cool), heat (only warm), auto (both), fan (no change).
     * AC shuts off if it cannot reach target in freeze/heat.<br>
     * <br>
     * Constraints: −50 ≤ troom, tcond ≤ 50. Examples: (10, 20, heat)→20; (10, 20, freeze)→10
     *
     * @param tR   room temp
     * @param tC   target temp (AC setting)
     * @param mode freeze | heat | auto | fan
     * @return final room temp
     */
    int solve(int tR, int tC, String mode) {
        if (tC > tR && mode.equals("heat") || (tC < tR && mode.equals("freeze")) || mode.equals("auto")) return tC;
        return tR;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] rc = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String mode = reader.readLine();

        Main sol = new Main();
        writer.write(String.valueOf(sol.solve(rc[0], rc[1], mode)));

        reader.close();
        writer.close();
    }
}
