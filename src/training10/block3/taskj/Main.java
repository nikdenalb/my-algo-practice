package training10.block3.taskj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97115/problems?id=30404%2F2018_03_15%2FZnIPFQf2Tt">
 * Пирамидальная сортировка
 * </a>
 * <br><br>
 * Блок 3. Сортировки.<br>
 * Lecture: <a href="https://youtu.be/m48sFcBLzR0">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240278">VK Video</a>.<br>
 * Editorial: <a href="https://youtu.be/HJlQtz1OSAY">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240274">VK Video</a>.<br>
 * Practice: <a href="https://new.contest.yandex.ru/contests/97115">Тренировки 10.0 - 3.4. Пирамидальная сортировка</a>.
 */
public class Main {

    int end;

    void solve(int[] arr) {
        end = arr.length - 1;

        heapify(arr);
        extractSort(arr);
    }

    void extractSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) arr[i] = extract(arr);
    }

    int extract(int[] arr) {
        int out = arr[0];
        arr[0] = arr[end--];
        down(arr, 0, end);
        return out;
    }

    void heapify(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) down(arr, i, arr.length - 1);
    }

    void down(int[] arr, int i, int end) {
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
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine(); // N
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        new Main().solve(arr);
        writer.write(Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))
        );

        reader.close();
        writer.close();
    }
}
