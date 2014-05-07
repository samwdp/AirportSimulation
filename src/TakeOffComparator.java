import java.util.Comparator;

public class TakeOffComparator implements Comparator<Aircraft>
{
	
	@Override
	public int compare(Aircraft a1, Aircraft a2) {
		
		if(a1.getStepAdded() < a2.getStepAdded()){
		return -1;}
		else if(a1.getStepAdded() > a2.getStepAdded()){
		return 1;
	}
		else return 0;
	}
}