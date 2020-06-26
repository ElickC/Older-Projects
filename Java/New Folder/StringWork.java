// Elick Coval 30777547
import java.util.Scanner;
public class StringWork{
   public static void main(String[] args){
      Scanner console = new Scanner(System.in);
      System.out.println("Enter a line of text");
      String str = console.nextLine();
      str = str.toUpperCase();
      System.out.println(str);
      int len = str.length();
      char c = str.charAt(len-1);
      System.out.println(str);
      System.out.println("last character is: " + c);
   
   
   }
}