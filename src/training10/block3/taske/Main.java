package training10.block3.taske;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97114/problems?id=4105%2F2015_01_14%2FBJoIIyloBm">
 * Слияние
 * </a>
 * <br><br>
 * Блок 3. Сортировки.<br>
 * Lecture: <a href="https://youtu.be/_mO6BqVwr70">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240279">VK Video</a>.<br>
 * Editorial: <a href="https://youtu.be/_2slvKj9oO0">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240280">VK Video</a>.<br>
 * Practice: <a href="https://new.contest.yandex.ru/contests/97114">Тренировки 10.0 - 3.3. Сортировка слиянием</a>.
 */
public class Main {

    int[] solve(int[] arr1, int[] arr2) {
        int[] out = new int[arr1.length + arr2.length];

        int i = 0, j1 = 0, j2 = 0;
        for (; j1 < arr1.length && j2 < arr2.length; i++) {
            if (arr1[j1] <= arr2[j2]) out[i] = arr1[j1++];
            else out[i] = arr2[j2++];
        }

        int[] source = j2 == arr2.length ? arr1 : arr2;
        int j = j2 == arr2.length ? j1 : j2;
        System.arraycopy(source, j, out, i, source.length - j);

        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        int[] arr1;
        if (N == 0) {
            arr1 = new int[0];
            reader.readLine();
        } else arr1 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(reader.readLine());
        int[] arr2 = M == 0 ?
                new int[0] :
                Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(Arrays.stream(new Main().solve(arr1, arr2))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))
        );

        reader.close();
        writer.close();
    }
}
