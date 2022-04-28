
public class McasTimer {
	long ms;
	
	McasTimer(long time) {
		this.ms = time;
	}
	
	public void set(){}
	
	public boolean isExpired() {
		return false;
	}
}
