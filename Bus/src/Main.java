import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        BusProb bp;

        bp=new BusProb() ;
        int capacity;
        int  stops;
        List<String> listOfInputs= new ArrayList<>();

        capacity=8;
        stops=5;

        listOfInputs.add("+1001 +1002 +1003 +1004 +1005 +1015");
        listOfInputs.add("-1001 -1003 -1005 +1006 +1007 -1015");
        listOfInputs.add("+1008 -1004 -1002 +1009 -1006 +1001");
        listOfInputs.add("-1008 +1010 -1009 +1005 -1007");
        listOfInputs.add("+1011 -1010 -1005");

        String query="5, 1001";
        String actual=bp.output(capacity,stops,listOfInputs,query);
        System.out.println(actual);
        System.out.println(actual.hashCode());


    }
}
