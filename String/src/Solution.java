import java.util.Scanner;

class CipherDecipher{
    public String ciphering(String normal){
        char[] ch = normal.toCharArray();
        for (char c: ch) {
            if(Character.isDigit(c))
                return null;
        }
        StringBuilder sb= new StringBuilder();
        for (char c: ch ) {
            if(Character.isLowerCase(c))
                sb.append(Character.toUpperCase(c));
            else if(Character.isUpperCase(c))
                sb.append(Character.toLowerCase(c));
            else if(c==' ')
                sb.append("*");
            else
                sb.append(c);
        }
        sb.reverse();
        String ns=sb.toString();
        StringBuilder sb1=new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if(i%2!=0)
                sb1.append((int) ns.charAt(i));
            else
                sb1.append(ns.charAt(i));
        }
        sb1.append(3);
        return sb1.toString();
    }
    public String deciphering(String ciphered){
        String t;
        int n;
        StringBuilder sb1= new StringBuilder();
        StringBuilder sb= new StringBuilder();
        StringBuilder num = new StringBuilder();

        sb1.append(ciphered.charAt(0));
        for (int i = 1; i < ciphered.length(); i++) {
            if(Character.isDigit(ciphered.charAt(i))){
                num.append(ciphered.charAt(i));
            }
            else {
                System.out.println(sb1);
                t=num.toString();
                if(!t.equals("")){
                    n=Integer.parseInt(t);
                    char ch=(char) n;
                    sb1.append(ciphered.charAt(i));
                }
            }
        }
        if(!num.toString().equals("")){
            n=Integer.parseInt(num.toString());
            char ch=(char) n;
            sb1.append(ch);
        }
        sb1.reverse();
        String b=sb1.toString();
        System.out.println(b);
        char[] ch1=b.toCharArray();
        for (char c: ch1 ) {
            if(Character.isLowerCase(c))
                sb.append(Character.toUpperCase(c));
            else if(Character.isUpperCase(c))
                sb.append(Character.toLowerCase(c));
            else if(c=='*')
                sb.append(' ');
            else
                sb.append(c);
        }
        return sb.toString();
    }

}
public class Solution {
    public static void main(String[] args){
        Scanner readInput = new Scanner(System.in);
        String normal=readInput.nextLine();
        String ciphered= readInput.nextLine();

        CipherDecipher cipherOrDecipher = new CipherDecipher();
        System.out.println(cipherOrDecipher.ciphering(normal));
        System.out.println(cipherOrDecipher.deciphering(ciphered));
    }
}
