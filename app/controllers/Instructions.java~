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
    public void Instructions(){ganador="";}
    public static void index()  {
	renderArgs.put("ganador", ganador);
        render();
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
	Person person = new Person();
        person.firstName = win;
        person.lastName = "3";
        person.create();
	System.out.println("Ganador!: " + ganador);	
	index();
	}	
}
