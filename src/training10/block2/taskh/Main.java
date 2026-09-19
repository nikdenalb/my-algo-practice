package training10.block2.taskh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97110/problems?id=30404%2F2023_03_10%2FqSBGEPKnZL">
 * Strategy tetris
 * </a>
 * <br><br>
 * Блок 2. Очереди, деки, кучи.<br>
 * Lecture: <a href="https://youtu.be/Z032PF_YmEg">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240265">VK Video</a>.<br>
 * Editorial: <a href="https://youtu.be/W8QcmIKOcvc">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240266">VK Video</a>.<br>
 * Practice: <a href="https://new.contest.yandex.ru/contests/97110">Тренировки 10.0 - 2.3. Реализация кучи</a>.
 */
public class Main {

    int[] solve(int[][] blocks) {
        int n = blocks.length;
        int h = 0;
        int[] out = new int[n + 1];

        Arrays.sort(blocks, Comparator.comparingInt(block -> block[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(b -> b[0]));
        List<List<Integer>> lines = new ArrayList<>();

        for (int[] block : blocks) {
            int a = block[0], b = block[1], id = block[2];
            int row;
            if (!pq.isEmpty() && pq.peek()[0] < a) row = pq.poll()[1];
            else {
                row = h++;
                lines.add(new ArrayList<>());
            }
            lines.get(row).add(id);
            pq.offer(new int[]{b, row});
        }

        out[0] = h;
        int i = 0;
        for (List<Integer> row : lines) for (int id : row) out[++i] = id;
        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] NW = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] blocks = new int[NW[0]][3];
        for (int i = 0; i < NW[0]; i++) {
            int[] row = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            blocks[i][0] = row[0];
            blocks[i][1] = row[0] + row[1] - 1;
            blocks[i][2] = i + 1;
        }

        StringBuilder out = new StringBuilder();
        int[] ans = new Main().solve(blocks);
        out.append(ans[0]).append(System.lineSeparator());
        for (int i = 1; i < ans.length - 1; i++) out.append(ans[i]).append(" ");
        out.append(ans[ans.length - 1]);
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
