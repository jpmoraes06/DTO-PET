package com.usuario.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pet")
public class Pett {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@NotBlank
	@NotNull
	private String nome;


	private String documento;


	@NotBlank
	@NotNull
	private String nascimento;


	@NotBlank
	@NotNull
	private String cuidador;


	public Pett(Long id, @NotBlank @NotNull String nome, @NotBlank @NotNull String nascimento,
			@NotBlank @NotNull String cuidador) {
		super();
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.cuidador = cuidador;
	}








}
