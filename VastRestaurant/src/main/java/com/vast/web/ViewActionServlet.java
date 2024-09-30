package com.vast.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.vast.dao.DbFoodDao;
import com.vast.dao.IFoodDao;

@WebServlet("/ViewActionServlet")
public class ViewActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger("vast");
       
    
    public ViewActionServlet() {
        super();
        
    }
    
    public void init() {
    	
    	IFoodDao dao=DbFoodDao.getDaoInstance();
    	Map<String, String> eventMap = readUriMappings();
		getServletContext().setAttribute("mappings", eventMap);
		Map<String, Action> map = new HashMap<String, Action>();
		getServletContext().setAttribute("instanceMap",map);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path=request.getServletPath();
		Map<String, String> actionMap=(Map<String, String>)getServletContext().getAttribute("mappings");
		Map<String, Action> instanceMap=(Map<String, Action>)getServletContext().getAttribute("instanceMap");
		String view = null;
		if (actionMap.containsKey(path)) {
			String cls=actionMap.get(path);
			createInstanceIfNotExists(instanceMap, cls);
			Action action=instanceMap.get(cls);
			view=action.execute(request, response);
			RequestDispatcher rd=request.getRequestDispatcher(view);
			rd.forward(request, response);
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void createInstanceIfNotExists(Map<String, Action> instanceMap, String cls) {
		if (!instanceMap.containsKey(cls)) {
			try {
				Class clazz = Class.forName(cls);
				Action obj = (Action)clazz.newInstance();
				instanceMap.put(cls, obj);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				logger.debug(e.getMessage());
				logger.error(e.getMessage());
				
			}
		}
		
	}
	private Map<String, String> readUriMappings() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Map<String, String> eventMap = new HashMap<String, String>();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputStream in = getServletContext().getResourceAsStream("WEB-INF/action.xml");
			Document doc= db.parse(in);
			
			logger.debug("XML parsing started");
			NodeList nlist = doc.getElementsByTagName("action");
			for (int i = 0; i < nlist.getLength(); i++) {
				
				String uri=nlist.item(i).getAttributes().getNamedItem("uri").getTextContent();
				String cls=nlist.item(i).getAttributes().getNamedItem("class").getTextContent();
				
				eventMap.put(uri,cls);
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			logger.error(e.getMessage());
		}
		return eventMap;
	}

}
