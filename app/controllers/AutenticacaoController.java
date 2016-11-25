package controllers;

import javax.inject.Inject;

import models.ColaboradorDAO;
import org.omg.CORBA.CompletionStatus;
import play.libs.ws.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletionStage;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataOutputStream;

import play.*;
import play.mvc.*;
import play.libs.Json;
import models.Colaborador;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;

/* classe responsável por autenticar o Usuario e receber
 * os dados da API Colaboradores para verificar se o mesmo está
 * autenticado.
 */
public class AutenticacaoController extends Controller {

	@Inject WSClient ws;


	public Result autentica(String token) {
		StringBuilder url = new StringBuilder("http://localhost:9000/auxiliar").append("?hash=").append(token);
		String url2 = url.toString();
//		WSRequest request = ws.url(url.toString());
//		CompletionStage<Result> resposta = request.get().thenApply(x -> {
//			return ok(x.asJson());
//		});

//        WSRequest request = ws.url(url.toString());
//        CompletionStage<JsonNode> resposta = request.get().thenApply(WSResponse::asJson);

		try{


			URL urll = new URL(url2);
			HttpURLConnection connection = (HttpURLConnection) urll.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			String resposta = inputStreamToString(connection.getInputStream());
			connection.disconnect();

			return ok(Json.parse(resposta));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Result auxiliar(String hash) {
		if(hash.equals("58da9670ec69344319d39beccd165d57")){
			Colaborador colaborador = ColaboradorDAO.findById(1);
			ObjectNode res = Json.newObject();
			res.put("status", 200);
			res.put("colaborador", Json.toJson(colaborador));
			return jsonResult(ok(Json.toJson(res)));
		} else {

			ObjectNode res = Json.newObject();
			res.put("status", 500);
			return ok(Json.toJson(res));
		}
	}

	public Result jsonResult(Result httpResult) {
		return httpResult;
	}

	public static String inputStreamToString(InputStream is) throws IOException {
		if (is != null) {
			Writer writer = new StringWriter();

			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} finally {
				is.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}

}