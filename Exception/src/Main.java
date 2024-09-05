import java.util.Scanner;

class InvalidMessageException extends Exception{

}
class Encrypter{
    public static String encryptMessage(String name){
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        String out="";

        try {
            if(Validator.validate(name)){
                sb.append(name);
                name=sb.reverse().toString();
                for (int i = 0; i < name.length(); i++) {
                    if(Character.isUpperCase(name.charAt(i)))
                        sb1.append(Character.toLowerCase(name.charAt(i)));
                    else
                        sb1.append(name.charAt(i));
                }
                out=sb1.toString();
            }
            else{
                throw new InvalidMessageException();
            }
        }catch (InvalidMessageException e){
            System.out.println("InvalidMessageException: Try again with valid message");
            return out;
        }
        return out;
    }
}
class Validator{
    public static boolean validate(String message){
        return message.matches("[A-Za-z0-9]");
    }
}
public class Main {
    private static final Scanner INPUT_READER=new Scanner(System.in);

    public static void main(String[] args) {
        String message = INPUT_READER.nextLine();
        try {
            String encrypted_message = Encrypter.encryptMessage(message);
            if (!encrypted_message.startsWith("InvalidMessageException"))
                System.out.println(encrypted_message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
