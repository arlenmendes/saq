package controllers;

import javax.inject.Inject;

import java.util.Calendar;

import models.Avaliacao;
import play.*;
import play.mvc.*;
import play.libs.Json;
import play.db.*;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Created by arlen on 23/11/16.
 */
public class AvaliacaoController extends Controller {
    private Database db;

    @Inject
    public AvaliacaoController(Database db) {
        this.db = db;
    }

    public Result create() {

        Avaliacao avaliacao = Json.fromJson(request().body().asJson(), Avaliacao.class);
//        Calendar c = new Calendar();
//        return ok(c.getTime());
//        JsonNode json = request().body().asJson();


//        Avaliacao avaliacao = new Avaliacao(json.get("descricao").asText(), json.get("titulo").asText());
//        avaliacao.save();

        return ok(Json.toJson(request().body().asJson()));
    }
}