// Elick Coval 30777547
import java.util.*;
public class DoubleLetters{
 
   public static void main(String[] args){
      int offset = 0;
  
      System.out.println("Enter a line of text");
      Scanner scan = new Scanner(System.in);
      String input = scan.nextLine();
      StringBuilder output = new StringBuilder(input);
       
      for(int i = 0; i < input.length(); i++){
         char c = input.charAt(i);
         
         if(Character.isLetter(c))
            output.insert((i+offset),c);
     
         else if (c == '!'){
            output.insert((i+offset),c);
            output.insert((i+offset),c);
            offset++;
         }
         else
            offset--;
         offset++;
      }
    
      System.out.print(output);
   }
}