import java.util.Comparator;
public class AreaSort implements Comparator<RegularPolygon>{
     public int compare(RegularPolygon rp1, RegularPolygon rp2){
      Double area1 = rp1.getArea();
      Double area2 = rp2.getArea();
      
      return area1.compareTo(area2);

}