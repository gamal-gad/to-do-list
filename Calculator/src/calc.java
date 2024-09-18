import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calc extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	JFrame frame = new JFrame("Calculator") ;
    JTextField textField ;
    JButton numberButtons[]=new JButton[10] ;
    JButton functionButtont[]=new JButton[8] ;
    JButton sub , add , mul , dev ;
    JButton cle , dec , equ , del ;
    Font myFont =new Font("Ink Free",Font.BOLD,30);
    double n1=0,n2=0,result=0 ;
    char operator ;
    JPanel panel ;
    double runningTotal=0 ;
    
    calc(){
     // frame\\	
	 frame.setVisible(true); 
	 frame.setSize(420,550);
	 frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	 frame.setLayout(null);
	 frame.setResizable(false);
	 
	// text field \\
	 textField =new JTextField();
	 textField.setBounds(50, 25, 300, 50); 
	 textField.setFont(myFont);
	 textField.setEditable(false);
	 frame.add(textField);
	 
	 
	 // buttons \\
	 add=new JButton("+");
	 sub=new JButton("-");
	 mul=new JButton("*");
	 dev=new JButton("/");
	 dec=new JButton(".");
	 equ=new JButton("=");
	 del=new JButton("Delete");
	 cle=new JButton("Clear");
	 
	 functionButtont[0]=add;
	 functionButtont[1]=sub;
	 functionButtont[2]=mul;
	 functionButtont[3]=dev;
	 functionButtont[4]=dec;
	 functionButtont[5]=equ;
	 functionButtont[6]=del;
	 functionButtont[7]=cle;
	 
	 for(int i =0;i<8;i++) {
		 functionButtont[i].addActionListener(this);
		 functionButtont[i].setFont(myFont);
		 functionButtont[i].setFocusable(false);
	 }
	  
	 for(int i =0;i<10;i++) {
		 numberButtons[i]=new JButton(String.valueOf(i));
		 numberButtons[i].addActionListener(this);
		 numberButtons[i].setFont(myFont);
		 numberButtons[i].setFocusable(false);
	 }
	 
	 
	 del.setBounds(50, 430, 145, 50);
	 cle.setBounds(205, 430, 145, 50);
	 
	 frame.add(cle);
	 frame.add(del);
	 
	 // panel \\
	 panel =new JPanel();
	 panel.setBounds(50, 100 ,300, 300);
	 panel.setLayout(new GridLayout(4,4,10,10));
	 frame.add(panel);
	 
     
	 panel.add(numberButtons[1]);
	 panel.add(numberButtons[2]);
	 panel.add(numberButtons[3]);
	 panel.add(add);
	 panel.add(numberButtons[4]);
	 panel.add(numberButtons[5]);
	 panel.add(numberButtons[6]);
	 panel.add(sub);
	 panel.add(numberButtons[7]);
	 panel.add(numberButtons[8]);
	 panel.add(numberButtons[9]);
	 panel.add(mul);
	 panel.add(dec);
	 panel.add(numberButtons[0]);
	 panel.add(equ);
	 panel.add(dev);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++) {
		if(e.getSource()==numberButtons[i]) {
			textField.setText(textField.getText().concat(String.valueOf(i)));
		 }if(e.getSource()==cle) {
			 runningTotal = 0;
			textField.setText(""); 
		 }if(e.getSource()==dec) {
			 if (!textField.getText().contains(".")) {
			textField.setText(textField.getText().concat("."));
			 }
		 }if(e.getSource()==add) {
			 runningTotal +=Double.parseDouble(textField.getText());
			 operator = '+';
			 textField.setText("");
		 }if(e.getSource()==sub) {
			 runningTotal +=Double.parseDouble(textField.getText());
			 operator = '-';
			 textField.setText("");
		 }	 
		 }if(e.getSource()==mul) {
			 runningTotal +=Double.parseDouble(textField.getText());
			 operator = '*';
			 textField.setText("");
		 }if(e.getSource()==dev) {
			 runningTotal +=Double.parseDouble(textField.getText());
			 operator = '/';
			 textField.setText("");
	     }if(e.getSource()==equ) {
		     n2=Double.parseDouble(textField.getText());
		     
		     switch(operator) {
		     case '+' :
		    	  runningTotal += n2 ;
		            break; 
		     case '-' :
		    	  runningTotal -= n2 ;
		    	 break ;
		     case '*' :
		    	  runningTotal *= n2 ;
		    	 break ;
		     case '/' :
		    	 if (n2 == 0) {
                 textField.setText("Error: Division by zero!");
                 return;
             }
                 runningTotal /= n2 ;
		    	 
		    	 break ;
		     }
		     textField.setText(String.valueOf(runningTotal));
	     }
	     if(e.getSource()==del) {
			 String str =textField.getText();
			 textField.setText("");
			 for(int i =0 ; i<str.length()-1;i++) {
				 textField.setText(textField.getText() + str.charAt(i));
			 }		
		  }
	   }
	}
