
public interface Actor {
	
	/**
	 * Abstract method to get the state of the aircraft
	 * @return isCrashed
	 */
	public abstract Boolean isCrashed();
	public abstract void act(Runway runway, int time);
}
