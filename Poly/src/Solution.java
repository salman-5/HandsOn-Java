import java.util.Scanner;

class Parent{
    public int startElement,endElement;
    public String filter(){
        return null;
    }
}
class ChildOne extends Parent{
    ChildOne(int a,int b){
        this.startElement=a;
        this.endElement=b;
    }
    @Override
    public String filter(){
        String result="";
        for (int i =startElement; i <=endElement ; i++) {
            int f=1;
            int j=2;
            while (j<=0.5*i){
                if(i%j==0){
                    f=0;
                    break;
                }
                j++;
            }
            if (i==1)
                continue;
            else if (f==1)
                result=result+i+" ";
        }
        return result.trim();
    }
}
class ChildTwo extends Parent{
    ChildTwo(int a, int b){
        this.startElement=a;
        this.endElement=b;
    }
    public int sum (int num){
        int sum=0;
        while (num>0){
            int n1=num%10;
            sum=sum+n1*n1;
            num=num/10;
        }
        return sum;
    }
    @Override
    public String filter(){
        String result="";
        for (int i = startElement; i <=endElement; i++) {
            int su=0;
            su=sum(i);
            while (true){
                su=sum(su);
                if(su==1 || su==4){
                    break;
                }
            }
            if (su==1)
                result=result+i+" ";
        }
        return result.trim();
    }
}

public class Solution {

    public static void main(String[] args) throws  Exception{
        Scanner sc= new Scanner(System.in);
        int a=Integer.parseInt(sc.nextLine());
        int b=Integer.parseInt(sc.nextLine());
        ChildOne c1=new ChildOne(a,b);
        System.out.println(c1.filter());
        ChildTwo c2=new ChildTwo(a,b);
        System.out.println(c2.filter());
    }
}
