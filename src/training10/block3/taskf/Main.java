package training10.block3.taskf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97114/problems?id=30404%2F2021_09_07%2FMUszsx4NBx">
 * Стильная одежда 2
 * </a>
 * <br><br>
 * Блок 3. Сортировки.<br>
 * Lecture: <a href="https://youtu.be/_mO6BqVwr70">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240279">VK Video</a>.<br>
 * Editorial: <a href="https://youtu.be/_2slvKj9oO0">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240280">VK Video</a>.<br>
 * Practice: <a href="https://new.contest.yandex.ru/contests/97114">Тренировки 10.0 - 3.3. Сортировка слиянием</a>.
 */
public class Main {

    int[] solve(int[][] N) {
        for (int[] row : N) Arrays.sort(row);
        int[] i = new int[4];
        int[] out = new int[]{N[0][0], N[1][0], N[2][0], N[3][0]};

        int min = 0, max = 0;

        for (int j = 1; j < 4; j++) {
            if (N[j][0] < N[min][0]) min = j;
            if (N[j][0] > N[max][0]) max = j;
        }

        int gap = N[max][0] - N[min][0];

        while (++i[min] < N[min].length) {
            min = 0;
            max = 0;
            for (int j = 1; j < 4; j++) {
                if (N[j][i[j]] < N[min][i[min]]) min = j;
                if (N[j][i[j]] > N[max][i[max]]) max = j;
            }

            int d = N[max][i[max]] - N[min][i[min]];
            if (d < gap) {
                gap = d;
                for (int j = 0; j < 4; j++) out[j] = N[j][i[j]];
            }
        }

        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] N = new int[4][];
        for (int i = 0; i < 4; i++) {
            reader.readLine();
            N[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        writer.write(Arrays.stream(new Main().solve(N))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))
        );

        reader.close();
        writer.close();
    }
}
