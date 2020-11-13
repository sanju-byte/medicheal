package com.helxir.medicheal.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DEG_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Degree implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String deg;
	private String passingYear;
	@ManyToOne
	@JoinColumn(name = "doc_id", nullable = false)
	private Doctor doctor;

}
