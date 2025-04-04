package com.br.rocha.entities;

import java.io.Serializable;

import com.br.rocha.enu.SystemType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ROCHA_COMMAND")
public class Command implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String command;
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "`system`")
	private SystemType  system;

	@ManyToOne
	@JoinColumn(name = "tools_id")
	private CommandTools tools;

}
