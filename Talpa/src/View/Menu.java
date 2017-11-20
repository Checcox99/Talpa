package View;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class Menu extends JPanel {
	private JButton btnServer;
	private JLabel label;
	private JLabel label_1;
	private JTextField txtIp;
	private JTextField txtPorta;
	private JButton btnClient;

	/**
	 * Create the panel.
	 */
	public Menu() {
		setLayout(null);
		
		btnServer = new JButton("SERVER");
		btnServer.setBounds(415, 9, 173, 191);
		add(btnServer);
		
		label = new JLabel("IP");
		label.setBounds(12, 9, 391, 81);
		add(label);
		
		label_1 = new JLabel("PORTA");
		label_1.setBounds(12, 226, 391, 81);
		add(label_1);
		
		txtIp = new JTextField();
		txtIp.setBounds(12, 103, 391, 97);
		add(txtIp);
		txtIp.setColumns(10);
		
		txtPorta = new JTextField();
		txtPorta.setBounds(12, 320, 391, 97);
		add(txtPorta);
		txtPorta.setColumns(10);
		
		btnClient = new JButton("CLIENT");
		btnClient.setBounds(415, 226, 173, 191);
		add(btnClient);

	}

	public JButton getBtnServer() {
		return btnServer;
	}

	public void setBtnServer(JButton button) {
		this.btnServer = button;
	}

	public JButton getBtnClient() {
		return btnClient;
	}

	public void setBtnClient(JButton btnClient) {
		this.btnClient = btnClient;
	}

	public JTextField getTxtIp() {
		return txtIp;
	}

	public void setTxtIp(JTextField txtIp) {
		this.txtIp = txtIp;
	}

	public JTextField getTxtPorta() {
		return txtPorta;
	}

	public void setTxtPorta(JTextField txtPorta) {
		this.txtPorta = txtPorta;
	}

}
