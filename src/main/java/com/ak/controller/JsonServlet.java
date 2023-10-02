package com.ak.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ak.pojo.EntryRecord;
import com.ak.service.DbService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class JsonServlet extends HttpServlet {

	
	static{
		System.out.println("ghsdshdshgdsg");
		
	}
	
	private DbService dbService=null;
	
	@Override
	public void init() throws ServletException {
		this.dbService=new DbService();
		super.init();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("/index.jsp");
	}
	
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do post==============================="+req.getParameter("jsondata"));
		
		List<Object> hm=new ArrayList<>();
		
		try {
		Gson gson = new Gson();
		List<Object> objs = gson.fromJson(req.getParameter("jsondata"), hm.getClass());
		
		dbService.insertRecords(stringToArray(objs));
		
		}catch (Exception e) {
			System.out.println("error::");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public static  List<EntryRecord> stringToArray(List<Object> source) {
	    List<EntryRecord> entryRecords= new ArrayList<>();
		Gson gson=new Gson();
		for (Object obj : source) {
			  String t=  gson.toJson(obj);
			  EntryRecord p= gson.fromJson(t, EntryRecord.class);
			  entryRecords.add(p);
		}
	  return entryRecords;
	}
}
