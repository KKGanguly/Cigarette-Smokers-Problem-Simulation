import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Interface {
	public static JFrame frame = new JFrame();
	public static JButton label = new JButton();
	public static JButton label1 = new JButton();
	public static JButton label2 = new JButton();
	public static JLabel fig1 = new JLabel();
	public static JLabel fig2 = new JLabel();
	public static JLabel fig3 = new JLabel();
	public static JLabel imageLabel1 = new JLabel(new ImageIcon("tobacco.png"));
	public static JLabel imageLabel2 = new JLabel(new ImageIcon("paper.png"));
	public static JLabel imageLabel3 = new JLabel(new ImageIcon("match.png"));
	private JButton exit;

	public Interface() {
		frame.setLayout(null);
		frame.setSize(450, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		exit = new JButton("Stop");
		exit.setBounds(300, 40, 90, 30);
		label.setBounds(10, 300, 135, 50);
		label1.setBounds(150, 300, 125, 50);
		label2.setBounds(280, 300, 120, 50);
		label.setText("Tobacco");
		label1.setText("Paper");
		label2.setText("Match");
		imageLabel1.setBounds(50, 100, 100, 80);
		imageLabel2.setBounds(170, 100, 100, 80);
		imageLabel3.setBounds(290, 100, 100, 80);
		fig1.setBounds(70, 170, 70, 70);
		fig2.setBounds(190, 170, 70, 70);
		fig3.setBounds(310, 170, 70, 70);
		frame.add(imageLabel1);
		frame.add(imageLabel2);
		frame.add(imageLabel3);
		frame.add(label);
		frame.add(label1);
		frame.add(label2);
		frame.add(fig1);
		frame.add(fig2);
		frame.add(fig3);
		frame.add(exit);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == exit) {
					Main.control = false;
					Main.application.shutdown();
					
						Interface.fig3.setText("Sleeping");
						Interface.fig2.setText("Sleeping");
						Interface.fig1.setText("Sleeping");
						try{
							Main.bw.close();
						}catch(Exception e1){
							
						}

				}
			}
		});
	}
}
