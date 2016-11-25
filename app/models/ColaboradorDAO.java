package models;

import models.Colaborador;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.avaje.ebean.Model;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;

public class ColaboradorDAO extends Model {

	public ColaboradorDAO() {

    }

    public static Model.Finder<Long, Colaborador> find = new Model.Finder<>(Colaborador.class);

    public static List<Colaborador> findAll() {
        return find.findList();
    }

    public static Colaborador findById(long id){
        return find.byId(id);
    }


}