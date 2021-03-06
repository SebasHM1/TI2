package model; 

public class Event {
	
	private Date eventDate; 
	private String hostName;
	private double value;
	private String description;
	private EventType eventType;
	private String wetlandID;
	
	public Event (String hostName, double value, String description, int year, int month, int day, int eventType, String wetlandID) {
		
		this.eventDate = new Date (day, month, year);
		this.hostName = hostName;
		this.value = value;
		this.description = description;
		this.wetlandID = wetlandID;
		
		switch (eventType) {
		
		case 1: 
			
			this.eventType = EventType.MAINTENANCE;
			break;
			
		case 2: 
			
			this.eventType = EventType.SCHOOL_VISITORS;
			break;
			
		case 3: 
			
			this.eventType = EventType.UPGRADINGS;
			break;
		
		case 4: 
			
			this.eventType = EventType.CELEBRATIONS;
			break;	
		}
		
	}
	
	public String getWetlandID() {
		return wetlandID;
	}

	public void setWetlandID(String wetlandID) {
		this.wetlandID = wetlandID;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(int day, int month, int year) {
		this.eventDate = new Date (day, month, year);
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return "Event Host name: " + hostName + " Date: " + eventDate + ", value: " + value + " description: " + description + " Event type: " + eventType
		+ " wetland ID: " + wetlandID;
	}
	
	
	
}