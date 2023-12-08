import java.util.Arrays;

class SortingAlgorithms {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
                ComparisonCounter.incrementComparisonCount();
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                ComparisonCounter.incrementComparisonCount();
            }
            swap(arr, i, minIndex);
        }
    }

    public static void mergeSort(int[] arr) {
        ComparisonCounter.resetComparisonCount();
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = Arrays.copyOfRange(arr, low, low + n1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, mid + 1 + n2);

        int i = 0, j = 0, k = low;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
            ComparisonCounter.incrementComparisonCount();
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }
    }

    public static void quickSort(int[] arr) {
        ComparisonCounter.resetComparisonCount();
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSortHelper(arr, low, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
            ComparisonCounter.incrementComparisonCount();
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sortingPerformance() {
        long[][] timeData = new long[4][10];
        long[][] comparisonData = new long[4][10];
        String[] sortingAlgorithms = {"Bubble Sort", "Selection Sort", "Merge Sort", "Quick Sort"};

        for (int i = 0; i < 10; i++) {
            int n = (i + 1) * 5000;
            int[] data = Data.generateRandomData(n, n);

            for (int j = 0; j < 4; j++) {
                ComparisonCounter.resetComparisonCount();

                long startTime = System.currentTimeMillis();
                if (j == 0) {
                    bubbleSort(data.clone());
                } else if (j == 1) {
                    selectionSort(data.clone());
                } else if (j == 2) {
                    mergeSort(data.clone());
                } else if (j == 3) {
                    quickSort(data.clone());
                }
                long endTime = System.currentTimeMillis();

                timeData[j][i] = (endTime - startTime);
                comparisonData[j][i] = ComparisonCounter.getComparisonCount();
            }
        }

        for (int i = 0; i <= 10; i++) {
            if (i == 0) {
                System.out.printf("%-40s", "\nSample size");
            } else {
                System.out.printf("%-20s", i * 5000);
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.printf("%-40s", "\n" + sortingAlgorithms[i] + ", random, comparisons");
            for (int j = 0; j < 10; j++) {
                System.out.printf("%-20s", comparisonData[i][j]);
            }

            System.out.printf("%-40s", "\n" + sortingAlgorithms[i] + ", random, ms");
            for (int j = 0; j < 10; j++) {
                System.out.printf("%-20s", timeData[i][j]);
            }
        }

        System.out.println("\n");
    }
}
