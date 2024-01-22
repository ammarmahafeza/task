package payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class searchData {
	@JsonProperty("placeId")
    String placeId;
	@JsonProperty("checkIn")
	String checkIn;
	@JsonProperty("checkOut")
    String checkOut;
	@JsonProperty("room")
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

		

			public String  getCheckIn() {
				return  checkIn;
			}
			
			public String getCheckOut() {
				return checkOut;
			}



}
