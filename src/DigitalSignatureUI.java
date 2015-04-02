import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class DigitalSignatureUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ConnectionImpl();
					ConnectionImpl.koneksi();
					DigitalSignatureUI frame = new DigitalSignatureUI();
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
	public DigitalSignatureUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Generate Digital Signature");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			       	}
		});
		
		JButton btnNewButton_1 = new JButton("Choose File");
		btnNewButton_1.addActionListener(new ActionListener() {
			private XWPFWordExtractor xw;
			public void actionPerformed(ActionEvent arg0) {
	                JFileChooser openFile = new JFileChooser();
	                FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                        ".doc & .docx", "doc", "docx");
	                    openFile.setFileFilter(filter);
	                    int returnVal = openFile.showOpenDialog(btnNewButton_1);
	                    if(returnVal == JFileChooser.APPROVE_OPTION) {
	                       System.out.println("You choose to open this file: " +
	                    	openFile.getSelectedFile().getName());
	                    }
	                    String saveFile = openFile.getSelectedFile().getAbsolutePath();
	                    FileInputStream fs;
				        File file = new File(saveFile);
				        try {	
							fs = new FileInputStream(file);
							OPCPackage d = OPCPackage.open(fs);
							xw = new XWPFWordExtractor(d);
							/*
							String insert123 = xw.getText();
							PreparedStatement ps = null;
							String insertTableSQL = "INSERT INTO digsin_source"
									+ "(Source) VALUES"
									+ "(?)";
					 
							 try {
								ps = (PreparedStatement) ConnectionImpl.connection.prepareStatement(insertTableSQL);
								ps.setString(1, insert123);
								
								// execute insert SQL stetement
								ps.executeUpdate();
								System.out.println("Record is inserted into table!");
							} catch (SQLException e) {
								System.out.println(e.getMessage());
							}
							*/
							System.out.println(xw.getText());   
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvalidFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (XmlException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (OpenXML4JException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblSenderName = new JLabel("Sender Name");
		
		JLabel lblCompany = new JLabel("Company");
		
		JLabel lblReceiver = new JLabel("Receiver");
		
		JLabel lblEmail = new JLabel("E-mail");
		
		JLabel label = new JLabel(":");
		
		JLabel label_1 = new JLabel(":");
		
		JLabel label_2 = new JLabel(":");
		
		JLabel label_3 = new JLabel(":");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(43, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSenderName)
						.addComponent(lblReceiver)
						.addComponent(lblCompany)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
						.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
						.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textField_3, Alignment.LEADING)
						.addComponent(textField_2, Alignment.LEADING)
						.addComponent(textField_1, Alignment.LEADING)
						.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
					.addGap(37))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(94)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenderName)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCompany)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblReceiver)
						.addComponent(label_3))
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
