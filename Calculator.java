/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author admin
 */
public class Calculator implements ActionListener {
    JFrame myframe;
    JTextField text;
    JButton norm[]=new JButton[10];
    JButton func[]=new JButton[9];
    JButton clr,del,neg,eq,add,sub,mul,div,dec;
    Font myfont=new Font("serrif",Font.BOLD,20);
    double num1=0,ans=0;
    char op;
    Calculator(){
     myframe=new JFrame("Calculator");
     //myframe.setBounds(0,0,500,700);
     myframe.setSize(500,700);
     myframe.setLayout(null);
     text=new JTextField();
     myframe.setResizable(false);
     myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     text.setBounds(10,50,450,100);
     text.setFont(myfont);
     text.setBackground(Color.white);
     text.setEditable(false);
     clr=new JButton("clr");
     del=new JButton("del");
     neg=new JButton("+/-");
     eq=new JButton("=");
     add=new JButton("+");
     sub=new JButton("-");
     mul=new JButton("*");
     div=new JButton("/");
     dec=new JButton(".");
     func[0]=add;
     func[1]=sub;
     func[2]=mul;
     func[3]=div;
     func[4]=clr;
     func[5]=dec;
     func[6]=neg;
     func[7]=eq;
     func[8]=del;
    for(int i=0;i<9;i++){
        func[i].addActionListener(this);
        func[i].setFont(myfont);
        func[i].setFocusable(false);
    }
    for(int i=0;i<10;i++){
        norm[i]=new JButton(Integer.toString(i));
        norm[i].addActionListener(this);
        norm[i].setFont(myfont);
        norm[i].setFocusable(false);
        norm[i].setBackground(Color.gray);
        norm[i].setForeground(Color.black);
    }
    dec.setBounds(10,550,450/4,270/4);
    neg.setBounds((10+(450/4)+10),550,450/4,270/4);
    eq.setBounds(350,550,450/4,270/4);
    JPanel mypan=new JPanel();
    mypan.setBounds(10,250,450,270);
    mypan.setLayout(new GridLayout(4,4,10,10));
    
    mypan.add(norm[1]);
    mypan.add(norm[2]);
    mypan.add(norm[3]);
    mypan.add(clr);
    mypan.add(norm[4]);
    mypan.add(norm[5]);
    mypan.add(norm[6]);
    mypan.add(del);
    mypan.add(norm[7]);
    mypan.add(norm[8]);
    mypan.add(norm[9]);
    mypan.add(add);
    mypan.add(norm[0]);
    mypan.add(mul);
    mypan.add(div);
    mypan.add(sub);
    
    eq.setBackground(Color.black);
    eq.setForeground(Color.green);
    dec.setBackground(Color.black);
    dec.setForeground(Color.red);
    neg.setBackground(Color.black);
    neg.setForeground(Color.red);
    myframe.add(text);
    myframe.add(mypan);
    myframe.add(dec);
    myframe.add(neg);
    myframe.add(eq);
    
    myframe.setVisible(true);
    }
    
    public static void main(String[] args) {
        Calculator obj=new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        for(int i=0;i<10;i++){
            if(e.getSource()==norm[i]){
                text.setText(text.getText().concat(Integer.toString(i)));
            }
        }
        if(e.getSource()==dec){
                text.setText(text.getText().concat("."));
            }
        if(e.getSource()==neg){
            double temp=Double.parseDouble(text.getText());
            temp=-temp;
                text.setText(Double.toString(temp));
            }
        if(e.getSource()==add){
            num1=Double.parseDouble(text.getText());
            op='+';    
            text.setText("");
            }
        if(e.getSource()==sub){
            num1=Double.parseDouble(text.getText());
            op='-';    
            text.setText("");
            }
        if(e.getSource()==div){
            num1=Double.parseDouble(text.getText());
            op='/';    
            text.setText("");
            }
        if(e.getSource()==mul){
            num1=Double.parseDouble(text.getText());
            op='*';    
            text.setText("");
            }
        if(e.getSource()==clr){
            text.setText("");
            }
        if(e.getSource()==eq){
            double num2=Double.parseDouble(text.getText());
           // System.out.println(num1+"+"+num2+"=");
            switch(op){
                case '+': ans=num1+num2;
                //System.out.println(num1+"+"+num2+"=");
                break;
                case '-': ans=num1-num2;
                break;
                case '*': ans=num1*num2;
                break;
                case '/': ans=num1/num2;
                break;
            }
            //System.out.println(ans);
            text.setText(Double.toString(ans));
            num1=ans;
            }
        if(e.getSource()==del){
            String s=text.getText();
            text.setText(s.substring(0,(s.length()-1)));
            }
    }
    
}
