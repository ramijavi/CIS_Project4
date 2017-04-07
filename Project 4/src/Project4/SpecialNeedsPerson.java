package Project4;

public class SpecialNeedsPerson extends Person{

	@Override
	public void setCashiersTime(int Time) {
		// TODO Auto-generated method stub
		this.cashiersTime = Time*2;
	}

	@Override
	public void setLeaveTime(int Time) {
		// TODO Auto-generated method stub
		this.leaveTime = Time*3;
	}

	@Override
	public void setEateryTime(int Time) {
		// TODO Auto-generated method stub
		this.eateryTime = Time*4;
	}
}