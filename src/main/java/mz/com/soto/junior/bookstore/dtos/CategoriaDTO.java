package mz.com.soto.junior.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import mz.com.soto.junior.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Campo Nome eh requerido")
	@Length(min = 3, max = 100, message = "O Campo NOME deve conter entre tres 3 e cem 100 caracteres")
	private String nome;
	
	@NotEmpty(message = "Campo Descricao eh requerido")
	@Length(min = 3, max = 200, message = "O Campo DESCRICAO deve conter entre tres 3 e cem 200 caracteres")
	private String descricao;
	
	public CategoriaDTO() {
		
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
