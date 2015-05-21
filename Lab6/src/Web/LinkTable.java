package Web;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.text.AttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import org.w3c.dom.Document;

public class LinkTable {
	String linkURL;
	String[][] matris;
	public LinkTable (String inURL) {
		System.out.println(inURL);
		linkURL = inURL;
		Links(inURL);
	}
	
	private void Links(String url) {
		System.out.println(url+"abc");
		//String webpage="http://www.nada.kth.se/~henrik";
		InputStream in;
		
		ArrayList<String> a_tag = new ArrayList<String>();
		ArrayList<String> href = new ArrayList<String>();
		System.out.println("ABC");
		try {
			in = new URL(url).openConnection().getInputStream();
			InputStreamReader reader= new InputStreamReader(in);
			/*while(reader.ready()) 
				System.out.print((char)reader.read());
			 */
			HTMLDocument doc = new HTMLDocument(); 
			doc.putProperty("IgnoreCharsetDirective",Boolean.TRUE);	
			HTMLEditorKit newKit = new HTMLEditorKit();
			newKit.read(reader,doc,0);
			for (HTMLDocument.Iterator it = doc.getIterator(HTML.Tag.A); it.isValid(); it.next()) {

				AttributeSet attributes = it.getAttributes();
				String urlString = (String) attributes.getAttribute(HTML.Attribute.HREF);
				int startOffset = it.getStartOffset();
				int endOffset = it.getEndOffset();
				int length = endOffset - startOffset;
				String text = doc.getText(startOffset, length);
				System.out.println(" - " + text +"       "+ urlString);
				href.add(urlString);
				a_tag.add(text);
			}
			String[] href_array = href.toArray(new String[Math.min(href.size(), 50)]);
			String[] atag_array = a_tag.toArray(new String[Math.min(a_tag.size(), 50)]);
			matris = new String[atag_array.length][2];
			
			for(int i =0; i<atag_array.length; i++) {
				matris[i][0] = atag_array[i];
				matris[i][1] = href_array[i];
			}
			
			for(int i=0; i<matris.length;i++){
				for(int j=0;j<2;j++){
					System.out.println(matris[i][j]);
				}
				System.out.println("STOP");
				
			}
		} catch (Exception e) {

		}

		/*
		 * Iterera genom doc från A tag till A tag
		 * Läs av HREF attribut och skriv ut värdet
		 * 
		 * Skapa ett TAG-A iteratorobjekt och ett HREF attributobjekt
		 * LÄs HTML dokumentation
		 * 
		 * 
		 * Skriv ut texten mellan A tag och A tag 
		 * med it.getStartOffset() och it.getEndOffset()
		 * Läs hur i HTMLDOcument
		 */


	}
	
	public String[][] getMatrix(){
		return matris;
	}

}
