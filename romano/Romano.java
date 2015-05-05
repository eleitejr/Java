package romano;

/**
 * Classe que permite transformar algarismos arábicos para romanos e vice-versa
 * @author Erasmo Leite
 *
 */
public class Romano {
	
	private String valRomano;
	private int valArabico;
	
	public Romano() {
		super();
		// Construtor default
	}

	public Romano(int valArabico) {
		super();
		this.valArabico = valArabico;
	}

	public Romano(String valRomano) {
		super();
		this.valRomano = valRomano;
	}

	public String getValRomano() {
		return valRomano;
	}

	public void setValRomano(String valRomano) {
		this.valRomano = valRomano;
	}

	public int getValArabico() {
		return valArabico;
	}

	public void setValArabico(int valArabico) {
		this.valArabico = valArabico;
	}

	
	/**
	 * 	Método para transformar de notação ROMANA para ARÁBICA
	 */
	public int romanToArabic(String r) throws	LimiteExcedidoException, 
												NumberFormatException, 
												FormatoNaoRomanoException 
	{
		valArabico = 0;
		int tamanho = r.length();
		
		if (isRoman(r)) {
				
			for (int k = 0; k < tamanho; k++){
				
				switch(r.charAt(k)){
					
					case 'M':
						valArabico += 1000;
						break;
						
					case 'C':
						valArabico += 100;
						
						if (k+1 < tamanho && r.charAt(k+1) == 'M') {
							valArabico += 800;
							++k;
							continue;
						}
						
						if (k+1 < tamanho && r.charAt(k+1) == 'D') {
							valArabico += 300;
							++k;
							continue;
						}
						break;
						
					case 'D':
						valArabico += 500;
						break;
						
					case 'L':
						valArabico += 50;
						break;
						
					case 'X':
						valArabico += 10;
						
						if (k+1 < tamanho && r.charAt(k+1) == 'C') {
							valArabico += 80;
							++k;
							continue;
						}
						if (k+1 < tamanho && r.charAt(k+1) == 'L') {
							valArabico += 30;
							++k;
							continue;
						}
						break;
						
					case 'V':
						valArabico += 5;
						break;
						
					case 'I':
						
						valArabico += 1;
						
						if (k+1 < tamanho && r.charAt(k+1) == 'V') {
							valArabico += 3;
							++k;
							continue;
						}
						
						if (k+1 < tamanho && r.charAt(k+1) == 'X') {
							valArabico += 8;
							++k;
							continue;
						}
						
						break;
				}
				
			}
			
		} else throw new FormatoNaoRomanoException();
			
		return valArabico;
	}
	
	private boolean isRoman(String r) {
		for (int j = 0; j < r.length(); ++j) {
			
				char t = r.charAt(j);
				
				if (	   t != 'M' 
						&& t != 'D' 
						&& t != 'C' 
						&& t != 'L' 
						&& t != 'X' 
						&& t != 'V' 
						&& t != 'I' ) return false;
				
		}	
		return true;
		
	}

	/**
	 * 	Método para transformar de notação ARÁBICA para ROMANA
	 */
	
	public String arabicToRoman(int a) throws NumberFormatException, LimiteExcedidoException{
		
		valRomano = "";
		if (a < 4000) valArabico = a; else throw new LimiteExcedidoException();
		
		do {
			
			while (valArabico >= 1000){
				
				valRomano += "M";
				valArabico -= 1000;
			}
			
			while (valArabico >= 900){
				
				valRomano += "CM";
				valArabico -= 900;
			}
			
			while (valArabico >= 500){
				valRomano += "D";
				valArabico -= 500;
			}
			
			while (valArabico >= 400){
				valRomano += "CD";
				valArabico -= 400;
			}
			
			while (valArabico >= 100 ){
				valRomano += "C";
				valArabico -= 100;
			}
			
			while (valArabico >= 90){
				
				valRomano += "XC";
				valArabico -= 90;
			}
			
			while (valArabico >= 50){
				valRomano += "L";
				valArabico -= 50;
			}
			
			while (valArabico >= 40){
				valRomano += "XL";
				valArabico -= 40;
			}
			
			while (valArabico >= 10){
				valRomano += "X";
				valArabico -= 10;
			}
			
			while (valArabico >= 9){
				
				valRomano += "IX";
				valArabico -= 9;
			}
			while (valArabico >= 5){
				valRomano += "V";
				valArabico -= 5;
			}
			
			while (valArabico >= 4){
				valRomano += "IV";
				valArabico -= 4;
			}
			
			while (valArabico >= 1){
				valRomano += "I";
				valArabico -= 1;
			}
			
			
		} while (valArabico > 0);
		
		return valRomano;
	}

}
