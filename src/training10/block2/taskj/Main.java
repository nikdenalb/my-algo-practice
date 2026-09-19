package training10.block2.taskj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97111/problems?id=4105%2F2015_10_19%2FfnOQhIILXx">
 * Медиана
 * </a>
 * <br><br>
 * Блок 2. Очереди, деки, кучи.<br>
 * Lecture: <a href="https://youtu.be/rIxJPOKkIgM">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240269">VK Video</a>.<br>
 * Editorial: <a href="https://youtu.be/O5-TlBnASmg">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240267">VK Video</a>.<br>
 * Practice: <a href="https://new.contest.yandex.ru/contests/97111">Тренировки 10.0 - 2.4. Медиана в окне</a>.
 */
public class Main {

    int[] solve(int[] arr) {
        int[] out = new int[arr.length];
        out[0] = arr[0];
        if (arr.length == 1) return out;
        out[1] = Math.min(arr[0], arr[1]);
        if (arr.length == 2) return out;

        PriorityQueue<Integer> lpq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> rpq = new PriorityQueue<>();

        lpq.add(Math.min(arr[0], arr[1]));
        rpq.add(Math.max(arr[0], arr[1]));

        for (int i = 2; i < arr.length; i++) {
            int num = arr[i];
            if (num <= lpq.peek()) lpq.add(num);
            else rpq.add(num);

            if (rpq.size() > lpq.size()) lpq.add(rpq.poll());
            else if (lpq.size() > rpq.size() + 1) rpq.add(lpq.poll());

            out[i] = lpq.peek();
        }

        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        if (!reader.readLine().equals("0")) {
            int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            writer.write(
                    Arrays.stream(new Main().solve(arr))
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" "))
            );
        }

        reader.close();
        writer.close();
    }
}
