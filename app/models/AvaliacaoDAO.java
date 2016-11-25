package models;

import models.Avaliacao;

import com.avaje.ebean.Model;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;

import java.util.List;

public class AvaliacaoDAO extends Model {

    public static Model.Finder<Long, Avaliacao> find = new Model.Finder<>(Avaliacao.class);

    public AvaliacaoDAO() {

    }

    public static List<Avaliacao> findAll() {
        return find.findList();
    }

    public static Avaliacao findById(long id) {
        return find.byId(id);
    }



}
