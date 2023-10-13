public class Main {
    public static void main(String[] args){
        Author author = new Author("Andrzej", "andrzej@gardenforce.pl", Gender.MALE);
        Book book = new Book("Andrzej 3", author, 100.99, 10000);
        Book book2 = new Book("Andrzej 2", author, 11.50, 1);
        
        System.out.println(book.toString());
        System.out.println(book.getAuthor().toString());
        System.out.println(book2.toString());
    }
}
