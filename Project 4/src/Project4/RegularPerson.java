package Project4;

public class RegularPerson extends Person{

	@Override
	public void setCashiersTime(int Time) {
		this.cashiersTime = Time;
	}

	@Override
	public void setLeaveTime(int Time) {
		this.leaveTime = Time;
	}

	@Override
	public void setEateryTime(int Time) {
		this.eateryTime = Time;
	}
}