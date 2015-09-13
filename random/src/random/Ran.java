package random;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Ran extends JFrame {
	JFrame d;;
	JPanel panel;
	JButton l;
	JLabel label;

	public Ran() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		d = new JFrame("Ëæ»ú³éÈ¡Ñ§ºÅ");
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d.setSize(400, 110);
		panel = new JPanel();

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize(); 
		Dimension framesize = d.getSize(); 
		int x = (int) screensize.getWidth() / 2 - (int) framesize.getWidth() / 2; 
		int y = (int) screensize.getHeight() / 2 - (int) framesize.getHeight() / 2;
		d.setLocation(x, y);
		Font font =new Font("", Font.PLAIN, 30);
		
		l = new JButton("click!");
		l.setFont(font);
		label = new JLabel();
//		label.setBounds(100, 100, 100, 50);
		l.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String text = Ran.getRanNumber() + "";
				
				label.setFont(font);
			
				label.setText(text);
				
			}
		});
		panel.add(l);
		panel.add(label);
		d.add(panel);
		d.setVisible(true);
	}

	public static int getRanNumber() {
		int ran = (int) (Math.random() * 217) + 1;
		return ran;
	}

	public static void main(String[] args) {

		Ran ran = new Ran();

	}

}
