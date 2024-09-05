public class StudentClass<T,M> {

    public String getQuery(String studentData, String query){
        StudentList<M> nl= new StudentList<M>();
        ScoreList<T> sl= new ScoreList<T>();
        String[] q=query.split(",");
        String out="";
        if(q[0].equals("1")){
            for (String names: studentData.split(" ")){
                nl.addElement((M) names);
            }
            out=nl.beginsWith(q[1]);
        }
        else if(q[0].equals("2")){
            for (String names: studentData.split(" ")){
                nl.addElement((M) names);
            }
            out=nl.bloodGroupOf(q[1],q[2]);
        }
        else if(q[0].equals("3")){
            int count=0;
            for (String score: studentData.split(" ")){
                sl.addElement((T) score);
                if(Integer.parseInt(score)>= Integer.parseInt(q[1]))
                    count++;
            }
            out=count+" students scored "+q[1]+" above";
        }
        else if(q[0].equals("4")){
            for (String score: studentData.split(" ")){
                sl.addElement((T) score);
            }
            out=sl.averageValues();
        }
        else if(q[0].equals("5")){
            for (String score: studentData.split(" ")){
                sl.addElement((T) score);
            }
            out=sl.averageValues();
        }
        return out;
    }
}
