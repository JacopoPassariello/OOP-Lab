public class Main {
   public static void main(String[] args) {
      String[] words = {"pippo", "pluto", "alice", "bob"};

      for (String word : words) {
         char middleChar;
         //Selezionare il carattere centrale usando CharAt
         middleChar=word.charAt(word.length()/2);
         System.out.println(middleChar);
      }

      String[] words2 = {"John", "Fitzgerald", "Kennedy"};
      String initials = "";
      for(String word : words2)
      {
         initials+=(word.charAt(0));
      }

      System.out.println(initials);
   }
}