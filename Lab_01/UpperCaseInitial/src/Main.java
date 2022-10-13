public class Main {
    public static void main(String[] args) {
        String[] words = {"", "a", "alice", "bob", "pippo", "pluto"};
        String result = "";
        char initial;
        for (String word : words) {
            if(word.length()>=1)
            {
                result="";
                initial=word.charAt(0);
                result += initial;
                result=result.toUpperCase();
                result+=word.substring(1);
            }
            System.out.println(result);
        }

    }
}