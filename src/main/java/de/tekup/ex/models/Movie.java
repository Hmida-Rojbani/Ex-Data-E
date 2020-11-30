package de.tekup.ex.models;



import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "movies")
public class Movie {

	@Id
	@Column(length = 50)
	private String title;
	
	private int year;
	
	private LocalTime length;
	
	private byte color;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "studio")
	private Studio studio;
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(name="starsIn", 
	joinColumns = @JoinColumn(name = "movie"),
	inverseJoinColumns = @JoinColumn(name = "star"))
	private List<Star> stars;
}
