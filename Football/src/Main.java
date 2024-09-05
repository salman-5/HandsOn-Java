
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static String sortItOut(String hash) throws IOException{
        String[] string =hash.split(" ");
        Arrays.sort(string);
        String str="";
        for (String s: string  ) {
            str+=s+" ";
        }
        if(true){
            return str;
        }
        return null;
    }
    public static void main(String[] args) throws IOException{
        Hashset hashset;
        hashset=new Hashset();

        String output=hashset.getOut(4,"Ronaldo Eder Andre Bruma Goncalo Jota Daniel Patricio Ricardo Dom Semedo Bernado Pereira Bruno Pizzi Paciencia Jota Daniel Patricio Ronaldo Eder Andre Bruma Ricardo Dom#Ronaldo Eder Andre Bruma Goncalo Joao Dyego Jose Nelson Pepe Mario Pereira Rafa Renato Ferro Bruma Goncalo Joao Dyego Jose Nelson Pepe Mario Pereira#Ronaldo Eder Andre Bruma Goncalo Jota Daniel Patricio Nelson Pepe Mario Pereira Rafa Renato Ferro Daniel Patricio Nelson Pepe Mario Pereira Rafa Renato#Ronaldo Eder Andre Bruma Goncalo Joao Dyego Jose Ricardo Dom Semedo Bernado Pereira Bruno Pizzi",2,4);
        String[] stringArray =output.split(", ");
        String actual=Main.sortItOut(stringArray[0])+Main.sortItOut(stringArray[1]);
        System.out.println(actual);
        System.out.println(actual.hashCode());
    }
}
