package Project4;

public class LimitedTimePerson extends Person{
	
	@Override
	public void setCashiersTime(int Time) {
		// TODO Auto-generated method stub
		this.cashiersTime = Time;
	}

	@Override
	public void setLeaveTime(int Time) {
		// TODO Auto-generated method stub
		this.leaveTime = (int) (Time*0.5);
	}

	@Override
	public void setEateryTime(int Time) {
		// TODO Auto-generated method stub
		this.eateryTime = (int) (Time*0.5);
	}
}
