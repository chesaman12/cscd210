import java.util.Comparator;
public class RegularPolygon{

   private int sides;
   private double sideLength;
   private int pSides;
   private double pSideLength;
   
   
   public RegularPolygon(){
      sides = 3;
      sideLength = 1.0;
   }
   public RegularPolygon(int pSides){
      sides = pSides;
      sideLength = 1.0;
   }
   public RegularPolygon(double pSideLenth){
      sideLength = pSideLength;
      sides = 3;
   }
   public RegularPolygon(int pSides, double pSideLenth){
      sideLength = pSideLength;
      sides = pSides;
   }
   
   public int getSides(){
      return sides;
   }
   
   public double getSideLength(){
      return sideLength;
   }
   
   public void setSides(int psides){
      if(pSides >= 3){
         sides = pSides;
      }else{
         throw new IllegalArgumentException("Bad Parameter");
      }
   }
   
   public void setSideLength(double pSideLength){
      if(pSideLength > 0){
         sideLength = pSideLength;
      }else{
         throw new IllegalArgumentException("Bad Parameter");
      }
   
   }
   
   public double getPerimeter(){
      double perimeter = sides * sideLength;
      return perimeter;
   }
   
   public double getArea(){
   //Apothem X Perimeter / 2
      double area = getApothem() * getPerimeter() / 2;
      return area;
   }
   
   public double getApothem(){
   //Length of Single Side / (2.0 * tangent(180 / Number of Sides)
      double apothem = sideLength / (2 * Math.tan(Math.PI / sides));
      return apothem;
   }
   
   public int compareTo (RegularPolygon that){
      if (this.sides > that.sides){ 
         return 1;
      }else if (this.sides < that.sides){
         return -1;
      }else{
         if(this.sideLength > that.sideLength){
            return 1;
         }else if(this.sideLength > that.sideLength)
            return -1;
         }
      return 0;
      
   }
   
   public String toString(){
   //Sides: 5 Side Length: 0.6 Perimeter: 3.0 Area: 0.6193718642120281
      return "Sides: "+sides+" Side Length: "+sideLength+" Perimeter: "+getPerimeter()+" Area: "+getArea();
   
   }
}