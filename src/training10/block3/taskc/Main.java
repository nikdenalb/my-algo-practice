package training10.block3.taskc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97113/problems?id=30404%2F2018_03_02%2FXA99r5fK4A">
 * Столица
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

    int[] solve(int[][] towns) {
        int n = towns.length;

        int[] xx = new int[n], yy = new int[n];
        Set<Town> townSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            xx[i] = towns[i][0];
            yy[i] = towns[i][1];
            townSet.add(new Town(xx[i], yy[i]));
        }

        int[] medX, medY;
        if (n % 2 == 1) {
            int mx = findMedOdd(xx), my = findMedOdd(yy);
            medX = new int[]{mx, mx};
            medY = new int[]{my, my};
        } else {
            medX = findMedEven(xx);
            medY = findMedEven(yy);
        }

        for (int x = medX[0]; x <= medX[1]; x++)
            for (int y = medY[0]; y <= medY[1]; y++)
                if (!townSet.contains(new Town(x, y))) return new int[]{x, y};

        int sumM = Integer.MAX_VALUE;
        int[] out = new int[2];
        for (int x = medX[0] - n; x <= medX[0] + n; x++) {
            for (int y = medY[0] - n; y <= medY[0] + n; y++) {

                if (x >= medX[0] && x <= medX[1] && y >= medY[0] && y <= medY[1]) continue;
                if (townSet.contains(new Town(x, y))) continue;

                int d = 0;
                for (int[] t : towns) d += Math.abs(x - t[0]) + Math.abs(y - t[1]);

                if (d < sumM) {
                    sumM = d;
                    out[0] = x;
                    out[1] = y;
                }
            }
        }
        return out;
    }

    record Town(int x, int y) {
    }

    int findMedOdd(int[] a) {
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

    int[] findMedEven(int[] a) {
        int mL = a.length / 2 - 1, mR = a.length / 2;

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

            if (mR <= i) r = i;
            else if (mL >= j) l = j;
            else {
                if (mL <= i) {
                    a[mL] = a[l];
                    for (int k = l + 1; k <= i; k++) a[mL] = Math.max(a[mL], a[k]);
                }
                if (mR >= j) {
                    a[mR] = a[j];
                    for (int k = j + 1; k <= r; k++) a[mR] = Math.min(a[mR], a[k]);
                }
                return new int[]{a[mL], a[mR]};
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        int[][] towns = new int[N][2];
        for (int i = 0; i < N; i++)
            towns[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] out = new Main().solve(towns);
        writer.write(out[0] + " " + out[1]);

        reader.close();
        writer.close();
    }
}
