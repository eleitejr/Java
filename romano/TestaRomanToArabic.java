package romano;

import java.util.Scanner;

import romano.Romano;

public class TestaRomanToArabic {
	

	public static void main(String[] args) throws FormatoNaoRomanoException, LimiteExcedidoException, NumberFormatException {
		
		int numArabico;
		String numRomano;
		Romano romano = new Romano();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite um numero romano menor que 4000: ");
		numRomano = sc.next();
		numArabico = romano.romanToArabic(numRomano);
		
		System.out.println("O número romano " + numRomano + " é igual a: " + numArabico);
		sc.close();

	}

}
