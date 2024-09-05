import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        LambdaFn fn;
        fn= new LambdaFn();
        long a,b;
        a=46;
        b=1000;

        List<String> listOfIntegers = new ArrayList<>();
        for (long i=a;i<=b;i++){
            listOfIntegers.add(i+"");
        }
        System.out.println(listOfIntegers);
        int actual =fn.functionalProgramming(listOfIntegers).hashCode();
        System.out.println(actual);
    }
}
