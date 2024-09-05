import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaFn {
    public static int func(int number){
        double sum=0;
        int temp=number;
        int digits=Integer.toString(number).length();
        while (temp>0){
            int remain =temp%10;
            temp=temp/10;
            sum=sum+Math.pow(remain,digits);
        }
        if (sum==number)
            return 1;
        else
            return 0;
    }
    public List<Integer> functionalProgramming(List<String> listOfIntegers){
        List<Integer> outputList = Collections.emptyList();
        outputList=listOfIntegers.stream().map(x -> Integer.parseInt(x)).filter(x->func(x)==1).collect(Collectors.toList());
        return outputList;
    }
}
