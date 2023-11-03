package com.codingdojo.Burger.models;




import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="burgers")
public class Burger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "Burger name must not be blank.")
	@Size(min=5, max=200, message = "Burger name must be between 5 and 200.")
	private String burgername;
	
	@NotNull(message = "Restaurnat name must not be blank.")
	@Size(min=5, max=200, message = "Restaurnat name must be between 5 and 200.")
	private String resname;
	
	@NotNull(message = "Rating must not be blank.")
	@Min(value=1, message = "Rating must not be between 1-5.")
	@Max(value=5, message = "Rating must not be between 1-5.")
	private Integer rating;
	
	@NotNull
	@Size(max=1000)
	@Column(columnDefinition="TEXT")
	private String notes;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Burger() {
    }
    public Burger(String burgername,String resname,Integer rating,String notes) {
    	this.burgername=burgername;
    	this.resname=resname;
    	this.rating=rating;
    	this.notes=notes;
}
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBurgername() {
		return burgername;
	}
	public void setBurgername(String burgername) {
		this.burgername = burgername;
	}
	public String getResname() {
		return resname;
	}
	public void setResname(String resname) {
		this.resname = resname;
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
    
}
