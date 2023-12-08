import java.util.Scanner;

public class SearchingSortingProject {
    public static void main(String[] args) {
        int[] data;
        char choice;
        int key;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Menu of Searching and Sorting Testbed.\n");
            System.out.println("1) Linear searching");
            System.out.println("2) Binary searching");
            System.out.println("3) O(n^2) type of sorting");
            System.out.println("4) O(n*log(n)) type of sorting");
            System.out.println("5) Sorting performance\n");
            System.out.println("q/Q) Quit\n");
            System.out.print("Your choice: ");

            choice = scanner.next().charAt(0);
            switch(choice) {
                case '1':
                    data = Data.getValuesZeroToNine();

                    System.out.print("\nIn the list are values 0, ..., 9; which value would you like to search with linear search? ");
                    key = scanner.nextInt();

                    SearchingAlgorithms.linearSearch(data, key);

                    break;
                case '2':
                    data = Data.getValuesZeroToNine();

                    System.out.print("\nIn the list are values 0, ..., 9; which value would you like to search with binary search? ");
                    key = scanner.nextInt();

                    SearchingAlgorithms.binarySearch(data, key);

                    break;
                case '3':
                    data = Data.generateRandomData(10, 100);

                    System.out.println("\nData set before bubble sorting: ");
                    for (int i: data) {
                        System.out.print(i + " ");
                    }

                    SortingAlgorithms.bubbleSort(data);

                    System.out.println("\n\nData set after bubble sorting: ");
                    for (int i: data) {
                        System.out.print(i + " ");
                    }
                    System.out.println("\n");

                    break;
                case '4':
                    data = Data.generateRandomData(10, 100);

                    System.out.println("\nData set before quicksort: ");
                    for (int i: data) {
                        System.out.print(i + " ");
                    }

                    SortingAlgorithms.quickSort(data);

                    System.out.println("\n\nData set after quicksort: ");
                    for (int i: data) {
                        System.out.print(i + " ");
                    }
                    System.out.println("\n");

                    break;
                case '5':
                    SortingAlgorithms.SortingPerformance();

                    break;
                case 'q', 'Q':
                    System.out.println("\nExiting...");

                    break;

                default:
                    System.out.println("\nInvalid choice...\n");
            }
        } while (choice != 'q' && choice != 'Q');
    }
}
