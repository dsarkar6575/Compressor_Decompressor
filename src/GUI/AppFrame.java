package GUI;

import java.awt.Color;
import java.awt.event.*;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import comp_decomp.compressor;
import comp_decomp.decompressor;

public class AppFrame extends JFrame implements ActionListener  {

	JButton compressButton;
	JButton deCompressButton;
	 AppFrame()
	{
		
		
	    compressButton=new JButton("Select file to Compress");
		compressButton.setBounds(20,100,200,30);
		compressButton.addActionListener(this);
		
		
		deCompressButton=new JButton("Select file to DeCompress");
		deCompressButton.setBounds(250, 100, 200, 30);
		deCompressButton.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(1000, 500);
		this.getContentPane().setBackground(Color.green);
		this.setVisible(true);
		this.add(compressButton);
		this.add(deCompressButton);
		 
	}
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
	    	if(e.getSource()==compressButton)
	    	{
	    		JFileChooser fileChooser=new JFileChooser();
	    		int response=fileChooser.showSaveDialog(null);
	    		if(response==JFileChooser.APPROVE_OPTION) {
	    			File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
	    			System.out.print(file);
	    			try {
	    				compressor.method(file);
	    			}catch(Exception ee)
	    			{
	    				JOptionPane.showMessageDialog(null,ee.toString());
	    			}
	    		}
	    	}
	    	
	    	if(e.getSource()==deCompressButton)
	    	{
	    		JFileChooser fileChooser=new JFileChooser();
	    		int response=fileChooser.showSaveDialog(null);
	    		if(response==JFileChooser.APPROVE_OPTION) {
	    			File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
	    			System.out.print(file);
	    			try {
	    				decompressor.method(file);
	    			}catch(Exception ee)
	    			{
	    				JOptionPane.showMessageDialog(null,ee.toString());
	    			}
	    		}
	    	}
	    }
}