package block2.taskc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89518/problems?id=175943%2F2016_10_05%2FLq0Bt3dLjD">
 * Intersection of sets (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * @param arr1 first list (up to 10<sup>5</sup> numbers)
     * @param arr2 second list (up to 10<sup>5</sup> numbers)
     * @return intersection in ascending order
     */
    Set<Integer> solve(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            int[] tmp = arr1;
            arr1 = arr2;
            arr2 = tmp;
        }
        Set<Integer> set1 = new TreeSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : arr1) set1.add(i);
        for (int i : arr2) set2.add(i);

        set1.retainAll(set2);

        return set1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        int[] arr1 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(new Main().solve(arr1, arr2).stream().map(String::valueOf).collect(Collectors.joining(" ")));

        writer.close();
        reader.close();
    }
}
