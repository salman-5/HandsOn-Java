import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Hashset {

    public static String getOut(int numberOfMatches, String squads, int squad1, int squad2){
        HashSet<String> matchSquad= new HashSet<>();
        HashSet<String> allStarters= new HashSet<>();
        List<HashSet> perDay = new ArrayList<>();
        String[] squadEveryday= squads.split("#");
        StringBuilder sb = new StringBuilder();

        for (String squad:squadEveryday ) {
            String[] names=squad.split(" ");
            for (String name: names     ) {
                matchSquad.add(name);
            }
            perDay.add(matchSquad);
            matchSquad=new HashSet<>();
        }
        //part 1 of question
        allStarters=(HashSet<String>) perDay.get(0).clone();
        for (String temp: (HashSet<String>) perDay.get(0)     ) {
            for (int j = 1; j < numberOfMatches; j++) {
                if(!perDay.get(j).contains(temp))
                    allStarters.remove(temp);
            }
        }
        //part 2 of question
        perDay.get(squad2-1).removeAll(perDay.get(squad1));
        // creating string
        for (String t : allStarters          ) {
            sb.append(t);
            sb.append(" ");
        }
        sb.append(", ");
        for (String s: (HashSet<String>) perDay.get(squad2-1)   ) {
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString();

    }
}
