import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import boofcv.io.webcamcapture.UtilWebcamCapture;

import com.github.sarxos.webcam.Webcam;

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
    private BufferedImage nextImage;

    /**
     * creates a new WebCamViewer with default bounds and no listeners
     */
    public WebCamViewer()
    {
        setBounds(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
        cam = UtilWebcamCapture.openDefault(CAMERA_WIDTH, CAMERA_HEIGHT);
        listeners = new ArrayList<ImageListener>();
        nextImage = null;
    }

    /**
     * begins an infinite loop forever displaying the image of the webcam
     */
    public void startViewing()
    {
        while (true)
        {
            BufferedImage bi = cam.getImage();
            for (ImageListener l : listeners)
            {
                l.ImageRecieved(bi);
            }
            nextImage = bi;
            repaint();
        }
    }

    /**
     * paints the component with the current image inside of it
     * 
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (nextImage != null)
        {
            g.drawImage(nextImage.getScaledInstance(getWidth(), getHeight(),
                    Image.SCALE_DEFAULT), 0, 0, null);
        }
    }

    /**
     * adds a listener on the webcam
     * 
     * @param listener
     *            an object to receive each image before it is displayed
     */
    public void addImageListener(ImageListener listener)
    {
        listeners.add(listener);
    }
}
