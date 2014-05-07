
import java.util.HashMap;
import java.util.Iterator;


public class AirportStats {
		private HashMap<Aircraft, Counter> counters;	
		private boolean countsValid;
			
		public AirportStats(){
			counters = new HashMap<Aircraft, Counter>();
			countsValid = true;
		}
			
		/**
		 * 
		 */
		public void reset(){
			countsValid = false;
			Iterator<Aircraft> keys = counters.keySet().iterator();
			while(keys.hasNext()) {
				Counter cnt = counters.get(keys.next());
				cnt.reset();
			}
		}
		
		/**
		 * 
		 * @param aircraft
		 * @return
		 */
		public String getPlaneStatistics(Aircraft aircraft)
		{
			Runway runway = new Single();
			aircraft = runway.getFirstLanding();
			if(aircraft.getLandIdentifier() == "Commercial landing"){
				incrementLandCommercial(aircraft);
			}
			else if(aircraft.getLandIdentifier() == "Light landing"){
				incrementLandLight(aircraft);
			}
			else if(aircraft.getLandIdentifier() == "Glider landing"){
				incrementLandGlider(aircraft);
			}
			
			if(aircraft.getCrashIdentifier() == "Commercial crash"){
				incrementCrashCommercial(aircraft);
			}
			else if(aircraft.getCrashIdentifier() == "Light crash"){
				incrementCrashLight(aircraft);
			}
			else if(aircraft.getCrashIdentifier() == "Glider crash"){
				incrementCrashGlider(aircraft);
			}
			StringBuffer buffer = new StringBuffer();
			if(!countsValid) {
				generateLandGliderCount(aircraft);
			}
			Iterator<Aircraft> keys = counters.keySet().iterator();
			while(keys.hasNext()) {
				Counter info = counters.get(keys.next());
				buffer.append(info.getName());
				buffer.append(": ");
				buffer.append(info.getCount());
				buffer.append(' ');
			}
			return buffer.toString();
		}
		
		
		/**
		 * 
		 * @param glider
		 */
		public void incrementLandGlider(Aircraft glider)
		{
			Counter count = counters.get(glider);
			
			if(count == null && glider.isLanding() == true) {
				
				count = new Counter(glider.getLandIdentifier());
				counters.put(glider, count);
			}
			count.increment();
		}
		
		/**
		 * 
		 * @param commercial
		 */
		public void incrementLandCommercial(Aircraft commercial)
		{
			Counter count = counters.get(commercial);
			
			if(count == null && commercial.isLanding() == true) {
				
				count = new Counter(commercial.getLandIdentifier());
				counters.put(commercial, count);
			}
			count.increment();
		}
		
		/**
		 * 
		 * @param light
		 */
		public void incrementLandLight(Aircraft light)
		{
			Counter count = counters.get(light);
			
			if(count == null && light.isLanding() == true) {
				
				count = new Counter(light.getLandIdentifier());
				counters.put(light, count);
			}
			count.increment();
		}
		
		/**
		 * 
		 * @param commercial
		 */
		public void incrementCrashCommercial(Aircraft commercial)
		{
			Counter count = counters.get(commercial);
			
			if(count == null && commercial.isCrashed() == true) {
				
				count = new Counter(commercial.getCrashIdentifier());
				counters.put(commercial, count);
			}
			count.increment();
		}
		
		/**
		 * 
		 * @param light
		 */
		public void incrementCrashLight(Aircraft light)
		{
			Counter count = counters.get(light);
			
			if(count == null && light.isCrashed() == true) {
				
				count = new Counter(light.getCrashIdentifier());
				counters.put(light, count);
			}
			count.increment();
		}
		
		/**
		 * 
		 * @param glider
		 */
		public void incrementCrashGlider(Aircraft glider)
		{
			Counter count = counters.get(glider);
			
			if(count == null && glider.isCrashed() == true) {
				
				count = new Counter(glider.getCrashIdentifier());
				counters.put(glider, count);
			}
			count.increment();
		}
		
		/**
		 * 
		 */
		public void countFinished()
		{
			countsValid = true;
		}
		
		/**
		 * 
		 * @param light
		 */
		private void generateLandLightCount(Aircraft light)
		{
			if(light.isLanding() == true){
				incrementLandLight(light);
			}
		}
		
		/**
		 * 
		 * @param commercial
		 */
		private void generateLandCommmercialCount(Aircraft commercial)
		{
			if(commercial.isLanding() == true){
				incrementLandCommercial(commercial);
			}
		}
		
		/**
		 * 
		 * @param glider
		 */
		private void generateLandGliderCount(Aircraft glider)
		{
			if(glider.isLanding() == true){
				incrementLandGlider(glider);
			}
		}
		
		/**
		 * 
		 * @param commercial
		 */
		private void generateCrashCommmercialCount(Aircraft commercial)
		{
			if(commercial.isCrashed() == true){
				incrementCrashCommercial(commercial);
			}
		}
		
		/**
		 * 
		 * @param light
		 */
		private void generateCrashLightCount(Aircraft light)
		{
			if(light.isCrashed() == true){
				incrementCrashLight(light);
			}
		}
}	