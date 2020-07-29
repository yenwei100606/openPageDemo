import java.io.File;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			String url = "https://meet.jit.si/mcasmeet";
			java.net.URI uri = java.net.URI.create(url);
			java.awt.Desktop dp = java.awt.Desktop.getDesktop();
			if(dp.isSupported(java.awt.Desktop.Action.BROWSE)){
				dp.browse(uri);
			}
		}catch(java.lang.NullPointerException e){
			e.printStackTrace();
		}catch(java.io.IOException e){
			e.printStackTrace();
		}
		
	}

}
