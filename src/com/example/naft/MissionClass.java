package com.example.naft;

public class MissionClass {
	private String Staffname="";
	private String Placename="";
	private String start_date_mission="";
	private String end_date_mission="";
	private int duration_missions=0;
	
	public MissionClass(String name ,String place, String start , String end , int duration){
		this.Staffname=name;
		this.Placename=place;
		this.start_date_mission=start;
		this.end_date_mission=end;
		this.duration_missions=duration;
	}
	
	public MissionClass(String name ,String place, String start ){
		this.Staffname=name;
		this.Placename=place;
		this.start_date_mission=start;
		this.end_date_mission="";
		this.duration_missions=0;
	}
	
	public MissionClass(String name ,String place, String start , String end ){
		this.Staffname=name;
		this.Placename=place;
		this.start_date_mission=start;
		this.end_date_mission=end;
		this.duration_missions=0;
	}

	public String getStaffname() {
		return Staffname;
	}

	public String getPlacename() {
		return Placename;
	}

	public void setPlacename(String placename) {
		Placename = placename;
	}

	public void setStaffname(String staffname) {
		Staffname = staffname;
	}

	public String getStart_date_mission() {
		return start_date_mission;
	}

	public void setStart_date_mission(String start_date_mission) {
		this.start_date_mission = start_date_mission;
	}

	public String getEnd_date_mission() {
		return end_date_mission;
	}

	public void setEnd_date_mission(String end_date_mission) {
		this.end_date_mission = end_date_mission;
	}

	public int getDuration_missions() {
		return duration_missions;
	}

	public void setDuration_missions(int duration_missions) {
		this.duration_missions = duration_missions;
	}

}
