package org.ncu.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fName;
	private String lName;
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail", referencedColumnName = "instructorId")
	private InstructorDetail instructorDetail;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "instructor")
	//@JoinColumn(name = "courses" , referencedColumnName = "cid")
	private List<Course> courses;
	
	public Instructor() {
		// default constructor
	}
	
	public Instructor(String fName, String lName, String email) {
		super();
		//this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
	}
	
	
	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}


	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + "]";
	}
	
	/* added convenience method to sync the bi-directional relationship */ 
	
	  public void addCourses(Course course) 
	  { if (courses == null) { 
		  courses = new ArrayList<>(); 
		  } 
	  courses.add(course); 
	  course.setInstructor(this); }
	
}
