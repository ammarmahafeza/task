package payload;

import java.util.Random;

public class searchData {

	String identifier;
	String method;
    String placeId;
    String checkIn;
    String checkOut;
    String token ;
String room;
 public void setPlaceID(String placeId) {
	this.placeId = placeId;
}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	
	public void setRoom(String room) {
		this.room = room;
	}

	public String getToken() {
	return token;
}

	 public void setToken(String token) {
			this.token = token;
		}
			public String getidentifier() {
				return identifier;
			}
			public void setidentifier(String identifier) {
				this.identifier = identifier;
			}
			public String getmethod() {
				return method;
			}
			public void setmethod(String method) {
				this.method = method;
			}




}
