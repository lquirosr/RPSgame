package controllers;

import models.Person;
import play.mvc.Controller;

import java.util.List;

public class People extends Controller {

    public static void index() {
        List<Person> people = Person.findAll().fetch(10);
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
