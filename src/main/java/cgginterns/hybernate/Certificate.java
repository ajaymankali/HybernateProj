package cgginterns.hybernate;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	private String duration1;
	private String course;
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuration() {
		return duration1;
	}
	public void setDuration(String duration) {
		this.duration1 = duration;
	}
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Certificate [course=" + course + ", duration=" + duration1 + "]";
	}
	public Certificate(String course, String duration) {
		super();
		this.course = course;
		this.duration1 = duration;
	}
//	private String duration;
}
