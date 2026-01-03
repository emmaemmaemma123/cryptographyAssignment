import java.util.Scanner;
public class vigenereCipher{
    public static String encode(String plainText, String keyword) {
        String res="";
        int j=0;
        char plainChar;
        char base;
        char keyBase;
        for(int i=0;i<plainText.length();i++){
            plainChar=plainText.charAt(i);
            char keyChar=keyword.charAt(j);
            if(!Character.isLetter(plainChar)){
                res += plainChar;
                
            }
            else{
                if(Character.isUpperCase(plainChar)){
                    base='A';
                } else{
                    base='a';
                }
                if(Character.isUpperCase(keyChar)){
                    keyBase='A';
                } else{
                    keyBase='a';
                }
                keyChar=(char) (keyChar-keyBase);
                char newChar = (char) ( ( (plainChar - base) + keyChar) % 26 + base);
                res+=newChar;
                if (j<keyword.length()-1)j++;
                else j=0;
            }
        }
        return res;
    }
    public static String decode(String cipherText, String keyword) {
        String res="";
        int j=0;
        char plainChar;
        char base;
        char keyBase;
        for(int i=0;i<cipherText.length();i++){
            plainChar=cipherText.charAt(i);
            char keyChar=keyword.charAt(j);
            if(!Character.isLetter(plainChar)){
                res += plainChar;
                
            }
            else{
                if(Character.isUpperCase(plainChar)){
                    base='A';
                } else{
                    base='a';
                }
                if(Character.isUpperCase(keyChar)){
                    keyBase='A';
                } else{
                    keyBase='a';
                }
    
                
                keyChar=(char) (keyChar-keyBase);
                plainChar = (char)(plainChar-base);
                if(plainChar<keyChar) plainChar = (char)(plainChar+26);
                                
                char newChar = (char) ( ( plainChar - keyChar) % 26 + base);
                res+=newChar;
                if (j<keyword.length()-1)j++;
                else j=0;
            }
        }
        return res;
    }

    public static void main (String [] args){
       Scanner in = new Scanner(System.in);
       String plainText = in.nextLine();
       Scanner in2 = new Scanner(System.in);
       String keyword = in2.nextLine();
       System.out.println(decode(plainText, keyword));
    }
}