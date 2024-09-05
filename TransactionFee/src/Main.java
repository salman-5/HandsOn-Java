public class Main {

    public static void main(String[] args){
        float total;
        total=1000;
        System.out.println("Transaction Fee of all options");
        for (PaymentOptions p: PaymentOptions.values()){
            System.out.printf("Fee with %s is %f \n",p,p.fee(total));
        }
    }
}
