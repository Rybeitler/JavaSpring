package com.codingdojo.projectManager.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min=2, max=255, message="First name must be 2 to 255 characters.")
	private String firstName;
	@NotBlank
	@Size(min=2, max=255, message="Last name must be 2 to 255 characters.")
	private String lastName;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Size(min=8, max=128, message="password must be 8 to 128 characters")
	private String password;
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	@OneToMany(mappedBy="lead", fetch=FetchType.LAZY)
	private List<Project> projectsLead;
    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Task> tasks;
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    		name="users_projects",
    		joinColumns = @JoinColumn(name="user_id"),
    		inverseJoinColumns = @JoinColumn(name="project_id")
    )
    private List<Project>projects;
    
	public User() {}
	
    public User(
			@NotBlank @Size(min = 2, max = 255, message = "User name must be 2 to 255 characters.") String firstName,
			@NotBlank @Size(min = 2, max = 255, message = "User name must be 2 to 255 characters.") String lastName,
			@NotBlank @Email String email,
			@NotBlank @Size(min = 8, max = 128, message = "password must be 8 to 128 characters") String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}



	public List<Project> getProjectsLead() {
		return projectsLead;
	}

	public void setProjectsLead(List<Project> projectsLead) {
		this.projectsLead = projectsLead;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}