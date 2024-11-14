import java.util.Random;

public class BogoSort {
    private static Random random = new Random();

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    public static void shuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            swap(arr, i, random.nextInt(arr.length));
        }
    }

    public static void bogoSort(int[] arr) {
        while (!isSorted(arr)) shuffle(arr);
    }
}