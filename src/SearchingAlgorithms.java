class SearchingAlgorithms {
    public static void linearSearch(int[] arr, int key) {
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("\nNot found\n");
        } else {
            System.out.println("\nFound\n");
        }
    }

    public static void binarySearch(int[] arr, int key) {
        int index = binarySearchHelper(arr, key, 0, arr.length - 1);

        if (index == -1) {
            System.out.println("\nNot found\n");
        } else {
            System.out.println("\nFound\n");
        }
    }

    public static int binarySearchHelper(int[] arr, int key, int low, int high) {
        if (high >= low) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                return binarySearchHelper(arr, key, low, mid - 1);
            } else {
                return binarySearchHelper(arr, key, mid + 1, high);
            }
        }

        return -1;
    }
}
