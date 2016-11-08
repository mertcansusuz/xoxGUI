package nonMVC;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmNonMVC extends JFrame {
    
	private static final int CONTINUE = 0;

	private static final int XWINS = 0;

	private static final int OWINS = 0;

	boolean player1Turn = true;
    
	private JPanel contentPane;
	
	JButton[][] buttons = new JButton[3][3];
	
	JButton btn00;
	JButton btn10;
	JButton btn20;
	JButton btn01;
	JButton btn11;
	JButton btn21;
	JButton btn02;
	JButton btn12;
	JButton btn22;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmNonMVC frame = new FrmNonMVC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmNonMVC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				if (btn.getText().equals("_")){
					if (player1Turn) {
						btn.setText("X");
					}else{
						btn.setText("O");
					}
					player1Turn = !player1Turn;
					int result = checkBoard(btn);
				}
				
			}
			
		};
		
		
		btn00 = new JButton("_");
		btn00.addActionListener(listener);
		btn00.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btn00);
		buttons[0][0] = btn00;
		
		btn10 = new JButton("_");
		btn10.addActionListener(listener);
		btn10.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btn10);
		buttons[1][0] = btn10;
		
		btn20 = new JButton("_");
		btn20.addActionListener(listener);
		btn20.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btn20);
		buttons[2][0] = btn20;
		
		btn01 = new JButton("_");
		btn01.addActionListener(listener);
		btn01.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btn01);
		buttons[0][1] = btn01;
		
		btn11 = new JButton("_");
		btn11.addActionListener(listener);
		btn11.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btn11);
		buttons[1][1] = btn11;
		
		btn21 = new JButton("_");
		btn21.addActionListener(listener);
		btn21.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btn21);
		buttons[2][1] = btn21;
		
		btn02 = new JButton("_");
		btn02.addActionListener(listener);
		btn02.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btn02);
		buttons[0][2] = btn02;
		
		btn12 = new JButton("_");
		btn12.addActionListener(listener);
		btn12.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btn12);
		buttons[1][2] = btn12;
		
		btn22 = new JButton("_");
		btn22.addActionListener(listener);
		btn22.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btn22);
		buttons[2][2] = btn22;
	}
	
	
	private int checkBoard(JButton btn) {
		int result = CONTINUE;
		int buttonX = 0;
		int buttonY = 0;
		for(int i = 0; i<3; i++){
			for(int j=0; j<3; j++){
				if(buttons[i][j] == btn){
					buttonX = i;
					buttonY = j;
					
				}
			}
		}
		
		String lastSymbol = btn.getText();
		
		boolean allSame = true;
		for(int j=0; j<3; j++){
			if(!buttons[buttonX][j].getText().equals(lastSymbol)){
				allSame =  false;
			}
		}
		
		if(allSame){
			if(lastSymbol.equals("X")){
				System.out.println("X Wins");
				return XWINS;
			}
			System.out.println("O Wins");
			return OWINS;
			
		}
		
		
		allSame = true;
		for(int i=0; i<3; i++){
			if(!buttons[i][buttonY].getText().equals(lastSymbol)){
				allSame =  false;
			}
		}
		
		
		if(allSame){
			if(lastSymbol.equals("X")){
				System.out.println("X Wins");
				return XWINS;
			}
			System.out.println("O Wins");
			return OWINS;
			
		}
		
		
		if( (buttonX + buttonY)%2 == 0 ) {
			if (buttonX == buttonY){
				allSame = true;
				for(int i=0; i<3; i++){
					if(!buttons[i][i].getText().equals(lastSymbol)){
						allSame =  false;
					}
				}
				if(allSame){
					if(lastSymbol.equals("X")){
						System.out.println("X Wins");
						return XWINS;
					}
					System.out.println("O Wins");
					return OWINS;
					
				}
				
			}
			
			if ( (buttonX+buttonY) == 2){
				allSame = true;
				for(int i=0; i<3; i++){
					if(!buttons[i][2-i].getText().equals(lastSymbol)){
						allSame =  false;
					}
				}
				if(allSame){
					if(lastSymbol.equals("X")){
						System.out.println("X Wins");
						return XWINS;
					}
					System.out.println("O Wins");
					return OWINS;
					
				}
								
			}
		}
		
		
		return result;
	}

}
