package training10.block2.taskc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97108/problems?id=30404%2F2024_11_02%2FG0KugiBpvC">
 * Автоматизированный склад
 * </a>
 * <br><br>
 * Блок 2. Очереди, деки, кучи.<br>
 * Lecture: <a href="https://youtu.be/-ZVZt3dp0nw">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240272">VK Video</a>.<br>
 * Editorial: <a href="https://vkvideo.ru/video-220652761_456240271">VK Video</a>.<br>
 * Practice: <a href="https://new.contest.yandex.ru/contests/97108">Тренировки 10.0 - 2.1. Очередь и способы её реализации</a>.
 */
public class Main {

    int[] solve(int a, int b, int[][] arr) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            switch (arr[j][0]) {
                case 1 -> l1.add(j);
                case 2 -> l2.add(j);
                case 3 -> l3.add(j);
                case 4 -> l4.add(j);
            }
        }
        l1.sort(Comparator.comparingInt(x -> arr[x][1]));
        l2.sort(Comparator.comparingInt(x -> arr[x][1]));
        l3.sort(Comparator.comparingInt(x -> arr[x][1]));
        l4.sort(Comparator.comparingInt(x -> arr[x][1]));

        Queue<Integer> q1 = new ArrayDeque<>(l1);
        Queue<Integer> q2 = new ArrayDeque<>(l2);
        Queue<Integer> q3 = new ArrayDeque<>(l3);
        Queue<Integer> q4 = new ArrayDeque<>(l4);
        Router router = new Router(a, b);
        int n = arr.length;
        int[] out = new int[n];
        for (int t = 1, i = 0; i < n; t++) {
            boolean[] state = new boolean[4];
            if (!q1.isEmpty() && arr[q1.peek()][1] <= t) state[0] = true;
            if (!q2.isEmpty() && arr[q2.peek()][1] <= t) state[1] = true;
            if (!q3.isEmpty() && arr[q3.peek()][1] <= t) state[2] = true;
            if (!q4.isEmpty() && arr[q4.peek()][1] <= t) state[3] = true;

            if (!(state[0] || state[1] || state[2] || state[3])) {
                int next = Integer.MAX_VALUE;
                if (!q1.isEmpty()) next = Math.min(next, arr[q1.peek()][1]);
                if (!q2.isEmpty()) next = Math.min(next, arr[q2.peek()][1]);
                if (!q3.isEmpty()) next = Math.min(next, arr[q3.peek()][1]);
                if (!q4.isEmpty()) next = Math.min(next, arr[q4.peek()][1]);
                t = next - 1;
                continue;
            }

            switch (router.resolve(state)) {
                case 1 -> {out[q1.poll()] = t; i++;}
                case 2 -> {out[q2.poll()] = t; i++;}
                case 3 -> {out[q3.poll()] = t; i++;}
                case 4 -> {out[q4.poll()] = t; i++;}
                case 5 -> {out[q1.poll()] = t; out[q3.poll()] = t; i += 2;}
                case 6 -> {out[q2.poll()] = t; out[q4.poll()] = t; i += 2;}
            }
        }
        return out;
    }

    class Router {
        int a, b;

        Router(int a, int b) {
            this.a = a;
            this.b = b;
        }

        int resolve(boolean[] state) {
            boolean[] cross = new boolean[4];
            for (int i = 0; i < 4; i++) {
                if (!state[i]) continue;
                boolean meMain = i + 1 == a || i + 1 == b;
                int r = (i + 3) % 4;
                int l = (i + 1) % 4;
                int opp = (i + 2) % 4;
                boolean rMain = r + 1 == a || r + 1 == b;
                boolean lMain = l + 1 == a || l + 1 == b;
                boolean oppMain = opp + 1 == a || opp + 1 == b;
                if (state[r] && (!meMain || rMain)) continue;
                if (!meMain && state[l] && lMain) continue;
                if (!meMain && state[opp] && oppMain) continue;
                cross[i] = true;
            }
            if (cross[0] && cross[2]) return 5;
            if (cross[1] && cross[3]) return 6;
            if (cross[0]) return 1;
            if (cross[1]) return 2;
            if (cross[2]) return 3;
            return 4;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        int[] ab = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++)
            arr[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(Arrays.stream(new Main().solve(ab[0], ab[1], arr))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));

        reader.close();
        writer.close();
    }
}
