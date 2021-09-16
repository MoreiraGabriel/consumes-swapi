package com.sw.api.starwars.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "planet")
@Entity(name = "planet")
public class Planet implements Serializable {

	private static final long serialVersionUID = -5519121338682044204L;
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", updatable = false, length = 50)
	private String id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "climate", nullable = false)
	private String climate;
	
	@Column(name = "terrain", nullable = false)
	private String terrain;
	
	@Column(name = "num_films", nullable = false)
	private Integer numFilms;

}
