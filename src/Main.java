import java.awt.print.Book;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookServiceInterface service =new BookServiceImpl();

        do{
            System.out.println("Welcome ");
            System.out.println("1.add Book\n"+
                    "2.show All Books\n"+ "3.Show Available Books\n "+
                    "4.Borrow Book \n"+ "5.Return Book\n"+ "6.Exit\n");

            System.out.println("Enter your Choice ! ");
            int ch = sc.nextInt();

            switch (ch){
                case 1:
                    service.addBook();
                    break;
                case 2:
                    service.showAllBooks();
                    break;
                case 3:
                    service.showAllAvailableBooks();
                    break;
                case 4:
                    service.borrowBook();
                    break;
                case 5:
                    service.returnBook();
                    break;
                case 6:
                    break;
            }
        }
        while (true);
    }
}