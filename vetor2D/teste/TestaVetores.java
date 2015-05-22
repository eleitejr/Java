package teste;

import javax.swing.JOptionPane;

import entidades.Vetor;
import entidades.VetorPolar;

public class TestaVetores {

	public static void main(String[] args) throws NumberFormatException{

		String str_modulo_a = JOptionPane.showInputDialog("Módulo do vetor A:", null);
		String str_fase_a = JOptionPane.showInputDialog("Fase do vetor A em graus:", null);
		String str_modulo_b = JOptionPane.showInputDialog("Módulo do vetor B:", null);
		String str_fase_b = JOptionPane.showInputDialog("Fase do vetor B em graus:", null);

		Double modulo_a = Double.parseDouble(str_modulo_a);
		Double fase_a = Double.parseDouble(str_fase_a);

		Double modulo_b = Double.parseDouble(str_modulo_b);
		Double fase_b = Double.parseDouble(str_fase_b);

		try {
			Vetor a = new VetorPolar(modulo_a, fase_a);
			Vetor b = new VetorPolar(modulo_b, fase_b);

			Vetor fSoma = new VetorPolar();
			Vetor fSub = new VetorPolar();
			Vetor fMult = new VetorPolar();
			Vetor fDiv = new VetorPolar();

			fSoma = fSoma.soma(a, b);
			fSub = fSub.sub(a, b);
			fMult = fMult.mult(a, b);
			fDiv = fDiv.div(a, b);

			String r1 = ("A\u0305 = ( " + a.mostraPolar() + " )");
			String r2 = ("B\u0305 = ( " + b.mostraPolar() + " )");
			String r3 = ("A\u0305 + B\u0305 = ( " + fSoma.mostraPolar() + " )");
			String r4 = ("A\u0305 - B\u0305 = ( " + fSub.mostraPolar() + " )");
			String r5 = ("A\u0305 x B\u0305 = ( " + fMult.mostraPolar() + " )");
			String r6 = ("A\u0305 / B\u0305 = ( " + fDiv.mostraPolar() + " )");

			String r7 = ("A\u0305 = ( " + a.MostraOrtogonal() + " )");
			String r8 = ("B\u0305 = ( " + b.MostraOrtogonal() + " )");
			String r9 = ("A\u0305 + B\u0305 = ( " + fSoma.MostraOrtogonal() + " )");
			String r10 = ("A\u0305 - B\u0305 = ( " + fSub.MostraOrtogonal() + " )");
			String r11 = ("A\u0305 x B\u0305 = ( " + fMult.MostraOrtogonal() + " )");
			String r12 = ("A\u0305 / B\u0305 = ( " + fDiv.MostraOrtogonal() + " )");

			String FormaPolar = "Forma Polar: " + "\n" + r1 + "\n" + r2 + "\n" +  r3 + "\n" +  r4 + "\n" +  r5 + "\n" +  r6;
			String FormaOrtogonal = "Forma Retangular: " + "\n" + r7 + "\n" + r8 + "\n" +  r9 + "\n" +  r10+ "\n" +  r11 + "\n" +  r12;


			JOptionPane.showMessageDialog(null, FormaPolar + "\n\n" + FormaOrtogonal + "\n", "Operações com Vetores",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Erro de Formato! Tente Novamente." , "Operações com Vetores",
					JOptionPane.ERROR_MESSAGE);
		}


		System.exit(0);
	}


}
