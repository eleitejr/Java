package romano;
import javax.swing.JOptionPane;
@SuppressWarnings("serial")
public class LimiteExcedidoException extends Exception{
	public LimiteExcedidoException() {
		JOptionPane.showMessageDialog(null, "O valor fornecido deve ser menor que 4000.");
	}

}
