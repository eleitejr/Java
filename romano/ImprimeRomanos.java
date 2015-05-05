package romano;

import romano.Romano;

public class ImprimeRomanos {

	public static void main(String[] args) throws Exception {
		
		Romano romano = new Romano();
		
		for (int k = 1; k < 4000; ++k) System.out.println( k + " em romano é: " + romano.arabicToRoman(k) );
		
	}

}
