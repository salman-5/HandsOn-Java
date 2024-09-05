public class Main {
    public static void main(String[] args){
        Aided aided;
        SelfFinance self;
        aided=new Aided();
        self=new SelfFinance();

        String allmarks="67 4,34 2,54 5,100 2|1,100,5|0,100,5";
        String actual=aided.result(allmarks);
        int expected=1624853;
        System.out.println(actual);
        System.out.println(actual.hashCode());

        allmarks="100 5,100 5,100 5,76 3|0,100,5";
        actual=self.result(allmarks);
        expected=1714291;
        System.out.println(actual);
        System.out.println(actual.hashCode());
    }
}
