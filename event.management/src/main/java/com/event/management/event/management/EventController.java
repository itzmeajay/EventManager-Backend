package com.event.management.event.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/event")
public class EventController {
	@GetMapping
	public String printString() {
		return "ScriptKids";
	}

	@GetMapping
	@RequestMapping("/name")
	public String printStrings() {
		return "chandrasekar";
	}

	@GetMapping
	@RequestMapping("/details")
	public sample returnDetails() {
		sample Sample = new sample();
		Sample.setName("chandru");
		return Sample;
	}

	@GetMapping
	@RequestMapping("/events")
	public json returnDetail() {
		json event = new json();
		event.setNames("chandru");
		event.setId("123");
		event.setType("workshop");
		event.setDate("22.02.2020");
		event.setVenue("coda");
		return event;
	}

	@GetMapping
	@RequestMapping("/newevents")
	public json returnDetai() {
		json event = new json();
		event.setFriend("jagadesh");
		event.setDept("cse");
		return event;
	}

	@GetMapping
	@RequestMapping("events/list")
	public List<json> returnlist() {
		List<json> sampleList = new ArrayList<>();
		json le = new json();
		le.setNames("chandru");
		le.setId("123");
		le.setType("workshop");
		le.setDate("22.02.2020");
		le.setVenue("coda");
		json les = new json();
		les.setFriend("jagadesh");
		les.setDept("cse");
		sampleList.add(le);
		sampleList.add(les);
		return sampleList;
	}

	@GetMapping
	@RequestMapping("/deta")
	public ArrayList<json> retur() throws SQLException  {
		ArrayList<json> eventlist=new ArrayList<>();
		Connection connection= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","srmc");
			Statement statement =connection.createStatement();
			ResultSet results =statement.executeQuery("select * from events");
			while(results.next()) {
				json event=new json();
				event. setNames(results.getString("name"));
				event.setId(results.getString("id"));
				event.setType(results.getString("type"));
				event.setDate(results.getString("date"));
				event.setVenue(results.getString("venue"));
				eventlist.add(event);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		
		
		
		return eventlist;
	}
	

}
