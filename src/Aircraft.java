
import java.util.Random;

public abstract class Aircraft implements Actor{
	protected Random rand;
	protected Boolean isCrashed;
	protected Boolean isLanding;
	
	public Aircraft(){
		rand = new Random();
		isCrashed = false;
		isLanding = false;
	}
	
	/**
	 * abstract method to get the landing state of an aircraft
	 * @return isLanding
	 */
	public Boolean isLanding(){
		return isLanding;
	}
	
	/**
	 * method to return the crashed state of the aircraft
	 * @return isCrashed
	 */
	public Boolean isCrashed(){
		return isCrashed;
	}
	
	/**
	 * 
	 */
	public void setLanding(){
		isLanding = true;
	}
	
	public abstract int getFuelLevel();
	public abstract double getProbability();
	public abstract void act(Runway runway, int time);
	public abstract int getStepAdded();
	public abstract void setTime(int time);
	public abstract String getName();
	public abstract String getLandIdentifier();
	public abstract String getCrashIdentifier();
}
