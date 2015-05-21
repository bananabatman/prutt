package Web;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.text.Document;

public class WebReader extends JEditorPane{
	//String address;
	
	public String currentURL;
	public WebReader(){
		setEditable(false);
	}
	
	public void showPage(String inURL) throws IOException{
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