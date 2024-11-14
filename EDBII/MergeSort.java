public class MergeSort {

    public static void merge(int[] list, int init, int middle, int end) {
        int leftLength = middle - init + 1;
        int rightLength = end - middle;

        int[] leftList = new int[leftLength];
        int[] rightList = new int[rightLength];

        System.arraycopy(list, init, leftList, 0, leftLength);
        System.arraycopy(list, middle + 1, rightList, 0, rightLength);

        int i = 0, j = 0, k = init;

        while (i < leftLength && j < rightLength) {
            if (leftList[i] <= rightList[j]) {
                list[k++] = leftList[i++];
            } else {
                list[k++] = rightList[j++];
            }
        }

        while (i < leftLength) list[k++] = leftList[i++];
        while (j < rightLength) list[k++] = rightList[j++];
    }

    public static void mergeSort(int[] list, int init, int end) {
        if (init < end) {
            int middle = init + (end - init) / 2;
            mergeSort(list, init, middle);
            mergeSort(list, middle + 1, end);
            merge(list, init, middle, end);
        }
    }
}