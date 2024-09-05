public class Aided extends Student{

    @Override
    public String result(String markString){
        String[] marks=markString.split("\\|");
        String[] subjects=marks[0].split(",");
        double sumProduct_markCredit=0;
        double totalCredit=0;
        float credit;
        float mark;
        String gradePoint;
        //try streams
        for (String subject:subjects    ) {
            String[] markCredit=subject.split(" ");
            mark=Float.parseFloat(markCredit[0]);
            credit=Float.parseFloat(markCredit[1]);
            gradePoint=grade(mark);
            totalCredit=totalCredit+5;
            sumProduct_markCredit=sumProduct_markCredit+Double.parseDouble(gradePoint)*credit;

        }
        for (int i = 1; i < 3; i++) {
            String[] items=marks[i].split(",");
            if(Integer.parseInt(items[0])==1){
                totalCredit=totalCredit+5;
                mark=Float.parseFloat(items[1]);
                credit=Float.parseFloat(items[2]);
                gradePoint=grade(mark);
                sumProduct_markCredit=sumProduct_markCredit+Double.parseDouble(gradePoint)*credit;

            }

        }
        return String.format("%.2f",sumProduct_markCredit/totalCredit);
    }

}
