package romano;
import javax.swing.JOptionPane;
@SuppressWarnings("serial")
public class FormatoNaoRomanoException extends Exception{
	public FormatoNaoRomanoException() {
		JOptionPane.showMessageDialog(null, "Valor fornecido não é um número romano.");
	}

}
