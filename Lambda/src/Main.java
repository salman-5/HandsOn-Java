public class Main {
    public static void main(String[] args){
        float n1,n2;
        n1=185;
        n2=0;

        Operation add =(a,b)->a+b;
        Operation subtract =(a,b)->a-b;
        Operation multiply =(a,b)->a*b;
        Operation divide =(a,b)->{
            if (b==0)
                return 0;
            else
                return a/b;
        };

        System.out.printf("Numbers are %f and %f \n",n1,n2);
        System.out.println("Addition Result = "+add.execute(n1,n2));
        System.out.println("Subtraction Result = "+subtract.execute(n1,n2));
        System.out.println("Multiplication Result = "+multiply.execute(n1,n2));
        System.out.println("Division Result = "+divide.execute(n1,n2));

    }
}
