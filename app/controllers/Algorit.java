/*
Esta clase contiene los metodos necesarios para solucionar el juego
Los problemas A y B

Luis Quirós Rojas
lquirosr@gmail.com
9/10/2014

*/
//Play Framework
package controllers;
import models.Person;
import play.mvc.Controller;
import java.util.List;

///Necesario para el algoritmo

import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;
import java.util.Hashtable;
import java.io.*; 
import java.net.*;

public class Algorit extends Controller {
	Hashtable<String,Integer> match_map = new Hashtable<String,Integer>();
	public void Algorit() {
        //Introduzco la tabla de resultados posibles en una tabla de hash, 0 -> gana el primero 1 ->gana el segundo
	match_map.put("SS", 0);
	match_map.put("SR", 1);
	match_map.put("SP", 0);
	match_map.put("RR", 0);
	match_map.put("RS", 0);
	match_map.put("RP", 1);
	match_map.put("PP", 0);
	match_map.put("PS", 1);
	match_map.put("PR", 0);
   }

//leo el archivo  
public String readFile(String filename)
{
   String content = null;
//   File file = Play.resource("public/"+filename);// new File(filename);
	
// etc.
   try {
	java.io.File yourFile = new java.io.File(filename);
	java.io.FileReader fr = new java.io.FileReader(yourFile);
       //FileReader reader = new FileReader(realFile);
       //char[] chars = new char[(int) file.length()];
       char[] chars = new char[(int) yourFile.length()];
       fr.read(chars);
       //reader.read(chars);
       content = new String(chars);
       //reader.close();
       fr.close();
   } catch (IOException e) {
       e.printStackTrace();
   }
   //return File.toString(new File(filename)); //(String) 
   return content;
}

    //ALGORITMO DEl PROBLEMA A
    public String solve_game(String game){
    //a.1
	game = game.replaceAll("\\s+","");
	System.out.println("trimmed down game: " + game);
    try {
   
	if((game.split(",")).length != 4){ throw new Exception("Exception levantada! El número de jugadores debe ser igual a dos!");}
	else{System.out.println("all fine");}
        }
    catch(Exception exc) {
            System.out.println(exc.getMessage());
        }
   //a.2
   try {
   	String[] game_ = game.split(","); 
	//Revisión de la estrategia, case insensitive, un false se propaga debido al AND && y fuerza el else
	if((game_[1].substring(1,2).equalsIgnoreCase("S") || game_[1].substring(1,2).equalsIgnoreCase("R") || game_[1].substring(1,2).equalsIgnoreCase("P")) && (game_[3].substring(1,2).equalsIgnoreCase("S") || game_[3].substring(1,2).equalsIgnoreCase("R") || game_[3].substring(1,2).equalsIgnoreCase("P"))){ System.out.println("all fine");}
	else{throw new Exception("Exception levantada! Estrategia mal formada!");}
        }
    catch(Exception exc) {
            System.out.println(exc.getMessage());
        }
   //a.3
	int winner = 0;
	String[] game_ = game.split(","); 
	
	System.out.println("strat: " + game_[1].substring(1,2)+game_[3].substring(1,2));
	//uso ambas estrategias para sacar la ganadora según la tabla de hash
	winner = (int) match_map.get(game_[1].substring(1,2)+game_[3].substring(1,2));
	//System.out.println("winner : " + winner);
 	String result = "";  
	if(winner==0){result=game_[0].substring(1,game_[0].length()) + ", " + game_[1];}
	else{result=game_[2] +", "+ game_[3].substring(0,game_[3].length()-1);}
   	//System.out.println("result : " + result);
   return result;
   }



public List<String> extract_matches(String tournament){
	List<String> match_list = new ArrayList<String>();

//averiguar el orden del torneo (profundidad) y otras cosas necesarias para descomponerlo

	tournament = tournament.replaceAll("\\s+","");
	String[] torneo = tournament.split(",");
	int counter = torneo[0].split("\\[").length - 1;	//cuento los brakets de apertura para averiguar la profundidad
	int counter2 = torneo.length - 1;			//cantidad de commas
	//System.out.println("contador de brakets: " + counter);
	//System.out.println("contador de commas: " + counter2);
//descomposición de un torneo de tamaño arbitrario en una lista ordenada de encuentros

	String linea = "";
	int i = 0;
	while(i<counter2-2){
		if(i<3){
			linea = torneo[0].substring((counter-2),torneo[0].length()-1) +", "+ torneo[1]+ ", " +torneo[2]+", "+torneo[3];
			//System.out.println("i1: " + linea);
			match_list.add(linea);
		}
		else{
			linea = torneo[i].substring(torneo[i].indexOf("\"")-2,torneo[i].length()) +", " +torneo[i+1]+ ", " +torneo[i+2]+", "+torneo[i+3].substring(0,torneo[i+3].indexOf("\"")+5);
			//System.out.println("i2: " + linea);
			match_list.add(linea);
		}
		i=i+4;
		}
/*

Agregar un error por el tamaño del torneo, pues este debe ser par

*/
return match_list;
}

public String campeonato(List<String> champ){
	String resultado = "";
//determinacion del tamaño de la tabla final

	//la tabla crece de manera que empezando con n encuentros, por cada ronda k hay que agregar n/(2^k)-1 encuentros a la tabla
	//esto me da el limite superior a la hora de recorrerla y el resultado se obtiene solucionando el juego que está
	//en la ultima fila de la lista "champ" que contiene el campeonato completo 

	int size_op = champ.size();
	int final_size = size_op;	
	while(size_op % 2 == 0)		
	{
		size_op=size_op/2;
		final_size = final_size + size_op;
	}
	//System.out.println("el torneo tendrá: " + final_size + " competencias!");

/// Iteración y sobre la lista, esta va a crecer en tanto se van realizando los encuentros, se itera hasta final_size
	Algorit AL = new Algorit();
	int k = 0;
	while ( k < final_size-1) {
		//Cada nuevo nuevo encuentro resultado del ganador de dos juegos consecutivos en la tabla de partidas "champ"
		champ.add("["+AL.solve_game(champ.get(k))+"," + AL.solve_game(champ.get(k+1))+"]");
		k=k+2;
	}
	int n = 0;	
	System.out.println("Campeonato completo! : ");
	while (n < final_size){System.out.println(champ.get(n));n++;}
	//System.out.println("Campeonato completo! : " + champ);
	//solucionando el último juego de la tabla se obtiene el ganador del torneo!
	return AL.solve_game(champ.get(final_size-1));
}


//Solucion al problema B

	//public String return_winner(String filename){
	//Algorit S = new Algorit();
	//return S.campeonato(S.extract_matches(S.readFile(filename)));
	//}
	
	public String return_winner(String file){
	Algorit S = new Algorit();
	return S.campeonato(S.extract_matches(file));
	}
        public static void aux() throws Exception {
	System.out.println("prueba en heroku!");
	Algorit p2 = new Algorit();
	//System.out.println("ganador del campeonato!: " + p2.return_winner("conf/champ.txt"));
	//System.out.println(java.io.File.path());
	
	//
	String Content = "";
 	URL oracle = new URL("https://dl.dropboxusercontent.com/u/6822814/champ.txt");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            Content = Content + inputLine;//System.out.println(inputLine);
        in.close();
	
	System.out.println(Content);

	System.out.println("ganador del campeonato!: " + p2.return_winner(Content));
	}
}
