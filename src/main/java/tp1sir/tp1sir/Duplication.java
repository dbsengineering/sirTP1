package tp1sir.tp1sir;

import org.jdesktop.swingx.JXBusyLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * 
 * @author CavronJ
 *
 */
public class Duplication extends JFrame implements ActionListener {

	// --- Déclaration des propriétées --
	JXBusyLabel bLabel1;
	JComboBox comboBackground;
	JComboBox comboForeground;
	JButton btnStart;
	JButton btnStop;
	Color[] colors = {Color.BLACK, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN, Color.GRAY, Color.YELLOW};
	
	/**
	 * 
	 */
	private void codeMort() {
		System.out.println("codeMort");
	}

	/**
	 * Constructeur de la classe.
	 */
	public Duplication() {
		bLabel1 = new JXBusyLabel(new Dimension(60, 60));
		bLabel1.setBusy(true);

		String[] colorsName = {"Choose a color", "BLACK", "WHITE", "RED", "BLUE", "GREEN", "GRAY", "YELLOW"};
		comboBackground = new JComboBox(colorsName);
		comboForeground = new JComboBox(colorsName);
		btnStart = new JButton("Start");
		btnStop = new JButton("Stop");

		comboBackground.addActionListener(this);
		comboForeground.addActionListener(this);
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);

		JPanel panelSouth = new JPanel();
		panelSouth.add(new JLabel("Background"));
		panelSouth.add(comboBackground);
		panelSouth.add(new JLabel("Foreground"));
		panelSouth.add(comboForeground);
		JPanel panelNorth = new JPanel();
		panelNorth.add(btnStart);
		panelNorth.add(btnStop);

		add(panelNorth, BorderLayout.NORTH);
		add(bLabel1, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);

		setSize(400, 160);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Procédure d'action.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboBackground) {
			bLabel1.getBusyPainter().setBaseColor(colors[comboBackground.getSelectedIndex()-1]);
		} else if (e.getSource() == comboForeground) {
			bLabel1.getBusyPainter().setHighlightColor(colors[comboForeground.getSelectedIndex()-1]);
		} else if (e.getSource() == btnStart) {
			bLabel1.setBusy(true);
		} else if (e.getSource() == btnStop) {
			bLabel1.setBusy(false);
		}
	}

	/**
	 * Procédure principale
	 * @param args
	 */
	public static void main(String[] args) {
		new JXBusyLabelTest();
	}
}
