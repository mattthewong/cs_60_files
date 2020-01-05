//login(s): eu6
public class ClaremontStudent {
	public enum School {
		CGU, CMC, HMC, KECK_GRAD_INST, PITZER, POMONA, SCRIPPS;
	}

	private School mySchool;
	private String myName;
	//the constructor never modified this, the variables mySchool and myName
	//in the ClaremontStudent class were never modified. Changed "School" to "this".
	public ClaremontStudent(School inputSchool, String name) {
		this.myName = name;
		this.mySchool = inputSchool;
	}

	public String getName() {
		return this.myName;
		}
	//to fix this code, I added specific cheers to each school, then filled in the breaks that were needed to
	//separate the colleges.
	public String cheer() {
		String myCheer = "";
		switch (this.mySchool) {
		case CGU:
			myCheer = "Yay CGU!";
			break;
		case KECK_GRAD_INST:
			myCheer = "Yay Keck Graduate Institute of Applied Life Sciences!";
			break;
		case CMC:
			myCheer = "Go Stags and Athenas!";
			break;
		case HMC:
			myCheer = "Go Stags and Athenas!";
			break;
		case SCRIPPS:
			myCheer = "Go Stags and Athenas!";
			break;
		case PITZER:
			myCheer = "Go Sagehens!";
			break;
		case POMONA:
			myCheer = "Go Sagehens!";
			break;
		}
		return myCheer;
	}
	//I used print statements and found that the if statement wasn't being accessed.
	//for this reason, I assumed it had somthing to do with the ==, changing it to .equals.
	//this worked.
	public boolean equals(Object obj){
		if (obj instanceof ClaremontStudent) {
			ClaremontStudent student2 = (ClaremontStudent) obj;
			if (this.myName.equals(student2.myName)) {
				return this.mySchool == student2.mySchool;
			}
		}
		return false;
	}
}