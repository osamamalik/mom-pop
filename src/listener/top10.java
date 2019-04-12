package listener;

import java.util.ArrayList;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import bean.BookBean;
import model.*;

/**
 * Application Lifecycle Listener implementation class top10
 *
 */
@WebListener
public class top10 implements HttpSessionAttributeListener {
	
	private DatabaseOperator databaseOperator;

    public top10() {
        databaseOperator = new DatabaseOperator();
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	if (event.getName().equals("Order")){
    		try {
				
    			ArrayList<BookBean> abb= databaseOperator.getTop10Orders();
				event.getSession().setAttribute("Top10", abb);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	if (event.getName().equals("Order")){
    		try {
				
    			ArrayList<BookBean> abb= databaseOperator.getTop10Orders();
				event.getSession().setAttribute("Top10", abb);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
	
}
