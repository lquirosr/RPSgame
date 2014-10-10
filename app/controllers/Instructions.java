package controllers;

import play.mvc.Controller;
import play.mvc.*;
import java.io.*; 
import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import models.Person;

public class Instructions extends Controller{
    static String ganador = "";
    static String ganador2 = "";
    public void Instructions(){ganador="";}
    public static void index()  {
	renderArgs.put("ganador", ganador);
	renderArgs.put("ganador2", ganador2);	
        render();
    }	
	public static void load_game(String URL_d){
	String win = campeonato_ulr(String URL_s);
	ganador2 =  "El ganador es: " + win;
	System.out.println("Ganador en partida cargada!: " + win);	
	index();
	}
	public static void uploadTextFile(String title, File textFile) throws Exception {
	String Content = "";
		try {		
		List<String> LIST = FileUtils.readLines(textFile);
		int k = LIST.size();
		int j = 0;
			while(j<k){
				Content=Content + LIST.get(j);j++;			
			}
		}
		catch (IOException e) {
		       e.printStackTrace();
	   	}
	//System.out.println("Archivo cargado: " + Content);
	Algorit A = new Algorit();
	String win = A.campeonato(A.extract_matches(Content));	

	ganador =  "El ganador es: " + win;

	//System.out.println("conteo: " + Person.count("firstname = ?", win));	
	if(People.find_name(win)==true){
	List<Person> p = Person.find("firstname", win).fetch();
	p.get(0).lastName = ""+(Integer.parseInt(p.get(0).lastName) + 3);
	p.get(0).save();
	System.out.println("registro repetido");
	}
	else{	
	System.out.println("registro nuevo!");
	Person person = new Person();
        person.firstName = win;
        person.lastName = "3";
        person.create();
	}
	System.out.println("Ganador!: " + win);	
	index();
	}	
}
