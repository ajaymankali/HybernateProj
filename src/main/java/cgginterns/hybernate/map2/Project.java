package cgginterns.hybernate.map2;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	@Column(name = "project_id")
	private int pId;
	@Column(name = "project_name")
	private String pName;
	@ManyToMany
	@JoinTable(name="pro_emp",joinColumns={@JoinColumn(name="eid")},inverseJoinColumns= {@JoinColumn(name="ename")})
	private List<Emp> employes;

	public Project(int pId, String pName) {
		super();
		this.pId = pId;
		this.pName = pName;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public List<Emp> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Emp> employes) {
		this.employes = employes;
	}

}
