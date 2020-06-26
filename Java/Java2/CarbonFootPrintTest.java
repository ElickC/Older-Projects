// File name: CarbonFootprintTest.java

// Written by: Elick Coval
 
// Description: This program outputs the carbon footprint of different
//              objects in pounds of CO2. Stores three different objects
//              into an ArrayList. Through polymorphism and the implementation
//              of an interface, each object outputs it's own footprint data.
//              
// Challenges: Rembering how to use ArrayList's.
//
// Time Spent: About 1.5 hours.

// Revision History:
// Date:         		By:      Action:
// ---------------------------------------------------
/* DD/MM/YYY   (name)                       
 * 9/16/2016    (EC)    Created CarbonFootprintTest class to test the interface.
 *                      
*/      


import java.util.*;

public class CarbonFootPrintTest {
    
    public static void main(String[] args){
        
        //Create objects to be used later
        Bicycle bicycle = new Bicycle();
        Building building = new Building(15000);
        Car car = new Car(14.0);
        
        //Arraylist initialized and objects added
        ArrayList<CarbonFootprint> carbonList = new ArrayList();
        carbonList.add(bicycle);
        carbonList.add(building);
        carbonList.add(car);
        
        //Print statements to set up data
        System.out.println("Carbon Footprint (lbs of CO2 per year)");
        System.out.println("----------------------");
        
        //For loop iterating through objects in arraylist
        for (CarbonFootprint currentPrint : carbonList){
            currentPrint.GetCarbonFootprint();
            
        }
    }
    
}
