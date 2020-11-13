package com.helxir.medicheal.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DOC_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Doctor implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doc_id")
	private long id;
	@Column(name = "regId")
	private String regId;
	@NotNull
	@Size(max = 65)
	@Column(name = "first_name")
	private String fName;

	@NotNull
	@Size(max = 65)
	@Column(name = "middle_name")
	private String mName;

	@NotNull
	@Size(max = 65)
	@Column(name = "last_name")
	private String lname;

	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	private Date dob;

	@NotNull
	@Email
	@Size(max = 100)
	@Column(unique = true)
	private String email;

	@Column(name = "phone_number")
	@Size(max = 15)
	private String phone;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Gender gender;
	@OneToMany(mappedBy = "doctor")
	private List<Degree> degrees;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "doctor")
	private Address address;

}
