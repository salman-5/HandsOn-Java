import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

public class Main {
    public static void main(String[] args){
        StudentClass stud;

        stud=new StudentClass();
        Method[] methods= StudentList.class.getMethods();
        int count=0;
        for (Method method: methods) {
            if (method.getName().equals("addElement"))
                count++;
            else if (method.getName().equals("removeElement"))
                count++;
            else if (method.getName().equals("getElement"))
                count++;
            else if (method.getName().equals("beginsWith"))
                count++;
            else if (method.getName().equals("bloodGroupOf"))
                count++;
            else if (method.getName().equals("thresholdScore"))
                count++;
        }
        if(count==6)
            System.out.println("success");
        else
            System.out.println("fail");
        methods=ScoreList.class.getMethods();
        count=0;
        for (Method method: methods) {
            if (method.getName().equals("addElement"))
                count++;
            else if (method.getName().equals("removeElement"))
                count++;
            else if (method.getName().equals("getElement"))
                count++;
            else if (method.getName().equals("averageValues"))
                count++;
        }
        if(count==4)
            System.out.println("Success");
        else
            System.out.println("fail");

        Field[] fields1=StudentList.class.getDeclaredFields();
        Field[] fields2=ScoreList.class.getDeclaredFields();
        int flag=0;
        for (Field field: fields1 ) {
            System.out.println(field);
            if(field.getType().toString().equals("class java.util.ArrayList"))
                flag++;
        }
        for (Field field: fields2 ) {
            System.out.println(field);
            if(field.getType().toString().equals("class java.util.ArrayList"))
                flag++;
        }
        if (flag>=2)
            System.out.println("s");
        else
            System.out.println("f");
        TypeVariable<Class<StudentList>> [] parameter1 =StudentList.class.getTypeParameters();
        TypeVariable<Class<ScoreList>> [] parameter2 =ScoreList.class.getTypeParameters();
        if(parameter1.length==1 && parameter2.length==1)
            System.out.println("s");
        else
            System.out.println("f");

        String expected= "6.32";
        String actual=stud.getQuery("6.4 7.9 7.4 3.4 6.5","5");
        System.out.println(actual);
    }
}