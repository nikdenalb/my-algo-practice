package training10.block3.taskd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97113/problems?id=30404%2F2019_04_20%2FUKS6C0Eoo3">
 * Пираты Баренцева моря
 * </a>
 * <br><br>
 * Блок 3. Сортировки.<br>
 * Lecture: <a href="https://youtu.be/7cnDfKSv4PE">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240276">VK Video</a>.<br>
 * Editorial: <a href="https://youtu.be/stAQWu2tjSc">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240275">VK Video</a>.<br>
 * Practice: <a href="https://new.contest.yandex.ru/contests/97113">Тренировки 10.0 - 3.2. Поиск порядковой статистики за линейное время</a>.
 */
public class Main {

    int solve(int[][] ships) {
        int n = ships.length;
        int[] xx = new int[n];
        int[] yy = new int[n];

        for (int i = 0; i < ships.length; i++) {
            xx[i] = ships[i][0];
            yy[i] = ships[i][1];
        }

        int out = 0;

        Arrays.sort(xx);
        for (int i = 0; i < n; i++) out += Math.abs(xx[i] - (i + 1));

        int yMed = findMed(yy);
        for (int e : yy) out += Math.abs(e - yMed);

        return out;
    }

    int findMed(int[] a) {
        int m = a.length / 2;

        int l = 0, r = a.length - 1;
        while (true) {
            int x = a[l + (int) (Math.random() * (r - l + 1))];
            int j = l, i = r;
            while (j <= i) {
                while (a[j] < x) j++;
                while (a[i] > x) i--;
                if (j <= i) {
                    int t = a[j];
                    a[j] = a[i];
                    a[i] = t;
                    j++;
                    i--;
                }
            }
            if (m <= i) r = i;
            else if (m >= j) l = j;
            else return a[m];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        int[][] ships = new int[N][];
        for (int i = 0; i < N; i++)
            ships[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(String.valueOf(new Main().solve(ships)));

        reader.close();
        writer.close();
    }
}
