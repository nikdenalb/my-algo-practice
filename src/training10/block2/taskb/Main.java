package training10.block2.taskb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97108/problems?id=175943%2F2016_11_22%2FCd32DDMkPb">
 * Карточная игра
 * </a>
 * <br><br>
 * Блок 2. Очереди, деки, кучи.<br>
 * Lecture: <a href="https://youtu.be/-ZVZt3dp0nw">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240272">VK Video</a>.<br>
 * Editorial: <a href="https://vkvideo.ru/video-220652761_456240271">VK Video</a>.<br>
 * Practice: <a href="https://new.contest.yandex.ru/contests/97108">Тренировки 10.0 - 2.1. Очередь и способы её реализации</a>.
 */
public class Main {

    String solve(int[] deck1, int[] deck2) {
        Queue<Integer> q1 = Arrays.stream(deck1).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        Queue<Integer> q2 = Arrays.stream(deck2).boxed().collect(Collectors.toCollection(ArrayDeque::new));

        int cnt = 0;
        for (; !q1.isEmpty() && !q2.isEmpty(); cnt++) {
            int card1 = q1.poll();
            int card2 = q2.poll();
            if ((card1 > card2 && !(card1 == 9 && card2 == 0)) || (card1 == 0 && card2 == 9)) {
                q1.offer(card1);
                q1.offer(card2);
            } else {
                q2.offer(card1);
                q2.offer(card2);
            }
        }

        if (q1.isEmpty()) return "second " + cnt;
        return "first " + cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] deck1 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] deck2 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(new Main().solve(deck1, deck2));

        reader.close();
        writer.close();
    }
}
