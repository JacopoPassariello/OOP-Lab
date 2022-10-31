import java.util.Random;
import java.util.Scanner;

public class Dice {

    public static void main(String[] args) {
        BankAccount playerAccount = new BankAccount(1000);
        BankAccount casinoAccount = new BankAccount(100000);
        int predictedValue, actualValue;
        double bet;
        Random rand = new Random();
        String choice = "no";
        Scanner in = new Scanner(System.in);

        do {
            if(playerAccount.getBalance() == 0)
            {
                System.out.println("Hai finito i soldi, prova a spenderne altri per recuperare le perdite.");
                break;
            }
            if(casinoAccount.getBalance() == 0)
            {
                System.out.println("Hai sfondato!!");
                break;
            }
            System.out.println("Vuoi scommettere?");
            choice = in.nextLine();
            System.out.println(choice);
            if(!choice.equalsIgnoreCase("si")) break;

            do
            {
                System.out.println("Inserire quanto vuoi scommettere:");
                bet = in.nextDouble();
                if (bet > playerAccount.getBalance() || bet > casinoAccount.getBalance() / 5) {
                    System.out.println("Valore scommessa non valida");
                }
                else break;
            }while(true);

            do
            {
                System.out.println("Inserire il valore da predirre:");
                predictedValue = in.nextInt();
                if (predictedValue < 1 || predictedValue > 6) {
                    System.out.println("Valore non valido");
                }
                else break;
            }while(true);

            actualValue = (rand.nextInt(6)+1);

            System.out.println("Il valore del dado è: " + actualValue );
            if (predictedValue == actualValue)
            {
                System.out.println("Hai vinto!");
                casinoAccount.withdraw(bet*5);
                playerAccount.deposit(bet*5);
            }
            else
            {
                System.out.println("Hai perso...");
                playerAccount.withdraw(bet);
            }

            System.out.println("Il tuo saldo è " + playerAccount.getBalance());
            in.nextLine();

        }while(true);

    }
}