package block4.taski;

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
 * <a href="https://new.contest.yandex.ru/contests/89532/problems?id=175943%2F2016_11_22%2FCd32DDMkPb">
 * Card game (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Constraints (from statement):<br>
     * - two players, five cards each, values 0..9, all ten values distinct; each line lists a deck top to bottom<br>
     * - each turn both reveal the top card; higher rank wins both cards and puts them under their deck: first the card revealed by player one, then the card revealed by player two (the second player’s card ends at the bottom of that deck).<br>
     * - rank order: larger beats smaller except 0 beats 9<br>
     * - if the game does not finish within 10<sup>6</sup> turns, the required output is the word botva instead of a winner and a move count<br>
     * - time limit 1 s, memory 64 MB<br>
     * <br>
     * Goal: output first or second and the number of turns until one deck is empty, or output botva if the move cap is reached without a winner.<br>
     * <br>
     * Approach:<br>
     * - model each deck as a queue, repeatedly pop two tops, compare with the rule above, push the pair to the winner’s queue in the required order.<br>
     *
     * @param deck1 first player’s initial deck top-to-bottom
     * @param deck2 second player’s initial deck top-to-bottom
     * @return two ints: 1 if first wins else 2, then move count
     */
    int[] solve(int[] deck1, int[] deck2) {
        Deque<Integer> d1 = new ArrayDeque<>();
        Deque<Integer> d2 = new ArrayDeque<>();
        for (int x : deck1) d1.addLast(x);
        for (int x : deck2) d2.addLast(x);
        int cnt = 0;
        while (!d1.isEmpty() && !d2.isEmpty()) {
            cnt++;
            int c1 = d1.poll();
            int c2 = d2.poll();
            if (c1 == 0 && c2 == 9 ||
                    c1 == 9 && c2 != 0 ||
                    c1 > c2 && c1 != 9
            ) {
                d1.add(c1);
                d1.add(c2);
            } else {
                d2.add(c1);
                d2.add(c2);
            }
        }
        return new int[]{d2.isEmpty() ? 1 : 2, cnt};
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] deck1 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] deck2 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ans = new Main().solve(deck1, deck2);
        writer.write((ans[0] == 1 ? "first " : "second ") + ans[1]);

        reader.close();
        writer.close();
    }
}
