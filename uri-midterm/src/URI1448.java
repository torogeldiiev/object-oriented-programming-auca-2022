import java.util.Scanner;

public class URI1448 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= number; i++) {
            int counter1 = 0, counter2 = 0;
            String init = sc.nextLine();
            String first = sc.nextLine();
            String second = sc.nextLine();
            int index1 = -1, index2 = -1;

            for (int j = 0; j < first.length(); j++) {
                if (init.charAt(j) == first.charAt(j)) {
                    counter1++;
                } else {
                    if (index1 == -1 && second.charAt(j) == init.charAt(j)) {
                        index1 = j;
                    }
                }
                if (init.charAt(j) == second.charAt(j)) {
                    counter2++;
                } else {
                    if (index2 == -1 && first.charAt(j) == init.charAt(j)) {
                        index2 = j;
                    }
                }
            }
            if (counter1 > counter2) {
                System.out.println("Instancia " + i);
                System.out.println("time 1");
            } else if (counter1 < counter2) {
                System.out.println("Instancia " + i);
                System.out.println("time 2");
            } else {
                if (index1 < index2) {
                    System.out.println("Instancia " + i);
                    System.out.println("time 2");
                } else if (index1 > index2) {
                    System.out.println("Instancia " + i);
                    System.out.println("time 1");
                } else {
                    System.out.println("Instancia " + i);
                    System.out.println("empate");
                }
            }
            System.out.println();

        }
    }
}

