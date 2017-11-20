package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class Server extends JPanel {
	private JButton btnStart;
	private JLabel lblTesto;

	/**
	 * Create the panel.
	 */
	public Server() {
		setLayout(null);
		
		btnStart = new JButton("START");
		btnStart.setBounds(12, 290, 576, 125);
		add(btnStart);
		
		lblTesto = new JLabel("TESTO");
		lblTesto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTesto.setBounds(12, 13, 576, 266);
		add(lblTesto);

	}

	public JButton getBtnStart() {
		return btnStart;
	}

	public void setBtnStart(JButton btnStart) {
		this.btnStart = btnStart;
	}

	public JLabel getLblTesto() {
		return lblTesto;
	}

	public void setLblTesto(JLabel lblTesto) {
		this.lblTesto = lblTesto;
	}
}
