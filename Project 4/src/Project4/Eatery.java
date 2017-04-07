package Project4;

public class Eatery {
	
	private int averageWaitTime;
	private int maxQWaitTime;
	private int maxPeopleInQ;
	
	private CIS163Q eateryQ;	
	
	public void addToEateryQ(Person person){
		eateryQ.enQ(person);
	}
	
	public int removeFromEateryQ(){
		
		try{
			eateryQ.deQ();
		}catch (EmptyQException ex){
			return 0;
		}
		return 0;
	}
	
	
}


