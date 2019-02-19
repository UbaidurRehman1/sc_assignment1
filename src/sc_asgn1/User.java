package sc_asgn1;


public class User
{
	private int numberOfDays;
	private RoomType roomType;
	private String name;
	private String birthday;
	private long CNIC;
	private String cnicPhotocopy;
	private int rating;
	
	
	public int getNumberOfDays() {
		return numberOfDays;
	}
	
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public long getCNIC() {
		return CNIC;
	}
	public void setCNIC(long cNIC) {
		CNIC = cNIC;
	}
	public String getCnicPhotocopy() {
		return cnicPhotocopy;
	}
	public void setCnicPhotocopy(String cnicPhotocopy) {
		this.cnicPhotocopy = cnicPhotocopy;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "User [numberOfDays=" + numberOfDays + ", roomType=" + roomType + ", name=" + name + ", birthday="
				+ birthday + ", CNIC=" + CNIC + ", cnicPhotocopy=" + cnicPhotocopy + ", rating=" + rating + "]";
	}

	public User(int numberOfDays, RoomType roomType, String name, String birthday, long cNIC, String cnicPhotocopy,
			int rating) {
		super();
		this.numberOfDays = numberOfDays;
		this.roomType = roomType;
		this.name = name;
		this.birthday = birthday;
		CNIC = cNIC;
		this.cnicPhotocopy = cnicPhotocopy;
		this.rating = rating;
	}
	
	

}
