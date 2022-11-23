import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double sum = 0;
        int tries = 0;
        boolean bool = true;
        do {
            try {
                System.out.println("Dammi un numero");
                sum += in.nextDouble();
            }
            catch (InputMismatchException e) {
                tries++;
                System.out.println("Input errato.");

                if (tries == 2) {
                    System.out.println("Tentativi esauriti");
                    break;
                }
            }
            finally {in.nextLine();}
        }while(bool);
        System.out.println("Il totale dei valori inseriti è " + sum);
    }
}