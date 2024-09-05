import java.util.ArrayList;

public class ScoreList <T>{
    ArrayList<T> list= new ArrayList<>();
    public void addElement(T type){list.add(type);}
    public void removeElement(T type){ list.remove(type);}
    public T getElement(int index){ return list.get(index);}
    public String averageValues(){
        float avg=0;
        for (T s:list    ) {
            avg=avg+Float.parseFloat((String) s);
        }
        avg=avg/list.stream().count();
        return String.format("%.2f",avg);
    }
}
