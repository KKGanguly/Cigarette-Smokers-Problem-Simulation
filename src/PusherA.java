
public class PusherA extends Pusher implements Runnable{

	

	public PusherA(boolean isMatch, boolean isTobacco, boolean isPaper,
			Semaphore tobacco, Semaphore paper, Semaphore match,
			Semaphore tobaccoSem, Semaphore paperSem, Semaphore matchSem,
			Semaphore mutex) {
		super(isMatch, isTobacco, isPaper, tobacco, paper, match, tobaccoSem, paperSem,
				matchSem, mutex);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void scheduleSmoker() {
		// TODO Auto-generated method stub
		while(true){
		tobacco.waits();
		mutex.waits();
		if(isPaper){
			Pusher.isPaper=false;
			matchSem.signals();
			
		}
		else if(isMatch){
			Pusher.isMatch=false;
			paperSem.signals();
		}
		else {
			Pusher.isTobacco=true;
			
		}
		
		mutex.signals();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		scheduleSmoker();
	}

}
