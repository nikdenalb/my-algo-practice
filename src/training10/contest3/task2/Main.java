package training10.contest3.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        Deque<String[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            q.add(reader.readLine().split(" "));
        }

        int m = Integer.parseInt(reader.readLine());

        Queue<String[]> qAdd = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            qAdd.add(reader.readLine().split(" "));
        }

        StringBuilder out = new StringBuilder();
        long time = 0;

        while (!q.isEmpty()) {

            while (!qAdd.isEmpty() && Integer.parseInt(qAdd.peek()[0]) <= time) {
                String[] poll = qAdd.poll();
                q.addFirst(new String[]{poll[1], poll[2]});
            }

            String[] song = q.poll();
            out.append(song[0]).append(" ").append(time).append(System.lineSeparator());

            time += Integer.parseInt(song[1]);

            if (q.isEmpty() && !qAdd.isEmpty()) {
                time = Math.max(time, Integer.parseInt(qAdd.peek()[0]));

                String[] poll = qAdd.poll();
                q.addFirst(new String[]{poll[1], poll[2]});

            }
        }


        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
