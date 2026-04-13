package block4.taskj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89532/problems?id=175943%2F2016_11_22%2FCu8aaoPcmm">
 * Minimum on a segment (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Constraints (from statement):<br>
     * - sequence length n and window length k with k ≤ n, n ≤ 150000, k ≤ 10000<br>
     * - output n − k + 1 lines: the minimum inside each length-k window as it slides by one position along the sequence<br>
     * - a naive minimum scan per window is too slow for the limits<br>
     * - time limit 1 s, memory 64 MB<br>
     * <br>
     * Goal: list the window minima in order from the first window to the last.<br>
     * <br>
     * Approach:<br>
     * - maintain a deque of candidates in increasing value order so the front always holds the current window minimum.<br>
     * - slide the window: drop indices or values that leave the window, pop from the back while the new value is smaller, push the new value, read the front as the answer for each completed window.<br>
     *
     * @param n sequence length
     * @param k window length
     * @param arr the n integers in order
     * @return the n − k + 1 window minima, in order
     */
    List<Integer> solve(int n, int k, int[] arr) {
        List<Integer> out = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (i < k) {
                while (!q.isEmpty() && arr[i] < q.peekLast()) q.removeLast();
                q.addLast(arr[i]);
                if (i == k - 1) out.add(q.peekFirst());
                continue;
            }
            if (arr[i - k] == q.peekFirst()) q.removeFirst();
            while (!q.isEmpty() && arr[i] < q.peekLast()) q.removeLast();
            q.addLast(arr[i]);
            out.add(q.peekFirst());
        }
        return out;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nk = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        writer.write(new Main()
                .solve(nk[0], nk[1], arr).stream().map(String::valueOf).collect(Collectors.joining("\n")));

        reader.close();
        writer.close();
    }
}
