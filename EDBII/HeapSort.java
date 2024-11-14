public class HeapSort {

    public static void maxHeapify(int[] array, int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && array[left] > array[largest]) largest = left;
        if (right < size && array[right] > array[largest]) largest = right;

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            maxHeapify(array, size, largest);
        }
    }

    public static void heapSort(int[] array) {
        int size = array.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(array, size, i);
        }

        for (int i = size - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            maxHeapify(array, i, 0);
        }
    }
}
