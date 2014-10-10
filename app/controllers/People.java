package controllers;

import models.Person;
import play.mvc.Controller;

import java.util.List;

public class People extends Controller {

    public static void index() {
        List<Person> people = Person.find("order by lastName desc").fetch(10);
        render(people);
    }
    
    public static void create(String firstName, String lastName) {
        Person person = new Person();
        person.firstName = firstName;
        person.lastName = lastName;
        person.create();

        index();
    }
    
    public static void delete(Long id) {
        Person person = Person.findById(id);
        person.delete();

    }

    public static void delete_all(){
    	List<Person> to_go = Person.findAll(); // type inference works here!
	for(Person p : to_go) {
	    p.delete();
	}
	index();
    }
    public static boolean find_name(String Name){
	boolean v = false;    	
	if(Person.count("firstname = ?", Name)==0){v = false;}
	else {v = true;}
	return v;
    }
        public static void aux() {
	System.out.println("prueba exitosa!");
    }



}
