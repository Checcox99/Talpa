package View;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Client extends JPanel {
	private JPanel panel;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;
	private JButton button_15;
	private JButton button_16;
	private JButton button_17;
	private JButton button_18;
	private JButton button_19;
	private JButton button_20;
	private JButton button_21;
	private JButton button_22;
	private JButton button_23;
	private JButton button_24;
	private JPanel panel_1;
	private JLabel lblToccaATe;
	private JLabel lblAvversario;
	private JLabel lblTrovaLaTalpa;
	private JLabel lblRisultato;
	private JPanel panel_uno;
	private JPanel panel_due;

	/**
	 * Create the panel.
	 */
	public Client() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(12, 13, 400, 404);
		add(panel);
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
		button = new JButton("1");
		button.setEnabled(false);
		panel.add(button);
		
		button_1 = new JButton("2");
		button_1.setEnabled(false);
		panel.add(button_1);
		
		button_2 = new JButton("3");
		button_2.setEnabled(false);
		panel.add(button_2);
		
		button_3 = new JButton("4");
		button_3.setEnabled(false);
		panel.add(button_3);
		
		button_4 = new JButton("5");
		button_4.setEnabled(false);
		panel.add(button_4);
		
		button_5 = new JButton("6");
		button_5.setEnabled(false);
		panel.add(button_5);
		
		button_6 = new JButton("7");
		button_6.setEnabled(false);
		panel.add(button_6);
		
		button_7 = new JButton("8");
		button_7.setEnabled(false);
		panel.add(button_7);
		
		button_8 = new JButton("9");
		button_8.setEnabled(false);
		panel.add(button_8);
		
		button_9 = new JButton("10");
		button_9.setEnabled(false);
		panel.add(button_9);
		
		button_10 = new JButton("11");
		button_10.setEnabled(false);
		panel.add(button_10);
		
		button_11 = new JButton("12");
		button_11.setEnabled(false);
		panel.add(button_11);
		
		button_12 = new JButton("13");
		button_12.setEnabled(false);
		panel.add(button_12);
		
		button_13 = new JButton("14");
		button_13.setEnabled(false);
		panel.add(button_13);
		
		button_14 = new JButton("15");
		button_14.setEnabled(false);
		panel.add(button_14);
		
		button_15 = new JButton("16");
		button_15.setEnabled(false);
		panel.add(button_15);
		
		button_16 = new JButton("17");
		button_16.setEnabled(false);
		panel.add(button_16);
		
		button_17 = new JButton("18");
		button_17.setEnabled(false);
		panel.add(button_17);
		
		button_18 = new JButton("19");
		button_18.setEnabled(false);
		panel.add(button_18);
		
		button_19 = new JButton("20");
		button_19.setEnabled(false);
		panel.add(button_19);
		
		button_20 = new JButton("21");
		button_20.setEnabled(false);
		panel.add(button_20);
		
		button_21 = new JButton("22");
		button_21.setEnabled(false);
		panel.add(button_21);
		
		button_22 = new JButton("23");
		button_22.setEnabled(false);
		panel.add(button_22);
		
		button_23 = new JButton("24");
		button_23.setEnabled(false);
		panel.add(button_23);
		
		button_24 = new JButton("25");
		button_24.setEnabled(false);
		panel.add(button_24);
		
		panel_1 = new JPanel();
		panel_1.setBounds(424, 13, 164, 404);
		add(panel_1);
		panel_1.setLayout(new GridLayout(4, 1, 0, 0));
		
		lblTrovaLaTalpa = new JLabel("TROVA LA TALPA");
		lblTrovaLaTalpa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrovaLaTalpa.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblTrovaLaTalpa);
		
		panel_uno = new JPanel();
		panel_uno.setBorder(null);
		panel_1.add(panel_uno);
		panel_uno.setLayout(null);
		
		lblToccaATe = new JLabel("TOCCA A TE");
		lblToccaATe.setBounds(10, 11, 144, 79);
		panel_uno.add(lblToccaATe);
		lblToccaATe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblToccaATe.setHorizontalAlignment(SwingConstants.CENTER);
		lblToccaATe.setVerticalAlignment(SwingConstants.CENTER);
		
		panel_due = new JPanel();
		panel_due.setBorder(null);
		panel_1.add(panel_due);
		panel_due.setLayout(null);
		
		lblAvversario = new JLabel("AVVERSARIO");
		lblAvversario.setBounds(10, 11, 144, 79);
		panel_due.add(lblAvversario);
		lblAvversario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAvversario.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRisultato = new JLabel("RISULTATO");
		lblRisultato.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRisultato.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblRisultato);

	}

	public JPanel getPanel_due() {
		return panel_due;
	}

	public void setPanel_due(JPanel panel_due) {
		this.panel_due = panel_due;
	}

	public JPanel getPanel_uno() {
		return panel_uno;
	}

	public void setPanel_uno(JPanel panel_uno) {
		this.panel_uno = panel_uno;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public JButton getButton_1() {
		return button_1;
	}

	public void setButton_1(JButton button_1) {
		this.button_1 = button_1;
	}

	public JButton getButton_2() {
		return button_2;
	}

	public void setButton_2(JButton button_2) {
		this.button_2 = button_2;
	}

	public JButton getButton_3() {
		return button_3;
	}

	public void setButton_3(JButton button_3) {
		this.button_3 = button_3;
	}

	public JButton getButton_4() {
		return button_4;
	}

	public void setButton_4(JButton button_4) {
		this.button_4 = button_4;
	}

	public JButton getButton_5() {
		return button_5;
	}

	public void setButton_5(JButton button_5) {
		this.button_5 = button_5;
	}

	public JButton getButton_6() {
		return button_6;
	}

	public void setButton_6(JButton button_6) {
		this.button_6 = button_6;
	}

	public JButton getButton_7() {
		return button_7;
	}

	public void setButton_7(JButton button_7) {
		this.button_7 = button_7;
	}

	public JButton getButton_8() {
		return button_8;
	}

	public void setButton_8(JButton button_8) {
		this.button_8 = button_8;
	}

	public JButton getButton_9() {
		return button_9;
	}

	public void setButton_9(JButton button_9) {
		this.button_9 = button_9;
	}

	public JButton getButton_10() {
		return button_10;
	}

	public void setButton_10(JButton button_10) {
		this.button_10 = button_10;
	}

	public JButton getButton_11() {
		return button_11;
	}

	public void setButton_11(JButton button_11) {
		this.button_11 = button_11;
	}

	public JButton getButton_12() {
		return button_12;
	}

	public void setButton_12(JButton button_12) {
		this.button_12 = button_12;
	}

	public JButton getButton_13() {
		return button_13;
	}

	public void setButton_13(JButton button_13) {
		this.button_13 = button_13;
	}

	public JButton getButton_14() {
		return button_14;
	}

	public void setButton_14(JButton button_14) {
		this.button_14 = button_14;
	}

	public JButton getButton_15() {
		return button_15;
	}

	public void setButton_15(JButton button_15) {
		this.button_15 = button_15;
	}

	public JButton getButton_16() {
		return button_16;
	}

	public void setButton_16(JButton button_16) {
		this.button_16 = button_16;
	}

	public JButton getButton_17() {
		return button_17;
	}

	public void setButton_17(JButton button_17) {
		this.button_17 = button_17;
	}

	public JButton getButton_18() {
		return button_18;
	}

	public void setButton_18(JButton button_18) {
		this.button_18 = button_18;
	}

	public JButton getButton_19() {
		return button_19;
	}

	public void setButton_19(JButton button_19) {
		this.button_19 = button_19;
	}

	public JButton getButton_20() {
		return button_20;
	}

	public void setButton_20(JButton button_20) {
		this.button_20 = button_20;
	}

	public JButton getButton_21() {
		return button_21;
	}

	public void setButton_21(JButton button_21) {
		this.button_21 = button_21;
	}

	public JButton getButton_22() {
		return button_22;
	}

	public void setButton_22(JButton button_22) {
		this.button_22 = button_22;
	}

	public JButton getButton_23() {
		return button_23;
	}

	public void setButton_23(JButton button_23) {
		this.button_23 = button_23;
	}

	public JButton getButton_24() {
		return button_24;
	}

	public void setButton_24(JButton button_24) {
		this.button_24 = button_24;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public JLabel getLblToccaATe() {
		return lblToccaATe;
	}

	public void setLblToccaATe(JLabel lblToccaATe) {
		this.lblToccaATe = lblToccaATe;
	}

	public JLabel getLblAvversario() {
		return lblAvversario;
	}

	public void setLblAvversario(JLabel lblAvversario) {
		this.lblAvversario = lblAvversario;
	}

	public JLabel getLblTrovaLaTalpa() {
		return lblTrovaLaTalpa;
	}

	public void setLblTrovaLaTalpa(JLabel lblTrovaLaTalpa) {
		this.lblTrovaLaTalpa = lblTrovaLaTalpa;
	}

	public JLabel getLblRisultato() {
		return lblRisultato;
	}

	public void setLblRisultato(JLabel lblRisultato) {
		this.lblRisultato = lblRisultato;
	}
}
