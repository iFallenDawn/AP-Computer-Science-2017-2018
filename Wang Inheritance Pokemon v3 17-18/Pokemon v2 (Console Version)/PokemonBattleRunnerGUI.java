//Jordan Wang

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
import java.applet.*;

public class PokemonBattleRunnerGUI extends JFrame
{
	private int count = 0;
	private int userdmgDealt = 0;
	private int oppdmgDealt = 0;
	private int critNum = 0;
	private Timer tmr;
	private TimerListener tmrListener;
	private Starter user = new Starter();
	private Starter opponent = new Starter();
	private JLabel lblTorchic, lblTreecko, lblMudkip, lblWelcome;
	private JLabel lblTorchicPic, lblTreeckoPic, lblMudkipPic, lbloakPic, lbloppPic, lbluserPic;
	private JButton btnTorchic, btnTreecko, btnMudkip, btnFight, btnAttack;
	private JTextArea jtaOutput, jtauserDesc, jtaoppDesc;
	private ImageIcon icoTorchic, icoTreecko, icoMudkip, icoOak, icoPlayer, icoOpponent;
	private ButtonListener listener;
	public PokemonBattleRunnerGUI()
	{
		super("Pokemon Wang");
		Container cp = getContentPane();
		cp.setLayout(null);

		tmrListener = new TimerListener();
		tmr = new Timer(1500, tmrListener);

		jtaOutput = new JTextArea(400, 100);
		jtaOutput.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		jtaoppDesc = new JTextArea();
		jtaoppDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		jtauserDesc = new JTextArea();
		jtauserDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		jtaOutput.setEditable(false);
		jtaoppDesc.setEditable(false);
		jtauserDesc.setEditable(false);
		jtaOutput.setLineWrap(true);
		jtaoppDesc.setLineWrap(true);
		jtauserDesc.setLineWrap(true);

		lblWelcome = new JLabel("Welcome! Choose your Pokemon!");
		lblWelcome.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblTorchic = new JLabel("Torchic");
		lblTorchic.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTreecko = new JLabel("Treecko");
		lblTreecko.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblMudkip = new JLabel("Torchic");
		lblMudkip.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

		lblTorchicPic = new JLabel();
		lblTreeckoPic = new JLabel();
		lblMudkipPic = new JLabel();
		lbloakPic = new JLabel();
		lbluserPic = new JLabel();
		lbloppPic = new JLabel();

		icoTorchic = new ImageIcon("torchic.jpg");
		icoTreecko = new ImageIcon("treecko.jpg");
		icoMudkip = new ImageIcon("mudkip.jpg");
		icoOak = new ImageIcon("ko.png");
		icoPlayer = new ImageIcon("");
		icoOpponent = new ImageIcon("");

		btnTorchic = new JButton("Torchic");
		btnTorchic.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnTreecko = new JButton("Treecko");
		btnTreecko.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnMudkip = new JButton("Mudkip");
		btnMudkip.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnFight = new JButton("FIGHT");
		btnFight.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnAttack = new JButton();
		btnAttack.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));

		listener = new ButtonListener();

		btnTorchic.addActionListener(listener);
		btnTreecko.addActionListener(listener);
		btnMudkip.addActionListener(listener);
		btnAttack.addActionListener(listener);
		btnFight.addActionListener(listener);

		//Set pictures
		lbloakPic.setIcon(icoOak);
		lblTorchicPic.setIcon(icoTorchic);
		lblTreeckoPic.setIcon(icoTreecko);
		lblMudkipPic.setIcon(icoMudkip);

		//Set bounds
		lblWelcome.setBounds(95, 0, 500, 30);
		lbloakPic.setBounds(180, 50, 150, 200);
		lblTorchicPic.setBounds(20, 300, 100, 100);
		lblTreeckoPic.setBounds(185, 300, 100, 100);
		lblMudkipPic.setBounds(340, 300, 100, 100);
		btnTorchic.setBounds(20, 400, 100, 50);
		btnTreecko.setBounds(185, 400, 100, 50);
		btnMudkip.setBounds(340, 400, 100, 50);
		btnFight.setBounds(600, 360, 183, 100);
		btnAttack.setBounds(600, 360, 183, 100);
		lbluserPic.setBounds(150, 240, 100, 100);
		lbloppPic.setBounds(450, 10, 100, 100);
		jtaOutput.setBounds(0, 360, 400, 100);
		jtauserDesc.setBounds(600, 270, 200, 180);
		jtaoppDesc.setBounds(10, 10, 150, 100);

		//Add everything
		cp.add(lblWelcome);
		cp.add(lblTorchic);
		cp.add(lblTreecko);
		cp.add(lblMudkip);
		cp.add(lblTorchicPic);
		cp.add(lblTreeckoPic);
		cp.add(lblMudkipPic);
		cp.add(lbloakPic);
		cp.add(lbluserPic);
		cp.add(lbloppPic);
		cp.add(btnTorchic);
		cp.add(btnTreecko);
		cp.add(btnMudkip);
		cp.add(btnFight);
		cp.add(btnAttack);
		cp.add(jtaOutput);
		cp.add(jtauserDesc);
		cp.add(jtaoppDesc);

		btnFight.setVisible(false);
		btnAttack.setVisible(false);
		lbluserPic.setVisible(false);
		lbloppPic.setVisible(false);
		jtaOutput.setVisible(false);
		jtauserDesc.setVisible(false);
		jtaoppDesc.setVisible(false);

		setSize(500,600);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] args)
	{
		PokemonBattleRunnerGUI pkmn = new PokemonBattleRunnerGUI();
	}

	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			count++;
			critNum = (int)(Math.random()*25);
			userdmgDealt = (int)(Math.random()*3)+2;
			oppdmgDealt = (int)(Math.random()*3)+2;

			if(count == 1)
			{
				if(critNum == 10)
				{
					jtaOutput.append("\nIt was a critical hit!");
					userdmgDealt = userdmgDealt * 2;
				}
				jtaOutput.append("\n" + opponent.getName() + " took " + userdmgDealt + " damage!");
				opponent.calculateHealth(userdmgDealt);
			}
			if(opponent.getHealth() <= 0)
			{
				JOptionPane.showMessageDialog(null, "You won the battle!");
				System.exit(0);
			}
			critNum = (int)(Math.random()*25);
			if(count == 2)
			{
				jtaOutput.setText(opponent.getName() + " used " + opponent.getAttack() + "!");
				if(critNum == 10)
				{
					jtaOutput.append("\nIt was a critical hit!");
					oppdmgDealt = oppdmgDealt * 2;
				}
				jtaOutput.append("\n" + user.getName() + " took " + oppdmgDealt + " damage!");
				user.calculateHealth(oppdmgDealt);
			}
			if(user.getHealth() <= 0)
			{
				JOptionPane.showMessageDialog(null, "You blacked out . . .");
				System.exit(0);
			}
			jtauserDesc.setText(user.toString());
			jtaoppDesc.setText(opponent.toString());

			jtauserDesc.setText(user.toString());
			jtaoppDesc.setText(opponent.toString());
			if(count == 3)
			{
				tmr.stop();
				btnFight.setEnabled(true);
				btnFight.setVisible(true);
				btnAttack.setVisible(false);
				count = 0;
			}
		}
	}

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int userdmgDealt = 0;
			int oppdmgDealt = 0;
			int critNum = 0;
			Object source = new Object();
			source = event.getSource();
			if(source == btnTorchic)
			{
				user = new Starter("Scratch", 20, "Torchic", "Fire");
				opponent = new Starter("Tackle", 20, "Mudkip", "Water");

				setSize(800, 500);
				lblWelcome.setVisible(false);
				lbloakPic.setVisible(false);
				lblTorchicPic.setVisible(false);
				lblMudkipPic.setVisible(false);
				lblTreeckoPic.setVisible(false);
				btnTorchic.setVisible(false);
				btnTreecko.setVisible(false);
				btnMudkip.setVisible(false);

				btnFight.setVisible(true);
				jtaOutput.setVisible(true);
				lbluserPic.setVisible(true);
				jtauserDesc.setVisible(true);
				lbloppPic.setVisible(true);
				jtaoppDesc.setVisible(true);

				lbluserPic.setIcon(icoTorchic);
				lbloppPic.setIcon(icoMudkip);

				btnAttack.setText(user.getAttack());
				jtauserDesc.setText(user.toString());
				jtaoppDesc.setText(opponent.toString());
			}
			if(source == btnTreecko)
			{
				user = new Starter("Pound", 20, "Treecko", "Grass");
				opponent = new Starter("Scratch", 20, "Torchic", "Fire");

				setSize(800, 500);
				lblWelcome.setVisible(false);
				lbloakPic.setVisible(false);
				lblTorchicPic.setVisible(false);
				lblMudkipPic.setVisible(false);
				lblTreeckoPic.setVisible(false);
				btnTorchic.setVisible(false);
				btnTreecko.setVisible(false);
				btnMudkip.setVisible(false);

				btnFight.setVisible(true);
				jtaOutput.setVisible(true);
				lbluserPic.setVisible(true);
				jtauserDesc.setVisible(true);
				lbloppPic.setVisible(true);
				jtaoppDesc.setVisible(true);

				lbluserPic.setIcon(icoTreecko);
				lbloppPic.setIcon(icoTorchic);

				btnAttack.setText(user.getAttack());
				jtauserDesc.setText(user.toString());
				jtaoppDesc.setText(opponent.toString());
			}
			if(source == btnMudkip)
			{
				user = new Starter("Tackle", 20, "Mudkip", "Water");
				opponent = new Starter("Pound", 20, "Treecko", "Grass");

				setSize(800, 500);
				lblWelcome.setVisible(false);
				lbloakPic.setVisible(false);
				lblTorchicPic.setVisible(false);
				lblMudkipPic.setVisible(false);
				lblTreeckoPic.setVisible(false);
				btnTorchic.setVisible(false);
				btnTreecko.setVisible(false);
				btnMudkip.setVisible(false);

				btnFight.setVisible(true);
				jtaOutput.setVisible(true);
				lbluserPic.setVisible(true);
				jtauserDesc.setVisible(true);
				lbloppPic.setVisible(true);
				jtaoppDesc.setVisible(true);

				lbluserPic.setIcon(icoMudkip);
				lbloppPic.setIcon(icoTreecko);

				btnAttack.setText(user.getAttack());
				jtauserDesc.setText(user.toString());
				jtaoppDesc.setText(opponent.toString());
			}
			if(source == btnFight)
			{
				btnFight.setVisible(false);
				btnAttack.setVisible(true);
			}
			if(source == btnAttack)
			{
				btnFight.setVisible(true);
				btnAttack.setVisible(false);
				btnFight.setEnabled(false);
				tmr.start();
				if(count == 0)
					jtaOutput.setText(user.getName() + " used " + user.getAttack() + "!");
			}
		}
	}
}

