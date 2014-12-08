import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static ExecutorService application;
	public static boolean control=true;
	public static FileOutputStream fw;
	
	public static BufferedWriter bw;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		try{
			 fw = new FileOutputStream(new File("smokers_log.txt"));
			 bw = new BufferedWriter(new OutputStreamWriter(fw));
		}catch(Exception e){
			
		}
		Semaphore agentSemaphore = new Semaphore(1);
		Semaphore mutex = new Semaphore(1);
		Semaphore tobacco = new Semaphore(0);
		Semaphore paper = new Semaphore(0);
		Semaphore match = new Semaphore(0);
		Semaphore tobaccoSem = new Semaphore(0);
		Semaphore paperSem = new Semaphore(0);
		Semaphore matchSem = new Semaphore(0);
		Boolean isMatch = new Boolean(false);
		Boolean isTobacco = new Boolean(false);
		Boolean isPaper = new Boolean(false);
		
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Interface();
			}
		});
		
		application = Executors.newCachedThreadPool();
		application.execute(new AgentA(agentSemaphore, tobacco, paper, match));
		application.execute(new AgentB(agentSemaphore, tobacco, paper, match));
		application.execute(new AgentC(agentSemaphore, tobacco, paper, match));
		application.execute(new PusherA(isMatch, isTobacco, isPaper, tobacco,
				paper, match, tobaccoSem, paperSem, matchSem, mutex));
		application.execute(new PusherB(isMatch, isTobacco, isPaper, tobacco,
				paper, match, tobaccoSem, paperSem, matchSem, mutex));
		application.execute(new PusherC(isMatch, isTobacco, isPaper, tobacco,
				paper, match, tobaccoSem, paperSem, matchSem, mutex));
		application.execute(new SmokerWithMatch(tobaccoSem, paperSem, matchSem,
				agentSemaphore));
		application.execute(new SmokerWithPaper(tobaccoSem, paperSem, matchSem,
				agentSemaphore));
		application.execute(new SmokerWithTobacco(tobaccoSem, paperSem,
				matchSem, agentSemaphore));
		if (application.awaitTermination(6, TimeUnit.SECONDS)) {
			
		} 
			
		}
		
	}

