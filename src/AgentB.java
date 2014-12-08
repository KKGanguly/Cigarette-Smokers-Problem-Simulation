import java.awt.Color;

import javax.swing.JLabel;

public class AgentB extends Agent implements Runnable {

	public AgentB(Semaphore agentSemaphore, Semaphore tobacco, Semaphore paper,
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
			if (Main.control){
			Interface.label2.setBackground(Color.red);
			;
			Interface.frame.validate();
			Interface.frame.repaint();
			Interface.label1.setBackground(Color.red);
			;
			Interface.frame.validate();
			Interface.frame.repaint();
			}
			match.signals();

			paper.signals();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block

			}
			
			Interface.label1.setBackground(Color.white);
			Interface.label2.setBackground(Color.white);
			Interface.frame.validate();
			Interface.frame.repaint();

		}

	}

}
