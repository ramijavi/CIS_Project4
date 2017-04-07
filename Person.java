package Project4;


public abstract class Person {
	protected int cashiersTime;
	protected int leaveTime;
	protected int eateryTime;
	protected int totalTime;
	protected int cashiersQTime;
	protected int currentTimeInQ;
	protected Eatery destination;
	
	public abstract void setCashiersTime (int Time);
	public abstract void setLeaveTime (int Time);
	public abstract void setEateryTime (int Time);

}
