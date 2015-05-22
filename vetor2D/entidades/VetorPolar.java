package entidades;

public class VetorPolar extends Vetor{

	/**
	 * @author Erasmo Leite
	 */
	public VetorPolar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param modulo Modulo do fasor
	 * @param fase Fase do Vetor
	 */
	public VetorPolar(double modulo, double fase) {
		super();
		
		this.setModulo(modulo);
		this.setFase(fase);
		
		this.calculaParaOrto();
	}

		
}
