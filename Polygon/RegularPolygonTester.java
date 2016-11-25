import java.util.Arrays;

public class RegularPolygonTester {

	public static void main(String[] args) {
		//Infinitesimal Calculus PI derivation
		System.out.println("Approximate PI using RegularPolygon class.");
		for (int ctr=1000000; ctr < 10000001; ctr += 1000000) {
			RegularPolygon rp = new RegularPolygon(ctr);
			System.out.println(ctr + " sides - PI: " + rp.getPerimeter() / (rp.getApothem() * 2));
		}
		System.out.println();
		
		System.out.println("Testing Sorts:");
		RegularPolygon polys [] = {new RegularPolygon(6,.5),
									new RegularPolygon(8),
									new RegularPolygon(.2),
									new RegularPolygon(6,.4),
									new RegularPolygon(),
									new RegularPolygon(7),
									new RegularPolygon(5,.6),
									new RegularPolygon(6),
									new RegularPolygon(7),
									new RegularPolygon(4),
									new RegularPolygon(14,.05)};
		printPolys(polys);
		
		
		Arrays.sort(polys);
		printPolys(polys);
	
      //example to make sure 1 case works
      //System.out.println(polys[0].compareTo(polys[1]);
      //example to make sure -1 case works (need 0 case too)
      //System.out.println(polys[1].compareTo(polys[2]);
   	
		Arrays.sort(polys, new PerimeterSort());
		printPolys(polys);
		
		Arrays.sort(polys, new AreaSort());
		printPolys(polys);
	
	}
	
	public static void printPolys(final RegularPolygon[] polys) {
		for (int ix = 0; ix < polys.length; ix++){
			System.out.println(polys[ix]);
		}
		System.out.println();
	}
}

