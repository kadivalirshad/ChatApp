
package chat.app;
import java.awt.Color;
import java.io.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;
public class Server extends JFrame implements ActionListener{
    JPanel p1;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1;
     static JTextArea a;
    JButton b1;
    static ServerSocket skt;
     static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
      String msg="";
    Server()
    {
       p1=new JPanel();
       p1.setBounds(0, 0, 450, 50);
       p1.setBackground(new Color(7,94,84));
      
       ImageIcon mg1=new ImageIcon("D:\\icon1.jpeg");
       Image i1=mg1.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
       ImageIcon i2=new ImageIcon(i1);
        l1=new JLabel(i2);
       l1.setBounds(5,5,20,40);
       p1.add(l1);
       p1.setLayout(null);
       
        ImageIcon mg2=new ImageIcon("C:\\Users\\dell\\Pictures\\IMG_20200326_092506.jpg");
       Image i3=mg2.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
       ImageIcon i4=new ImageIcon(i3);
       l2=new JLabel(i4);
       l2.setBounds(25, 5, 40, 40);
       p1.add(l2);
       add(p1);
       
       l3=new JLabel("Irshad Kadival");
       l3.setBounds(80, 6, 200, 30);
       l3.setFont(new Font("Couriar",Font.PLAIN,16));
       l3.setForeground(Color.white);
       p1.add(l3);
       
        l4=new JLabel("Online");
       l4.setBounds(80, 25, 200, 30);
       l4.setFont(new Font("Couriar",Font.PLAIN,12));
       l4.setForeground(Color.white);
       p1.add(l4);
       
        ImageIcon mg3=new ImageIcon("C:\\Users\\dell\\Pictures\\images (1).png");
       Image i5=mg3.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
       ImageIcon i6=new ImageIcon(i5);
        l5=new JLabel(i6);
       l5.setBounds(260,5,20,40);
       p1.add(l5);
       
        ImageIcon mg4=new ImageIcon("C:\\Users\\dell\\Pictures\\images.jpeg");
       Image i7=mg4.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
       ImageIcon i8=new ImageIcon(i7);
        l6=new JLabel(i8);
        l6.setBackground(Color.white);
       l6.setBounds(310,5,20,40);
       p1.add(l6);
       
        ImageIcon mg5=new ImageIcon("C:\\Users\\dell\\Pictures\\three-dots-menu-png-12.png");
       Image i9=mg5.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
       ImageIcon i10=new ImageIcon(i9);
        l7=new JLabel(i10);
       l7.setBounds(350,5,20,40);
       p1.add(l7);
       
       l1.addMouseListener(new MouseAdapter()
       {
         public void mouseClicked(MouseEvent e)
         {
           System.exit(0);
         }
       }
      );
       
       t1=new JTextField();
       t1.setBounds(0, 550, 300, 30);
       t1.setFont(new Font("San-Serief",Font.PLAIN,15));
       add(t1);
       
       b1=new JButton("SEND");
       b1.setBounds(300, 550,100,30);
       add(b1);
   
       setLayout(null);
       setSize(400,580);
       setDefaultCloseOperation(3);
       setLocation(600,80);
       setUndecorated(true);
       setVisible(true);
       
       b1.addActionListener(this);
       
       b1.setBackground(new Color(7,94,84));
       b1.setForeground(Color.white);
       
       a=new JTextArea();
       a.setBounds(0, 60, 450, 490);
       a.setEditable(false);
       a.setLineWrap(true);
       a.setFont(new Font("Couriar",Font.PLAIN,13));
       a.setWrapStyleWord(true);
       add(a);
       getContentPane().setBackground(Color.white);
       
    }
    public static void main(String[] args) {
        new Server().setVisible(true);
     
        try{
             
              skt=new ServerSocket(1001);
              s=skt.accept();
              
              din=new DataInputStream(s.getInputStream());
              dout=new DataOutputStream(s.getOutputStream());
          
                  while(true)
            {  
                  String msg=din.readUTF();
                  a.setText(a.getText()+"\n"+msg);
                  
            }    
        
           }
        catch(Exception ef)
        {
         ef.printStackTrace();
        }    
     
    }

   
    public void actionPerformed(ActionEvent e) {
       
        
      try{  
          String out=t1.getText();
          a.setText(a.getText()+"\n\t\t\t"+out);
          dout.writeUTF(out);
          t1.setText("");
         }
      catch(Exception ef)
      {
         ef.printStackTrace();
      }  
    } 
    
    
}
