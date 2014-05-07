

public class Glider extends Aircraft{
	private static final Double PROBABILITY = 0.002;
	private int fuelLevel;
	private int time;
	private String name;
	private String landing;
	private String crash;
	
	public Glider(int time){
		super();
		fuelLevel = 100;
		name = "Glider";
		landing = "Glider Landing";
		crash = "Glider crash";
		setTime(time);
	}

	/**
	 * 
	 * @return
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLandIdentifier(){
		return landing;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCrashIdentifier(){
		return crash;
	}
	
	/**
	 * returns the state of the aircraft
	 * @return isCrashed
	 */
	public Boolean isCrashed() {
		return isCrashed;
	}

	/**
	 * returns the landing state of the aircraft
	 * @return isLanding
	 */
	public Boolean isLanding() {
		return isLanding;
	}

	/**
	 * returns the probability that the aircraft will occur
	 * @return PROBABILITY
	 */
	@Override
	public double getProbability(){
		return PROBABILITY;
	}
	
	/**
	 * 
	 */
	public void setLanding(){
		isLanding = true;
	}
	
	/**
	 * 
	 */
	@Override
	public int getFuelLevel() {
		return fuelLevel;
	}

	/**
	 * 
	 */
	@Override
    public int getStepAdded() {
		return time;
	}
	
	/**
	 * 
	 */
	public void setTime(int time){
		this.time = time;
	}
	
	/**
	 * 
	 */
	public void act(Runway runway, int step) {
		Aircraft a = new Glider(step);
		if(isLanding == true){
			a = runway.getFirstLanding();
			runway.removeLanding();
			runway.addTakeOff(a);
		}
		if (isLanding == false && runway.getLandingSize() == 0){
			runway.removeTakeOff();
		}
	}
}