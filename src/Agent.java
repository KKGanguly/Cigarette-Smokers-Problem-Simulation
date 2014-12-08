
public abstract class Agent {
	protected Semaphore agentSemaphore;
	protected Semaphore tobacco;
	protected Semaphore paper;
	protected Semaphore match;
	public static Semaphore mutex2=new Semaphore(1);
	public Agent(Semaphore agentSemaphore, Semaphore tobacco, Semaphore paper,
			Semaphore match) {
		super();
		this.agentSemaphore = agentSemaphore;
		this.tobacco = tobacco;
		this.paper = paper;
		this.match = match;
	}
	

}
