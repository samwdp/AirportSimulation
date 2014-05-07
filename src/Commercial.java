import java.util.Random;

public class Commercial extends Aircraft{
	private Double probability;
	private int fuelTotal;
	private int time;
	private String name;
	private String landing;
	private String crash;
	private int totalWait;

	public Commercial(Double probability, int time){
		super();
		this.probability = probability;
		name = "Commercial";
		landing = "Commercial landing";
		crash = "Commercial crash";
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
	 * returns the crashed state
	 * @return isCrashed
	 */
	public Boolean isCrashed() {	
		return isCrashed;
	}
	
	/**
	 * returns the landing state
	 * @return isLanding
	 */
	public Boolean isLanding(){
		return isLanding;
	}

	/**
	 * sets the fuel level
	 */
	public void setFuelLevel() {
		Random rand = new Random();
		fuelTotal = rand.nextInt(40) + 40;
	}

	/**
	 * returns the probability that the aircraft will occur
	 * @return probability
	 */
	@Override
	public double getProbability() {
		return probability;
	}

	/**
	 * Returns the total fuel level
	 * @return fuelTotal
	 */
	@Override
	public int getFuelLevel() {
		return fuelTotal;
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
	 * @param a
	 * @param currentStep
	 */
	public void calculateWaitingTime(Aircraft a, int currentStep){
		totalWait = currentStep - a.getStepAdded();
	}
	
	/**
	 * 
	 * @return
	 */
	public int getTotalWait(){
		return totalWait;
	}

	/**
	 * 
	 */
	public void act(Runway runway, int step) {
		Aircraft a = new Commercial(probability, step);
		if(isLanding == true){
			a = runway.getFirstLanding();
			runway.removeLanding();
			runway.addTakeOff(a);
			calculateWaitingTime(a, step);
			
			
		}else{
			fuelTotal--;
		}
		if (isLanding == false && runway.getLandingSize() == 0){
			runway.removeTakeOff();
			fuelTotal = 80;
			calculateWaitingTime(a, step);
		}
		if(fuelTotal <= 0){
			isCrashed = true;
			runway.removeLanding();
			calculateWaitingTime(a, step);
		}
	}
}