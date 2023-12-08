import java.util.Random;

class Data {
    private static final int[] valuesZeroToNine = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static int[] getValuesZeroToNine() {
        return valuesZeroToNine;
    }

    public static int[] generateRandomData(int length, int n) {
        int[] data = new int[length];
        Random rand = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(2 * n) - n;
        }

        return data;
    }
}
