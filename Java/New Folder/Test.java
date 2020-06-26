
public class Test {
public static void method3 () throws RuntimeException { 

throw new RuntimeException ("RuntimeException occurred in method3" );
 } //end method3
 //method2
 public static void method2 () throws RuntimeException {
 try{
 method3 ();
 } //try block
 catch (RuntimeException exception) {
 System.out.printf ("The following exception occurred in method2\n%s\n",
 exception.getMessage ());
 throw exception;
 } //end catch block
 } // end method2

 //method1
 public static void method1 () throws RuntimeException {
 try {
 method2 ();
 }
 catch (RuntimeException exception)
 {
 System.out.printf ("The following exception occurred in method1\n%s\n",
 exception.toString ());
 throw exception;
 }
 } // end method1
 public static void main (String args[]) {
 try {
 method1 ();
 }
 catch (RuntimeException exception ) {
 System.out.println ("The following exception occurred in main");
 System.out.println (exception);
 } //end catch
 }// end main
 } // end class test