package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.Control;

public class IOManager extends JFrame implements CustomEventResponse {
	private JPanel tablero;
	private JPanel infoPane;
	private Control c;

	public IOManager() {

		c = new Control();

		c.setEvent(this);
		setSize(700,1000);
		setTitle("Método gráfico");
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		infoPane = new Info();
		infoPane.setBounds(5,470,467,80);
		((Info)infoPane).setEvents(c);
		add(infoPane);

		tablero = new TriquiPane();
		tablero.setBounds(5,5,468, 460);
		((TriquiPane)tablero).setEvent(c);
		add(tablero);
	}

	@Override
	public void restarGame() {
		((TriquiPane)tablero).createTriqui();
	}

	@Override
	public void showWinner(int[] winOp, String resultString) {
		((TriquiPane)tablero).showWinnerT(winOp,resultString);
		
	}
} 
