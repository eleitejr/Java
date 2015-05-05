package romano;

	import java.util.Scanner;

import romano.Romano;

	public class TestaArabicToRoman {
		
		public static void main(String[] args) throws RuntimeException {
			
			int numArabico = 0;
			String numRomano = "";
			Romano romano = new Romano();

			Scanner sc = new Scanner(System.in);
			
			System.out.println("Digite um numero arábico menor que 4000: ");
			numArabico = sc.nextInt();
			try {
				numRomano = romano.arabicToRoman(numArabico);
			} catch (LimiteExcedidoException e) {
				// TODO Auto-generated catch block
			}
			
			System.out.println("O número arábico " + numArabico + " é igual a: " + numRomano);
			sc.close();

		}

	}
