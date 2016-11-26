import java.util.Comparator;
public class PerimeterSort implements Comparator <RegularPolygon>{
   public int compare(RegularPolygon rp1, RegularPolygon rp2){
      double x = rp1.getPerimeter();
      double y = rp2.getPerimeter();
      if(x > y){
         return 1;
      }
      else if( x < y){
         return -1;
      }
      return 0;
   }
}
      