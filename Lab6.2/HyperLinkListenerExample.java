package Web;

        import java.awt.BorderLayout;
        import java.awt.Container;
        import java.io.IOException;

        import javax.swing.JEditorPane;
        import javax.swing.JFrame;
        import javax.swing.JScrollPane;
        import javax.swing.event.HyperlinkEvent;
        import javax.swing.event.HyperlinkListener;

public class HyperLinkListenerExample {

    public static void main(String args[]) {

        JFrame jFrame = new JFrame();

        Container cPane = jFrame.getContentPane();

        final JEditorPane editorPane = new JEditorPane();

        try {

            editorPane.setPage("http://www.javacodegeeks.com/");

        } catch (IOException e) {

            System.err.println("Invalid URL: " + e);

            System.exit(-1);

        }

        HyperlinkListener listener = new HyperlinkListener() {

            @Override

            public void hyperlinkUpdate(HyperlinkEvent event) {

                if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {

                    try {

                        editorPane.setPage(event.getURL());

                    } catch (IOException ioe) {

                        System.err.println("Error loading url from link: " + ioe);

                    }

                }

            }

        };

        editorPane.addHyperlinkListener(listener);

        editorPane.setEditable(false);

        JScrollPane pane = new JScrollPane(editorPane);

        cPane.add(pane, BorderLayout.CENTER);

        jFrame.setSize(800, 600);

        jFrame.setVisible(true);
    }
}