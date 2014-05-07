import java.util.Random;

public class Light extends Aircraft{
	private static final Double PROBABILITY = 0.005;
	private int fuelTotal;
	private int time;
	private String name;
	private String landing;
	private String crash;
	
	public Light(int time){
		super();
		name = "Light";
		landing  = "Light Landing";
		crash = "Light crash";
		setFuelLevel();
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
	 * Gets the crashed state of the aircraft
	 * @return isCrashed
	 */
	public Boolean isCrashed() {
		return isCrashed;
	}

	/**
	 * Gets the landing state of the aircraft
	 * @return isLanding 
	 */

	public Boolean isLanding() {
		return isLanding;
	}

	/**
	 * Calculates the amount of fuel the aircraft has
	 */
	public void setFuelLevel() {
		Random rand = new Random();
		fuelTotal = rand.nextInt(40) + 20;
	}

	/**
	 * Returns the probability that the aircraft will occur
	 * @return PROBABILITY
	 */
	@Override
	public double getProbability() {
		return PROBABILITY;
	}

	/**
	 * Returns the total fuel
	 * @return totalFuel
	 */
	@Override
	public int getFuelLevel() {
		return fuelTotal;
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
	@Override
	public void act(Runway runway, int step) {
		Aircraft a = new Light(step);
		if(isLanding == true){
			a = runway.getFirstLanding();
			runway.removeLanding();
			runway.addTakeOff(a);
		}else{
			fuelTotal--;
		}
		if (isLanding == false && runway.getLandingSize() == 0){
			runway.removeTakeOff();
			fuelTotal = 60;
		}
		if(fuelTotal <= 0){
			isCrashed = true;
			runway.removeLanding();
		}
	}
}