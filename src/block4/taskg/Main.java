package block4.taskg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89531/problems?id=30404%2F2023_01_18%2Fm3PAau25IW">
 * Great Lineland migration (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Constraints (from statement):<br>
     * - N cities on a line, numbered 0 to N − 1; 2 ≤ N ≤ 10<sup>5</sup><br>
     * - living costs a<sub>0</sub>, …, a<sub>N−1</sub> with 0 ≤ a<sub>i</sub> ≤ 10<sup>9</sup><br>
     * - for each city i, output the smallest index j &gt; i with a<sub>j</sub> &lt; a<sub>i</sub>, or −1 if none (migration into empty eastern infinity)<br>
     * - time limit 1 s, memory 256 MB<br>
     * <br>
     * Approach:<br>
     * - scan indices eastward; keep a monotone stack of city indices with strictly decreasing costs.<br>
     * - when the current cost breaks the pattern, pop and record the current index as the destination for those popped cities.<br>
     * - reuse the int array to store answers; remaining stack entries map to −1.<br>
     *
     * @param a on entry, living costs per city; on exit, destination index or −1 per city (same length)
     * @return the array of answers (same reference as a after in-place fill)
     */
    int[] solve(int[] a) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && a[stack.peek()] > a[i]) a[stack.pop()] = i;
            stack.push(i);
        }
        while (!stack.isEmpty()) a[stack.pop()] = -1;
        return a;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine(); //int N = Integer.parseInt(reader.readLine());
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        writer.write(
                Arrays.stream(new Main().solve(a)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}
