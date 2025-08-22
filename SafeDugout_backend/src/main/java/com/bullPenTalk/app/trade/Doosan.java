package com.bullPenTalk.app.trade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Doosan implements TradeService{

	@Override
	public void execute(String action, HttpServletRequest request, HttpServletResponse response) {
		switch(action) {
		case "list" :
			Listcontroller.list(request, response);
			break;
		case "detail" :
			detail(request, response);
			break;
			
		case "uniformList" :
			uniformList(request, response);
			break;
			
		case "capList" :
			capList(request, response);
			break;
		
		case "apparelList" :
			apparelList(request, response);
			break;
			
		case "accessoriesList" :
			accessoriesList(request, response);
			break;
		
		case "cheeringitemList" :
			cheringItemList(request, response);
			break;
			
		case "baseballgearList" : 
			baseballgearList(request, response);
			break;
				
		}
		
	}
	
	
}
