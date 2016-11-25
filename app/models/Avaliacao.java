package models;

import play.*;
import play.mvc.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;

public class Avaliacao extends Model {
	private long id;
	private String descricao;
	private String titulo;

	public Avaliacao() {

	}

	public Avaliacao(long id, String descricao, String  titulo) {
		this.id = id;
		this.descricao = descricao;
		this.setTitulo(titulo);
	}

	public Avaliacao(String descricao, String titulo) {
		this.descricao = descricao;
		this.setTitulo(titulo);
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId() {
		return this.id;
	}

	public void setDescricao(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}