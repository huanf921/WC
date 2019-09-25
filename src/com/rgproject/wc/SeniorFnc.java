package com.rgproject.wc;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.WindowConstants;
import javax.swing.JCheckBox;

public class SeniorFnc extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeniorFnc frame = new SeniorFnc();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeniorFnc() {
		
		
		setTitle("WordCount.exe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(142, 0, 450, 366);
		textArea.setFont(new Font("Serif",0,20));
		contentPane.add(textArea);
		
		JFileChooser jf = new JFileChooser();
		
		JCheckBox checkBox = new JCheckBox("\u5B57\u7B26\u6570");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WordCount.checkBox0 = true;
			}
		});
		checkBox.setBounds(-1, 24, 133, 27);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("\u8BCD\u6570");
		checkBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WordCount.checkBox1 = true;
			}
		});
		checkBox_1.setBounds(-1, 102, 133, 27);
		contentPane.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("\u884C\u6570");
		checkBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WordCount.checkBox2 = true;
			}
		});
		checkBox_2.setBounds(-1, 186, 133, 27);
		contentPane.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("\u7279\u6B8A\u884C\u6570");
		checkBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WordCount.checkBox3 = true;
			}
		});
		checkBox_3.setBounds(-1, 260, 133, 27);
		contentPane.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("\u5168\u90E8\u7EDF\u8BA1");
		checkBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WordCount.checkBox4 = true;
			}
		});
		checkBox_4.setBounds(-1, 339, 133, 27);
		contentPane.add(checkBox_4);
		
		JButton button = new JButton("\u9009\u62E9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int returnVal = jf.showOpenDialog(contentPane);
				
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = jf.getSelectedFile();
                    textArea.setText("选择文件:" + file.getPath());
                    
                    if(WordCount.checkBox4) {
                    	new BasicFnc("-c",file);
                    	textArea.append("\n字符数："+WordCount.cnum);
                    	new BasicFnc("-w",file);
                    	textArea.append("\n词数："+WordCount.wnum);
                    	new BasicFnc("-l",file);
                    	textArea.append("\n行数："+WordCount.lnum);
                    	new ExtendFnc("-a",file);
                    	textArea.append("\n空行数："+WordCount.bknum);
                    	textArea.append("\n代码行数："+WordCount.cdnum);
                    	textArea.append("\n注释行数："+WordCount.annum);
                    	
                    	System.out.println("-------------------------------");
                    }else {
                    	if(WordCount.checkBox0) {
                    		new BasicFnc("-c",file);
                    		textArea.append("\n字符数："+WordCount.cnum);
                    	}
                    	if(WordCount.checkBox1) {
                    		new BasicFnc("-w",file);
                    		textArea.append("\n词数："+WordCount.wnum);
                    	}
                    	if(WordCount.checkBox2) {
                    		new BasicFnc("-l",file);
                    		textArea.append("\n行数："+WordCount.lnum);
                    	}
                    	if(WordCount.checkBox3) {
                    		new ExtendFnc("-a",file);
                    		textArea.append("\n空行数："+WordCount.bknum);
                    		textArea.append("\n代码行数："+WordCount.cdnum);
                        	textArea.append("\n注释行数："+WordCount.annum);
                    	}
                    	
                    	System.out.println("-------------------------------");
                    }
                    
                } else {
                    textArea.setText("用户取消打开文件");
                }

			}
		});
		button.setBounds(465, 403, 113, 27);
		contentPane.add(button);
		
		
	}
}
