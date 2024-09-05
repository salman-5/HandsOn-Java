import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Passanger{

    int id;
    float fare;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }
    public Passanger(int id,float fare){
        this.id=id;
        this.fare=fare;
    }
    //just to see class objects
    @Override
    public String toString(){
        return "Passanger{"+
                "id=" + id +
                ", fare=" + fare+
                "}";

    }
}
public class BusProb {
    public String output(int capacity, int stops, List<String> listOfInputStrings, String query){
        String outString="";
        String[] q= query.split(",");

        List<Passanger> listPassangers=new ArrayList<>();
        HashSet<String> insidePassengers=new HashSet<>();
        int countFare1=0,countFare2=0,countFare3=0;
        float fareTotal=0;
        int times=0;
        int currently=0,entry=0,exit=0;
        float fare;

        for (String t:listOfInputStrings ) {
            entry=entry+(int) t.chars().filter(ch -> ch=='+').count();
            exit=exit+(int) t.chars().filter(ch -> ch=='-').count();
            currently=entry-exit;

            String[] sps=t.split(" ");
            for (String sp:sps) {
                if(sp.startsWith("+")){
                    if(currently<=Math.ceil(capacity*0.25))
                        fare= (float) (capacity+capacity*0.6);
                    else if(currently>Math.ceil(capacity*0.25)&& (currently)<= Math.ceil(capacity*0.5))
                        fare=(float) (capacity+capacity*0.3);
                    else
                        fare=(float) capacity;

                    insidePassengers.add(sp.substring(1));
                    Passanger temp=new Passanger(Integer.parseInt(sp.substring(1)),fare);
                    listPassangers.add(temp);
                }
                if (sp.startsWith("-"))
                    insidePassengers.remove(sp.substring(1));
                }
            }

            for (Passanger passanger: listPassangers) {
                if(q[0].equals("3")){
                    if(passanger.getId()==Integer.parseInt(q[1].trim()))
                        fareTotal=fareTotal+passanger.getFare();
                }
                if (q[0].equals("4")){
                    if (passanger.getId()==Integer.parseInt(q[1].trim()))
                        times++;
                }
                if(passanger.getFare()==(float) (capacity+capacity*0.6))
                    countFare1++;
                else if(passanger.getFare()==(float) (capacity+capacity*0.3))
                    countFare2++;
                else
                    countFare3++;
            }

            //query 1
            if(q[0].equals("1"))
                outString=entry+" passengers got on the bus and "+ exit + " passengers got out of the bus";
            //query 2
            else if(q[0].equals("2"))
                outString=countFare1 + " passengers traveled with a fare of "+ (float) (capacity+capacity*0.6)+", "+countFare2+ " passengers traveled with a fare of "+(float)(capacity+capacity*0.3)+" and "+ countFare3+" passengers traveled with a fare of "+ (double) capacity;
            //query 5
            else if(q[0].equals("5")) {
                String qw = q[1].trim();
                System.out.println(qw);
                if (insidePassengers.contains(qw))
                    outString = "Passenger " + qw + " was inside the bus at the end of the trip";
                else
                    outString = "Passenger " + qw + " was not inside the bus at the end of the trip";

            }
            //query 4
            else if(q[0].equals("4"))
                outString="Passenger "+ q[1].trim()+ " has got on the bus for "+times+" times";
            //query 3
            else if(q[0].equals("3"))
                outString="Passenger "+q[1].trim()+ " spent a total fare of "+(float) fareTotal;



    return outString;
    }
}
