package br.com.music.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.rest.core.annotation.RestResource;

import lombok.Data;


@Audited
@AuditTable(value="album_audit")
@Data
@Entity
@Table
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String title;

	@Column
	private String author;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "productor_id", nullable = false)
	@RestResource(exported = false)
	private Productor productor;

	@Column(name = "dt_create", nullable = false)
	private String dateCreate;
}
