package block4.contest12.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89544/problems?id=23867%2F2026_03_01%2FYSwACHCPFO">
 * Balls (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Constraints (from statement):<br>
     * - one line: count N then N ball colors; N ≤ 1000; each color is a digit 0..9<br>
     * - at most one contiguous run of three or more equal colors in the initial line<br>
     * - whenever three or more consecutive equal colors appear, that block is removed and the rest closes up; repeats until stable<br>
     * - time limit 1 s, memory 512 MB<br>
     * <br>
     * Goal: total number of balls removed.<br>
     * <br>
     * Approach:<br>
     * - scan colors left to right while keeping a stack of the current line.<br>
     * - whenever the next color differs from the stack top, measure the homogeneous run ending at the top; if its length is at least 3, pop that run and add its length to the answer, then push the new color.<br>
     * - after the last input color, apply the same tail check once for a homogeneous run left at the top.<br>
     *
     * @param bls ball colors in left-to-right order (length N from the statement)
     * @return how many balls are destroyed in total
     */
    int solve(int[] bls) {
        Deque<Integer> stack = new ArrayDeque<>();
        int out = 0;
        for (int bl : bls) {
            if (stack.isEmpty()) {
                stack.push(bl);
                continue;
            }
            if (stack.peek() == bl) {
                stack.push(bl);
                continue;
            }
            Iterator<Integer> it = stack.iterator();
            int elem = it.next();
            int cnt = 1;
            while (!stack.isEmpty() && it.hasNext()) {
                if (it.next() != elem) break;
                else cnt++;
            }
            if (cnt >= 3) {
                out += cnt;
                while (cnt-- > 0) stack.pop();
            }
            stack.push(bl);
        }

        Iterator<Integer> it = stack.iterator();
        int elem = it.next();
        int cnt = 1;
        while (!stack.isEmpty() && it.hasNext()) {
            if (it.next() != elem) break;
            else cnt++;
        }
        if (cnt >= 3) {
            out += cnt;
            while (cnt-- > 0) stack.pop();
        }

        return out;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] bls = Arrays.stream(reader.readLine().split(" ")).skip(1).mapToInt(Integer::parseInt).toArray();
        writer.write(String.valueOf(new MainRefined().solve(bls)));

        reader.close();
        writer.close();
    }
}
