import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Shell extends JFrame{

	private JLabel  L_host_name;
	private JTextField T_host_name;
	private JButton B_enter;
	
	public Shell(){
		super.setTitle("Meet123");
		super.setLayout(null);
//		
//		Container pane = super.getContentPane();
//		label1 = new JLabel();
//		label1.setText("1231231");
//		pane.add(label1);
		L_host_name = new JLabel("會議名稱:");
		L_host_name.setBounds(10,20,100,20);
		super.add(L_host_name);
		
		T_host_name = new JTextField();
		T_host_name.setBounds(10,50,100,20);
		super.add(T_host_name);
		
		B_enter = new JButton("確定");
		B_enter.setBounds(100, 300, 80, 30);
		super.add(B_enter);
		
		
		super.setSize(400,400);
		super.setVisible(true);
		
		
		B_enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				String host_name = T_host_name.getText();
				String url = "https://meet.jit.si/" + host_name;
				
				openURL open = new openURL();
				open.openWebPage(url, 800, 500);

			}
		});
		
	}
}
