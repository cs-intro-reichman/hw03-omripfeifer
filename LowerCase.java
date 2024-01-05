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
    public static String lowerCase(String str) {
        String lowstr = "" ;
        int a = str.length();
        int i = 0 ;
        while ( i < a ) {
            if ( str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' ) {
                int decimalValue = 32 + (int) str.charAt(i);
                char character = (char) decimalValue;
                lowstr += character ;
            } else {
                lowstr += str.charAt(i) ;
            } 
            i ++; 
        }
        return lowstr;
    }
}
