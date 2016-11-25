package controllers;

import models.ColaboradorDAO;
import play.*;
import play.mvc.*;
import views.html.*;
import models.Colaborador;
import play.libs.Json;
import java.util.List;

import com.fasterxml.jackson.databind.*;

public class ColaboradorController extends Controller {

	public Result colaboradores() {


		List<Colaborador> colaboradores = ColaboradorDAO.findAll();

		JsonNode aux = Json.toJson(colaboradores);

		ObjectMapper mapper = new ObjectMapper();
		// List<String> names = mapper.readValue(jsonSource, List.class);
		//mapear os itens de um JSON
		// result = mapper.readValue(aux, List.class);

		// Colaborador aux2 = Json.fromJson(aux, Colaborador.class);

		return ok(aux);
	}
			
}