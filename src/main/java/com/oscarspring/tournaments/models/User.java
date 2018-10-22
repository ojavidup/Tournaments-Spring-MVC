package com.oscarspring.tournaments.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enable", insertable=false)
	//@NotNull
	private Integer enable;
	
	@OneToMany(mappedBy="idUser", cascade= {CascadeType.ALL})
	private List<Tournament> tournaments;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_authority")
	private Authority idAuthority;

	public User() {
	
	}

	public User(int id, String name, String email, String password, Integer enable, List<Tournament> tournaments,
			Authority idAuthority) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.enable = enable;
//		this.tournaments = tournaments;
		this.idAuthority = idAuthority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public Authority getIdAuthority() {
		return idAuthority;
	}

	public void setIdAuthority(Authority idAuthority) {
		this.idAuthority = idAuthority;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", enable="
				+ enable + "]";
	}
	
}
