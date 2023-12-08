class ComparisonCounter {
    private static long comparisonCount = 0;

    public static long getComparisonCount() {
        return comparisonCount;
    }

    public static void resetComparisonCount() {
        comparisonCount = 0;
    }

    public static void incrementComparisonCount() {
        comparisonCount++;
    }
}
