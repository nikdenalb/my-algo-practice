package training10.block2.taskd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97109/problems?id=30404%2F2021_10_27%2FvXyC6otXEb">
 * Пляжный волейбол
 * </a>
 * <br><br>
 * Блок 2. Очереди, деки, кучи.<br>
 * Lecture: <a href="https://youtu.be/szs0GafJbR0">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240268">VK Video</a>.<br>
 * Editorial: <a href="https://youtu.be/UHKqJVWKT6A">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240270">VK Video</a>.<br>
 * Practice: <a href="https://new.contest.yandex.ru/contests/97109">Тренировки 10.0 - 2.2. Дек, минимум в окне</a>.
 */
public class Main {

    int[][] solve(int[] pow, long[] K) {
        Deque<Integer> dq = new ArrayDeque<>(Arrays.stream(pow).boxed().toList());
        int N = pow.length;
        int Q = K.length;

        int[][] dist = new int[N][2];
        int sortCnt = 0;
        for (; dq.getFirst() < N; sortCnt++) {
            int a = dq.pollFirst();
            int b = dq.pollFirst();
            dist[sortCnt][0] = a;
            dist[sortCnt][1] = b;

            if (a > b) {
                dq.addFirst(a);
                dq.addLast(b);
            } else {
                dq.addFirst(b);
                dq.addLast(a);
            }
        }
        int[] arr = dq.stream().mapToInt(Integer::intValue).toArray();

        int[][] out = new int[Q][2];
        for (int i = 0; i < K.length; i++) {
            if (K[i] <= sortCnt) out[i] = dist[(int) K[i] - 1];
            else {
                out[i][0] = arr[0];
                out[i][1] = arr[1 + (int) ((K[i] - sortCnt - 1) % (N - 1))];
            }
        }

        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        int[] pow = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int Q = Integer.parseInt(reader.readLine());
        long[] K = new long[Q];
        for (int i = 0; i < Q; i++) K[i] = Long.parseLong(reader.readLine());

        writer.write(
                Arrays.stream(new Main().solve(pow, K))
                        .map(row -> Arrays.stream(row)
                                .mapToObj(String::valueOf)
                                .collect(Collectors.joining(" ")))
                        .collect(Collectors.joining(System.lineSeparator()))
        );

        reader.close();
        writer.close();
    }
}
