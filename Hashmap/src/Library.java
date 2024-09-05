import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;

public class Library {
    String bookName;
    String author;
    Library(){}
    @Override
    public int hashCode(){
        int hash=3;
        hash=83*hash+ Objects.hashCode(this.bookName);
        hash=83*hash+ Objects.hashCode(this.author);
        return hash;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if (obj==null){
            return false;
        }
        if (getClass()!=obj.getClass()){
            return false;
        }
        final Library other=(Library) obj;
        if(!Objects.equals(this.bookName, other.bookName)){
            return false;
        }
        if(!Objects.equals(this.author, other.author)){
            return false;
        }
        return true;
    }
    Library(String bookName,String author){
        this.bookName=bookName;
        this.author=author;
    }
    public HashMap<Integer,Library> createLibraryMap(String booksInLibrary){
        HashMap<Integer,Library> map= new HashMap<>();
        String[] splitting = booksInLibrary.split("\\|");
        for (String string: splitting){
            String[] each=string.split(",");
            int n=Integer.parseInt(each[0]);
            String name=each[1];
            String author=each[2];
            Library tem= new Library(name,author);
            map.put(n,tem);
        }
        return map;
    }

    public HashMap<Integer,Integer> createUserMap(String borrowedUsers){
        HashMap<Integer,Integer> map = new HashMap<>();
        String[] splitting=borrowedUsers.split("\\|");
        for (String string: splitting ) {
            String[] each=string.split(",");
            int n=Integer.parseInt(each[0]);
            int n1=Integer.parseInt(each[1]);
            map.put(n,n1);
        }
        return map;
    }

    public String getQuery(String bookInLibrary, String borrowedUsers, String query){
        HashMap<Integer,Library> library=new HashMap<>();
        HashMap<Integer,Integer> borrow=new HashMap<>();
        library=createLibraryMap(bookInLibrary);
        borrow=createUserMap(borrowedUsers);
        String[] q=query.split(",");
        String out="";
        int qr=Integer.parseInt(q[0]);
        switch (qr){
            case 1:
                int bid=Integer.parseInt(q[1]);
                if(borrow.containsKey(bid))
                    out="No Stock\nIt is owned by "+borrow.get(bid)+"\n";
                else if (library.containsKey(bid))
                    out="It is available\nAuthor is "+library.get(bid).author+"\n";
                break;
            case 2:
                bid=Integer.parseInt(q[1]);
                for (int i : borrow.keySet()) {
                    if (borrow.get(i)==bid){
                        out=out+i+" "+library.get(i).bookName+"\n";
                    }
                }
                break;
            case 3:
                String bn=q[1];
                int nb=0,np=0;
                for (int i:library.keySet()   ) {
                    if (library.get(i).bookName.equals(bn)){
                        if (borrow.containsKey(i))
                            nb++;
                        else
                            np++;
                    }
                }
                out=nb+" out\n"+np+" in\n";
                break;
            case 4:
                bn=q[1];
                for (int i: library.keySet()   ) {
                    if (library.get(i).author.equals(bn))
                        out=out+library.get(i).bookName+"\n";
                }
                break;
            case 5:
                bn=q[1];
                for (int i: library.keySet()) {
                    if (library.get(i).bookName.toLowerCase().contains(bn.toLowerCase()))
                        out=out+i+" "+library.get(i).bookName+"\n";
                }
                break;
        }
        return out;

    }

}
