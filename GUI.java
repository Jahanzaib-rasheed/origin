package task2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
public class GUI {

	private JFrame frame;
	private JTextField text;
	private static boolean b,b1,b2,b3,b4,b5,b6;
	private static int index;
	private static List<Sentence> l;
	private static task2 data;
	
	
	public static void main(String[] args) {
		index=0;
		data=new task2();
		l=data.ReadFromFile();
		main1();
	}
	public static void main1(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public GUI() {
		initialize();
	}
	private void initialize() {
		b=b1=b2=b3=b4=b5=b6=false;
		
		frame = new JFrame();
		frame.setBounds(30, 30, 600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		text = new JTextField();
		text.setText(giveString());
		text.setBounds(35, 35, 510, 100);
		frame.getContentPane().add(text);
		text.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.setBounds(35, 550, 150, 50);
		frame.getContentPane().add(submit);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Submit();
			}
		});
			
		
		JButton skip = new JButton("Skip");
		skip.setBounds(400, 550, 150, 50);
		frame.getContentPane().add(skip);
		skip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Skip();
			}
		});
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Accessibility of teacher outside the class room");
		rdbtnNewRadioButton.setBounds(35, 175, 500, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(b)b=false;else b=true;
			}
		});
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Knowledge base/grip of instructor over subject");
		rdbtnNewRadioButton_1.setBounds(35, 225, 500, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(b1)b1=false;else b1=true;
			}
		});
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Instructor's ability to motivate you towards the module");
		rdbtnNewRadioButton_2.setBounds(35, 275, 500, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(b2)b2=false;else b2=true;
			}
		});
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Instructor's ability to intigerate contents with real-world");
		rdbtnNewRadioButton_3.setBounds(35, 325, 500, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(b3)b3=false;else b3=true;
			}
		});
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Adherence to course outline");
		rdbtnNewRadioButton_4.setBounds(35, 375, 500, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(b4)b4=false;else b4=true;
			}
		});
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Instructor's concern regarding lab");
		rdbtnNewRadioButton_5.setBounds(35, 425, 500, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_5);
		rdbtnNewRadioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(b5)b5=false;else b5=true;
			}
		});
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Your satisfaction level with the delivery method of instructor");
		rdbtnNewRadioButton_6.setBounds(35, 475, 500, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_6);
		rdbtnNewRadioButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(b6)b6=false;else b6=true;
			}
		});
		
	}
	public String giveString(){
		try{
		return l.get(index).getSentence();
		}catch (Exception e){
			index=0;
			return l.get(index).getSentence();
		}
	}
	public void Submit(){
		l.get(index).SubmitIncrcerment();
		if(b) l.get(index).chbox1Incrcerment();
		if(b1)l.get(index).chbox2Incrcerment();
		if(b2)l.get(index).chbox3Incrcerment();
		if(b3)l.get(index).chbox4Incrcerment();
		if(b4)l.get(index).chbox5Incrcerment();
		if(b5)l.get(index).chbox6Incrcerment();
		if(b6)l.get(index).chbox7Incrcerment();
		data.WriteInFile(l);
		index++;
		main1();
	}
	public void Skip(){
		l.get(index).SkipIncrcerment();
		data.WriteInFile(l);
		index++;
		main1();
	}
}
