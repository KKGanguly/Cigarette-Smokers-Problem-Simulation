public abstract class Pusher {
	protected static boolean isMatch;
	protected static boolean isTobacco;
	protected static boolean isPaper;
	protected Semaphore tobacco;
	protected Semaphore paper;
	protected Semaphore match;
	protected Semaphore tobaccoSem;
	protected Semaphore paperSem;
	protected Semaphore matchSem;
	protected Semaphore mutex;
	
	public Pusher(boolean isMatch, boolean isTobacco, boolean isPaper,
			Semaphore tobacco, Semaphore paper, Semaphore match,
			Semaphore tobaccoSem, Semaphore paperSem, Semaphore matchSem,
			Semaphore mutex) {
		super();
		
		this.tobacco = tobacco;
		this.paper = paper;
		this.match = match;
		this.tobaccoSem = tobaccoSem;
		this.paperSem = paperSem;
		this.matchSem = matchSem;
		this.mutex = mutex;
	}

	public abstract void scheduleSmoker();

}
