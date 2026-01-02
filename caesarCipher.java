import java.util.Scanner;
public class caesarCipher{
    public static String encode(String plainText, int key){
        String res="";
        for(int i=0;i<plainText.length();i++){
            char originalChar = plainText.charAt(i);
            if(Character.isLetter(originalChar)==true){
                char base;
                if(Character.isUpperCase(originalChar)){
                    base='A';
                } else {
                    base='a';
                }
                char newChar = (char) ( ( (originalChar - base) + key) % 26 + base);
                res=res+newChar;
            } else {
                res=res+originalChar;
            }
        }
        return res;
    }
    public static String decode(String cipherText, int key){
        return encode(cipherText,26-key);
    }
    public static void main (String [] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word to encode it: ");
        String text = in.nextLine();
        System.out.println(encode(text,3));
        Scanner in2 = new Scanner(System.in);
        System.out.print("Enter a word to decode it: ");
        String code = in2.nextLine();
        System.out.println(decode(code,3));
    }
}