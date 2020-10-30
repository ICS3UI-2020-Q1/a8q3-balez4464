import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables 
  JLabel degreesFahrenheitLabel;
  JLabel degreesCelsiusLabel;

  JTextField fahrenheitNum;
  JTextField celsiusNum;

  JButton celsiusConverter;
  JButton fahrenheitConverter;

  JPanel mainPanel;
  


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Fahrenheit and Celsius Converter");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //creates main panel and makes it setVisible
    mainPanel = new JPanel();
    mainPanel.setLayout(null);
    frame.add(mainPanel);

    //creates labels and sets bounds
    degreesFahrenheitLabel = new JLabel("Degrees Fahrenheit");
    degreesFahrenheitLabel.setBounds(235, 180, 150, 25);
    degreesCelsiusLabel = new JLabel("Degrees Celsius");
    degreesCelsiusLabel.setBounds(235, 220, 150, 25);

    //makes labels setVisible
    mainPanel.add(degreesFahrenheitLabel);
    mainPanel.add(degreesCelsiusLabel);


    //creates text fields and sets bounds
    fahrenheitNum = new JTextField();
    fahrenheitNum.setBounds(400, 180, 80, 25);
    celsiusNum = new JTextField();
    celsiusNum.setBounds(400, 220, 80, 25);

    //makes text fields setVisible
    mainPanel.add(fahrenheitNum);
    mainPanel.add(celsiusNum);

    //creates and sets bounds for buttons
    fahrenheitConverter = new JButton("F -> C");
    fahrenheitConverter.setBounds(490, 180, 100, 25);
    celsiusConverter = new JButton("C -> F");
    celsiusConverter.setBounds(490, 220, 100, 25);

    //sets action comman for buttons
    fahrenheitConverter.setActionCommand("fahrenToCelsius");
    celsiusConverter.setActionCommand("CelToFahrenheit");

    //adds action lisner to the buttons
    fahrenheitConverter.addActionListener(this);
    celsiusConverter.addActionListener(this);

    //makes buttons setVisible
    mainPanel.add(fahrenheitConverter);
    mainPanel.add(celsiusConverter);
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("fahrenToCelsius")){
     //makes text into string 
      String  fahrenheitText = fahrenheitNum.getText();
      //makes into double
      double fahrenDigit = Double.parseDouble(fahrenheitText);
      //converts to celsius
      double celsiusAnswer;
      celsiusAnswer = (fahrenDigit - 32)* 5 / 9;
      //sets answer to string
      String printedAnswer = "" + celsiusAnswer;
      //outputs celsiusAnswer
      celsiusNum.setText(printedAnswer);

    }else if(command.equals("CelToFahrenheit")){
      //makes text into string
      String celsiusText = celsiusNum.getText();
      //makes string into double
      double celsiusDigit = Double.parseDouble(celsiusText);
      //converts to fahrenheit
      double fahrenheitAnswer = (celsiusDigit * 9)/5 + 32;
      //sets answer to string
      String printedAnswer = "" + fahrenheitAnswer;
      //prints answer
      fahrenheitNum.setText(printedAnswer);
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
