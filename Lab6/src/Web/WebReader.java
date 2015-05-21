package Web;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JEditorPane;

public class WebReader extends JEditorPane{
	//String address;
	
	public String currentURL;
	public WebReader(){
		setEditable(false);
	}
	
	public void showPage(String inURL) throws Exception{
		setCurrentURL(inURL);
		setPage(getCurrentURL());
	}
	public String getAddress(){
		return getCurrentURL();
	}

	public String getCurrentURL() {
		return currentURL;
	}

	public void setCurrentURL(String currentURL) {
		this.currentURL = currentURL;
	}
}
