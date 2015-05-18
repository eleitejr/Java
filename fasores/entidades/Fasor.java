package entidades;

public class Fasor {
	
	private double modulo;		// amplitude do fasor;
	private double fase;		// fase em graus;
		
	public Fasor soma(Fasor a, Fasor b) {
		
		double x_a = a.getModulo() * Math.cos(Math.toRadians(a.getFase()));
		double y_a = a.getModulo() * Math.sin(Math.toRadians(a.getFase()));
		
		double x_b = b.getModulo() * Math.cos(Math.toRadians(b.getFase()));
		double y_b = b.getModulo() * Math.sin(Math.toRadians(b.getFase()));
		
		double x = x_a + x_b;
		double y = y_a + y_b;
		
		Fasor fasorSoma = new Fasor(Math.hypot(x, y), Math.toDegrees(Math.atan((y/x))));
		
		return fasorSoma;
	}
	
	/**
	 * @param modulo
	 * @param fase
	 */
	public Fasor(double modulo, double fase) {
		super();
		
		if (modulo < 0){
			modulo *= -1;
			fase += 180;
		}
		
		fase = (fase + 360) % 360;
		this.modulo = modulo;
		if (modulo != 0.0) this.fase = fase;
			else this.fase = 0;
	}
	
	public Fasor(){
		super();
		//this.modulo = 0;
		//this.fase = 0;
	}
	
	public double getModulo() {
		return modulo;
	}
	public void setModulo(double modulo) {
		this.modulo = modulo;
	}
	public double getFase() {
		return fase;
	}
	public void setFase(double fase) {
		this.fase = fase;
	}
	
}
