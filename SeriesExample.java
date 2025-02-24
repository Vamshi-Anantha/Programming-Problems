import java.util.Scanner;

public class SeriesExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();
        scanner.close();

        int term = 1;

        System.out.print("Sequence: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(term + " ");
            term = term + i;
        }
    }
}
