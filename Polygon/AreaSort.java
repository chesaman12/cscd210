import java.util.Comparator;
public class AreaSort implements Comparator <RegularPolygon>{
   public int compare(RegularPolygon rp1, RegularPolygon rp2){
      double x = rp1.getArea();
      double y = rp2.getArea();
      if(x > y){
         return 1;
      }
      else if( x < y){
         return -1;
      }
   return 0;
   }
}