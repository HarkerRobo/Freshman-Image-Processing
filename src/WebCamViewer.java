import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import boofcv.io.webcamcapture.UtilWebcamCapture;

import com.github.sarxos.webcam.Webcam;

/**
 * 
 */

/**
 * @author joelmanning
 *
 */
public class WebCamViewer extends JPanel
{

    /**
     * Generated Serial Version UID
     */
    private static final long serialVersionUID = -4592925283167582444L;
    
    public static final int CAMERA_WIDTH = 640;
    public static final int CAMERA_HEIGHT = 480;
    
    private Webcam cam;
    private List<ImageListener> listeners;
    private boolean shouldUpdate;
    private BufferedImage nextImage;
    
    /**
     * 
     */
    public WebCamViewer(){
        setBounds(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
        cam = UtilWebcamCapture.openDefault(CAMERA_WIDTH, CAMERA_HEIGHT);
        listeners = new ArrayList<ImageListener>();
        shouldUpdate = false;
        nextImage = null;
    }
    
    /**
     * 
     */
    public void startViewing(){
        while(true){
            BufferedImage bi = cam.getImage();
            for(ImageListener l: listeners){
                l.ImageRecieved(bi);
            }
            nextImage = bi;
            shouldUpdate = true;
            repaint();
        }
    }

    /**
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(shouldUpdate){
            g.drawImage(nextImage, 0, 0, null);
            shouldUpdate = false;
        }
    }
    
    

}
