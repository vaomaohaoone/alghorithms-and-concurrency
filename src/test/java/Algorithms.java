
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Algorithms {

    private final int[] template = {7, 4, 2, 8, 10, 1, 6, 5, 3, 9};
    private final int[] predicted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void bubbleSortDummy() {
        int[] a = template.clone();
        int i = 0;
        int N = a.length;
        while (i != N) {
            int j = 1;
            while (j != N) {
                if (a[j] < a[j - 1]) {
                    swap(a, j - 1, j);
                }
                j = j + 1;
            }
            i = i + 1;
        }
        assertArrayEquals(predicted, a);
    }

    @Test
    public void bubbleSortShort() {
        int[] a = template.clone();
        int N = a.length;
        for (int i = 0; i < N; i ++) {
            for (int j = 1; j < N; j++) {
                if (a[j] < a[j - 1]) {
                    swap(a, j - 1, j);
                }
            }
        }
        assertArrayEquals(predicted, a);
    }

    @Test
    public void testBinarySearch() {
        assertEquals(4, binarySearch(predicted, 5));
        assertEquals(0, binarySearch(predicted, 1));
        assertEquals(9, binarySearch(predicted, 10));
        assertEquals(-1, binarySearch(predicted, 11));
    }

    @Test
    public void testQuickSort() {
        int[] a = template.clone();
        quickSort(a, 0, a.length - 1);
        assertArrayEquals(predicted, a);
    }

    @Test
    public void insertSort() {
        int[] a = template.clone();
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1])
                    swap(a, j, j - 1);
            }
        }
        assertArrayEquals(predicted, a);
    }

    @Test
    public void mergeSortTest() {
        int[] a = template.clone();
        assertArrayEquals(predicted, mergeSort(a));
    }

    private static int binarySearch(int [] array, int num) {
        int left = 0, right = array.length - 1;
        int mid = (left + right) / 2;
        while (array[mid] != num) {
            if (left > right)
                return -1;
            if (array[mid] < num) {
                left = mid + 1;
            }
            else
                right = mid - 1;
            mid = (left + right) / 2;

        }
        return mid;
    }

    public static void quickSort(int[] arr, int from, int to) {

        if (from < to) {

            int divideIndex = partition(arr, from, to);

            quickSort(arr, from, divideIndex - 1);

            quickSort(arr, divideIndex, to);
        }
    }

    private static int partition(int[] array, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = array[from + (to - from) / 2];
        while (leftIndex <= rightIndex) {

            while (array[leftIndex] < pivot) {
                leftIndex++;
            }

            while (array[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(array, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(int [] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    private int[] mergeSort(int [] array) {
        if (array.length <= 1)
            return array;
        int [] left = Arrays.copyOfRange(array, 0, array.length / 2);
        int [] right = Arrays.copyOfRange(array, array.length / 2, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int [] a, int [] b) {
        int [] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k] = a[i];
                i++;
            }else {
                c[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < a.length) {
            c[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
            c[k] = b[j];
            j++;
            k++;
        }
        return c;
    }

}
