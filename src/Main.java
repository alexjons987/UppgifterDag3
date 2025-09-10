import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n1. Staff register");
            System.out.println("2. Recipe manager");
            System.out.println("3. Film library");
            System.out.println("4. Training log");
            System.out.println("5. Bookstore");
            System.out.print("Choose assignment 1-5 (0 = exit): ");
            int chosenAssignment = scanner.nextInt();

            switch (chosenAssignment) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    Uppgift1.main(args);
                    break;
                case 2:
                    Uppgift2.main(args);
                    break;
                case 3:
                    Uppgift3.main(args);
                    break;
                case 4:
                    Uppgift4.main(args);
                    break;
                case 5:
                    Uppgift5.main(args);
                    break;
                default:
                    break;
            }
        }
        System.out.println("Bye bye!");
    }
}