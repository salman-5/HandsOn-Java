import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.awt.geom.FlatteningPathIterator;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

class Register{
    public static Register getInstance(){
        if(register==null)
            register=new Register();
        return register;
    }
    private static Register register=null;
    Map<String,Float> list = new HashMap<>();
    Register(){
        this.list.put("apple",2.0F);
        this.list.put("orange",1.5F);
        this.list.put("mango",1.2F);
        this.list.put("grape",1.0F);
    }
    public String getTotalBill(Map<String, Integer> itemDetails){
        float sum=0;
        for (Map.Entry mapElement : itemDetails.entrySet() ) {
            String key = ((String) mapElement.getKey()).toLowerCase();
            if(register.list.containsKey(key)){
                sum=sum+register.list.get(key)*(float)(itemDetails.get(key));
            }

        }
        return String.valueOf(sum);
    }
}
public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner readInput = new Scanner(System.in);
        String[] input=readInput.nextLine().split(" ");
        Map<String, Integer> myItems = new HashMap<>();
        for (int i = 0; i < input.length; i+=2) {
            myItems.put(input[i],Integer.parseInt(input[i+1]));
        }
        Register regObj = Register.getInstance();
        System.out.println(regObj.getTotalBill(myItems));
        readInput.close();
    }
}
