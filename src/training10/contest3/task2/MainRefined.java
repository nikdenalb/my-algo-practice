package training10.contest3.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97118/problems?id=30404%2F2026_08_02%2FROVIoIYOyM">
 * Плейлист
 * </a>
 */
public class MainRefined {

    String solve(Deque<Song> dq, Queue<Insert> q) {
        StringBuilder out = new StringBuilder();

        long currTime = 0;
        while (!dq.isEmpty()) {
            while (!q.isEmpty() && q.peek().time() <= currTime) dq.addFirst(q.poll().song());

            Song song = dq.poll();
            out.append(song.name()).append(" ").append(currTime).append(System.lineSeparator());

            currTime += song.len();

            if (dq.isEmpty() && !q.isEmpty()) {
                currTime = Math.max(currTime, q.peek().time());
                dq.addFirst(q.poll().song());
            }
        }

        return out.toString();
    }

    record Song(String name, int len) {}
    record Insert(int time, Song song) {}

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        Deque<Song> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            dq.addLast(new Song(line[0], Integer.parseInt(line[1])));
        }

        int m = Integer.parseInt(reader.readLine());

        Queue<Insert> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            String[] line = reader.readLine().split(" ");
            q.add(new Insert(Integer.parseInt(line[0]), new Song(line[1], Integer.parseInt(line[2]))));
        }

        writer.write(new MainRefined().solve(dq, q));

        reader.close();
        writer.close();
    }
}
