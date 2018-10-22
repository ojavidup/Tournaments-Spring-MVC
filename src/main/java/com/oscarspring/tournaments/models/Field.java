package com.oscarspring.tournaments.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="fields")
public class Field {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_field")
	private int id;
	
	@Column(name="field_name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@OneToMany(mappedBy="idField", cascade= {CascadeType.ALL})
	private List<Tournament> tournaments;

	public Field() {
	}

	public Field(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	@Override
	public String toString() {
		return "Field [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
