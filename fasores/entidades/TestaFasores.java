package entidades;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 * @class TestaFasores
 * 	Test Class for Fasor class
 * @erasmoleitejr
 * @date 2015/05/01
 * 
 **/

public class TestaFasores {

	public static void main(String[] args) throws NumberFormatException{
		
		DecimalFormat df = new DecimalFormat("###.##");
		
		String str_modulo_a = JOptionPane.showInputDialog("Módulo do fasor A:", null);
		String str_fase_a = JOptionPane.showInputDialog("Fase do fasor A:", null);
		String str_modulo_b = JOptionPane.showInputDialog("Módulo do fasor B:", null);
		String str_fase_b = JOptionPane.showInputDialog("Fase do fasor B:", null);
		
		Double modulo_a = Double.parseDouble(str_modulo_a);
		Double fase_a = Double.parseDouble(str_fase_a);
		
		Double modulo_b = Double.parseDouble(str_modulo_b);
		Double fase_b = Double.parseDouble(str_fase_b);
				
		try {
			Fasor a = new Fasor(modulo_a, fase_a);
			Fasor b = new Fasor(modulo_b, fase_b);
			Fasor c = new Fasor();
			c = c.soma(a,b);
			String r1 = ("A\u0305 = ( " + df.format(a.getModulo()) + " / " + df.format(a.getFase()) + "° ) ");
			String r2 = ("B\u0305 = ( " + df.format(b.getModulo()) + " / " + df.format(b.getFase()) + "° ) ");
			String r3 = ("A\u0305 + B\u0305 = ( " + df.format(c.getModulo()) + " / " + df.format(c.getFase()) + "° ) ");
			
			JOptionPane.showMessageDialog(null, r1 + "\n" + r2 + "\n" +  r3 + "\n" , "Cálculo da Soma dos Fasores",
			        JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Erro de Formato! Tente Novamente." , "Cálculo da Soma dos Fasores",
			        JOptionPane.ERROR_MESSAGE);
		}
				
		
		System.exit(0);
	}

}
