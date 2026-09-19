package training10.block2.taski;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97110/problems?id=30404%2F2021_12_13%2F0RnfACzM6R">
 * Коммерческий калькулятор
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

    long solve(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) pq.add(num);
        long out = 0;
        while (pq.size() > 1) {
            int sum =  pq.poll() + pq.poll();
            pq.add(sum);
            out += sum * 5L;
        }
        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine(); // N
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long out = new Main().solve(nums);
        writer.write(out / 100 + "." + (out % 100) / 10 + out % 10);

        reader.close();
        writer.close();
    }
}
