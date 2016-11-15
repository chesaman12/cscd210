import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.InputMismatchException;

public class Statistics{
   public static void main(String[] args)throws Exception{
      int[] list = {1,2,3,4};
      userInterface(list);
   }
   
   public static int[] userInterface(int[] list)throws Exception{
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
               list = addValue(list, scan.nextInt());
               break; 
            case 2:
               System.out.print("Enter the integer to remove from the list: ");
               list = removeInt(list, scan.nextInt());
               break;
            case 3: 
               System.out.print("Enter the element to remove from the list: ");
               list = removeIndex(list, scan.nextInt());
               break;   
            case 4: 
               printArray(list);
               break;
            case 5:
               System.out.println("The mean is: " + mean(list));
               break;
            case 6:
               System.out.println("The median is: " + median(list));
               break;
            case 7:
               System.out.println("The midpoint is: " + midpoint(list));
               break;
            case 8:
               System.out.println("The mode(s) is: " + mode(list));
               break;
            case 9:
               System.out.println("The standard deviation is: " + standardDev(list));
               break;
            case 10:
               System.out.println("File saved! ");
               fileWrite(list);
               break;
            case 11:
               File Filename = new File("arrays.txt");
               list = fileRead(Filename);
               System.out.println("File loaded!");;
               
               break;
         
            
         
            default: 
               System.out.println("Enter a listed option please!");
            
         }
      }
         while(!done);
      return list;
   }
   
   public static int[] addValue(int[] list, final int element){
      int[] temp = new int[list.length + 1];
      for(int ix = 0; ix < temp.length; ix++){
         
         if(ix != list.length){
            temp[ix] = list[ix];
         }
         else{
            temp[ix] = element;
            
         }
      }
      return temp;   
   }
   public static void printArray(int[] list){
      for(int ix = 0; ix < list.length; ix++){
         if(ix == list.length - 1){
            System.out.print(list[ix]);
         }
         else{
            System.out.print(list[ix]+",");
         }
      }
   
      System.out.print("\n");
   
   }
   public static int[] removeIndex(int[] list, final int index){
      int[] temp = new int[list.length - 1];
      for(int ix = 0, y = 0; ix < list.length; ix++){
         /*if(index > ix){
            throw new IllegalArgumentException("Bad Parameter");
         }*/
         if(index != ix){
            temp[y++] = list[ix];
         } 
      }
      return temp;
   }
   
   public static int[] removeInt(int[] list, final int integer){
      int[] temp = new int[list.length - 1];
      for(int ix = 0, y = 0; ix < list.length; ix++){
        /* if(integer > ix){
            //throw new IllegalArgumentException("Bad Parameter");
         }*/
         if(integer != list[ix]){
            temp[y++] = list[ix];
         } 
      }
      return temp;
   }
   public static double mean(int[] list){
      double sum = 0;
      for(int i = 0; i < list.length; i++){
         sum += list[i];
      }
      return sum / list.length;
   }
   
   public static double median(int[] list) {
      sortArray(list);
      int med = list.length/2;
      if (list.length%2 == 1) {
         return list[med];
      } 
      else {
         return (list[med-1] + list[med]) / 2.0;
      }
   }  
   public static void sortArray(int[] list) {
        
      boolean swapped = false;
      do {
         swapped = false;
         for (int ix = 1; ix < list.length; ix++) {
            if (list[ix] < list[ix - 1]) { 
               int temp = list[ix];          
               list[ix] = list[ix - 1];
               list[ix - 1] = temp;
               swapped = true;
            }
                
         }
      
      } while (swapped);
        
   }
   
   public static int midpoint(int[] list){
      sortArray(list);
      int first = list[0];
      int last = list[list.length - 1];
      int sum = first + last;
      return sum /2;
   
   }    
   
   public static int mode(int[] list){
   
   //1.  create a temp array, size of N, where N is your largest value
   //2a. loop through array, each value in the array refers to indice in temp array
   //2b. increment indice value
   //3.  walk through temp array, returning largest values
   //3a. loop through the temp array once, finding the greatest count
   //3b. loop through the temp array again, returning items with greatest count
   
      int maxValue = 0;
      int maxCount = 0;
   
      for (int i = 0; i < list.length; ++i) {
         int count = 0;
         for (int j = 0; j < list.length; ++j) {
            if (list[j] == list[i]){
               count++;
            }
         }
         
        
         
         if (count > maxCount) {
            maxCount = count;
            maxValue = list[i];
         }
      }
   
      return maxValue;
   
   }
   
   public static double standardDev(int[] list){
      double mean = mean(list);
      double sum = 0;
      double[] temp = new double[list.length];
      for (int i = 0; i < list.length; i++) {
         temp[i] = list[i] - mean;
         temp[i] = temp[i] * temp[i];
         sum += temp[i];
      }
      sum = sum / (list.length - 1);
      return Math.sqrt(sum);
   }  
   public static void fileWrite(int[] list) throws Exception {
      PrintStream file0 = new PrintStream("arrays.txt");
      for (int ix = 0; ix < list.length; ix++){
         file0.println(list[ix]);
      
   }
}
  /* 
   public static void fileWrite(int[] list){
      System.out.println(Arrays.toString(System.getProperty("line.separator").getBytes()));
      //System.exit(0);
      String listString = list.length + "\n";
      for(int val : list){
         //arrayString += val + System.getProperty("line.separator");
         listString += val + "\n";
      }
     */ 
   
   
   public static int[] fileRead(File Filename) throws Exception{
   int count = 0;
   Scanner file1Count = new Scanner(Filename);
   Scanner file1 = new Scanner(Filename);
   
   while (file1Count.hasNext()){
      int num = file1Count.nextInt();
      count++;
   }
   int[] list = new int [count];
   for (int ix = 0; ix < count; ix++){
      list[ix] = file1.nextInt();
   
   }
   file1.close();
   return list;
   }
}