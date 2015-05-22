package entidades;

public class VetorOrto extends Vetor{

	/**
	 * 
	 */
	public VetorOrto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param real parte real
	 * @param imag parte imaginaria
	 */
	public VetorOrto(double real, double imag) {
		
		super();
		
		this.setReal(real);
		this.setImag(imag);
		
		this.calculaParaPolar();
		
	}
	
	

}
