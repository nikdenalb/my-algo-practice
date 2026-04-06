package block4.taskb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89528/problems?id=30404%2F2021_12_13%2F2EeqSEdSfr">
 * Wagon sorting lite (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Constraints (from statement):<br>
     * - 1 &lt;= N &lt;= 100<br>
     * - train cars are a permutation of numbers 1..N<br>
     * - allowed operation model corresponds to one side track (stack), with one-way moves from path 1 to stack and
     *   from stack to path 2<br>
     * - time limit 1 s, memory 64 MB<br>
     * <br>
     * Goal: determine whether cars can be output in order 1..N using the side track operations.<br>
     * <br>
     * Approach:<br>
     * - simulate classic stack permutation checking.<br>
     * - keep the next required output number t and process incoming cars from left to right.<br>
     * - if current car equals t, send it directly to output; otherwise push to side track.<br>
     * - before pushing, and also after processing all input, pop from side track while its top equals t; if a mismatch
     *   appears when numbers are still required, answer is NO; otherwise YES.<br>
     *
     * @param N number of cars
     * @param arr incoming order from path 1
     * @return true if target order 1..N is achievable, false otherwise
     */
    boolean solve(int N, int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int t = 1;
        for (int i = 0; i < N; ) {
            if (t == arr[i]) {
                i++;
                t++;
            } else if (!stack.isEmpty() && t == stack.peek()) {
                stack.pop();
                t++;
            } else {
                stack.push(arr[i++]);
            }
        }
        while (t <= N) if (t++ != stack.pop()) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        writer.write(new Main().solve(N, arr) ? "YES" : "NO");

        reader.close();
        writer.close();
    }
}
