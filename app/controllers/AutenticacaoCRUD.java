package controllers;

import javax.inject.Inject;

import play.mvc.*;
import play.db.*;

import java.sql.*;

class AutenticacaoCRUD extends Controller {

    private Database db;

    public AutenticacaoCRUD() {
        
    }

    @Inject
    public AutenticacaoCRUD(Database db) {
        this.db = db;
        Connection conex = db.getConnection();
    }

    public String ar(){
    	return "ArlenCRUD";
    }
}