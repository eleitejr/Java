package entidades;

import static java.lang.Math.atan;
import static java.lang.Math.cos;
import static java.lang.Math.hypot;
import static java.lang.Math.sin;
import static java.lang.Math.toDegrees;
import static java.lang.Math.toRadians;

import java.text.DecimalFormat;

public abstract class Vetor {

	private double modulo;		// amplitude do vetor
	private double fase;		// fase em graus
	private double real;		// parte real
	private double imag;		// parte imaginaria


	/**
	 * SOMA DE VETORES
	 * @param a Vetor A
	 * @param b Vetor B
	 * @return	Vetor Soma A + B
	 */
	public Vetor soma(Vetor a, Vetor b) {

		double x,y;

		if (a instanceof VetorPolar && b instanceof VetorPolar) {

			a.calculaParaOrto();
			b.calculaParaOrto();

		}


		if (a instanceof VetorOrto && b instanceof VetorOrto) {

			// default

		}


		x = a.real + b.real;
		y = a.imag + b.imag;

		Vetor vetorSoma = new VetorOrto(x, y);


		return vetorSoma;

	}

	/**
	 * SUBTRACAO DE VETORES
	 * @param a Vetor A
	 * @param b Vetor B
	 * @return	Vetor Diferenca A - B
	 */
	public Vetor sub(Vetor a, Vetor b) {

		double x,y;

		if (a instanceof VetorPolar && b instanceof VetorPolar) {

			a.calculaParaOrto();
			b.calculaParaOrto();

		}


		if (a instanceof VetorOrto && b instanceof VetorOrto) {

			// default

		}


		x = a.real - b.real;
		y = a.imag - b.imag;

		Vetor vetorSub = new VetorOrto(x, y);

		return vetorSub;

	}

	/**
	 * MULTIPLICACAO DE VETORES
	 * @param a vetor A
	 * @param b vetor B
	 * @return vetor A x B
	 */

	public Vetor mult(Vetor a, Vetor b) {

		double x,y;

		if (a instanceof VetorOrto && b instanceof VetorOrto) {

			a.calculaParaPolar();
			b.calculaParaPolar();

		}


		if (a instanceof VetorPolar && b instanceof VetorPolar) {

			// default

		}


		x = a.modulo * b.modulo;
		y = a.fase + b.fase;

		Vetor vetorMult = new VetorPolar(x, y);

		return vetorMult;

	}

	/**
	 * DIVISAO DE VETORES
	 * @param a vetor A
	 * @param b vetor B
	 * @return vetor A / B
	 */

	public Vetor div(Vetor a, Vetor b) {

		double x,y;

		if (a instanceof VetorOrto && b instanceof VetorOrto) {

			a.calculaParaPolar();
			b.calculaParaPolar();

		}


		if (a instanceof VetorPolar && b instanceof VetorPolar) {

			// default

		}


		x = a.modulo / b.modulo;
		y = a.fase - b.fase;

		Vetor vetorDiv = new VetorPolar(x, y);

		return vetorDiv;

	}

	/**
	 * CONSTRUTOR 1
	 * @param modo ORTO/POLAR
	 * @param a ( modo = "polar" --> modulo) ( modo = "orto" --> parte real )
	 * @param b ( modo = "polar" --> fase ) ( modo = "orto" --> parte imaginaria )
	 */
	public Vetor(String modo, double a, double b) {
		super();

		switch (modo){

		case "Orto": 
		case "O": 
		case "ORTHO": 
		case "ortho": 
		case "o": 
		case "orto": 
		case "ORTO":
		{

			double real = a;
			double imag = b;

			this.real = real;
			this.imag = imag;

			this.modulo = hypot(this.real, this.imag);
			this.fase = toDegrees(atan(this.imag/this.real));			

		}

		case "Polar": 
		case "P": 
		case "POLAR": 
		case "p": 
		case "polar": 
		{

			double modulo = a;
			double fase = b;

			if (modulo < 0){
				modulo *= -1;
				fase += 180;
			}

			fase = (fase + 360) % 360;
			this.modulo = modulo;
			if (modulo != 0.0) this.fase = fase;
			else this.fase = 0;

			this.real = (this.modulo * cos(toRadians(this.fase)));
			this.imag = (this.modulo * sin(toRadians(this.fase)));

		}
		}


	}

	public Vetor(){
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

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	public void calculaParaOrto(){

		this.setReal(this.modulo * cos(toRadians(this.fase)));
		this.setImag(this.modulo * sin(toRadians(this.fase)));

	}

	public void calculaParaPolar(){

		this.setModulo(hypot(this.real, this.imag));
		this.setFase(toDegrees(atan(this.imag/this.real)));

	}


	public String mostraPolar(){
		DecimalFormat df = new DecimalFormat("###.##");
		String formatado = df.format(this.getModulo()) + " / " + df.format(this.getFase()) + "° ";
		return formatado;
	}

	public String MostraOrtogonal(){
		DecimalFormat df = new DecimalFormat("###.##");
		String formatado = df.format(this.getReal()) + " + j " + df.format(this.getImag());
		return formatado;
	}

}
