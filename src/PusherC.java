public class PusherC extends Pusher implements Runnable {

	public PusherC(boolean isMatch, boolean isTobacco, boolean isPaper,
			Semaphore tobacco, Semaphore paper, Semaphore match,
			Semaphore tobaccoSem, Semaphore paperSem, Semaphore matchSem,
			Semaphore mutex) {
		super(isMatch, isTobacco, isPaper, tobacco, paper, match, tobaccoSem,
				paperSem, matchSem, mutex);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void scheduleSmoker() {
		// TODO Auto-generated method stub
		while (true) {
			match.waits();
			mutex.waits();

			if (isPaper) {
				Pusher.isPaper = false;
				tobaccoSem.signals();
			} else if (isTobacco) {
				Pusher.isTobacco = false;
				paperSem.signals();
			} else {
				Pusher.isMatch = true;
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
