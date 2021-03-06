package model;

public class Fauna {
	
	private String specieName;
	private String cientificName; 
	private boolean mig;
	private FaunaType faunaType;
	private String wetlandID;
	
	public Fauna (String specieName, String cientificName, boolean mig, int faunaType, String wetlandID) {
		
		this.specieName = specieName;
		this.cientificName = cientificName;
		this.mig = mig;
		this.wetlandID = wetlandID;
		switch (faunaType) {
	
		case 1: 
			
			this.faunaType = FaunaType.BIRD;
			break;
			
		case 2: 
			
			this.faunaType = FaunaType.MAMAL;
			break;
			
		case 3: 
			
			this.faunaType = FaunaType.ACUATIC;
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

	public FaunaType getFaunaType() {
		return faunaType;
	}

	public void setFaunaType(FaunaType faunaType) {
		this.faunaType = faunaType;
	}

	@Override
	public String toString() {
		
		String migShow = "";
		if (mig == true) {
			
			migShow = "Yes";
			
		} else if (mig == false) {
			
			migShow = "No";
			
		}
		
		return "Animal: Specie Name: " + specieName + ", cientific name: " + cientificName + ", migration: " + migShow + ", faunaType: "
				+ faunaType + ", wetland ID: " + wetlandID;
	}
	
	

}
