package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class WindowsApplicationCalculator {

	private JFrame frmCalculator;
	private JTextField textFieldNUmber1;
	private JTextField textFieldNumber2;
	private JButton btnADD;
	private JLabel lblResult;
	private JTextField textField_Result;
	private JButton btnReset;
	private JButton btnSub;
	private JButton btnMul;
	private JButton btnDiv;
	private JButton btnMod;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowsApplicationCalculator window = new WindowsApplicationCalculator();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowsApplicationCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setTitle("CALCULATOR");
		frmCalculator.getContentPane().setEnabled(false);
		frmCalculator.getContentPane().setLayout(null);
		
		JLabel lblNUmber1 = new JLabel("Enter First Number :");
		lblNUmber1.setFont(new Font("Consolas", Font.BOLD, 14));
		lblNUmber1.setBounds(10, 65, 171, 13);
		frmCalculator.getContentPane().add(lblNUmber1);
		
		JLabel lblEnterSecondNumber = new JLabel("Enter Second Number :");
		lblEnterSecondNumber.setFont(new Font("Consolas", Font.BOLD, 14));
		lblEnterSecondNumber.setBounds(10, 99, 171, 13);
		frmCalculator.getContentPane().add(lblEnterSecondNumber);
		
		textFieldNUmber1 = new JTextField();
		textFieldNUmber1.setBounds(199, 60, 163, 19);
		frmCalculator.getContentPane().add(textFieldNUmber1);
		textFieldNUmber1.setColumns(10);
		
		textFieldNumber2 = new JTextField();
		textFieldNumber2.setColumns(10);
		textFieldNumber2.setBounds(199, 94, 163, 19);
		frmCalculator.getContentPane().add(textFieldNumber2);
		
		btnADD = new JButton("ADD");
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int n1, n2, result;
				
				try
				{
					n1 = Integer.parseInt(textFieldNUmber1.getText());
					n2 = Integer.parseInt(textFieldNumber2.getText());
					
					result = n1 + n2;
					textField_Result.setText(Integer.toString(result));
					
					
				}
				catch(Exception ex)
				{
					//ex.getMessage();
					JOptionPane.showMessageDialog(null,"PLaese enter  a valid number-Must be a digit");
					textFieldNUmber1.setText(null);
					textFieldNumber2.setText("");
					textFieldNUmber1.requestFocus();
					
				}
				
				
				

			}
		});
		btnADD.setBounds(10, 217, 75, 31);
		frmCalculator.getContentPane().add(btnADD);
		
		lblResult = new JLabel("Result :");
		lblResult.setFont(new Font("Consolas", Font.BOLD, 14));
		lblResult.setBounds(10, 154, 137, 13);
		frmCalculator.getContentPane().add(lblResult);
		
		textField_Result = new JTextField();
		textField_Result.setColumns(10);
		textField_Result.setBounds(89, 149, 163, 19);
		frmCalculator.getContentPane().add(textField_Result);
		
		btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNUmber1.setText(null);
				textFieldNumber2.setText("");
				textFieldNUmber1.requestFocus();
				textField_Result.setText(null);
			}
		});
		btnReset.setBounds(316, 272, 82, 31);
		frmCalculator.getContentPane().add(btnReset);
		
		btnSub = new JButton("SUB");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int n1, n2, result;
				
				try
				{
					n1 = Integer.parseInt(textFieldNUmber1.getText());
					n2 = Integer.parseInt(textFieldNumber2.getText());
					
					result = n1 - n2;
					textField_Result.setText(Integer.toString(result));
					
					
				}
				catch(Exception ex)
				{
					//ex.getMessage();
					JOptionPane.showMessageDialog(null,"PLaese enter  a valid number-Must be a digit");
					textFieldNUmber1.setText(null);
					textFieldNumber2.setText("");
					textFieldNUmber1.requestFocus();
					
				}
			}
		});
		btnSub.setBounds(10, 272, 75, 31);
		frmCalculator.getContentPane().add(btnSub);
		
		btnMul = new JButton("MUL");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int n1, n2, result;
				
				try
				{
					n1 = Integer.parseInt(textFieldNUmber1.getText());
					n2 = Integer.parseInt(textFieldNumber2.getText());
					
					result = n1 * n2;
					textField_Result.setText(Integer.toString(result));
					
					
				}
				catch(Exception ex)
				{
					//ex.getMessage();
					JOptionPane.showMessageDialog(null,"PLaese enter  a valid number-Must be a digit");
					textFieldNUmber1.setText(null);
					textFieldNumber2.setText("");
					textFieldNUmber1.requestFocus();
					
				}
			}
		});
		btnMul.setBounds(162, 217, 75, 31);
		frmCalculator.getContentPane().add(btnMul);
		
		btnDiv = new JButton("DIV");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int n1, n2, result;
				
				try
				{
					n1 = Integer.parseInt(textFieldNUmber1.getText());
					n2 = Integer.parseInt(textFieldNumber2.getText());
					
					result = n1 / n2;
					textField_Result.setText(Integer.toString(result));
					
					
				}
				catch(Exception ex)
				{
					//ex.getMessage();
					JOptionPane.showMessageDialog(null,"PLaese enter  a valid number-Must be a digit");
					textFieldNUmber1.setText(null);
					textFieldNumber2.setText("");
					textFieldNUmber1.requestFocus();
					
				}
			}
		});
		btnDiv.setBounds(162, 272, 75, 31);
		frmCalculator.getContentPane().add(btnDiv);
		
		btnMod = new JButton("MOD");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int n1, n2, result;
				
				try
				{
					n1 = Integer.parseInt(textFieldNUmber1.getText());
					n2 = Integer.parseInt(textFieldNumber2.getText());
					
					result = n1 % n2;
					textField_Result.setText(Integer.toString(result));
					
					
				}
				catch(Exception ex)
				{
					//ex.getMessage();
					JOptionPane.showMessageDialog(null,"PLaese enter  a valid number-Must be a digit");
					textFieldNUmber1.setText(null);
					textFieldNumber2.setText("");
					textFieldNUmber1.requestFocus();
					
				}
			}
		});
		btnMod.setBounds(316, 217, 82, 31);
		frmCalculator.getContentPane().add(btnMod);
		
		lblNewLabel = new JLabel("Calculator V1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(183, 11, 82, 31);
		frmCalculator.getContentPane().add(lblNewLabel);
		frmCalculator.setBounds(100, 100, 476, 423);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
