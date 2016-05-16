package br.com.biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.Table;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String tipo;
	private String status;
	private String especial;
	
	

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String string) {
		this.status = string;
	}
	public String getEspecial() {
		return especial;
	}
	public void setEspecial(String especial) {
		this.especial = especial;
	}
}
