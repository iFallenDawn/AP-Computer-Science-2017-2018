// Jordan Wang
// Calculator GUI Runner
// Spec: Given an equation by the user, it calculates the answer

import java.awt.*; // abstract windowing toolkit
import java.awt.event.*; // respond to windows events
import javax.swing.*; // JGui stuff

public class CalculatorGUIRunner extends JFrame
{
	//text area, buttons, panel, buttonlistener
	//container set to borderlayout, panel set to gridlayout
	//5 Rows, 4 columns grid layout
	private JButton btnSqrt, btnSquared, btnInverse, btnDivide, btnMultiply,
	btnSubtract, btnAdd, btnClear, btnDecimal, btnEquals,
	btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero,
	btnClearStorage, btnDelete, btnClearAll, btnPowerOf;
	private JTextArea jtaInput, jtaStorage;
	private JScrollPane scroll;
	private JPanel pnlGrid;
	private ButtonListener listener;
	private String equation;
	private Calculator c;
	public CalculatorGUIRunner()
	{
		super("Jordan Calculator");
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());;
		pnlGrid = new JPanel();
		pnlGrid.setLayout(new GridLayout(6,4));
		equation = "";

		btnSqrt = new JButton("Sqrt");
		btnSquared = new JButton("x^2");
		btnInverse = new JButton("1/x");
		btnDivide = new JButton("/");
		btnMultiply = new JButton("*");
		btnSubtract = new JButton("-");
		btnAdd = new JButton("+");
		btnClear = new JButton("C");
		btnDecimal = new JButton(".");
		btnEquals = new JButton("=");
		btnOne = new JButton("1");
		btnTwo = new JButton("2");
		btnThree = new JButton("3");
		btnFour = new JButton("4");
		btnFive = new JButton("5");
		btnSix = new JButton("6");
		btnSeven = new JButton("7");
		btnEight = new JButton("8");
		btnNine = new JButton("9");
		btnZero = new JButton("0");
		btnClearStorage = new JButton("C Scroll");
		btnDelete = new JButton("Delete");
		btnClearAll = new JButton("C All");
		btnPowerOf = new JButton("^");
		jtaStorage = new JTextArea(40, 10);
		jtaStorage.setFont(new Font("Ariel", Font.PLAIN, 14));
		jtaStorage.setMargin(new Insets(10,10,10,10));
		jtaStorage.setLineWrap(true);
		jtaStorage.setEditable(false);
		jtaStorage.setBorder(BorderFactory.createLineBorder(Color.black));
		scroll = new JScrollPane(jtaStorage);
		jtaInput = new JTextArea(4, 40);
		jtaInput.setFont(new Font("Ariel", Font.PLAIN, 14));
		jtaInput.setMargin(new Insets(10,10,10,10));
		jtaInput.setLineWrap(true);
		jtaInput.setEditable(false);

		listener = new ButtonListener();

		//Listeners
		btnSqrt.addActionListener(listener);
		btnSquared.addActionListener(listener);
		btnInverse.addActionListener(listener);
		btnDivide.addActionListener(listener);
		btnMultiply.addActionListener(listener);
		btnSubtract.addActionListener(listener);
		btnAdd.addActionListener(listener);
		btnClear.addActionListener(listener);
		btnDecimal.addActionListener(listener);
		btnEquals.addActionListener(listener);
		btnOne.addActionListener(listener);
		btnTwo.addActionListener(listener);
		btnThree.addActionListener(listener);
		btnFour.addActionListener(listener);
		btnFive.addActionListener(listener);
		btnSix.addActionListener(listener);
		btnSeven.addActionListener(listener);
		btnEight.addActionListener(listener);
		btnNine.addActionListener(listener);
		btnZero.addActionListener(listener);
		btnClearStorage.addActionListener(listener);
		btnDelete.addActionListener(listener);
		btnClearAll.addActionListener(listener);
		btnPowerOf.addActionListener(listener);

		//row 1
		pnlGrid.add(btnDelete);
		pnlGrid.add(btnClearAll);
		pnlGrid.add(btnPowerOf);
		pnlGrid.add(btnClearStorage);

		//row 2
		pnlGrid.add(btnSqrt);
		pnlGrid.add(btnSquared);
		pnlGrid.add(btnInverse);
		pnlGrid.add(btnDivide);

		//row 3
		pnlGrid.add(btnSeven);
		pnlGrid.add(btnEight);
		pnlGrid.add(btnNine);
		pnlGrid.add(btnMultiply);

		//row 4
		pnlGrid.add(btnFour);
		pnlGrid.add(btnFive);
		pnlGrid.add(btnSix);
		pnlGrid.add(btnSubtract);

		//row 5
		pnlGrid.add(btnOne);
		pnlGrid.add(btnTwo);
		pnlGrid.add(btnThree);
		pnlGrid.add(btnAdd);

		//row 6
		pnlGrid.add(btnClear);
		pnlGrid.add(btnZero);
		pnlGrid.add(btnDecimal);
		pnlGrid.add(btnEquals);

		cp.add(jtaInput, BorderLayout.NORTH);
		cp.add(pnlGrid, BorderLayout.CENTER);
		cp.add(scroll, BorderLayout.EAST);

		setSize(500, 300);
		setVisible(true);

	}

	public static void main(String[] args)
	{
		CalculatorGUIRunner Calculator = new CalculatorGUIRunner();
	}

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object source = event.getSource();
			c = new Calculator();
			if(source == btnDelete)
			{
				String temp = jtaInput.getText();
				jtaInput.setText(temp.substring(0, temp.length() - 1));
			}
			else if(source == btnClearAll)
			{
				jtaInput.setText(null);
				jtaStorage.setText(null);
			}
			else if(source == btnPowerOf)
			{
				jtaInput.append("^");
			}
			else if(source == btnClearStorage)
			{
				jtaStorage.setText(null);
			}
			else if(source == btnSqrt)
			{
				jtaStorage.append("Square root of " + jtaInput.getText() + " = " + c.getSqrt(jtaInput.getText()) + "\n\n");
				jtaInput.setText(c.getSqrt(jtaInput.getText()));
			}
			else if(source == btnSquared)
			{
				jtaStorage.append(jtaInput.getText() + "^2 = " + c.getSquared(jtaInput.getText()) + "\n\n");
				jtaInput.setText(c.getSquared(jtaInput.getText()));
			}
			else if(source == btnInverse)
			{
				jtaStorage.append("1/" + jtaInput.getText() + " = " + c.getInverse(jtaInput.getText()) + "\n\n");
				jtaInput.setText(c.getInverse(jtaInput.getText()));
			}
			else if(source == btnDivide)
			{
				jtaInput.append(" / ");
			}
			else if(source == btnSeven)
			{
				jtaInput.append("7");
			}
			else if(source == btnEight)
			{
				jtaInput.append("8");
			}
			else if(source == btnNine)
			{
				jtaInput.append("9");
			}
			else if(source == btnMultiply)
			{
				jtaInput.append(" * ");
			}
			else if(source == btnFour)
			{
				jtaInput.append("4");
			}
			else if(source == btnFive)
			{
				jtaInput.append("5");
			}
			else if(source == btnSix)
			{
				jtaInput.append("6");
			}
			else if(source == btnSubtract)
			{
				jtaInput.append(" - ");
			}
			else if(source == btnOne)
			{
				jtaInput.append("1");
			}
			else if(source == btnTwo)
			{
				jtaInput.append("2");
			}
			else if(source == btnThree)
			{
				jtaInput.append("3");
			}
			else if(source == btnAdd)
			{
				jtaInput.append(" + ");
			}
			else if(source == btnClear)
			{
				equation = "";
				jtaInput.setText(null);
			}
			else if(source == btnZero)
			{
				jtaInput.append("0");
			}
			else if(source == btnDecimal)
			{
				jtaInput.append(".");
			}
			else if(source == btnEquals)
			{
				equation = jtaInput.getText();
				boolean checkPower = false;
				//Checks if there is a carrot for equations with exponents
				for(int i = 0; i < equation.length(); i++)
				{
					if(equation.substring(i,i+1).equals("^"))
					{
						checkPower = true;
						jtaInput.setText(c.toPowerOf(equation));
						jtaStorage.append(equation + " = " + c.toPowerOf(equation) + "\n\n");
						i = equation.length();
					}
				}
				//If there's no carrot, then normal calculations are done
				if(checkPower == false)
				{
					c = new Calculator(equation);
					jtaInput.setText(c.toString());
					jtaStorage.append(equation + " = " + c.toString() + "\n\n");
				}
			}
		}
	}
}