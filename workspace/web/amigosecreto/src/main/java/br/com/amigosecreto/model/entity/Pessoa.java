package br.com.amigosecreto.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pessoa")
public class Pessoa {

	@Id
	@Column(name="id")
	@SequenceGenerator(name = "seq_pessoa", initialValue = 2)
	@GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="bilhete")
	private String bilhete;
	
	@Column(name="email")
	private String email;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getBilhete() {
		return bilhete;
	}
	public void setBilhete(String bilhete) {
		this.bilhete = bilhete;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
