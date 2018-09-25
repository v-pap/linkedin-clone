public class Skill {
	private SkillPK id;
	private Professional professional;

	public Skill() {
	}

	public SkillPK getId() {
		return this.id;
	}

	public void setId(SkillPK id) {
		this.id = id;
	}

	public Professional getProfessional() {
		return this.professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

}