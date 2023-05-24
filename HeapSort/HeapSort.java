package HeapSort;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[20];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(101);
        }

        System.out.println(Arrays.toString(numbers));
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void sort(Integer[] numbers) {
        for (int i = numbers.length / 2 - 1; i >= 0; i--) {
            updateHeap(numbers, numbers.length, i);
        }

        for (int i = numbers.length - 1; i >= 0; i--) {
            int temp = numbers[0];
            numbers[0] = numbers[i];
            numbers[i] = temp;

            updateHeap(numbers, i, 0);
        }
    }

    private static void updateHeap(Integer[] numbers, int length, int i) {
        int startPos = i;
        int leftSide = 2 * i + 1;
        int rightSide = 2 * i + 2;

        if (leftSide < length && numbers[leftSide] > numbers[startPos]) {
            startPos = leftSide;
        }
        if (rightSide < length && numbers[rightSide] > numbers[startPos]) {
            startPos = rightSide;
        }
        if (startPos != i) {
            int temp = numbers[i];
            numbers[i] = numbers[startPos];
            numbers[startPos] = temp;

            updateHeap(numbers, length, startPos);
        }
    }
}
