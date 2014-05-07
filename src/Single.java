
public class Single extends Runway{
	
	public void addTakeOff(Aircraft a){
		takeOffQueue.add(a);
	}
	
	public void addLanding(Aircraft a){
		landingQueue.add(a);
	}
	
	public void removeCrashed(Aircraft a){
		landingQueue.remove(a);
	}
	
	public void removeTakeOff(){
		takeOffQueue.poll();
	}
	
	public void removeLanding(){
		landingQueue.poll();
    }
	
	public Aircraft getFirstGround(){
		return takeOffQueue.peek();
	}
	
	public Aircraft getFirstLanding(){
		return landingQueue.peek();
	}
	
	public int getTakeOffSize(){
		return takeOffQueue.size();
	}
	
	public int getLandingSize(){
		return landingQueue.size();
	}
	
	public void clearTakeOff(){
		takeOffQueue.clear();
	}
	
	public void clearLanding(){
		landingQueue.clear();
	}
}

