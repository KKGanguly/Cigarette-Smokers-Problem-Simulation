import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AgentA extends Agent implements Runnable {
	public AgentA(Semaphore agentSemaphore, Semaphore tobacco, Semaphore paper,
			Semaphore match) {
		super(agentSemaphore, tobacco, paper, match);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (Main.control) {
			agentSemaphore.waits();
			mutex2.waits();
			try {	
				if (Main.control){
				Interface.label.setBackground(Color.red);
				Interface.frame.validate();
				Interface.frame.repaint();
				Interface.label1.setBackground(Color.red);
				Interface.frame.validate();
				Interface.frame.repaint();
				tobacco.signals();
				}
				paper.signals();
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
			}
			;
			Interface.label.setBackground(Color.white);
			Interface.label1.setBackground(Color.white);
			Interface.frame.validate();
			Interface.frame.repaint();
			
			

		}

	}

}
