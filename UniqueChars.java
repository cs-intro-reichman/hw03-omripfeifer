/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String str) {
        String nstr = "" ;
        int a = str.length();
        int i = 0 ;
        while ( i < a ) {
            char currentChar = str.charAt(i) ;
            if ( currentChar == ' ' || nstr.indexOf(currentChar) == -1 ){
                nstr += currentChar ;
            } 
            i ++ ; 
        }
        return nstr;
    }
} 
