package model;

public class Flora {
	
	private String specieName;
	private String cientificName; 
	private boolean mig;
	private FloraType floraType;
	private String wetlandID;
	
	public Flora (String specieName, String cientificName, boolean mig, int floraType, String wetlandID) {
		
		this.specieName = specieName;
		this.cientificName = cientificName;
		this.mig = mig;
		this.wetlandID = wetlandID;
		switch (floraType) {
	
		case 1: 
			
			this.floraType = FloraType.ACUATIC;
			break;
			
		case 2: 
			
			this.floraType = FloraType.GROUND;
			break;
		
		}
		
	}
	
	public String getWetlandID() {
		return wetlandID;
	}

	public void setWetlandID(String wetlandID) {
		this.wetlandID = wetlandID;
	}

	
	public String getSpecieName() {
		return specieName;
	}

	public void setSpecieName(String specieName) {
		this.specieName = specieName;
	}

	public String getCientificName() {
		return cientificName;
	}

	public void setCientificName(String cientificName) {
		this.cientificName = cientificName;
	}

	public boolean isMig() {
		return mig;
	}

	public void setMig(boolean mig) {
		this.mig = mig;
	}

	public FloraType getFloraType() {
		return floraType;
	}

	public void setFloraType(FloraType floraType) {
		this.floraType = floraType;
	}

	@Override
	public String toString() {
		String migShow = "";
		if (mig == true) {
			
			migShow = "Yes";
			
		} else if (mig == false) {
			
			migShow = "No";
			
		}
		return "Species: Name" + specieName + ", cientific name: " + cientificName + ", migration: " + migShow + " Type: "
				+ floraType + ", wetland ID:" + wetlandID;
	}
	
	

}
