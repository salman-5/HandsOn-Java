public abstract class Student {
    public abstract String result(String markString);

    public String grade(float marks){
        double gradePoint;
        if(marks>=75)
            gradePoint=9.0+((marks-75)/25)*1;
        else if (marks>=60)
            gradePoint=8.0+0.9*((marks-60)/14);
        else if(marks>=50)
            gradePoint=7.0+0.9*((marks-50)/9);
        else if(marks>=40)
            gradePoint=6.0+0.9*((marks-40)/9);
        else
            gradePoint=0;

        //to get single decimal point(improve this)
        String strTemp=Double.toString(gradePoint);
        StringBuilder sb=new StringBuilder();
        char[] chars=strTemp.toCharArray();
        for (int i = 0; i < strTemp.length(); i++) {
            sb.append(strTemp.charAt(i));
            if(strTemp.charAt(i)=='.'){
                sb.append(strTemp.charAt(i+1));
                break;
            }
        }
        String output = sb.toString();
        return output;
    }
}
