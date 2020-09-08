import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Program extends JFrame {

	private JPanel contentPane;
	private JTextField txtEvaluation;
	private JTextField txtPostfix;
	private JTextField txtValue;
	private String inFix="";
	public static List<String> variables = new ArrayList<String>();
	private boolean flat=false;
	public static boolean isDone = true;
	public Value v;

	InfixToPostfix a = new InfixToPostfix();
	PostfixToInfix b = new PostfixToInfix();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program frame = new Program();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Program() {
		setTitle("Caculator-Written By VuHuyLoc");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEvaluation = new JTextField();
		txtEvaluation.setToolTipText("Just type: A B C D E F  a b c d e f 0 1 2 3 4 5 6 7 8 9 + - * / % ^ ! ( )");
		txtEvaluation.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent e) {
				if(checkkey(e)) {
					String s = e.getKeyChar()+"";
					s=s.toUpperCase();
					inFix=txtEvaluation.getText()+s;
					if (s.equals("A")|| s.equals("B")||s.equals("C")||s.equals("D")||s.equals("E")||s.equals("F")|| 
							s.equals("a")|| s.equals("b")||s.equals("c")||s.equals("d")||s.equals("e")||s.equals("f")) {
						variables.add(s);
						flat=true;
					}
				}
        	}
		});
				
		txtEvaluation.setForeground(new Color(50, 205, 50));
		txtEvaluation.setBackground(Color.DARK_GRAY);
		txtEvaluation.setHorizontalAlignment(SwingConstants.CENTER);
		txtEvaluation.setFont(new Font("DialogInput", Font.BOLD, 20));
		txtEvaluation.setText(inFix);
		txtEvaluation.setBounds(10, 25, 522, 54);
		contentPane.add(txtEvaluation);
		txtEvaluation.setColumns(10);
		
		JLabel lblPostfix = new JLabel("Postfix");
		lblPostfix.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPostfix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPostfix.setBounds(10, 93, 122, 54);
		contentPane.add(lblPostfix);
		
		txtPostfix = new JTextField();
		txtPostfix.setBackground(Color.DARK_GRAY);
		txtPostfix.setForeground(new Color(50, 205, 50));
		txtPostfix.setFont(new Font("DialogInput", Font.BOLD, 18));
		txtPostfix.setHorizontalAlignment(SwingConstants.CENTER);
		txtPostfix.setEditable(false);
		txtPostfix.setBounds(126, 90, 406, 62);
		contentPane.add(txtPostfix);
		txtPostfix.setColumns(10);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblValue.setBounds(10, 166, 122, 54);
		contentPane.add(lblValue);
		
		txtValue = new JTextField();
		txtValue.setBackground(Color.DARK_GRAY);
		txtValue.setFont(new Font("DialogInput", Font.BOLD, 18));
		txtValue.setForeground(new Color(50, 205, 50));
		txtValue.setHorizontalAlignment(SwingConstants.CENTER);
		txtValue.setEditable(false);
		txtValue.setColumns(10);
		txtValue.setBounds(126, 163, 406, 62);
		contentPane.add(txtValue);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="7";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btn7.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btn7.setBounds(66, 284, 47, 41);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="8";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btn8.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btn8.setBounds(123, 284, 47, 41);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="9";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btn9.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btn9.setBounds(180, 284, 47, 41);
		contentPane.add(btn9);
		
		JButton btnok = new JButton("OK");
		btnok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Process();
			}
		});
		btnok.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btnok.setBounds(404, 231, 96, 127);
		contentPane.add(btnok);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="4";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btn4.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btn4.setBounds(66, 336, 47, 41);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="5";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btn5.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btn5.setBounds(123, 336, 47, 41);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="6";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btn6.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btn6.setBounds(180, 336, 47, 41);
		contentPane.add(btn6);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="1";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btn1.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btn1.setBounds(66, 388, 47, 41);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="2";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btn2.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btn2.setBounds(123, 388, 47, 41);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="3";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btn3.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btn3.setBounds(180, 388, 47, 41);
		contentPane.add(btn3);
		
		JButton btnmn = new JButton("(");
		btnmn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="(";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btnmn.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btnmn.setBounds(294, 388, 47, 93);
		contentPane.add(btnmn);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="0";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btn0.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btn0.setBounds(66, 440, 75, 41);
		contentPane.add(btn0);
		
		JButton btndn = new JButton(")");
		btndn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+=")";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btndn.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btndn.setBounds(347, 388, 47, 93);
		contentPane.add(btndn);
		
		JButton btnch = new JButton(":");
		btnch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="/";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btnch.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btnch.setBounds(237, 284, 47, 41);
		contentPane.add(btnch);
		
		JButton btnn = new JButton("x");
		btnn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="*";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btnn.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btnn.setBounds(237, 336, 47, 41);
		contentPane.add(btnn);
		
		JButton btnt = new JButton("-");
		btnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="-";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btnt.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btnt.setBounds(237, 388, 47, 41);
		contentPane.add(btnt);
		
		JButton btnc = new JButton("+");
		btnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="+";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btnc.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btnc.setBounds(237, 440, 47, 41);
		contentPane.add(btnc);
		
		JButton btnDel = new JButton("del");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix=inFix.substring(0, inFix.length()-1);
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btnDel.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btnDel.setBounds(151, 440, 76, 41);
		contentPane.add(btnDel);
		
		JButton button_4 = new JButton("^");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="^";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		button_4.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		button_4.setBounds(294, 336, 47, 41);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("!");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="!";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		button_5.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		button_5.setBounds(347, 336, 47, 41);
		contentPane.add(button_5);
		
		JButton btnMod = new JButton("Mod");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="%";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
			}
		});
		btnMod.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btnMod.setBounds(295, 284, 99, 41);
		contentPane.add(btnMod);
		
		JLabel lblCodingByHuyloc = new JLabel("Coding by HuyLoc_ver1.1.0");
		lblCodingByHuyloc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodingByHuyloc.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 12));
		lblCodingByHuyloc.setBounds(180, 511, 352, 18);
		contentPane.add(lblCodingByHuyloc);
		
		JButton btnA = new JButton("A");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="A";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
				variables.add("A");
				flat=true;
			}
		});
		btnA.setForeground(Color.BLUE);
		btnA.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btnA.setBounds(66, 231, 47, 41);
		contentPane.add(btnA);
		
		JButton btnB = new JButton("B");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="B";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
				variables.add("B");
				flat=true;
			}
		});
		btnB.setForeground(Color.BLUE);
		btnB.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btnB.setBounds(123, 231, 47, 41);
		contentPane.add(btnB);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="C";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
				variables.add("C");
				flat=true;
			}
		});
		btnC.setForeground(Color.BLUE);
		btnC.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btnC.setBounds(180, 231, 47, 41);
		contentPane.add(btnC);
		
		JButton btnD = new JButton("D");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="D";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
				variables.add("D");
				flat=true;
			}
		});
		btnD.setForeground(Color.BLUE);
		btnD.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btnD.setBounds(237, 231, 47, 41);
		contentPane.add(btnD);
		
		JButton btnE = new JButton("E");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="E";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
				variables.add("E");
				flat=true;
			}
		});
		btnE.setForeground(Color.BLUE);
		btnE.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btnE.setBounds(294, 231, 47, 41);
		contentPane.add(btnE);
		
		JButton btnF = new JButton("F");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inFix+="F";
				txtEvaluation.setText(inFix);
				contentPane.updateUI();
				variables.add("F");
				flat=true;
			}
		});
		btnF.setForeground(Color.BLUE);
		btnF.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btnF.setBounds(347, 231, 47, 41);
		contentPane.add(btnF);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEvaluation.setText("");
			}
		});
		btnClear.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		btnClear.setBounds(404, 365, 96, 116);
		contentPane.add(btnClear);
	}
	public boolean checkkey(KeyEvent e) {
		char key = e.getKeyChar();
        if (key!='A'&& key!='B'&&key!='C'&&key!='D'&&key!='E'&&key!='F'&& key!='a'&& key!='b'&&key!='c'&&key!='d'&&key!='e'&&key!='f'&&
				key!='0'&&key!='1'&&key!='2'&&key!='3'&&key!='4'&&key!='5'&&key!='6'&&key!='7'&&key!='8'&&key!='9'&&
				key!='+'&&key!='-'&&key!='*'&&key!='/'&&key!='%'&&key!='^'&&
				key!='!'&&key!='('&&key!=')') {
        	JOptionPane.showMessageDialog(null, "Only numbers and letters from a-f and + - * / % ^ ! ( )");
            e.consume();
            return false;
        }
        return true;
	}
	public void Process() {
		
		
		
		if (flat) {
			CreateArray(variables);
			v = new Value();
			v.p = this;
			v.show();
			
		}
		else {
			String postFix=a.infixToPostfix(inFix);
			int value=b.evaluatePostfix(postFix);
			txtPostfix.setText(postFix);
			txtValue.setText(value+"");
			contentPane.updateUI();
			inFix="";
			
		}
	
	}
	public void abc() {
		String postFix=a.infixToPostfix(inFix);
		txtPostfix.setText(postFix);
		postFix=b.replaceValue(postFix, variables, v.va);
		if(v.va.size()>0)
		{
			postFix=b.replaceValue(postFix, variables, v.va);
			int value=b.evaluatePostfix(postFix);
			txtValue.setText(value+"");
			contentPane.updateUI();
			inFix="";
			flat=false;
			variables.removeAll(variables);
			v.va.removeAll(v.va);
		}
	}
	public void CreateArray(List<String> arrListNumber) {
		ArrayList<String> arrTemp = new ArrayList<>();
	    for (int i = 0; i < arrListNumber.size(); i++) {
	        if (!arrTemp.contains(arrListNumber.get(i))) {
	            arrTemp.add(arrListNumber.get(i));
	        }
	    }
	    arrListNumber.clear();
	    arrListNumber.addAll(arrTemp);
	}
}
