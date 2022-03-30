package model;

public class Date {
	
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) {
		
		this.day = day;
		this.month = month;
		this.year = year;
		
	}
	
	public int getDay () {
		
		return this.day;
		
	}
	
	public void setDay() {
		
		this.day=day;
		
	}
	
	public int getMonth() {
		
		return this.day;
		
	}
	
	public void setMonth() {
		
		this.month=month;
		
	}
	
	public int getYear () {
		
		return this.year;
		
	}
	
	public void setYear() {
		
		this.year=year;
		
	}
	
	public String toString() {
		
		String msg = "";
		
		return msg += day+"/"+month+"/"+year;
		
	}
	
}