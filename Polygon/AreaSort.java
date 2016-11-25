public class AreaSort{
     public int compare(RegularPolygon rp1, RegularPolygon rp2){
      if(rp1.getArea() > rp2.getArea()){
         return 1;
      }else if(rp1.getArea() < rp2.getArea()){
         return -1;
      }
      return 0;
      }

}