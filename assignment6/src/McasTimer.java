public class McasTimer {
    
	McasTimerSingleton test;
	
    // Constructor
    public McasTimer(long timeIntervalMs)
    {
    	test = McasTimerSingleton.getInstance();
    }

    public void set()
    {
        McasTimerSingleton x = McasTimerSingleton.getInstance();
        x.setTimerSet();
    }

    public boolean isExpired()
    {
        return test.isExpired;
    }
}
