import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static Pattern ID_PATTERN = Pattern.compile("^\\d{1,4}$");
    public static Pattern AuthorTitle_PATTERN = Pattern.compile("^[a-zA-Z]+$");
    public static Pattern PublishYear_PATTERN = Pattern.compile("^\\d{4}$");
    Scanner sc = new Scanner(System.in);

    public String validateId() {
        String bookid;
        while (true) {
            System.out.println("enter book id");
            bookid = sc.nextLine();
            if (!ID_PATTERN.matcher(bookid).matches()) {
                System.out.println(RED + " SORRY PLEASE ENTER VALID ID" + RESET);

            } else {
                break;
            }
        }
        return bookid;

    }

    public String validateAuthorTitle(String input) {
        String result;
        while (true) {
            if (input == "Title") {
                System.out.println("Enter Title");
            } else {
                System.out.println("Enter Author");
            }
            result = sc.nextLine();
            if (!AuthorTitle_PATTERN.matcher(result).matches()) {
                System.out.println(RED + "PLEASE ENTER VALID" + input + RESET);
            } else {
                break;
            }
        }
        return result;
    }

    public String validatePublishYear() {
        String year;
        while (true) {
            System.out.println("enter publish year of book");
            year = sc.nextLine();
            if (!PublishYear_PATTERN.matcher(year).matches()) {
                System.out.println(RED + " enter valid publish year" + RESET);
            } else {
                break;
            }
        }
        return year;
    }
}