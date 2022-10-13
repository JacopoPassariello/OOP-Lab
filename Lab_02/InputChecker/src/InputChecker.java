import java.util.Scanner;

public class InputChecker {

    public String checkInput(String input)
    {
        String[] array = {"S","SI","OK","certo","perché no?"};
        String[] array2 = {"No","N"};
       for(String i : array)
       {
           if(i.equals(input)) return "OK";
       }
       for(String i : array2)
       {
        if(i.equals(input)) return "Fine";
       }
       return "Dato non corretto";
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Dammi l'input di verifica: ");
        String input = in.nextLine();

        InputChecker inputChecker = new InputChecker();
        System.out.println(inputChecker.checkInput(input));
    }
}