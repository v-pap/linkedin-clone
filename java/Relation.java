public class Relation {
	private int status;
	private Professional professional1;
	private Professional professional2;

	public Relation() {
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Professional getProfessional1() {
		return this.professional1;
	}

	public void setProfessional1(Professional professional1) {
		this.professional1 = professional1;
	}

	public Professional getProfessional2() {
		return this.professional2;
	}

	public void setProfessional2(Professional professional2) {
		this.professional2 = professional2;
	}

}