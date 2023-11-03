package com.codingdojo.exam.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="teams")
public class Team {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message="Team Name is required!")
    private String name;
	
	@Min(value=1, message="Minimum value is 1")
	@Max(value=5, message="Maximum value is 5")
	private Long skilllvl;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
    @NotNull(message="Due Date is required!")
    @Future(message="Due Date must be in the future!")
    private Date gameday;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User creator;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "users_teams",
			joinColumns = @JoinColumn(name = "team_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
	)
    private List<User> users;
    
    @Column(updatable=false)
    @OneToMany(mappedBy="team", fetch = FetchType.LAZY)
    private List<Player> players;
    
    public Team() {}
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
	public Long getSkilllvl() {
		return skilllvl;
	}
	public void setSkilllvl(Long skilllvl) {
		this.skilllvl = skilllvl;
	}
	public Date getGameday() {
		return gameday;
	}
	public void setGameday(Date gameday) {
		this.gameday = gameday;
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
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	 public boolean isFull() {
	        return players.size() >= 9;
	    }
    
    
}
