package tailspin.surveys;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Key;

import tailspin.entities.Survey;
import tailspin.entities.Tenant;

@SuppressWarnings("serial")
public class TheSurveysAppServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		// create the persistence manager instance
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String action = req.getParameter("action");
		//display the lookup form
		if(action.equals("tenantLookup")){
			//query for the entities by tenant name
			String query = "select from "+ Tenant.class.getName()
					+" where tenantName== '"+req.getParameter("tenantName")+"'";
			List <Tenant> tenants = (List<Tenant>) pm.newQuery(query).execute();
			
			//pass the list to the jsp
			req.setAttribute("tenants", tenants);
			//forward the request to the jsp
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/tenantLookup.jsp");
			dispatcher.forward(req, resp);
		}
		//display the create new tenant form
		else if(action.equals("tenantCreate")){
			resp.sendRedirect("/tenantCreate.jsp");
		}
		// process the new tenant creation and send the user to the tenant display page
		else if(action.equals("tenantCreateDo")){
			// create the new tenant
			Tenant t = new Tenant(
					req.getParameter("name"),
					req.getParameter("description"),
					req.getParameter("address")
					);
			//persist the entity
			try{
				pm.makePersistent(t);
			}finally{
				pm.close();
			}
			resp.sendRedirect("thesurveysapp?action=tenantDisplay&tenantId="+t.getID());
		}
		//display the account details and opportunities
		else if(action.equals("tenantDisplay")){
			//fetch the tenant
			Key k = KeyFactory.createKey(Tenant.class.getSimpleName(), new Long(req.getParameter("tenantId")).longValue());
			Tenant t = pm.getObjectById(Tenant.class, k);
			
			//query for the surveys
			//String query = "select from "+Survey.class.getName()+" where tenatID=="+req.getParameter("tenantId");
			List <Survey> surveys = null;//(List<Survey>)pm.newQuery(query).execute();
			
			//pass the list to the jsp
			req.setAttribute("tenant", t);
			req.setAttribute("surveys", surveys);
			
			//forward the request to the jsp
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/tenantDisplay.jsp");
			dispatcher.forward(req, resp);
			
		}
		//display the create new survey form
		else if(action.equals("surveyCreate")){
			
		}
		//process the new survey creation and send the user to the tenant display page
		else if(action.equals("surveyCreateDo")){
			
		}
		//resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		doGet(req,resp);
	}
}
