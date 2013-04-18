package org.ibertech.client;



import org.ibertech.client.GreetingService;
import org.ibertech.client.GreetingServiceAsync;
import org.ibertech.server.TeamService;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;




public class GwtTestPlayerService extends GWTTestCase {

	private IClientFactory clientFactory;
	
	   
	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "org.ibertech.Prefaleague";
	}
	
	/**
	   * Add as many tests as you like.
	   */
	  public void testSimple() {
//		  assert(true);
		  ITeamServiceAsync teamService = clientFactory.getTeamService();
		   

		    delayTestFinish(10000);
		    assert(true);
		    finishTest();
//		    greetingService.greetServer("GWT User", new AsyncCallback<String>() {
//		      public void onFailure(Throwable caught) {
//
//		        fail("Request failure: " + caught.getMessage());
//		      }
//
//		      public void onSuccess(String result) {
//		        assertTrue(result.startsWith("Hello, GWT User!"));
//		        finishTest();
//		      }
//		    });
	  }

}
