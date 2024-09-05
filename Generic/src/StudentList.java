import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class StudentList<T> {
    ArrayList<T> list= new ArrayList<T>();
    public void addElement(T type){list.add(type);}
    public void removeElement(T type){list.remove(type);}
    public T getElement(int index){return list.get(index);}

    public String beginsWith(String c){
        String out="";
        for (T name:list      ) {
            String n=(String) name;
            if(n.startsWith(c.toUpperCase()))
                out=out+n+"\n";

        }
        return out;
    }
    public String bloodGroupOf(String type,String q){
        String out="";
        String[] bloodgrps=type.split(" ");
        for (int i = 0; i < bloodgrps.length; i++) {
            if(bloodgrps[i].equals(q))
                out=out+list.get(i)+"\n";
        }
        return out;
    }

    public void thresholdScore(T type){}

}
