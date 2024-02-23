import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import javax.swing.*;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

public class Calculator_1 extends JFrame implements ActionListener{
	Font font = new Font("Arial", Font.BOLD , 20);
	Font font1 = new Font("Arial", Font.BOLD , 15);
	Font customFont = new Font("Arial Unicode MS", Font.BOLD, 20);

	JLabel displab;
	JButton allclearButton,backspaceButton;
	JButton percentageButton,divisionButton,multiButton,subtractionButton,addButton,equalButton;
	JButton nineButton,eightButton,sevenButton,sixButton,fiveButton,fourButton,threeButton,twoButton;
	JButton oneButton,zeroButton;
	JButton dotButton,squrButton;
	double num1 = 0, num2 = 0, result = 0, FirstValuePercentage = 0, temp = 0, tempans = 0;
	char addition,subtraction,multiplication,division,percentage,square;
	double squareInput, SinglePercentage, percentageAns;
	
	public boolean isOperatorClicked=false;
	
	public Calculator_1() {
		//Frame
		JFrame jf=new JFrame("Calculator");
		jf.setLayout(null);
		jf.setSize(340, 575);
		jf.setLocation(100, 50);
		jf.getContentPane().setBackground(Color.white);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Label
		displab=new JLabel();
		displab.setBounds(5, 5, 315, 150);
		displab.setBackground(Color.LIGHT_GRAY);
		displab.setOpaque(true);
		displab.setHorizontalAlignment(SwingConstants.RIGHT);
		displab.setForeground(Color.black);
		displab.setFont(font);		
		jf.add(displab);
		//Buttons
		dotButton=new JButton(".");
		dotButton.setBounds(85, 460, 75, 70);
		dotButton.setFont(font);
		dotButton.addActionListener(this);
		jf.add(dotButton);
		
		zeroButton=new JButton("0");
		zeroButton.setBounds(5, 460, 75, 70);
		zeroButton.setFont(font);
		zeroButton.addActionListener(this);
		jf.add(zeroButton);
		
		oneButton=new JButton("1");
		oneButton.setBounds(5, 385, 75, 70);
		oneButton.setFont(font);
		oneButton.addActionListener(this);
		jf.add(oneButton);
		
		twoButton=new JButton("2");
		twoButton.setBounds(85, 385, 75, 70);
		twoButton.setFont(font);
		twoButton.addActionListener(this);
		jf.add(twoButton);
		
		threeButton=new JButton("3");
		threeButton.setBounds(165, 385, 75, 70);
		threeButton.setFont(font);
		threeButton.addActionListener(this);
		jf.add(threeButton);
		
		fourButton=new JButton("4");
		fourButton.setBounds(5, 310, 75, 70);
		fourButton.setFont(font);
		fourButton.addActionListener(this);
		jf.add(fourButton);
		
		fiveButton=new JButton("5");
		fiveButton.setBounds(85, 310, 75, 70);
		fiveButton.setFont(font);
		fiveButton.addActionListener(this);
		jf.add(fiveButton);
		
		sixButton=new JButton("6");
		sixButton.setBounds(165, 310, 75, 70);
		sixButton.setFont(font);
		sixButton.addActionListener(this);
		jf.add(sixButton);
		
		sevenButton=new JButton("7");
		sevenButton.setBounds(5, 235, 75, 70);
		sevenButton.setFont(font);
		sevenButton.addActionListener(this);
		jf.add(sevenButton);
		
		eightButton=new JButton("8");
		eightButton.setBounds(85, 235, 75, 70);
		eightButton.setFont(font);
		eightButton.addActionListener(this);
		jf.add(eightButton);
		
		nineButton=new JButton("9");
		nineButton.setBounds(165, 235, 75, 70);
		nineButton.setFont(font);
		nineButton.addActionListener(this);
		jf.add(nineButton);
		
		addButton=new JButton("+");
		addButton.setBounds(245, 385,75, 70);
		addButton.setFont(font);
		addButton.addActionListener(this);
		jf.add(addButton);
		
		subtractionButton=new JButton("-");
		subtractionButton.setBounds(245, 310,75, 70);
		subtractionButton.setFont(font);
		subtractionButton.addActionListener(this);
		jf.add(subtractionButton);
		
		multiButton=new JButton("x");
		multiButton.setBounds(245, 235, 75, 70);
		multiButton.setFont(font);
		multiButton.addActionListener(this);
		jf.add(multiButton);
		
		divisionButton=new JButton("÷");
		divisionButton.setBounds(245, 160, 75, 70);
		divisionButton.setFont(font);
		divisionButton.addActionListener(this);
		jf.add(divisionButton);
		
		percentageButton=new JButton("%");
		percentageButton.setBounds(165, 160, 75, 70);
		percentageButton.setFont(font);
		percentageButton.addActionListener(this);
		jf.add(percentageButton);
		
		squrButton=new JButton("x\u00B2"); //unicode for square
		squrButton.setBounds(85, 160, 75, 70);
		squrButton.setFont(font);
		squrButton.addActionListener(this);
		jf.add(squrButton);
		
		allclearButton=new JButton("AC"); //Clear All
		allclearButton.setBounds(5, 160, 75, 70);
		allclearButton.setFont(font);
		allclearButton.addActionListener(this);
		jf.add(allclearButton);
		
		backspaceButton=new JButton("\u232B"); //unicode for backspace logo
		backspaceButton.setBounds(165, 460, 75, 70);
		backspaceButton.setFont(customFont);
		backspaceButton.addActionListener(this);
		jf.add(backspaceButton);
		
		equalButton=new JButton("=");
		equalButton.setBounds(245, 460,75, 70);
		equalButton.setFont(font);
		equalButton.addActionListener(this);
		jf.add(equalButton);
	}
	//when Button clicked
	public void actionPerformed(ActionEvent e) {
		
			if(e.getSource()==nineButton) {
				
					if(isOperatorClicked) {	
					displab.setText("9");
					isOperatorClicked=false;
					} else { 
					displab.setText(displab.getText()+"9"); 
					}
				
			}else if(e.getSource()==eightButton){
				
					if(isOperatorClicked) {	
					displab.setText("8");
					isOperatorClicked=false;
					} else { 
					displab.setText(displab.getText()+"8"); 
					}
				
			}else if(e.getSource()==sevenButton) {
				
					if(isOperatorClicked) {	
					displab.setText("7");
					isOperatorClicked=false;
					} else { 
					displab.setText(displab.getText()+"7"); 
					}
				
			}else if(e.getSource()==sixButton) {
				
					if(isOperatorClicked) {	
					displab.setText("6");
					isOperatorClicked=false;
					} else { 
					displab.setText(displab.getText()+"6"); 
					}
				
			}else if(e.getSource()==fiveButton) {
				
					if(isOperatorClicked) {	
					displab.setText("5");
					isOperatorClicked=false;
					} else { 
					displab.setText(displab.getText()+"5"); 
					}
				
			}else if(e.getSource()==fourButton) {
				
					if(isOperatorClicked) {	
					displab.setText("4");
					isOperatorClicked=false;
					} else { 
					displab.setText(displab.getText()+"4"); 
					}
				
			}else if(e.getSource()==threeButton) {
				
					if(isOperatorClicked) {	
					displab.setText("3");
					isOperatorClicked=false;
					} else { 
					displab.setText(displab.getText()+"3"); 
					}
				
			}else if(e.getSource()==twoButton) {
				
					if(isOperatorClicked) {	
					displab.setText("2");
					isOperatorClicked=false;
					} else { 
					displab.setText(displab.getText()+"2"); 
					}
				
			}else if(e.getSource()==oneButton) {
				
					if(isOperatorClicked) {	
					displab.setText("1");
					isOperatorClicked=false;
					} else { 
					displab.setText(displab.getText()+"1"); 
					}
				
			}else if(e.getSource()==zeroButton) {
				
					if(isOperatorClicked) {	
					displab.setText("0");
					isOperatorClicked=false;
					} else { 
					displab.setText(displab.getText()+"0"); 
					}
				
			}else if(e.getSource()==addButton) {
				
					isOperatorClicked=true;
				
					if(result==0) {
						if(displab.getText().equals("")) {
							num1 = 0; 
						}else {
							tempans = Double.parseDouble(displab.getText());
							displab.setText("");

							temp=tempans+temp;
							num1=temp;
							addition='+';
						} 
					}else {
						addition = subtraction = multiplication = division = percentage = square = '\u0000';
							num1 = result;
							displab.setText("");
							addition='+'; 
					} isOperatorClicked=false;
	
			}else if(e.getSource()==subtractionButton) {
				
					isOperatorClicked=true;
					if(result==0) {
						displab.setText(displab.getText());
						tempans=Double.parseDouble(displab.getText());
						displab.setText("");
						
						temp=tempans-temp;
						num1=temp;

						subtraction='-'; }
					else {
						addition = subtraction = multiplication = division = percentage = square = '\u0000';
						num1=result;
						displab.setText("");
						subtraction='-';
					} isOperatorClicked=false;
					
			}else if(e.getSource()==multiButton) {
					isOperatorClicked=true;
					
					if(result==0) {
						if(displab.getText().equals("")) {
							num1 = 0;
						}else {
							tempans = Double.parseDouble(displab.getText());
							FirstValuePercentage=Double.parseDouble(displab.getText());
							displab.setText("");
							
							num1=tempans;
							multiplication='x';
							percentage='%'; }
					} else {
						addition = subtraction = multiplication = division = percentage = square = '\u0000';
						num1 = result;
						displab.setText("");
						multiplication='x';
					}isOperatorClicked=false;
				
			}else if(e.getSource()==percentageButton) {
					isOperatorClicked=true;						
										
						if(displab.getText().equals("")) {
							num1=0;
						} else {
							num1 = Double.parseDouble(displab.getText());
							displab.setText(displab.getText()+"%");
							addition = subtraction = multiplication = division = percentage = square = '\u0000';
							SinglePercentage = num1/100;
							percentageAns=FirstValuePercentage*SinglePercentage;
							percentage='%'; 
						}isOperatorClicked=false;
						
			}else if(e.getSource()==divisionButton) {
				isOperatorClicked=true;
				if(result==0) {
					if(displab.getText().equals("")) {
						num1=0;
					}else {
						num1 = Double.parseDouble(displab.getText());
						displab.setText("");
						division='÷'; }
				} else {
					addition = subtraction = multiplication = division = percentage = square = '\u0000';
					num1 = result;
					displab.setText("");
					division='÷';
				}isOperatorClicked=false;
			
			}else if(e.getSource()==squrButton) {
					isOperatorClicked=true;	
						num1 = Double.parseDouble(displab.getText());
					
					if(displab.getText().equals("")) {
								num1 = 0;
					} else {
							displab.setText(displab.getText()+"\u00B2");
							squareInput=num1;
							isOperatorClicked=false;
							square='^';
						}
				
			}else if(e.getSource()==allclearButton) {
					isOperatorClicked = false;
					displab.setText(""); 
					num1 = num2 = result = FirstValuePercentage = temp = tempans = 0; 
					addition = subtraction = multiplication = division = percentage = square = '\u0000';
				
			}else if(e.getSource()==backspaceButton) {
				
					String currentText=displab.getText();
				
					if (currentText.length() > 0) {
						displab.setText(currentText.substring(0,currentText.length()-1)); }
				
			}else if(e.getSource()==dotButton) {
				
						if (!displab.getText().contains(".")) {
							displab.setText(displab.getText()+"."); }
						
			}else if(e.getSource()==equalButton){
				isOperatorClicked=true;

			    if (displab.getText().equals("")) {
			        displab.setText("");
			        num1 = num2 = result = 0;
			        isOperatorClicked = false;
			        return;
			    }

						if(square=='^') {
							result=squareInput*squareInput;
							
						} else if(addition=='+') {
							num2 = Double.parseDouble(displab.getText());
							result=num1+num2;
							isOperatorClicked = false;
							
						} else if(subtraction=='-') {
							num2 = Double.parseDouble(displab.getText());
							result=num1-num2;
							isOperatorClicked = false;
							
						} else if(multiplication=='x' && displab.getText()!="%") {
							num2 = Double.parseDouble(displab.getText());
							result=num1*num2;
							isOperatorClicked = false;
							
						} else if(division=='÷') {
							num2 = Double.parseDouble(displab.getText());
							if(num2 !=0) {
								result=num1/num2;
							}else {
								displab.setText("Error");
								return; }
							
						} else if (percentage=='%') {
							if(percentageAns==0) {
								result=SinglePercentage;
							}else {
								result=percentageAns;
							} isOperatorClicked=false;
						}
				String resultString = String.valueOf(result);
						
				if(resultString.contains("."+"0")) {
						displab.setText(String.valueOf((int)result));
				}else { 
						displab.setText(String.valueOf(result));
				}
			}
		}	
	
	public static void main(String[] args) {
			new Calculator_1(); 
	}
}
