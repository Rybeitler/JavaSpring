package com.codingdojo.burgerTracker.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="burgers")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="Burger name cannot be blank")
    private String name;
    @NotBlank(message="Restaurant cannot be blank")
    private String restaurant;
    @NotNull(message="Must have a rating")
    @Min(1)
    @Max(5)
    private Integer rating;
    @NotBlank(message="Please write a note")
    @Size(min=2, max=255, message="Note should be between 2 and 255 characters")
    private String notes;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Burger() {
    	
    }
    
	public Burger(Long id, @NotBlank(message = "Burger name cannot be blank") String name,
			@NotBlank(message = "Restaurant cannot be blank") String restaurant,
			@NotNull(message = "Must have a rating") @Size(min = 1, max = 5, message = "Rating must be between 1 and 5") Integer rating,
			@NotBlank(message = "Please write a note") @Size(min = 2, max = 255, message = "Note should be between 2 and 255 characters") String notes) {
		super();
		this.id = id;
		this.name = name;
		this.restaurant = restaurant;
		this.rating = rating;
		this.notes = notes;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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
        this.updatedAt = new Date();//fills column on creation
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
