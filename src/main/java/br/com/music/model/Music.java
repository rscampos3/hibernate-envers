package br.com.music.model;

import java.io.Serializable;

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

import lombok.Data;

@Audited
@AuditTable(value="music_audit")
@Entity
@Table
@Data
public class Music implements Serializable {

	private static final long serialVersionUID = -5325982288524566779L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "time_duration", nullable = false)
    private Double timeDuration;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

}