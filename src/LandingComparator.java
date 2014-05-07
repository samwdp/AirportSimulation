import java.util.Comparator;

public class LandingComparator implements Comparator<Aircraft>
{
	
	@Override
	public int compare(Aircraft a1, Aircraft a2) {
		
		if(a1.getFuelLevel() < a2.getFuelLevel()){
		return -1;}
		else if(a1.getFuelLevel() > a2.getFuelLevel()){
		return 1;
	}
		else return 0;
	}
}