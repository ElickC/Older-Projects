// Elick Coval 30777547

public class HeightConverter{
   public static void main(String[] args){
   
      double conversionFactor = 2.54;
      String myName = "Elick Coval";
      int myAge = 30;
      int myHeightInches = 77;
      double myHeightCM = myHeightInches * conversionFactor;
      
      System.out.println(myName);
      System.out.println("age: " + myAge);
      System.out.println("height: " + myHeightInches + " inches");
      System.out.println("height: "  + myHeightCM + " cm");
   }
 }