package training10.contest4.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    long solve(int[] arr1, int k) {
        int n = arr1.length;

        int[] arr2 = arr1.clone();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) arr1[i] += k;
            else arr2[i] += k;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int m1 = arr1[arr1.length / 2];
        int m2 = arr2[arr2.length / 2];

        long ans1 = 0;
        long ans2 = 0;

        for (int e : arr1) ans1 += Math.abs((long) e - m1);
        for (int e : arr2) ans2 += Math.abs((long) e - m2);

        return Math.min(ans1, ans2);

    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nk = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(String.valueOf(new Main().solve(a, nk[1])));


        reader.close();
        writer.close();
    }
}
