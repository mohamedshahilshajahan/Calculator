import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.border.Border;

class RoundedBorder implements Border {
    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}

public class Calculator_3 extends JFrame implements ActionListener, KeyListener { //KeyListner for keyboard
	// Fonts
	Font font = new Font("Arial", Font.BOLD , 20);
	Font font1 = new Font("Arial", Font.BOLD , 15);
	Font customFont = new Font("Arial Unicode MS", Font.BOLD, 20);
	Font dispText = new Font("Arial", Font.BOLD, 30);
	
    // Components
	JMenuBar mb;
	JMenu file;
	JMenuItem mi1,mi2;
	JTextField displab;
	JButton allclearButton,backspaceButton;
	JButton percentageButton,divisionButton,multiButton,subtractionButton,addButton,equalButton;
	JButton nineButton,eightButton,sevenButton,sixButton,fiveButton,fourButton,threeButton,twoButton;
	JButton oneButton,zeroButton;
	JButton dotButton,squrButton;
	JPanel panel;
	
	//Colors
	Color whiteforButton = new Color(246, 246, 246);
	Color whiteBackground = new Color(243, 243, 243);
	Color blackforButton = new Color(60, 60, 60);
	Color blackBackground = new Color(32, 32, 32);
	String currentTheme = "light";
	
	public boolean isOperatorClicked=false;
	//This Array list for store numbers and values(+,-,x,/) in Array this method is help to store unlimited numbers and values
	ArrayList<Object> dynamicArray = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	
    // Variables
	double num1 = 0, num2 = 0, result = 0; 
	char addition,subtraction,multiplication,division,percentage,square;
	double squareInput, squareAns, SinglePercentage;
	double addtempans = 0, subtempans = 0, multempans = 0, divtempans = 0;

	// Constructor
    public Calculator_3() {
        // Frame settings
        this.setTitle("Calculator 3");
        this.setSize(340, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Menu Button
        mi1=new JMenuItem("Dark Mode");
		mi1.setFont(font1);
		mi2=new JMenuItem("Light Mode");
		mi2.setFont(font1);
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		file=new JMenu("\u23E3");
		file.setFont(customFont);
		file.add(mi1);
		file.add(mi2);
		mb=new JMenuBar();
		mb.setBounds(0, 5, 25, 25);
		mb.add(file);	
		
		//Theme Change
		mi1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	currentTheme = "dark";
		        applyTheme();
		        storeThemePreference();
		    }
		});

		mi2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	currentTheme = "light";
		    	applyTheme();
		    	storeThemePreference();
		    }
		});
		
		
		// Text Field
        displab = new JTextField();
        displab.setPreferredSize(new Dimension(500, 130));
        displab.setFont(dispText);
        displab.setHorizontalAlignment(JTextField.RIGHT);
        displab.setEditable(false);	
        displab.add(mb);

        // Number Buttons
		dotButton=new JButton(".");
		dotButton.setBorder(new RoundedBorder(20));
		dotButton.setFont(font);
		dotButton.addActionListener(this);
		this.add(dotButton);
		
		zeroButton=new JButton("0");
		zeroButton.setBorder(new RoundedBorder(20));
		zeroButton.setFont(font);
		zeroButton.addActionListener(this);
		this.add(zeroButton);
		
		oneButton=new JButton("1");
		oneButton.setBorder(new RoundedBorder(20));
		oneButton.setFont(font);
		oneButton.addActionListener(this);
		this.add(oneButton);
		
		twoButton=new JButton("2");
		twoButton.setBorder(new RoundedBorder(20));
		twoButton.setFont(font);
		twoButton.addActionListener(this);
		this.add(twoButton);
		
		threeButton=new JButton("3");
		threeButton.setBorder(new RoundedBorder(20));
		threeButton.setFont(font);
		threeButton.addActionListener(this);
		this.add(threeButton);
		
		fourButton=new JButton("4");
		fourButton.setBorder(new RoundedBorder(20));
		fourButton.setFont(font);
		fourButton.addActionListener(this);
		this.add(fourButton);
		
		fiveButton=new JButton("5");
		fiveButton.setBorder(new RoundedBorder(20));
		fiveButton.setFont(font);
		fiveButton.addActionListener(this);
		this.add(fiveButton);
		
		sixButton=new JButton("6");
		sixButton.setBorder(new RoundedBorder(20));
		sixButton.setFont(font);
		sixButton.addActionListener(this);
		this.add(sixButton);
		
		sevenButton=new JButton("7");
		sevenButton.setBorder(new RoundedBorder(20));
		sevenButton.setFont(font);
		sevenButton.addActionListener(this);
		this.add(sevenButton);
		
		eightButton=new JButton("8");
		eightButton.setBorder(new RoundedBorder(20));
		eightButton.setFont(font);
		eightButton.addActionListener(this);
		this.add(eightButton);
		
		nineButton=new JButton("9");
		nineButton.setBorder(new RoundedBorder(20));
		nineButton.setFont(font);
		nineButton.addActionListener(this);
		this.add(nineButton);

        // Function Buttons
		addButton=new JButton("+");
		addButton.setBorder(new RoundedBorder(20));
		addButton.setFont(font);
		addButton.addActionListener(this);
		this.add(addButton);
		
		subtractionButton=new JButton("-");
		subtractionButton.setBorder(new RoundedBorder(20));
		subtractionButton.setFont(font);
		subtractionButton.addActionListener(this);
		this.add(subtractionButton);
		
		multiButton=new JButton("x");
		multiButton.setBorder(new RoundedBorder(20));
		multiButton.setFont(font);
		multiButton.addActionListener(this);
		this.add(multiButton);
		
		divisionButton=new JButton("÷");
		divisionButton.setBorder(new RoundedBorder(20));
		divisionButton.setFont(font);
		divisionButton.addActionListener(this);
		this.add(divisionButton);
		
		percentageButton=new JButton("%");
		percentageButton.setBorder(new RoundedBorder(20));
		percentageButton.setFont(font);
		percentageButton.addActionListener(this);
		this.add(percentageButton);
		
		squrButton=new JButton("x\u00B2");
		squrButton.setBorder(new RoundedBorder(20));
		squrButton.setFont(font);
		squrButton.addActionListener(this);
		this.add(squrButton);
		
		allclearButton=new JButton("AC");
		allclearButton.setBorder(new RoundedBorder(20));
		allclearButton.setFont(font);
		allclearButton.addActionListener(this);
		this.add(allclearButton);
		
		backspaceButton=new JButton("\u232B");
		backspaceButton.setBorder(new RoundedBorder(20));
		backspaceButton.setFont(customFont);
		backspaceButton.addActionListener(this);
		this.add(backspaceButton);
		
		equalButton=new JButton("=");
		equalButton.setBorder(new RoundedBorder(20));
		equalButton.setFont(font);
		equalButton.addActionListener(this);
		this.add(equalButton);
		
        // Panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 6, 5));

        // Adding components to the panel
        panel.add(allclearButton);
        panel.add(squrButton);
        panel.add(percentageButton);
        panel.add(divisionButton);
        
        panel.add(sevenButton);
        panel.add(eightButton);
        panel.add(nineButton);
        panel.add(multiButton);
        
        panel.add(fourButton);
        panel.add(fiveButton);
        panel.add(sixButton);
        panel.add(subtractionButton);
        
        panel.add(oneButton);
        panel.add(twoButton);
        panel.add(threeButton);
        panel.add(addButton);

        panel.add(zeroButton);
        panel.add(dotButton);
        panel.add(backspaceButton);
        panel.add(equalButton);
        
        // Add key listener
        this.addKeyListener(this);

        // Set focus on the frame to enable keyboard input
        this.setFocusable(true);
        this.requestFocusInWindow();
        
        // Adding components to the frame
        this.add(displab, BorderLayout.NORTH);
        this.add(panel);
        loadThemePreference();
        this.setVisible(true);
    }
    //This is for Keyboard Buttons
    public void keyPressed(KeyEvent e) {
        char keyChar = e.getKeyChar();
        switch (keyChar) {
            case '0':
                zeroButton.doClick();
                break;
            case '1':
                oneButton.doClick();
                break;
            case '2':
                twoButton.doClick();
                break;
            case '3':
                threeButton.doClick();
                break;
            case '4':
                fourButton.doClick();
                break;
            case '5':
                fiveButton.doClick();
                break;
            case '6':
                sixButton.doClick();
                break;
            case '7':
                sevenButton.doClick();
                break;
            case '8':
                eightButton.doClick();
                break;
            case '9':
                nineButton.doClick();
                break;
            case '+':
                addButton.doClick();
                break;
            case '-':
                subtractionButton.doClick();
                break;
            case '*':
            case 'x':
            case 'X':
                multiButton.doClick();
                break;
            case '/':
                divisionButton.doClick();
                break;
            case '.':
                dotButton.doClick();
                break;
            case '\n': //This is Enter Button
            case '=':
                equalButton.doClick();
                break;
            case '\b': //This is backspace Button
            	backspaceButton.doClick();
                break;
            case '^':
            	squrButton.doClick();
            	break;
            case 'c':
            case 'C':
            	allclearButton.doClick();
            	break;
            case '%':
            	percentageButton.doClick();
            	break;
        }
    }
    
    private void loadThemePreference() {
        try (FileReader reader = new FileReader("theme.txt")) {
            char[] buffer = new char[10];
            int charsRead = reader.read(buffer);
            currentTheme = new String(buffer, 0, charsRead).trim();
        } catch (IOException e) {
            currentTheme = "light";  // Default to light theme
        }
        applyTheme();
    }

    private void storeThemePreference() {
        try (FileWriter writer = new FileWriter("theme.txt")) {
            writer.write(currentTheme);
        } catch (IOException e) {
            // Handle error if needed
        }
    }
    
    private void applyTheme() {
        if (currentTheme.equals("light")) {
        	displab.setBackground(whiteBackground);
        	displab.setForeground(Color.BLACK);
        	panel.setBackground(whiteBackground);
    		mb.setBackground(whiteBackground);
    		file.setForeground(Color.BLACK);
        	
            zeroButton.setBackground(whiteforButton); 
            zeroButton.setForeground(Color.BLACK);
        	
            oneButton.setBackground(whiteforButton); 
            oneButton.setForeground(Color.BLACK);
        	
            twoButton.setBackground(whiteforButton); 
            twoButton.setForeground(Color.BLACK);
        	
            threeButton.setBackground(whiteforButton); 
            threeButton.setForeground(Color.BLACK);
        	
            fourButton.setBackground(whiteforButton); 
            fourButton.setForeground(Color.BLACK);
        	
            fiveButton.setBackground(whiteforButton); 
            fiveButton.setForeground(Color.BLACK);
        	
            sixButton.setBackground(whiteforButton); 
            sixButton.setForeground(Color.BLACK);
        	
            sevenButton.setBackground(whiteforButton); 
            sevenButton.setForeground(Color.BLACK);
        	
            eightButton.setBackground(whiteforButton); 
            eightButton.setForeground(Color.BLACK);
        	
            nineButton.setBackground(whiteforButton); 
            nineButton.setForeground(Color.BLACK);
        	
            dotButton.setBackground(whiteforButton); 
            dotButton.setForeground(Color.BLACK);
        	
            addButton.setBackground(whiteforButton); 
            addButton.setForeground(Color.BLACK);
        	
            subtractionButton.setBackground(whiteforButton); 
            subtractionButton.setForeground(Color.BLACK);
        	
            multiButton.setBackground(whiteforButton); 
            multiButton.setForeground(Color.BLACK);
        	
            divisionButton.setBackground(whiteforButton); 
            divisionButton.setForeground(Color.BLACK);
        	
            percentageButton.setBackground(whiteforButton); 
            percentageButton.setForeground(Color.BLACK);
        	
            squrButton.setBackground(whiteforButton); 
            squrButton.setForeground(Color.BLACK);

            allclearButton.setBackground(whiteforButton); 
            allclearButton.setForeground(Color.BLACK);
            
            backspaceButton.setBackground(whiteforButton); 
            backspaceButton.setForeground(Color.BLACK);
        	
            equalButton.setBackground(whiteforButton); 
            equalButton.setForeground(Color.BLACK); 

        } else if (currentTheme.equals("dark")) {
        	displab.setBackground(blackBackground);
        	displab.setForeground(Color.WHITE);
        	panel.setBackground(blackBackground);
    		mb.setBackground(blackBackground);
    		file.setForeground(Color.WHITE);
        	
            zeroButton.setBackground(blackforButton); 
            zeroButton.setForeground(Color.WHITE);
        	
            oneButton.setBackground(blackforButton); 
            oneButton.setForeground(Color.WHITE);
        	
            twoButton.setBackground(blackforButton); 
            twoButton.setForeground(Color.WHITE);
        	
            threeButton.setBackground(blackforButton); 
            threeButton.setForeground(Color.WHITE);
        	
            fourButton.setBackground(blackforButton); 
            fourButton.setForeground(Color.WHITE);
        	
            fiveButton.setBackground(blackforButton); 
            fiveButton.setForeground(Color.WHITE);
        	
            sixButton.setBackground(blackforButton); 
            sixButton.setForeground(Color.WHITE);
        	
            sevenButton.setBackground(blackforButton); 
            sevenButton.setForeground(Color.WHITE);
        	
            eightButton.setBackground(blackforButton); 
            eightButton.setForeground(Color.WHITE);
        	
            nineButton.setBackground(blackforButton); 
            nineButton.setForeground(Color.WHITE);
        	
            dotButton.setBackground(blackforButton); 
            dotButton.setForeground(Color.WHITE);
        	
            addButton.setBackground(blackforButton); 
            addButton.setForeground(Color.WHITE);
        	
            subtractionButton.setBackground(blackforButton); 
            subtractionButton.setForeground(Color.WHITE);
        	
            multiButton.setBackground(blackforButton); 
            multiButton.setForeground(Color.WHITE);
        	
            divisionButton.setBackground(blackforButton); 
            divisionButton.setForeground(Color.WHITE);
        	
            percentageButton.setBackground(blackforButton); 
            percentageButton.setForeground(Color.WHITE);
        	
            squrButton.setBackground(blackforButton); 
            squrButton.setForeground(Color.WHITE);

            allclearButton.setBackground(blackforButton); 
            allclearButton.setForeground(Color.WHITE);
            
            backspaceButton.setBackground(blackforButton); 
            backspaceButton.setForeground(Color.WHITE);        	
        	
            equalButton.setBackground(blackforButton); 
            equalButton.setForeground(Color.WHITE); 
        }
    }

    
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
			
			if(subtempans == 0 && multempans == 0 && divtempans == 0 && squareAns == 0 && SinglePercentage == 0) {
				if(displab.getText().equals("")) {
					num1 = 0; 
				}else {
					addtempans = Double.parseDouble(displab.getText());
		            displab.setText("");
		            
		            dynamicArray.add(addtempans);
		            dynamicArray.add("+");
					addition='+';
				} 
			}else if(subtempans != 0) {
	            addition = subtraction = multiplication = division = percentage = square = '\u0000';
	            
	            dynamicArray.add(Double.parseDouble(displab.getText()));
	            dynamicArray.add("+");
	            displab.setText("");
	            subtempans = 0;
		        addition='+';
			} else if(multempans != 0) {
	            addition = subtraction = multiplication = division = percentage = square = '\u0000';

	            dynamicArray.add(Double.parseDouble(displab.getText()));
	            dynamicArray.add("+");
	            displab.setText("");
	            multempans = 0;
		        addition='+';
			} else if(divtempans != 0) {
	            addition = subtraction = multiplication = division = percentage = square = '\u0000';
	            
	            dynamicArray.add(Double.parseDouble(displab.getText()));
	            dynamicArray.add("+");
	            displab.setText("");
	            divtempans = 0;
		        addition='+';
			} else if(squareAns != 0) {
	            addition = subtraction = multiplication = division = percentage = square = '\u0000';
	            
	            dynamicArray.add(squareAns);
	            dynamicArray.add("+");
	            displab.setText("");
		        squareAns = 0;
		        addition='+';
			} else if (SinglePercentage != 0) {
				addition = subtraction = multiplication = division = percentage = square = '\u0000';
				
	            dynamicArray.add("+");				
				displab.setText("");
				SinglePercentage = 0;
				addition='+';
			} 
			isOperatorClicked=false;

	}else if(e.getSource()==subtractionButton) {
		
		if (displab.getText().isEmpty()) {
	        displab.setText("-");
	    } else {
			isOperatorClicked=true;
						
			if (addtempans == 0 && multempans == 0 && divtempans == 0 && squareAns == 0 && SinglePercentage == 0) {
		        if (displab.getText().equals("")) {
		            num1 = 0;
		        } else {
		            subtempans = Double.parseDouble(displab.getText());
		            displab.setText("");

		            dynamicArray.add(subtempans);
		            dynamicArray.add("-");
		            subtraction = '-';
		        }
			} else if(addtempans != 0) {
	            addition = subtraction = multiplication = division = percentage = square = '\u0000';
	            
	            dynamicArray.add(Double.parseDouble(displab.getText()));
	            dynamicArray.add("-");
	            displab.setText(""); 
	            addtempans = 0;
		        subtraction = '-';
			} else if(multempans != 0) {
	            addition = subtraction = multiplication = division = percentage = square = '\u0000';
	            
	            dynamicArray.add(Double.parseDouble(displab.getText()));
	            dynamicArray.add("-");

	            displab.setText("");
	            multempans = 0;
		        subtraction = '-';
			} else if(divtempans != 0) {
	            addition = subtraction = multiplication = division = percentage = square = '\u0000';
	            
	            dynamicArray.add(Double.parseDouble(displab.getText()));
	            dynamicArray.add("-");

	            displab.setText("");
	            divtempans = 0;
		        subtraction = '-';
			} else if(squareAns != 0) {
	            addition = subtraction = multiplication = division = percentage = square = '\u0000';
	            
	            dynamicArray.add(squareAns);
	            dynamicArray.add("-");
	            
	            displab.setText("");
		        squareAns = 0;
		        subtraction = '-';
			} else if (SinglePercentage != 0) {
				addition = subtraction = multiplication = division = percentage = square = '\u0000';
				
	            dynamicArray.add("-");
				
				displab.setText("");
				SinglePercentage = 0;
				subtraction = '-';
			} 
			isOperatorClicked=false;
	    }				
	}else if(e.getSource()==multiButton) {
			isOperatorClicked=true;
			
			if(addtempans == 0 && subtempans == 0 && divtempans == 0 && squareAns == 0 && SinglePercentage == 0) {
				if(displab.getText().equals("")) {
					num1 = 0;
				}else {
					multempans = Double.parseDouble(displab.getText());
		            displab.setText("");

		            dynamicArray.add(multempans);
		            dynamicArray.add("x");		            
					multiplication='x';
					}
			} else if(addtempans != 0) {
	            addition = subtraction = multiplication = division = percentage = square = '\u0000';
	            
	            dynamicArray.add(Double.parseDouble(displab.getText()));
	            dynamicArray.add("x");

	            displab.setText("");		        
	            addtempans = 0;
		        multiplication='x';
			} else if(subtempans != 0) {
	            addition = subtraction = multiplication = division = percentage = square = '\u0000';
	            
	            dynamicArray.add(Double.parseDouble(displab.getText()));
	            dynamicArray.add("x");
	            
	            displab.setText("");
	            subtempans = 0;
		        multiplication='x';
			} else if(divtempans != 0) {
	            addition = subtraction = multiplication = division = percentage = square = '\u0000';
	            
	            dynamicArray.add(Double.parseDouble(displab.getText()));
	            dynamicArray.add("x");
	            
	            displab.setText("");
	            divtempans = 0;
		        multiplication='x';
			} else if(squareAns != 0) {
	            addition = subtraction = multiplication = division = percentage = square = '\u0000';
	            
	            dynamicArray.add(squareAns);
	            dynamicArray.add("x");
	            
	            displab.setText("");
		        squareAns = 0;
		        multiplication='x';
			} else if (SinglePercentage != 0) {
				addition = subtraction = multiplication = division = percentage = square = '\u0000';
				
	            dynamicArray.add("x");
				
				displab.setText("");
				SinglePercentage = 0;
				multiplication='x';
			} 
			isOperatorClicked=false;
		
	}else if(e.getSource()==percentageButton) {
			isOperatorClicked=true;						
								
				if(displab.getText().equals("")) {
					num1=0;
				} else {
					num1 = Double.parseDouble(displab.getText());
					displab.setText(displab.getText()+"%");
					addition = subtraction = multiplication = division = percentage = square = '\u0000';
					SinglePercentage = num1/100;
					
		            dynamicArray.add(SinglePercentage);
				}isOperatorClicked=false;
				
	}else if(e.getSource()==divisionButton) {
		isOperatorClicked=true;
		if(addtempans == 0 && subtempans == 0 && multempans == 0 && squareAns == 0 && SinglePercentage == 0) {
			if(displab.getText().equals("")) {
				num1=0;
			}else {
				divtempans = Double.parseDouble(displab.getText());
	            displab.setText("");
	            
	            dynamicArray.add(divtempans);
	            dynamicArray.add("÷");
				division='÷'; }
		} else if(addtempans != 0) {
            addition = subtraction = multiplication = division = percentage = square = '\u0000';
            
            dynamicArray.add(Double.parseDouble(displab.getText()));
            dynamicArray.add("÷");
            
            displab.setText("");
            addtempans = 0;
	        division='÷';
		} else if(subtempans != 0) {
            addition = subtraction = multiplication = division = percentage = square = '\u0000';
            
            dynamicArray.add(Double.parseDouble(displab.getText()));
            dynamicArray.add("÷");

            displab.setText(""); 
            subtempans = 0;
	        division='÷';
		} else if(multempans != 0) {
            addition = subtraction = multiplication = division = percentage = square = '\u0000';
            
            dynamicArray.add(Double.parseDouble(displab.getText()));
            dynamicArray.add("÷");

            displab.setText("");
            multempans = 0;
	        division='÷';
		} else if(squareAns != 0) {
            addition = subtraction = multiplication = division = percentage = square = '\u0000';
            
            dynamicArray.add(squareAns);
            dynamicArray.add("÷");            
            displab.setText("");
	        squareAns = 0;
	        division='÷';
		} else if (SinglePercentage != 0) {
			addition = subtraction = multiplication = division = percentage = square = '\u0000';
			
            dynamicArray.add("÷");			
			displab.setText("");
			SinglePercentage = 0;
			division='÷';
		} 
		isOperatorClicked=false;
	
	}else if(e.getSource()==squrButton) {
			isOperatorClicked=true;	

			if(displab.getText().equals("")) {
						num1 = 0;
			} else {
				num1 = Double.parseDouble(displab.getText());
					displab.setText(displab.getText()+"\u00B2");
					squareInput=num1;
					squareAns=squareInput*squareInput;
					square='^';
				} isOperatorClicked=false;
		
	}else if(e.getSource()==allclearButton) {
			isOperatorClicked = false;
			displab.setText(""); 
			num1 = num2 = result = addtempans = subtempans = 0;
			multempans = divtempans = SinglePercentage = 0;
			addition = subtraction = multiplication = division = percentage = square = '\u0000';
			dynamicArray.clear();
		
	}else if(e.getSource()==backspaceButton) {
		
			String currentText=displab.getText();
		
			if (currentText.length() > 0) {
				displab.setText(currentText.substring(0,currentText.length()-1)); }
		
	}else if(e.getSource()==dotButton) {
		
				if (!displab.getText().contains(".")) {
					displab.setText(displab.getText()+"."); }
				
	}else if(e.getSource()==equalButton){
        performOperation();
        anotherOperation();
        isOperatorClicked = false;
	    }
        this.requestFocusInWindow(); //these helps when user use mouse to click the buttons then use keyboard this method
    }									//is help to fix the issue
    
    private void performOperation() {
        if (displab.getText().equals("")) {
            displab.setText("");
            num1 = num2 = result = 0;
            return;
        }
        
        if (square == '^') {
            dynamicArray.add(squareAns);
            squareAns = 0;

        } else if (multiplication == 'x' && displab.getText() != "%") {
            num2 = Double.parseDouble(displab.getText());
            
                dynamicArray.add(num2);
                num1 = num2 = 0;

        } else if (division == '÷') {
            num2 = Double.parseDouble(displab.getText());

	                if (num2 != 0) {
	                    dynamicArray.add(num2);
	                    num1 = num2 = 0;
	                } else {
	                    displab.setText("Error");
	                    return;
	                }	            

        } else if (addition == '+') {
            num2 = Double.parseDouble(displab.getText());
            dynamicArray.add(num2);
            num1 = num2 = 0;

        } else if (subtraction == '-') {
            num2 = Double.parseDouble(displab.getText());
            dynamicArray.add(num2);
            num1 = num2 = 0;

        }
    }

    private void anotherOperation() {
        if (dynamicArray.isEmpty()) {
            displab.setText("");
            num1 = num2 = result = 0;
            return;
        }
        System.out.println(dynamicArray);
        // Process multiplication and division first
        for (int i = 1; i < dynamicArray.size(); i += 2) {
            if (dynamicArray.get(i).equals("x")) {
                double operand = Double.parseDouble(dynamicArray.get(i + 1).toString());
                dynamicArray.set(i - 1, Double.toString(Double.parseDouble(dynamicArray.get(i - 1).toString()) * operand));
                dynamicArray.remove(i);
                dynamicArray.remove(i);
                i -= 2;
            } else if (dynamicArray.get(i).equals("÷")) {
                double operand = Double.parseDouble(dynamicArray.get(i + 1).toString());
                if (operand != 0) {
                    dynamicArray.set(i - 1, Double.toString(Double.parseDouble(dynamicArray.get(i - 1).toString()) / operand));
                    dynamicArray.remove(i);
                    dynamicArray.remove(i);
                    i -= 2;
                } else {
                    displab.setText("Error");
                    return;
                }
            }
        }

        // Process addition and subtraction
        result = Double.parseDouble(dynamicArray.get(0).toString());
        for (int i = 1; i < dynamicArray.size(); i += 2) {
            if (dynamicArray.get(i).equals("+")) {
                result += Double.parseDouble(dynamicArray.get(i + 1).toString());
            } else if (dynamicArray.get(i).equals("-")) {
                result -= Double.parseDouble(dynamicArray.get(i + 1).toString());
            }
        }

        dynamicArray.clear();
        System.out.println("Result: " + result);
        
        String resultString = String.valueOf(result);
        double fractionalPart = result - Math.floor(result);

        if (fractionalPart != 0.0) {
            displab.setText(resultString);
        } else {
            displab.setText(String.valueOf((int) result));
        }
        
    }
   
    public static void main(String[] args) {
        new Calculator_3();
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}