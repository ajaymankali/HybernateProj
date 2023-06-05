package cgginterns.hybernate.map2;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Emp {
		@Id
		@Column(name="e_id")
		private int eId;
		@Column(name="e_name")
		private String eName;
		@ManyToMany(mappedBy="employes")
		private List<Project> projects;
		public Emp(int eId, String eName) {
			super();
			this.eId = eId;
			this.eName = eName;
		}
		public Emp() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int geteId() {
			return eId;
		}
		public void seteId(int eId) {
			this.eId = eId;
		}
		public String geteName() {
			return eName;
		}
		public void seteName(String eName) {
			this.eName = eName;
		}
		public List<Project> getProjects() {
			return projects;
		}
		public void setProjects(List<Project> projects) {
			this.projects = projects;
		}
		
	
		
}
