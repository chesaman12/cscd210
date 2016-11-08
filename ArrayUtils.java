public class ArrayUtils{
   public static void main(String[] args){
      int[] testArray = {20,21,22,23,24,25,26,27};
      int[] testArray2 = {54,14,15,75,12,90,3,42};
      int[] test = {3,1,4,2};
      printArray(sortArray(test));
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
   
      System.out.print("\n");
   
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
//       int[] temp = new int[array.length - 1];
//       for(int ix = 0; ix < temp.length; ix++){
//          if(ix == temp.length){
//             //remove last value (do nothing)
//          }
//          else{
//             temp[ix] = array[ix];
//          }
//       }
//       return temp;
      return removeElement(array, array.length - 1);
   }
   
   //not finished
   public static int[] removeElement(int[] array, final int index){
      int[] temp = new int[array.length - 1];
      for(int ix = 0, y = 0; ix < array.length; ix++){
         if(index != ix){
           temp[y++] = array[ix];
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
    public static int[] sortArray(int[] array) {
        //int[] temp = new int[array.length];
        boolean swapped = false;
        do {
            swapped = false;
            for (int ix = 1; ix < array.length; ix++) {
                if (array[ix] < array[ix - 1]) { //if index value is greater then the index to the left, execute
                    int temp = array[ix];          //swap index's
                    array[ix] = array[ix - 1];
                    array[ix - 1] = temp;
                    swapped = true;
                }
                //printArray(array);
            }

        } while (swapped);
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