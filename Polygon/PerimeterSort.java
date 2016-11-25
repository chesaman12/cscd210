public class PerimeterSort{
   public int compare(RegularPolygon rp1, RegularPolygon rp2){
      if(rp1.getPerimeter() > rp2.getPerimeter()){
         return 1;
      }else if(rp1.getPerimeter() < rp2.getPerimeter()){
         return -1;
      }
      return 0;
      }
}