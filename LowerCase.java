/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String s) {
        String answer = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) > 64 && s.charAt(i) < 91){
                answer = answer + (char)(s.charAt(i) + 32);

            }
            else{
                answer = answer + s.charAt(i);
            }
        }
        return answer;
    }
}
