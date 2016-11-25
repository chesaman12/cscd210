import java.util.Comparator;
public class PerimeterSort implements Comparator<RegularPolygon>{
   public int compare(RegularPolygon rp1, RegularPolygon rp2){
      Double perim1 = rp1.getPerimeter();
      Double perim2 = rp2.getPerimeter();
      
      return perim1.compareTo(perim2);
      }
}