 
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import java.io.*;
import java.util.ArrayList;



public class Main {

    public static void main(String[] args) {

        GUIFrame one = new GUIFrame("Oregon Trails");

    }
}

class GUIFrame extends JFrame {
	
	
    JPanel titlePanel, StartButtonPanel, UserNamePanel, UserNameTextPanel, UserInfoButtonPanel;
    JPanel MainTextAreaPanel, FourButtonPanel;
    JTextArea MainTextAreaField; //this is the text
    JLabel TitleLabel, EnterUserNameLabel, TextLabel;
    JButton StartButton, NextButton, BackButton, ChoiceOne, ChoiceTwo, ChoiceThree, ChoiceFour;
    JTextField UserNameTextField;
    Font TitleFont = new Font("Times New Roman", Font.ITALIC, 35);
    Font TextAreaFont = new Font("Times New Roman", Font.ITALIC, 22);
    Font NormalFont = new Font("Times New Roman", Font.PLAIN, 20);
    Container con = new Container();


    public GUIFrame(String name){ //defult constructor , initilizes the game frame
        super(name); //passes in title
        CreateFrame(this);

        try{
            JLabel Image = new JLabel(new ImageIcon("GalacticTrails.jpg"));
            setContentPane(Image); //this is the background image
            add(Image);

        }catch(Exception e){

        }

        con = getContentPane();
        CreateTitleScreen();
        setVisible(true);
        backgroundMusic();


    }

    private void CreateFrame(GUIFrame Screen) {  //creates the frame 
        Screen.setLayout(null);

        Screen.setSize(600,600);
        Screen.getContentPane().setBackground(Color.BLACK);
        Screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Screen.setResizable(false);
        Screen.setLocationRelativeTo(null);


    }

    private void CreateTitleScreen() {  //creates title screen

        //------------------------------------------------------------------------------------
        try{ //try catch to make sure it dont throw exception when backing to previous page
            UserInfoButtonPanel.setVisible(false);
            UserNameTextPanel.setVisible(false);
            UserNamePanel.setVisible(false);

        }catch(Exception e){

        }

        //------------------------------------------------------------------------------------


        titlePanel = new JPanel();
        titlePanel.setBounds(100,100,400,100);
        titlePanel.setBackground(Color.BLACK);
        titlePanel.setOpaque(false);

        StartButtonPanel = new JPanel();
        StartButtonPanel.setBounds(250,400,100,50);
        StartButtonPanel.setBackground(Color.BLACK);
        StartButtonPanel.setOpaque(false);
        
        TitleLabel = new JLabel("Welcome to Oregon Trails");
        TitleLabel.setFont(TitleFont);
        TitleLabel.setForeground(Color.ORANGE);

        StartButton = new JButton("START");
        StartButton.setFont(NormalFont);
        StartButton.setForeground(Color.ORANGE);
        StartButton.setBackground(Color.BLACK);


        //------------------------------
        //this is where the action listener for Start button is added, calling different funciton

        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserInfoScreen();
            }
        });


        //-------------------------------

        titlePanel.add(TitleLabel);
        StartButtonPanel.add(StartButton);

        con.add(titlePanel);
        con.add(StartButtonPanel);
    }

    public void UserInfoScreen(){ //shows the enter name screen

        //----turn all jpanels to false visiable

        StartButtonPanel.setVisible(false);
        titlePanel.setVisible(false);

        //-------------------

        UserNamePanel = new JPanel();
        UserNamePanel.setBounds(100,100,400,100);
        UserNamePanel.setBackground(Color.BLACK);
        UserNamePanel.setOpaque(false);

        EnterUserNameLabel = new JLabel("Enter Your Name Below");
        EnterUserNameLabel.setFont(TitleFont);
        EnterUserNameLabel.setForeground(Color.ORANGE);


        UserNameTextPanel = new JPanel();
        UserNameTextPanel.setBounds(200,200,200,100);
        UserNameTextPanel.setBackground(Color.BLACK);
        UserNameTextPanel.setOpaque(false);


        UserNameTextField = new JTextField(7);
        UserNameTextField.setFont(TitleFont);
        UserNameTextField.setEditable(true);
        UserNameTextField.setBackground(Color.BLACK);
        UserNameTextField.setForeground(Color.ORANGE);


        UserInfoButtonPanel = new JPanel();
        UserInfoButtonPanel.setBounds(250,300,100,200);
        UserInfoButtonPanel.setBackground(Color.BLACK);
        UserInfoButtonPanel.setOpaque(false);

        BackButton = new JButton("BACK");
        BackButton.setFont(NormalFont);
        BackButton.setBackground(Color.BLACK);
        BackButton.setForeground(Color.ORANGE);

        NextButton = new JButton("NEXT");
        NextButton.setFont(NormalFont);
        NextButton.setBackground(Color.BLACK);
        NextButton.setForeground(Color.ORANGE);

        //---------------------------------------------
        //next button for page 1 action listener is here
        NextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SetName();  //checks name and saves it and call the page 1 of the content

            }
        });

        //---------------------------------------------

        //-----------------------------
        //Back button action listener is here which takes you back to the title screen.
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateTitleScreen(); //calls title screen button
            }
        });

        //-----------------------------


        UserInfoButtonPanel.add(BackButton);
        UserInfoButtonPanel.add(NextButton);
        UserNameTextPanel.add(UserNameTextField);
        UserNamePanel.add(EnterUserNameLabel);
        con.add(UserNamePanel);
        con.add(UserNameTextPanel);
        con.add(UserInfoButtonPanel);
    }

    public void GameContentPage1(){  //actual content page after background info
        //--------disable all the previous panels
        UserNamePanel.setVisible(false);
        StartButtonPanel.setVisible(false);
        //-----disable previous panels
        MainTextAreaPanel = new JPanel();
        MainTextAreaPanel.setBounds(100,120,400,150);
        MainTextAreaPanel.setBackground(Color.BLACK);
        MainTextAreaPanel.setOpaque(false);

        MainTextAreaField = new JTextArea("Rocket is about to take off \n weight limit of the rocket is almost reached \n you can take one more item with you \n which do you pick");
        MainTextAreaField.setFont(TextAreaFont);
        MainTextAreaField.setForeground(Color.ORANGE);
        MainTextAreaField.setBackground(Color.BLACK);
        MainTextAreaField.setEditable(false);


        FourButtonPanel = new JPanel();
        FourButtonPanel.setBounds(200,320,200,200);
        FourButtonPanel.setBackground(Color.BLACK);
        FourButtonPanel.setOpaque(false);

        ChoiceOne = new JButton("porn");
        ChoiceOne.setForeground(Color.ORANGE);
        ChoiceOne.setBackground(Color.BLACK);
        ChoiceOne.setFont(NormalFont);

        ChoiceTwo = new JButton("Extra food");
        ChoiceTwo.setForeground(Color.ORANGE);
        ChoiceTwo.setBackground(Color.BLACK);
        ChoiceTwo.setFont(NormalFont);

        ChoiceThree = new JButton("water bottle");
        ChoiceThree.setForeground(Color.ORANGE);
        ChoiceThree.setBackground(Color.BLACK);
        ChoiceThree.setFont(NormalFont);

        ChoiceFour = new JButton("Gun");
        ChoiceFour.setForeground(Color.ORANGE);
        ChoiceFour.setBackground(Color.BLACK);
        ChoiceFour.setFont(NormalFont);




        FourButtonPanel.add(ChoiceOne);
        FourButtonPanel.add(ChoiceTwo);
        FourButtonPanel.add(ChoiceThree);
        FourButtonPanel.add(ChoiceFour);
        MainTextAreaPanel.add(MainTextAreaField);
        con.add(MainTextAreaPanel);
        con.add(FourButtonPanel);



        //---------------------

        //---------------------
    }

    public void SetName(){ //validates the name and then creates person object as well as calling the background info screen1

        String name =  UserNameTextField.getText();
        System.out.println(name); //works for getting the string

        if(name.matches("Enter Name")){

            JOptionPane.showMessageDialog(null,
                    "You must enter your name",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE);

        }else if(name.matches("[A-Za-z]+") || name.matches("[A-Za-z]* [A-Za-z]*") || name.matches("[A-Za-z]* [A-Za-z]* [A-Za-z]*")){
            Operations player = new Operations();
            player.AddPlayer(new Player(name)); //new player initilized and added to array list.
            BackStory1(); //change this to the back story function
        }

        else{
            JOptionPane.showMessageDialog(null,
                    "Name can only be letters, and cannot be empty",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE);
        }


        //calls the page 1 of the game content
        // this is only called if the input is correct.
    }
    public static void backgroundMusic(){ //loops a music thats played in the background
        try{

            File musicPath = new File("backgroundMusic.wav");

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
			clip.loop(clip.LOOP_CONTINUOUSLY);
			
            //JOptionPane.showMessageDialog(null, "Press OK to stop Playing");
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void BackStory1(){ //shows background story 1
        UserInfoButtonPanel.setVisible(false);
        UserNameTextPanel.setVisible(false);
        UserNamePanel.setVisible(false);

        StartButtonPanel = new JPanel();
        StartButtonPanel.setBounds(100,100,400,250);
        StartButtonPanel.setBackground(Color.BLACK);
        StartButtonPanel.setOpaque(false);

        String story1= " The World never fully healed after the 2020 \n" +
                " CoronaVirus. Economic collapse after the \n" +
                " second wave broke the spirit of humanity.\n" +
                " After the nuclear wars of 2030.\n " +
                "Earth was uninhabitable. \n";

        MainTextAreaField = new JTextArea(story1);
        MainTextAreaField.setFont(TextAreaFont);
        MainTextAreaField.setForeground(Color.ORANGE);
        MainTextAreaField.setBackground(Color.BLACK);
        MainTextAreaField.setEditable(false);

        UserNamePanel = new JPanel();
        UserNamePanel.setBounds(250,400,100,50);
        UserNamePanel.setBackground(Color.BLACK);
        UserNamePanel.setOpaque(false);

        NextButton = new JButton("NEXT");
        NextButton.setFont(NormalFont);
        NextButton.setForeground(Color.ORANGE);
        NextButton.setBackground(Color.BLACK);
        NextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add storyline second page
                BackStory2();
            }
        });

        UserNamePanel.add(NextButton);
        StartButtonPanel.add(MainTextAreaField);
        con.add(StartButtonPanel);
        con.add(UserNamePanel);
    }

    public void BackStory2(){ //shows background story 2

        UserNamePanel.setVisible(false);
        StartButtonPanel.setVisible(false);
        //-----------------------------------
        StartButtonPanel = new JPanel();
        StartButtonPanel.setBounds(100,100,400,250);
        StartButtonPanel.setBackground(Color.BLACK);
        StartButtonPanel.setOpaque(false);

        String story2 = "X Æ A-12 Musk, now the CEO of his late \n" +
                "father's company, grew tired hearing \n" +
                "words like habitable and earth like and \n" +
                "SpaceX  had accomplished their goal of \n"+
                "colonizing Mars. But even the red planet \n" +
                "couldn’t support humanity forever. \n";

        MainTextAreaField = new JTextArea(story2);
        MainTextAreaField.setFont(TextAreaFont);
        MainTextAreaField.setForeground(Color.ORANGE);
        MainTextAreaField.setBackground(Color.BLACK);
        MainTextAreaField.setEditable(false);

        UserNamePanel = new JPanel();
        UserNamePanel.setBounds(250,400,100,50);
        UserNamePanel.setBackground(Color.BLACK);
        UserNamePanel.setOpaque(false);

        NextButton = new JButton("NEXT");
        NextButton.setFont(NormalFont);
        NextButton.setForeground(Color.ORANGE);
        NextButton.setBackground(Color.BLACK);
        NextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BackStory3();
            }
        });

        UserNamePanel.add(NextButton);
        StartButtonPanel.add(MainTextAreaField);
        con.add(StartButtonPanel);
        con.add(UserNamePanel);
    }

    public void BackStory3(){ //shows background story 3
        UserNamePanel.setVisible(false);
        StartButtonPanel.setVisible(false);
        //-----------------------------------
        StartButtonPanel = new JPanel();
        StartButtonPanel.setBounds(100,100,400,250);
        StartButtonPanel.setBackground(Color.BLACK);
        StartButtonPanel.setOpaque(false);

        String story2 = "People began to look up to the sky.\n" +
                "Not to pray, for many had lost their \n" +
                "faith in heavenly beings, but simply to\n " +
                "find a way to survive. You must take your\n" +
                "family to the stars and search for a habital\n" +
                "Planet";

        MainTextAreaField = new JTextArea(story2);
        MainTextAreaField.setFont(TextAreaFont);
        MainTextAreaField.setForeground(Color.ORANGE);
        MainTextAreaField.setBackground(Color.BLACK);
        MainTextAreaField.setEditable(false);

        UserNamePanel = new JPanel();
        UserNamePanel.setBounds(250,400,100,50);
        UserNamePanel.setBackground(Color.BLACK);
        UserNamePanel.setOpaque(false);

        NextButton = new JButton("NEXT");
        NextButton.setFont(NormalFont);
        NextButton.setForeground(Color.ORANGE);
        NextButton.setBackground(Color.BLACK);
        NextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameContentPage1();
            }
        });

        UserNamePanel.add(NextButton);
        StartButtonPanel.add(MainTextAreaField);
        con.add(StartButtonPanel);
        con.add(UserNamePanel);
    }

}

class Player{ //player class that takes just the name and sets the score as well
    protected String playerName;
    public int score;

    public Player(String name){
        this.playerName = name;
        this.score = 0;
    }

    public void SetScore(int newScore){
        this.score = newScore;
    }
    public int getScore(){
        return this.score;
    }

}

class Operations{ //operation class adds person to an arraylist, (maybe it can set the score as well , but lets see)
    ArrayList<Player> PlayerList = new ArrayList<Player>();

    public void AddPlayer(Player one){
        PlayerList.add(one); //adds the player to the array list
    }

    //this function will save the player info when they click saves
    //after they click save, it creates a file named UserData.text
    //we write name, score, panel number they were on
    //after that when they game lauches we always check if there was previous file left. 
    public void SaveUserData(Player x, int Score, int PanelNum){
         Formatter File;
         try{
             File = new Formatter("UserData.txt");
             File.format("%s %s %s", x.getPlayerName(), Score, PanelNum);
             File.close();
         }catch(Exception e){
             System.out.println("Error text when making file");
         }
    }

    //this function runs before the program takes place, or what ever
    //it checks if UserData already exists and then it proceedes accordingly
    //this is tricky
    //there should be try and catch block at main method
    //we should try to read in from file name UserData.txt,
    // we should run the entire program in catch block
    //and if it works for try block we should call this function.
    //this this take in the file as well
    public void CheckFileExists(Scanner File){
        //so when this is called the file does already exists
        String name, score, panelNumber;

        while(File.hasNext()){ //should only run just once, we only keep one person at a time.
            name = File.next();
            score = File.next();
            panelNumber = File.next();
        }

        //depending on panel num we call that also make a person class for the name
        //and add the score accordingly.
    }
}


























    