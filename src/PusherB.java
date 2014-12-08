public class PusherB extends Pusher implements Runnable {

	public PusherB(boolean isMatch, boolean isTobacco, boolean isPaper,
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

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			paper.waits();

			mutex.waits();

			if (isTobacco) {
				Pusher.isTobacco = false;
				matchSem.signals();

			} else if (isMatch) {
				Pusher.isMatch = false;
				tobaccoSem.signals();
			} else {
				Pusher.isPaper = true;

			}
			mutex.signals();
		}
	}
}
