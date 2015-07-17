package com.info.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("/hello")
public class Hello 
{

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray getTrackInJSON() throws JSONException {
		JSONArray list = new JSONArray();
		JSONArray reviews = new JSONArray();
		JSONObject jo = new JSONObject();
		jo.put("name", "John");
		jo.put("body", "good one");
		jo.put("author", "John@gmail.com");	
		JSONObject review1 = new JSONObject();
		review1.put("name", "John");
		review1.put("body", "good one");
		review1.put("author", "John@gmail.com");
		JSONObject review2 = new JSONObject();
		review2.put("name", "honey");
		review2.put("body", "good one");
		review2.put("author", "honey@gmail.com");
		reviews.put(review1);	
		reviews.put(review2);	
		jo.put("reviews", reviews);
		list .put(jo);
		return list;

	}


	@GET
	@Path("/java8")	
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray getJava8() throws JSONException {
		JSONArray list = new JSONArray();
		Properties prop = new Properties();
		String propFileName = "config.properties";
		InputStream inputStream;
		try {

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else 
			{
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} 
		Enumeration<?> e = prop.propertyNames();
		while (e.hasMoreElements()) {
			JSONObject jo = new JSONObject();
			String key = (String) e.nextElement();
			String value = prop.getProperty(key);
			System.out.println("Key : " + key + ", Value : " + value);
			jo.put("feature", key);
			jo.put("description", value);
			list .put(jo);
			}

		return list;


	}

	@GET
	@Path("/java7")	
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray getJava7() throws JSONException {
		JSONObject jo = new JSONObject();
		jo.put("version", "java");
		jo.put("feature", "Lambda Expressions");
		jo.put("description", "a new language feature, has been introduced in this release. They enable you to treat functionality as a method argument, or code as data. Lambda expressions let you express instances of single-method interfaces (referred to as functional interfaces) more compactly");
		jo.put("code", "class abc{}");
		JSONObject jo1 = new JSONObject();
		jo1.put("version", "java");
		jo1.put("feature", "28.0");
		jo1.put("description", "LG");
		JSONArray list = new JSONArray();
		list .put(jo);
		list .put(jo1);
		return list;

	}


	@GET
	@Path("/java9")	
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray getJava9() throws JSONException {
		JSONObject jo = new JSONObject();
		jo.put("version", "java");
		jo.put("feature", "good Expressions");
		jo.put("description", "a new language feature, has been introduced in this release. They enable you to treat functionality as a method argument, or code as data. Lambda expressions let you express instances of single-method interfaces (referred to as functional interfaces) more compactly");
		JSONObject jo1 = new JSONObject();
		jo1.put("version", "honey singh");
		jo1.put("feature", "28.0");
		jo1.put("description", "LG");
		JSONArray list = new JSONArray();
		list .put(jo);
		list .put(jo1);
		return list;

	}



	@POST
	@Path("/post")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String postPerson(Reviews reviews ) throws Exception  {		
		//
		// Code processing the input parameters
		//	
		return "JSON: The review is: " + reviews.getName() + ", Reviews body : " + reviews.getBody() + ", Reviews Author: " + reviews.getAuthor();
	}






}
