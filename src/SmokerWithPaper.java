import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;

public class SmokerWithPaper extends Smoker implements Runnable {

	public SmokerWithPaper(Semaphore tobaccoSem, Semaphore paperSem,
			Semaphore matchSem, Semaphore agentSemaphore) {
		super(tobaccoSem, paperSem, matchSem, agentSemaphore);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (Main.control) {
			paperSem.waits();
			makeCigarette();

			Interface.imageLabel1.setIcon(new ImageIcon("tobacco.png"));
			Interface.imageLabel2.setIcon(new ImageIcon("paper.png"));
			Interface.imageLabel3.setIcon(new ImageIcon("match.png"));
			Interface.frame.validate();
			Agent.mutex2.signals();
			agentSemaphore.signals();
		}
	}

	@Override
	public void makeCigarette() {
		// TODO Auto-generated method stub

		if (Main.control) {
			try {
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				Main.bw.write("Smoker with paper making cigarette "+dateFormat.format(date));
				Main.bw.newLine();
				Main.bw.flush();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Interface.imageLabel2.setIcon(new ImageIcon("smoker.png"));

			Interface.fig2.setText("Smoking");
			Interface.fig1.setText("Sleeping");
			Interface.fig3.setText("Sleeping");
			Interface.frame.validate();
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block

		}
	}

}
