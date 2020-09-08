import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Value extends JFrame{

	private JPanel contentPane;
	DefaultTableModel model;
	
	public Program p = null;
	public  List<String> va = new ArrayList<String>();
	private JTable table;
	Vector<String> columNames = new Vector<String>();
	static Vector<Vector> data = new Vector<Vector>();
	private JButton btnOk;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Value frame = new Value();
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
	public Value() {
		
		for (int i = 0; i < p.variables.size(); i++) {
			Vector<String> s = new Vector<String>();
			s.add(p.variables.get(i));
			s.add("");
			data.add(s);
		}
		
		columNames.add("Variable");
		columNames.add("Value");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterValues = new JLabel("Enter values - Press ENTER before clicking OK");
		lblEnterValues.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterValues.setBounds(0, 0, 434, 33);
		contentPane.add(lblEnterValues);
		
		
		model = new DefaultTableModel(data,columNames);
		model.setDataVector(data, columNames);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 414, 358);
		table = new JTable(model){
			boolean[] columnEditables = new boolean[] {
					false, true
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		table.setBackground(Color.WHITE);
		table.setEnabled(true);
		
		scrollPane.add(table);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		contentPane.add(scrollPane);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Process();
				
				close();
			}
		});
		btnOk.setBounds(149, 401, 135, 24);
		contentPane.add(btnOk);
	}
	public void Process() {
		int rows = table.getRowCount();
		for(int i=0;i<rows;i++) {
			String s = table.getValueAt(i, 1)+"";
			va.add(s);
		}
		p.abc();
		model.setRowCount(0);
	}
	public void close() {
		this.hide();
	}
}
