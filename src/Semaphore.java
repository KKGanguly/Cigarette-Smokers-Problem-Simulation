public class Semaphore {
	public volatile int initial;
	private static int lock=1;
	public Semaphore(int initial) {
		this.initial = initial;
	}
	public void waits(){
		while(initial<=0){
			
		};
		if(initial>0)initial--;
	}
	public  void signals(){
		initial++;

	}
}
