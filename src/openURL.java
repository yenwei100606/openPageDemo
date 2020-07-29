import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;

import com.teamdev.jxbrowser.permission.PermissionType;
import com.teamdev.jxbrowser.permission.callback.RequestPermissionCallback;
import com.teamdev.jxbrowser.view.swing.BrowserView;


public class openURL {
	private static JLabel label;
	
	public static void openWebPage(String url,int pageWidth,int pageHeight){
		String key="";
		EngineOptions options = EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey(key).build();
		Engine engine = Engine.newInstance(options);
        Browser browser = engine.newBrowser();
        label = new JLabel("Fuck you");
        SwingUtilities.invokeLater(() -> {
            // Creating Swing component for rendering web content
            // loaded in the given Browser instance.
            BrowserView view = BrowserView.newInstance(browser);

            // Creating and displaying Swing app frame.
            JFrame frame = new JFrame("Meet");
            // Close Engine and onClose app window
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    engine.close();
                }
            });
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JTextField addressBar = new JTextField(url);
            addressBar.addActionListener(e ->
                    browser.navigation().loadUrl(addressBar.getText()));
            frame.add(label,BorderLayout.NORTH);
//            frame.add(addressBar, BorderLayout.NORTH);
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(pageWidth, pageHeight);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            
            engine.permissions().set(RequestPermissionCallback.class, (params,tell)->{
            	PermissionType type = params.permissionType();
            	if(type == PermissionType.VIDEO_CAPTURE || type == PermissionType.AUDIO_CAPTURE){
            		tell.grant();
            	}else{
            		tell.grant();
            	}
            });

            browser.navigation().loadUrl(addressBar.getText());
            
//            MediaDevices mediaDevices = engine.mediaDevices();
//           
//           //Get all available video devices, e.g. web camera.
//            List<MediaDevice> videoDevices = mediaDevices.list(MediaDeviceType.VIDEO_DEVICE);
//
//           //Get all available audio devices, e.g. microphone.
//            List<MediaDevice> audioDevices = mediaDevices.list(MediaDeviceType.AUDIO_DEVICE);
//            System.out.print("Camera設備"+videoDevices);
//            System.out.print("Microphone設備"+audioDevices);
////            mediaDevices.set(SelectMediaDeviceCallback.class, params->SelectMediaDeviceCallback.Response.select(params.mediaDevices().get(1)));
////            mediaDevices.set(SelectMediaDeviceCallback.class, params->SelectMediaDeviceCallback.Response.select(params.mediaDevices().get(0)));
////            engine.mediaDevices().set(SelectMediaDeviceCallback.class, params->
////            Response.select(params.mediaDevices().get(0)));
            
        });
	} 
}
