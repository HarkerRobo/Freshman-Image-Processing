import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author joelmanning
 *
 */
public class Main
{
    private WebCamViewer view;
    private JFrame window;
    
    public static void main(String[] args){
        Main m = new Main();
        m.getView().startViewing();
    }
    
    public Main(){
        window = new JFrame("Webcam Processer");
        view = new WebCamViewer();
        window.add(view);
        window.setSize(WebCamViewer.CAMERA_WIDTH, WebCamViewer.CAMERA_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    /**
     * @return the view
     */
    public WebCamViewer getView()
    {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(WebCamViewer view)
    {
        this.view = view;
    }

    /**
     * @return the window
     */
    public JFrame getWindow()
    {
        return window;
    }

    /**
     * @param window the window to set
     */
    public void setWindow(JFrame window)
    {
        this.window = window;
    }
    
}
