package com.backend.estoque.model;

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
	
	
    @NotNull(message = "A quantidade do pedida é obrigatório.")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private int quantidade;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Positive(message = "O valor do produto precisa ser positivo.")
    private Double valor_uni;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Positive()
    private Double valor_total;
	

	// METODOS GET E SET
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor_uni() {
        return valor_uni;
    }

    public void setValor_uni(Double valor_uni) {
        this.valor_uni = valor_uni;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_uni * quantidade;
    } 
	
}
