/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Instructor
 */

  // Examp2: BasePlusCommissionEmployee.java it is a subclass of CommissionEmployee
public class BasePlusCommissionEmployee extends CommissionEmployee //3. error 
{  
   private double baseSalary; // base salary per week, instance variable 
   // six-argument constructor
   public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary ){

   super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);  //4. error
   //call super class’s constructor                   
      this.baseSalary = baseSalary;
   }
      // set base salary
   public void setBaseSalary(double baseSalary){
      this.baseSalary = baseSalary;   } 
   // return base salary
   public double getBaseSalary(){
      return baseSalary;  } 
   // calculate earnings
   @Override 
   public double earnings() {
      return getBaseSalary() + super.earnings();   }
   // return String representation of BasePlusCommissionEmployee
   @Override
   public String toString()   {
      return String.format("%s %s%n%s: %.2f", "base-salaried",
       super.toString(), "base salary", getBaseSalary());   //5. error, it needs to call super class's toString method
   } 
} // end class BasePlusCommissionEmployee
  
