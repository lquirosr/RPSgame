package controllers;

import play.mvc.Controller;
import play.mvc.*;

public class Instructions extends Controller {

    public static void index() {
        render();
    }	
	public static void uploadTextFile(String title, File textFile) {
	   String[] lines = FileUtils.readLines(textFile);
	}	
}
