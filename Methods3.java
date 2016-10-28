/*
/*
Nate Elliott
Proffesor Kamp
10/28/16
Assignment Methods3

evenChar - takes a string and returns a string with the characters that are in 
the even positions in the passed in string.  The first character in the string is at position 0.
arrayFill - takes an int array, and an int bound, uses Random.nextInt(int bound)
to fill the array with random integers and returns the filled array.
squareOfAsterisks - takes a single int for the number of rows and colums. Prints out a square made of astrisks
that has an equal number of rows and columns.
*/
import java.util.Random;

public class Methods3{
   public static String evenChar(String word){
      String str = "";
      for(int i = 0; i < word.length(); i += 2){
         char x = (word.charAt(i));
         str  = str + String.valueOf(x);
      
      }
   return str;
   }
   
   public static int[] arrayFill(int arraysize, int bound){
      int[] array = new int[arraysize];
      Random rand = new Random();
      int randnum = 0;
      for( int i = 0; i <= arraysize; i++){ 
        randnum = rand.nextInt(bound);
        array[i] = randnum;
      }
      return array;
   }
   
  /* public static void(int num){
      
      
   
   }
   */
   public static void main(String[] args){
   System.out.println(evenChar("h0ist8h8e7rge"));
   System.out.println(arrayFill(5, 10));
   }
}