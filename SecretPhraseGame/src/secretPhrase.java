import java.util.*;
import javax.swing.JOptionPane;

public class secretPhrase {
	
		
	public static void main(String[] args) {
		Scanner jin = new Scanner(System.in);
		Object[] option = {"Play Again?", "Quit"};
		int x;
		char charChoice = ' ';
		boolean play = true;
		String choice, hidden;
		String answer = getSecretPhrase();
		StringBuilder cloaked = new StringBuilder();
		
		for(int s = 0; s < answer.length(); s++) {
			if(answer.charAt(s) == ' ') {
				cloaked.append(' ');
			}
			else {
				cloaked.append('*');
			}	
		}
		
		hidden = cloaked.toString();
		
		JOptionPane.showMessageDialog(null,
				"Welcome to Secret Phrase Program Game.\nGuess the phrase one letter at a time, or try to guess the whole phrase.\n");
		
		do
		{
			//System.out.println(cloaked);
			//System.out.println("Choose a letter, or if you think you know the phrase enter it: ");
			choice = JOptionPane.showInputDialog(null, hidden + "\nChoose a letter, or if you think you know the phrase enter it: ",
					"Secret Phrases", JOptionPane.PLAIN_MESSAGE);
			//choice = jin.nextLine();
			
			if(choice == null) {
				System.exit(0);
			}
			
			if(choice.length() < 2) {
				charChoice = choice.charAt(0);
				
				if(answer.contains(""+charChoice)) {
					JOptionPane.showMessageDialog(null, charChoice + " is in the phrase.");
					hidden = replaceLetters(charChoice, answer, cloaked);			
				}else {
					JOptionPane.showMessageDialog(null, charChoice + " is not in the phrase.");
				}		
			}
				
			if(cloaked.equals(answer) || choice.equalsIgnoreCase(answer)) {
				//System.out.println("\n\n" + answer);
				JOptionPane.showMessageDialog(null, answer + "\n\nCongratulations! You guessed the phrase!");
				x = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Play Again?",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
				//option = jin.next();
				if(x == 0) {
					cloaked.delete(0, cloaked.length());
					answer = getSecretPhrase();
					for(int s = 0; s < answer.length(); s++) {
						if(answer.charAt(s) == ' ') {
							cloaked.append(' ');
						}
						else {
							cloaked.append('*');
						}	
					}
					hidden = cloaked.toString();
				}else if(x ==1) {
					play = false;
				}
			}else if((choice.length() > 1) && !(choice.equalsIgnoreCase(answer))){
				JOptionPane.showMessageDialog(null, choice + "\nThat is not the correct phrase, try again.");
			}
			
		}while(play == true);
		
		System.exit(0);
	}

	public static String replaceLetters(char charChoice, String answer, StringBuilder cloaked) {	
		for(int x = 0; x < answer.length(); x++) {
			if(charChoice == answer.charAt(x)) {
				cloaked.setCharAt(x, charChoice);
			} 
		}
		return cloaked.toString();
	}
	
	public static void setPhrases(String[] Phrases) {
		Phrases[0] = "For the Horde";
		Phrases[1] = "Love and Peace";
		Phrases[2] = "Never Stop Dreaming";
		Phrases[3] = "Believe in Miracles";
		Phrases[4] = "We All Lift Together";	
	}
	
	public static String getSecretPhrase() {
		Random random = new Random();
		String[] Phrases = new String[5];
		
		String secretPhrase;
		int rand;
		
		setPhrases(Phrases);
		
		rand = random.nextInt(5);
		secretPhrase = Phrases[rand];
		
		return secretPhrase;
	}
}