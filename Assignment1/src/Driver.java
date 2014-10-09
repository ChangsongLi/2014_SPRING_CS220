/**
 * This program has a Window with 7x7 TextFields. Yellow TextFields are for input by users.
 * The white TextFields shows the sums of each row and each column when user give some inputs.
 * Also, those TextFields only accept integers. If user input's number is double type or others,
 * the program will throw an error.
 * 
 * Feb 4 2014
 * @ Changsong Li
 * 
 */

import java.awt.Color;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Driver implements ActionListener { // The Driver class will handle
												// events

	// Globe variables
	private JFrame window;
	private JTextField[][] j;
	private JTextField[] textRow, textCol;
	private JTextField totalSum;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Driver d = new Driver();
	}

	// set up Window with 7x7 TextFields.
	public Driver() {
		window = new JFrame("Excel Window");
		window.setLayout(null);
		window.setBounds(10, 10, 600, 500);
		window.setVisible(true);

		j = new JTextField[6][6];
		for (int row = 0; row < j.length; row++) {
			for (int col = 0; col < j[row].length; col++) {
				j[row][col] = new JTextField("0");
				j[row][col].setBounds(60 + 60 * col, 60 + 40 * row, 55, 30);
				j[row][col].addActionListener(this);
				j[row][col].setBackground(Color.yellow);
				window.add(j[row][col], 0);
			}
		}

		textRow = new JTextField[6];
		for (int row = 0; row < textRow.length; row++) {
			textRow[row] = new JTextField("0");
			textRow[row].setBounds(480, 60 + 40 * row, 55, 30);
			window.add(textRow[row], 0);
		}

		textCol = new JTextField[6];
		for (int col = 0; col < textCol.length; col++) {
			textCol[col] = new JTextField("0");
			textCol[col].setBounds(60 + 60 * col, 340, 55, 30);
			window.add(textCol[col], 0);
		}

		totalSum = new JTextField("0");
		totalSum.setBounds(480, 340, 55, 30);
		window.add(totalSum);

		window.repaint();

	}

	/*
	 * Action after give integers to TextFields and press the Key of "Enter".
	 * Get the sums for each columns and Rows.
	 */
	public void actionPerformed(ActionEvent a) {
		int sumRow[] = new int[6];
		int sumCol[] = new int[6];
		int sumRowCol = 0;
		Scanner scan;
		for (int row = 0; row < j.length; row++)
			for (int col = 0; col < j[row].length; col++) {
				scan = new Scanner(j[row][col].getText());
				sumRow[row] = sumRow[row] + scan.nextInt();

				if (col == j[row].length - 1) {
					textRow[row].setText("" + sumRow[row]);
					sumRowCol = sumRowCol + sumRow[row];
				}
			}
		totalSum.setText(2 * sumRowCol + "");

		for (int col = 0; col < j[0].length; col++)
			for (int row = 0; row < j.length; row++) {
				scan = new Scanner(j[row][col].getText());
				sumCol[col] = sumCol[col] + scan.nextInt();

				if (row == j.length - 1)
					textCol[col].setText("" + sumCol[col]);

			}

	}
}
