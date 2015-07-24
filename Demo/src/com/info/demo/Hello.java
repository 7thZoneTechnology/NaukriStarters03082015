package com.info.demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;
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
	@Path("/interviewCollections")	
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray getinterviewCollections() throws JSONException {
		return getJSONArray("\\interviewCollections.json");
	}

	
	@GET
	@Path("/java8")	
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray getJava8() throws JSONException {
		return getJSONArray("\\java8.json");
	}


	@GET
	@Path("/java7")	
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray getJava7() throws JSONException {
		return getJSONArray("\\java7.json");
	}


	@GET
	@Path("/java9")	
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray getJava9() throws JSONException {
		return getJSONArray("\\java9.json");
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


	public JSONArray getJSONArray(String fileName) throws JSONException{

		JSONArray list = new JSONArray();
		try {

			JsonFactory jfactory = new JsonFactory();

			/*** read from file ***/
			JsonParser jParser = jfactory.createJsonParser(new File(fileName));

			while (jParser.nextToken() != JsonToken.END_ARRAY) 
			{	 

				// loop until token equal to "}"

				while (jParser.nextToken() != JsonToken.END_OBJECT) {

					String fieldname = jParser.getCurrentName();
					if ("feature".equals(fieldname)) {
						JSONObject jo = new JSONObject();
						// current token is "name",
						// move to next, which is "name"'s value
						jParser.nextToken();
						jo.put("feature", jParser.getText());
						jParser.nextToken();
						jParser.nextToken();
						jo.put("description", jParser.getText());
						jParser.nextToken();
						jParser.nextToken();
						jo.put("code", jParser.getText());
						list.put(jo);

					}

				}

			}
			jParser.close();


		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return list;

	}



}
