import java.util.Random;



public class MainSimulation {
	
	private int step = 1;
	private double commercialProbability;
	private static final double LIGHT_PROBABILITY = 0.005;
	private static final double GLIDER_PROBABILITY = 0.002;
	Runway runway = new Single();
	
	public static void main(String[] args) {
          MainSimulation s = new MainSimulation();
          s.simulate();
	}
		
	public void simulate(){
			while(step <= 2880){
				simulateAStep();
			} 
			//populate(runway, 42);
	}
	
	public void simulateAStep(){
	    step++;
	    
	}
	
	public void reset(int seed){
		step = 1;
		runway.clearLanding();
		runway.clearTakeOff();
		populate(runway, seed);
	}
	
	public void populate(Runway runway, int seed){
		Random rand = new Random(seed);
		//int x = 0;
		//while( x < 100){
		if(rand.nextDouble() <= 0.5){
			if(rand.nextDouble() <= commercialProbability){
				Aircraft com = new Commercial(commercialProbability, step);
				
				runway.addTakeOff(com);
			}
			else if(rand.nextDouble() <= LIGHT_PROBABILITY){
				Aircraft light = new Light(step);
				runway.addTakeOff(light);
			}
			else if(rand.nextDouble() <= GLIDER_PROBABILITY){
				Aircraft glider = new Glider(step);
				runway.addTakeOff(glider);
			}
		}
	    else{
			if(rand.nextDouble() <= commercialProbability){
				Aircraft com = new Commercial(commercialProbability, step);
				runway.addLanding(com);
			}
			else if(rand.nextDouble() <= LIGHT_PROBABILITY){
				Aircraft light = new Light(step);
				runway.addLanding(light);
			}
			else if(rand.nextDouble() <= GLIDER_PROBABILITY){
				Aircraft glider = new Glider(step);
				runway.addLanding(glider);
			}
		}
			//x++;
			step++;
		}
	   //Brilliant test 
	   //System.out.println("Landing: " + runway.getLandingSize() + " TakeOff: " + runway.getTakeOffSize());
		//int num1 = runway.getLandingSize();
	    //int num2 = runway.getTakeOffSize();
		//for (int q = 0; q < num1; q++){
		//System.out.println(runway.getFirstLanding().getFuelLevel() + " - > Landing");
		//runway.removeLanding();
		//System.out.println("Landing: " + runway.getLandingSize() + " TakeOff: " + runway.getTakeOffSize());
		//}
		//for (int z = 0; z < num2; z++){
		//System.out.println(runway.getFirstGround().getStepAdded() + " - > TakeOff");
		//runway.removeTakeOff();
		//System.out.println("Landing: " + runway.getLandingSize() + " TakeOff: " + runway.getTakeOffSize());
		//}
		}
