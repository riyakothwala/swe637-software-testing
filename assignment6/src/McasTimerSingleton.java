
public class McasTimerSingleton {
	// Static variable reference of timerInstance of type McasTimerSingleton
	private static McasTimerSingleton timerInstance = null;
	
	public String s;
	public boolean timerSet;
	public boolean isExpired;
	
	private McasTimerSingleton() {
		s = "Hello I am a String part of McasTimerSingleton class";
	}
	
	public void resetTimerSet() {
		this.timerSet = false;
	}
	
	public void setTimerSet() {
		this.timerSet = true;
	}
	
	public void resetIsExpired() {
		this.isExpired = false;
	}
	
	public void setIsExpired() {
		this.isExpired = true;
	}
	
	// Static method to create instance of McasTimerSingleton class
	public static McasTimerSingleton getInstance() {
		if (timerInstance == null) timerInstance = new McasTimerSingleton();
		
		return timerInstance;
	}
}
