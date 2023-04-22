package com.unicesumar.ordemDeServicoDigital.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unicesumar.ordemDeServicoDigital.entities.enums.StatusSolicitacao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Solicitacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer statusSolicitacao;
	

	@ManyToOne
	@JoinColumn(name = "solicitante_id")
	private User solicitante;

	public Solicitacao() {
	}

	public Solicitacao(Long id, Instant moment, StatusSolicitacao statusSolicitacao, User solicitante) {
		super();
		this.id = id;
		this.moment = moment;
		setStatusSolicitacao(statusSolicitacao);
		this.solicitante = solicitante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	

	public StatusSolicitacao getStatusSolicitacao() {
		return StatusSolicitacao.valueOf(statusSolicitacao);
	}

	public void setStatusSolicitacao(StatusSolicitacao statusSolicitacao) {
		if(statusSolicitacao != null) {
			this.statusSolicitacao = statusSolicitacao.getCode();
		}
	}

	public User getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(User solicitante) {
		this.solicitante = solicitante;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solicitacao other = (Solicitacao) obj;
		return Objects.equals(id, other.id);
	}

}
