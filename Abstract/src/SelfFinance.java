public class SelfFinance extends Student {
    @Override
    public String result(String markString){
        String[] marks=markString.split("\\|");
        String[] subjects=marks[0].split(",");
        double sumProduct_markCredit=0;
        double totalCredit=0;
        float credit;
        float mark;
        String gradePoint;

        for (String subject : subjects) {
            String[] mnc=subject.split(" ");
            mark=Float.parseFloat(mnc[0]);
            credit=Float.parseFloat(mnc[1]);
            gradePoint=grade(mark);
            totalCredit=totalCredit+5;
            sumProduct_markCredit=sumProduct_markCredit+Double.parseDouble(gradePoint)*credit;
        }
        String[] items=marks[1].split(",");
        if(Integer.parseInt(items[0])==1){
            totalCredit=totalCredit+5;
            mark=Float.parseFloat(items[1]);
            credit=Float.parseFloat(items[2]);
            gradePoint=grade(mark);
            sumProduct_markCredit=sumProduct_markCredit+Double.parseDouble(gradePoint)*credit;

        }
       return String.format("%.2f",sumProduct_markCredit/totalCredit);
    }
}
