import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Treemap{
    public TreeMap<Integer,String > createPlayerPositionMap(String cricketDataset){
        TreeMap<Integer,String> tree=new TreeMap<>();
        String[] splitter= cricketDataset.split("\\|");
        for (String sps:splitter  ) {
            String[] sp=sps.split(",");
            tree.put(Integer.parseInt(sp[0]),sp[1]);
        }
        return tree;
    }

    public TreeMap<String,Integer > createPlayerScoreMap(String cricketDataset){
        TreeMap<String,Integer> tree=new TreeMap<>();
        String[] splitter= cricketDataset.split("\\|");
        for (String sps:splitter  ) {
            System.out.println(sps);
            String[] sp=sps.split(",");
            tree.put((sp[1]),Integer.parseInt(sp[2]));
        }
        return tree;
    }

    public TreeMap<?,?> createMatchesMap(String cricketDataset){
        String[] a=cricketDataset.split("\\|");
        String[] s,u;
        int value=0;
        TreeMap<?,?> last = new TreeMap<>();
        TreeMap<String,Integer> net= new TreeMap<>();
        int i=0;
        while (i<a.length){
            int temp=1;
            s=a[i].toString().split(Pattern.quote("|"));
            for (int j = 0; j < s.length; j++) {
                u = s[j].toString().split(",");
                if (u[0].equals("1")) {
                    if (net.get(u[1]) != null) {
                        temp++;
                        value = (Integer.parseInt(net.get(u[1]).toString()) + Integer.parseInt(u[2])) / temp;
                        net.replace(u[1], value);
                    } else {
                        net.put(u[1], Integer.parseInt(u[2]));
                    }
                }
            }
            i++;
        }
        last=net;

        return last;
    }

    public String getQuery(String cricketDataset,String query){
        String[] q=query.split(" ");
        int n=Integer.parseInt(q[0]);
        String out="";
        if(n==1){
            TreeMap<Integer,String> tree = new TreeMap<>();
            int start=Integer.parseInt(q[1]);
            int end=Integer.parseInt(q[2]);
            tree=createPlayerPositionMap(cricketDataset);
            for (Map.Entry<Integer,String > entry: tree.subMap(start,end+1).entrySet())
                out=out+entry.getKey()+" "+entry.getValue()+"\n";
        }
        if (n==2){
            TreeMap<Integer,String> tree1 = new TreeMap<>();
            TreeMap<String ,Integer> tree= new TreeMap<>();
            int start=Integer.parseInt(q[1]);
            HashSet<String> num = new HashSet<>();
            tree1= createPlayerPositionMap(cricketDataset);
            tree=createPlayerScoreMap(cricketDataset);

            for(Map.Entry<String ,Integer> entry: tree.entrySet()){
                if(entry.getValue()>start){
                    num.add(entry.getKey());
                }
            }

            for(Map.Entry<Integer ,String> en: tree1.entrySet()){
                for( String n3: num   ) {
                    if(en.getValue().equals(n3))
                        out=out+en.getKey()+" "+en.getValue()+"\n";
                }
            }

        }
        if(n==3){
            String ads="";
            TreeMap<?,?> nes= new TreeMap<>();
            nes= createMatchesMap(cricketDataset);
            int comp=0;
            for (Map.Entry<?,?> integer : nes.entrySet() ) {
                if (Integer.parseInt(integer.getValue().toString())>=comp){
                    comp=Integer.parseInt(integer.getValue().toString());
                    ads=integer.getKey().toString();
                }
            }
            out="The Efficient Opener is "+ads;

        }
        return out;
    }
}
