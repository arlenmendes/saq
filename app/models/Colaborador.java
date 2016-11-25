package models;

import play.mvc.*;
import play.db.*;

import play.api.db.DB;

import java.util.List;
import javax.persistence.*;

import com.avaje.ebean.Model;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;

@Entity
public class Colaborador extends Model {

    @Id private long id;
    @Basic private String nome;
    @Basic private String email;
    @Basic private boolean possuiFoto;

    public Colaborador() {

    }

    public Colaborador(long id, String nome, String email, Boolean foto) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.possuiFoto = foto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean getPossuiFoto() {
        return possuiFoto;
    }

    public void setPossuiFoto(boolean possuiFoto) {
        this.possuiFoto = possuiFoto;
    }
}