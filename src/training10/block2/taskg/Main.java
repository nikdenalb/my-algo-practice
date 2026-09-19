package training10.block2.taskg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97110/problems?id=30404%2F2018_03_15%2F9rmjNYTmLo">
 * Хипуй
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

    static class MyHeap {
        int[] arr = new int[100_000];
        int end = -1;

        void insert(int e) {
            arr[++end] = e;
            for (int i = end; i > 0 && arr[i] > arr[(i - 1) / 2]; i = (i - 1) / 2) {
                int tmp = arr[i];
                arr[i] = arr[(i - 1) / 2];
                arr[(i - 1) / 2] = tmp;
            }
        }

        int extract() {
            int out = arr[0];
            arr[0] = arr[end--];
            int i = 0;
            while (true) {
                int l = 2 * i + 1, r = l + 1;
                int max = i;
                if (l <= end && arr[l] > arr[max]) max = l;
                if (r <= end && arr[r] > arr[max]) max = r;
                if (max == i) break;

                int tmp = arr[i];
                arr[i] = arr[max];
                arr[max] = tmp;
                i = max;
            }
            return out;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        MyHeap heap = new MyHeap();
        int N = Integer.parseInt(reader.readLine());
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] cmd = reader.readLine().split(" ");
            if (cmd[0].equals("0")) heap.insert(Integer.parseInt(cmd[1]));
            else out.append(heap.extract()).append(System.lineSeparator());
        }
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
