// Elick Coval 30777547

public class BankingDriver{
 
   public static void main(String[] args){
   int transCheck;
   int transSave;
   
   BankAccount nicksAcct = new BankAccount("Nick",450,550);
   BankAccount carolsAcct = new BankAccount("Carol",600,700);
   nicksAcct.printReport();
   carolsAcct.printReport();
   System.out.println("Total money in all accounts: $"+(nicksAcct.getCheckMoney()+nicksAcct.getSaveMoney()
                      +carolsAcct.getCheckMoney()+carolsAcct.getSaveMoney()));
   
   nicksAcct.makeCheckingDeposit(100);
   nicksAcct.printReport();
   
   transCheck = nicksAcct.getCheckMoney();
   transSave = nicksAcct.getSaveMoney();
   nicksAcct.makeCheckingWithdrawal(transCheck);
   nicksAcct.makeSavingsWithdrawal(transSave);
   carolsAcct.makeCheckingDeposit(transCheck+transSave);
   

   nicksAcct.printReport();
   carolsAcct.printReport();
   
   
   }
}