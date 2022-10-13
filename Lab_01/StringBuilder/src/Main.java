public class Main {
   public static void main(String[] args) {
      String sentence = "Hello, World!";
      StringBuilder newSentence = new StringBuilder(sentence);
      newSentence.replace(1,2,"o");
      newSentence.replace(4,5,"e");
      newSentence.replace(8,9,"e");


      System.out.println(newSentence);
   }
}