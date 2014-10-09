package controllers;

import play.mvc.Controller;
import play.mvc.*;
import java.io.*; 
import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Instructions extends Controller{

    public static void index()  throws Exception {
        render();
    }	
	public static void uploadTextFile(String title, File textFile) {
		try {		
		System.out.println("archivo completo: " + FileUtils.readLines(textFile));
		
		}
		catch (IOException e) {
		       e.printStackTrace();
	   	}
	}	
}
