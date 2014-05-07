import java.util.PriorityQueue;
import java.util.Comparator; 

public abstract class Runway {
	Comparator<Aircraft> takeOffComparator = new TakeOffComparator();
	Comparator<Aircraft> landingComparator = new LandingComparator();
	protected PriorityQueue<Aircraft> takeOffQueue = new PriorityQueue<Aircraft>(10, takeOffComparator);
	protected PriorityQueue<Aircraft> landingQueue = new PriorityQueue<Aircraft>(10, landingComparator);
	
	public Runway(){
		
	}
	
	public abstract void addTakeOff(Aircraft a);
	
	public abstract void addLanding(Aircraft a);
	
	public abstract void removeTakeOff();
	
	public abstract void removeLanding();
	
	public abstract Aircraft getFirstGround();
	
	public abstract Aircraft getFirstLanding();
	
	public abstract int getTakeOffSize();
	
	public abstract int getLandingSize();
	
	public abstract void clearTakeOff();
	
	public abstract void clearLanding();
}
