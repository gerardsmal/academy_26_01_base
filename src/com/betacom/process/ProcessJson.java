package com.betacom.process;

import java.lang.reflect.Type;
import java.util.List;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.ObjectJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ProcessJson implements ProcessInterface {

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin ProcessJson");
		
		ObjectJson usr = new ObjectJson("Giuseppe", "Verdi", true);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		
		/*
		 * Object to json
		 */
		String jsonString = gson.toJson(usr);
		System.out.println(jsonString);
		/*
		 * json to object
		 */
		ObjectJson newUsr = gson.fromJson(jsonString, ObjectJson.class);
		System.out.println("new object creato da Json:" +  newUsr);
		
		List<ObjectJson> lUser = List.of(
				new ObjectJson("Giuseppe", "Verdi", true),
				new ObjectJson("Paolo", "Paluco", true),
				new ObjectJson("Anna", "Bella", true)
				);
		
		System.out.println("Lisat json ********");
		jsonString = gson.toJson(lUser);
		System.out.println(jsonString);
		
		Type type = new TypeToken<List<ObjectJson>>() {}.getType();  // retrieve correct type
		List<ObjectJson> lUser1 = gson.fromJson(jsonString, type);
		lUser1.forEach(u -> System.out.println(u));
		
		return false;
	}

}
