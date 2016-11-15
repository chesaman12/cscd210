import java.util.Scanner;
import java.io.File;
import java.util.InputMismatchException;

public class Statistics{
   public static void main(String[] args){
      int[] array = {1,2,3,4};
      userInterface(array);
   }
   
   public static int[] userInterface(int[] array){
      boolean done = false;
      do{
         Scanner scan = new Scanner(System.in);
         System.out.println("1.) Add Value to List");
         System.out.println("2.) Delete Value from List (by value)");
         System.out.println("3.) Delete Value from List (by location in list)");
         System.out.println("4.) Display List");
         System.out.println("5.) Compute Mean");
         System.out.println("6.) Compute Median");
         System.out.println("7.) Compute Midpoint");
         System.out.println("8.) Compute Mode(s)");
         System.out.println("9.) Compute Standard Deviation");
         System.out.println("10.) Save List of Numbers to File");
         System.out.println("11.) Read List of Numbers from File");
         System.out.println();
         System.out.println();
         System.out.println("0.) Exit");
         System.out.print("Enter an option: ");
         int input = -1;
         try {
            input = scan.nextInt();
         } 
         catch (InputMismatchException e){
         }
      
         switch (input){
            case 0: 
               System.out.println("Good Bye!");
               done = true;
               break;
            case 1: 
               System.out.print("Enter the element to add to the list: ");
               array = addValue(array, scan.nextInt());
               break; 
            case 2:
               System.out.print("Enter the integer to remove from the list: ");
               array = removeInt(array, scan.nextInt());
               break;
            case 3: 
               System.out.print("Enter the element to remove from the list: ");
               array = removeIndex(array, scan.nextInt());
               break;   
            case 4: 
               printArray(array);
               break;
            case 5:
               System.out.println("The mean is: " + mean(array));
               break;
            case 6:
               System.out.println("The median is: " + median(array));
               break;
            case 7:
               System.out.println("The midpoint is: " + midpoint(array));
               break;
            case 8:
               System.out.println("The mode(s) is: " + mode(array));
               break;
            case 9:
               System.out.println("The standard deviation is: " + standardDev(array));
               break;
            case 10:
               //System.out.println("File saved! ");
               //fileWrite(array);
               break;
            case 11:
               //array = fileRead(array);
               //System.out.println("File loaded! Array is now: " + printArray(array););
               
               break;
         
            
         
            default: 
               System.out.println("Enter a listed option please!");
            
         }
      }
         while(!done);
      return array;
   }
   
   public static int[] addValue(int[] array, final int element){
      int[] temp = new int[array.length + 1];
      for(int ix = 0; ix < temp.length; ix++){
         
         if(ix != array.length){
            temp[ix] = array[ix];
         }
         else{
            temp[ix] = element;
            
         }
      }
      return temp;   
   }
   public static void printArray(int[] array){
      for(int ix = 0; ix < array.length; ix++){
         if(ix == array.length - 1){
            System.out.print(array[ix]);
         }
         else{
            System.out.print(array[ix]+",");
         }
      }
   
      System.out.print("\n");
   
   }
   public static int[] removeIndex(int[] array, final int index){
      int[] temp = new int[array.length - 1];
      for(int ix = 0, y = 0; ix < array.length; ix++){
         /*if(index > ix){
            throw new IllegalArgumentException("Bad Parameter");
         }*/
         if(index != ix){
            temp[y++] = array[ix];
         } 
      }
      return temp;
   }
   
   public static int[] removeInt(int[] array, final int integer){
      int[] temp = new int[array.length - 1];
      for(int ix = 0, y = 0; ix < array.length; ix++){
        /* if(integer > ix){
            //throw new IllegalArgumentException("Bad Parameter");
         }*/
         if(integer != array[ix]){
            temp[y++] = array[ix];
         } 
      }
      return temp;
   }
   public static double mean(int[] array){
      double sum = 0;
      for(int i = 0; i < array.length; i++){
         sum += array[i];
      }
      return sum / array.length;
   }
   
   public static double median(int[] array) {
      sortArray(array);
      int med = array.length/2;
      if (array.length%2 == 1) {
         return array[med];
      } 
      else {
         return (array[med-1] + array[med]) / 2.0;
      }
   }  
   public static void sortArray(int[] array) {
        
      boolean swapped = false;
      do {
         swapped = false;
         for (int ix = 1; ix < array.length; ix++) {
            if (array[ix] < array[ix - 1]) { 
               int temp = array[ix];          
               array[ix] = array[ix - 1];
               array[ix - 1] = temp;
               swapped = true;
            }
                
         }
      
      } while (swapped);
        
   }
   
   public static int midpoint(int[] array){
      sortArray(array);
      int first = array[0];
      int last = array[array.length - 1];
      int sum = first + last;
      return sum /2;
   
   }    
   
   public static int mode(int[] array){
      int maxValue = 0;
      int maxCount = 0;
   
      for (int i = 0; i < array.length; ++i) {
         int count = 0;
         for (int j = 0; j < array.length; ++j) {
            if (array[j] == array[i]){
               count++;
            }
         }
         
        
         if (count > maxCount) {
            maxCount = count;
            maxValue = array[i];
         }
      }
   
      return maxValue;
   
   }
   
   public static double standardDev(int[] array){
      //double mean = mean(array);
      double mean = mean(array);
      double sum = 0;
      double[] temp = new double[array.length];
      for (int i = 0; i < array.length; i++) {
         temp[i] = array[i] - mean;
         temp[i] = temp[i]*2;
         sum += temp[i];
      }
      sum = sum / (array.length - 1);
      return Math.sqrt(sum);
   }  
   
   public static void fileWrite(int[] array){
 
      
   
   }
}