package com.backend.estoque.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

	// ATRIBUTOS
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O nome do produto é obrigatório.")
	private String nome; 
	
    @NotNull(message = "A quantidade do pedida é obrigatório.")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private int quantidade;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Positive(message = "O valor do produto precisa ser positivo.")
    private BigDecimal valor;
	
	

	// METODOS GET E SET
	
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
	
}
