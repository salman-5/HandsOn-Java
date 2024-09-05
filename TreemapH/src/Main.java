public class Main {
    public static void main(String[] args){
        Treemap th;
        th=new Treemap();

        String expected="1 Virat\n3 Dhoni\n6 Rahul\n";
        String actual= th.getQuery("3,Dhoni,120|1,Virat,103|5,Jadeja,90|2,Rohit,70|4,Pandya,30|6,Rahul,150","2 100");
        System.out.println(actual);
    }

}
