public class Main {
    public static void main(String[] args) {
        String[] words = {"c","ac","pippo"};

        for (String word : words) {
            String result="";
            String first;
            String last;
            String middle;
            if(word.length()<2)
            {
                result="Stringa corta";
            }
            else
            {
                first=word.substring(0,1);
                last=word.substring(word.length()-1,word.length());
                middle=word.substring(1,word.length()-1);
                result = last + middle + first;
            }
            /* TODO */

            System.out.println(result);
        }
    }
}