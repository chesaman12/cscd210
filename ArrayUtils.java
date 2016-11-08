public class ArrayUtils{
   public static void main(String[] args){
      int[] testArray = {20,21,22,23,24,25,26,27};
      int[] testArray2 = {54,14,15,75,12,90,3,42};
      //printArray(sortArray(testArray2));
      //cloneArray(testArray);
      //System.out.println(searchArray(testArray,3));
      //printArray(removeElement(testArray,3));
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
   
   
   }
   
   public static int[] addElement(int[] array, final int element){
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

   public static int[] removeElement(int[] array){
      int[] temp = new int[array.length - 1];
      for(int ix = 0; ix < temp.length; ix++){
         if(ix == temp.length){
            //remove last value (do nothing)
         }
         else{
            temp[ix] = array[ix];
         }
      }
      return temp;
   }
   
   //not finished
   public static int[] removeElement(int[] array, final int index){
      int[] temp = new int[array.length - 1];
      for(int ix = 0; ix < temp.length; ix++){
         if(index == ix){
            //remove index value 
         }
         else{
            temp[ix] = array[ix];
         }
      }
      return temp;
   }
   
   public static int searchArray(int[] array, final int element){
      int num = 0;
      for(int ix = 0; ix < array.length; ix++){
         if(ix == element){
            num = array[ix]; //this is the index to return, returned as an int
         }
      }
      return num;
   }
   
   //not finished
   public static int[] sortArray(int[] array){
      int[] temp = new int[array.length];
      for(int ix = 1; ix < array.length; ix++){
         if(array[ix] < array[ix - 1]){ //if index value is greater then the index to the left, execute
            temp[ix] = array[ix];          //swap index's
            array[ix] = temp[ix-1];
            array[ix] = temp[ix];          
         }
      }
      return array;
   }
   
   public static int[] cloneArray(int[] array){
      int[] clone = new int[array.length];
      for(int ix = 0; ix < array.length; ix++){
         clone[ix] = array[ix];
      }
      return clone;
   }
   
}