public class Main {
    public static void main(String[] args){
        Library lib;
        lib=new Library();

        String actual=lib.getQuery("1001,Adventure of Sherlock Holmes,Sir Arthur Conan Doyle|1002,Adventure of Tom Slayer,The Mark Twain|1003,Alice in the Wonderland,Lewis Carroll|1004,All's Well that Ends well,William Shakespeare|1005,As you like it,William Shakespeare|1006,Anand Math,Bankin Chandra Chatterjee", "1006,101|1003,102|1001,101","2,101");
        String exp="1001 Adventures of Sherlock Holmes\n1006 Anand Math";
        System.out.println(actual);

    }
}