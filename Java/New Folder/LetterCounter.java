import java.util.Scanner;   
public class LetterCounter{       
   public static void main(String[] args){      
   
   
   
   String str = "halleloua";
   
   
      for(int j = 0; j <str.length();j++){
         char c = str.charAt(j);
         if(Character.isLetter(c))
            letter[c-'a']++;     // count of letters
      }
   
   
   
      for(int j=0; j< letter.length; j++){
         System.out.print((char)('a'+j));
         System.out.println(" " + letter[j]);
      
      }
   }
}