
public class Counter {

	private Integer count;
	private String name;

	public Counter(String name){
	
		this.name = name;
		count = 0;
	}
	
	
	public String getName(){
		return name;
	}
	
	
	public Integer getCount(){
		return count;
	}
	
	
	public void increment(){
		count++;
	
	}
	
	
	public void reset(){
		count = 0;
	}
}
