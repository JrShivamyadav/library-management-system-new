import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookServiceInterface {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLACK = "\u001B[30m";
    Scanner sc = new Scanner(System.in);
    Validator validator = new Validator();
    List<Book> books = new ArrayList<>();

    @Override
    public void addBook() {
        String bookid = validator.validateId();
        String Author = validator.validateAuthorTitle("Author");
        String Title = validator.validateAuthorTitle("Title");
        String year = validator.validatePublishYear();
        Book book = new Book(bookid, Author, Title, year, "Available");
        books.add(book);
        System.out.println(GREEN + " Book Added Successfully !!! " + RESET);
    }

    @Override
    public void showAllBooks() {
        boolean flag = false;
        System.out.println("\n -----------------------------------------------------------------------------");
        System.out.format(CYAN + "%s%15s%15s%15s%15s", "ID", "TITLE", "AUTHOR" , " PUBLISH_YEAR", "STATUS");
        System.out.println("\n -------------------------------------------------------------------------------------");

    for(Book book:books)

    {
        System.out.format(CYAN + "%s%15s%15s%15s%15s", book.getId(), book.getTitle(), book.getAuthor(), book.getPublishYear(), book.getStatus());
        System.out.println();
        flag = true;
    }
     System.out.println("\n---------------------------------------------------------------------------------------------");
    if(flag==false)
            System.out.println(RED+"THERE IS NO BOOK IN LIBRARY"+RESET);
}


    public void showAllAvailableBooks(){
        boolean flag = false;
    System.out.println("\n--------");
    System.out.format(CYAN + "%s%15s%15s%15s%15s","ID","TITLE","AUTHOR","PUBLISH_YEAR","STATUS" );
    System.out.println("\n-----------------------------------------------------------------------------");

    if (books.size()>0){
        for(Book book:books){
            if (book.getStatus()=="Available"){
                System.out.format(CYAN + "%s%15s%15s%15s%15s", book.getId(), book.getTitle(), book.getAuthor(), book.getPublishYear(), book.getStatus());
                System.out.println();
                flag = true;
            }
        }
    }
    else {
        System.out.println(RED+"NO books available in the library"+RESET);
    }
    System.out.println("\n------------------------------------------------------------------------------");
}
public void borrowBook(){
        String bookid = validator.validateId();
        boolean flag = false;
        for (Book book: books){
            if(book.getId().equals(bookid) && book.getStatus().equals("Available")){
            flag = true;
            System.out.println(GREEN +"Book Borrowed Successfully !!!"+RESET);
            book.setStatus("not Available");
            System.out.println("borrowed book Details:"+ book);
        }
    }
        if (flag= false)
            System.out.println(RED +" this book not available to borrow" +RESET);
}
public void returnBook(){
    boolean flag = false;
        String bookid = validator.validateId();

    for (Book book: books){
        if(book.getId().equals(bookid) && book.getStatus().equals(" not Available")){
            flag = true;
            System.out.println(GREEN +"Book returned Successfully !!!"+RESET);
            book.setStatus("Available");
            System.out.println("return book Details:"+book);
        }
    }
    if (flag= false)
        System.out.println(RED +" we can't return book" +RESET);
}


}

