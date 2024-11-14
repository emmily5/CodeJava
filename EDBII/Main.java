public class Main {

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {20, 5, 7, 7, 1};
        int[] arr2 = {20, 5, 7, 7, 1};
        int[] arr3 = {20, 5, 7, 7, 1};

        System.out.println("Original Array:");
        printArray(arr1);

        System.out.println("\nBogoSort:");
        BogoSort.bogoSort(arr1);
        printArray(arr1);

        System.out.println("\nMergeSort:");
        MergeSort.mergeSort(arr2, 0, arr2.length - 1);
        printArray(arr2);

        System.out.println("\nHeapSort:");
        HeapSort.heapSort(arr3);
        printArray(arr3);
    }
}
