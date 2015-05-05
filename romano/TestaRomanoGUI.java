package romano;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TestaRomanoGUI extends JFrame{
	/**
	 * @author Erasmo Leite
	 * @since 2015.04.01
	 */

	Romano romano = new Romano();
	private static final long serialVersionUID = 1L;
	// Componentes ativos
	private final JTextField tfRomano, tfArabico;
	private final JButton bLimpar, bConverter;
	// Componentes não-ativos
	private final JLabel lRomano, lArabico;
	// Info de tela
	private final Dimension tamanhoJanela = new Dimension(320,120);
	Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
	Point meio = new Point(tamanhoTela.width / 2, tamanhoTela.height / 2);


	// Construtor
	public TestaRomanoGUI() {
		super("Algarismos Romanos"); // ajuste do título da janela

		setPreferredSize(tamanhoJanela);

		// instanciação dos componentes
		lRomano = new JLabel("Romano");
		lArabico = new JLabel("Arabico");
		tfRomano = new JTextField();
		tfArabico = new JTextField();
		bLimpar = new JButton("Limpar");
		bLimpar.setToolTipText("Limpa as caixas de entrada");

		bConverter = new JButton("Converter");
		bConverter.setToolTipText("Efetua conversão do valor dado");

		// ajuste do layout e adição dos componentes
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(3,2,5,5));

		cp.add(lArabico); cp.add(tfArabico);
		cp.add(lRomano); cp.add(tfRomano);
		cp.add(bLimpar); cp.add(bConverter);

		// registro dos event listeners
		bLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bLimparClick();
			}
		});
		bConverter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					bConverterClick();
				} catch (NumberFormatException | FormatoNaoRomanoException | LimiteExcedidoException e1) {
					tfRomano.selectAll();
					tfRomano.requestFocus();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});

		// ajustes para janela
		cp.setBackground(Color.orange);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);

	}

	// ================================
	// limpa caixas de texto de entrada
	// ================================

	private void bLimparClick() {
		tfRomano.setText("");
		tfArabico.setText("");
	}

	// ======================================================
	// efetua conversão conforme conteúdo das caixas de texto
	// ======================================================

	private void bConverterClick() throws NumberFormatException, LimiteExcedidoException, FormatoNaoRomanoException {
		// Romano -> Arabico se tfArabico vazia e tfRomano com conteúdo
		if (tfArabico.getText().equals("") &&
				!tfRomano.getText().equals("")) {
			int res;
			try {
				res = romano.romanToArabic(tfRomano.getText());

				tfRomano.setText("");
				tfArabico.setText("" + res);

			} catch (NumberFormatException exc) {
				tfRomano.selectAll();
				tfRomano.requestFocus();
				Toolkit.getDefaultToolkit().beep();

			} catch (FormatoNaoRomanoException e) {
				tfRomano.selectAll();
				tfRomano.requestFocus();
				Toolkit.getDefaultToolkit().beep();

			} catch (LimiteExcedidoException e) {
				tfRomano.selectAll();
				tfRomano.requestFocus();
				Toolkit.getDefaultToolkit().beep();
			}

			// Arabico -> Romano se tfRomano vazia e tfArabico com conteúdo

		} else if (tfRomano.getText().equals("") &&
				!tfArabico.getText().equals("")) {
			String res;
			try {
				res = romano.arabicToRoman(Integer.parseInt(tfArabico.getText()));

				tfArabico.setText("");
				tfRomano.setText("" + res);

			} catch (NumberFormatException exc) {
				tfArabico.selectAll();
				tfArabico.requestFocus();
				Toolkit.getDefaultToolkit().beep();

			} catch (LimiteExcedidoException e) {
				tfArabico.selectAll();
				tfArabico.requestFocus();
				Toolkit.getDefaultToolkit().beep();
			}

		} 

	}
	//====================
	// Inicia a aplicação
	//====================

	public static void main(String a[]){

		new TestaRomanoGUI().setVisible(true);

	}
}
