
import java.util.ArrayList;
import java.util.Scanner;

public class game {
	public static String [] characters = {"Kai", "Jay", "Taylor","Charlie","Jesse"}; 
	public static String [] scenarios = {"Your friend came out to you as bisexual, how do you react?",
			"Your friend asks you to keep a secret for them but it was about your other friend, what should you do?",
			"Your friend said racial slur, what should you do?",
			"Your friend is being kicked out of your friend group for something they didn’t do, what should you do?",
			"Your friend is being cyber bullied for posting a video of herself on social media, what should you do?"}; 

	public static String [][] options = {
		{"a. Tell your other friends about it because they also deserve to know",
		"b. Say that what they did was very brave and you will always support them",
		"c. Questions their sexuality (Are you sure you’re bi? You act straight.)"},
		{"a. Keep it a secret but make sure that it does not harm your other friend",
		"b. Your other friend needs to know, tell them",
		"c. Force them to tell your other friends or you will stop being friends with them"},
		{"a. Publicly humiliate them because the deserve it",
		"b. Have a conversation with them privately and educate them", 
		"c. Join in with them because it is fun"},
		{"a. Ignore them and continue playing with the others", 
		"b. Help them confront your other friends and don’t leave them",
		"c. Pretend you’re not friends with them in front of others but still talk to them"},
		{"a. Confront the bullies online and make another video attacking them", 
		"b. Do nothing because you don’t want to be involved with the mess",
		"c. Mentally support them and get them off social media for a while because you can’t do much about it"}}; 
	
	
	public static String [] rightAns = {"b", "a", "b", "b", "c"}; 
	public static String [] rightAnsFull = {"Say that what they did was very brave and you will always support them",
			"Keep it a secret but make sure that it does not harm your other friend",
			"Have a conversation with them privately and educate them", 
			"Help them confront your other friends and don’t leave them",
			"Mentally support them and get them off social media for a while because you can’t do much about it"}; 
	
	static ArrayList<String> friends = new ArrayList<String>();
	static ArrayList<String> personalItems = new ArrayList<String>();
	public static int point = 0; 
	static int i = 0;
	
	
	//validation check
	public static String check(String letter) {
		String lc = letter.toLowerCase();
		boolean b = !lc.equals("a")&&!lc.equals("b")&&!lc.equals("c");
		while (b) {
			System.out.println("Please re-enter");
			Scanner input = new Scanner (System.in);
			lc = input.nextLine(); 
			b = !lc.equals("a")||!lc.equals("b")||!lc.equals("c");
		}
		return lc;
	}
	
	//asking the questions
	public static boolean question(String [] s, String [][] o, int i, String right ) {
		System.out.println(s[i]);
		for (int n=0;n<3;n++) {
			System.out.println(o[i][n]);
		}
		System.out.println("Enter a, b or c");
		Scanner input = new Scanner (System.in);
		String letter = input.nextLine(); 
		
		letter = check(letter); 
		if (letter.equals(right)) {
			return true; 
		} else {
			return false; 
		} 
	}
	
	public static void sG() {
		System.out.println("Here's your friend "+characters[i]);
		boolean b = question(scenarios, options, i, rightAns[i]);
		if (b) {
			System.out.println("You earn 5 social good points! Collect more to buy things");
			point += 5; 
			System.out.println("You have a total of "+point+" points!");
			System.out.println(characters[i]+" is now your friend");
			friends.add(characters[i]);
		} else {
			System.out.println("The right thing to do in this situation was "+rightAnsFull[i]);
		}
		i++;
	}
	
	public static void buy() {
		String [] items = {};
		int [] cost = {};
		int n = -1;
		
		System.out.println(items.toString());
		System.out.println("Enter what you want to buy");		
		Scanner input = new Scanner (System.in);
		String choice = input.nextLine();
		String choiceLower = choice.toLowerCase();
		for (int i=0;i<items.length;i++) {
			if (choiceLower == items[i]) {
				n = i;
			}
		}
		if (n != -1 ) {
			System.out.println("The "+items[n]+" "+cost[n]+" points");
			System.out.println("Do you want to buy it? (Enter true for yes and false for no)");
			Scanner input2 = new Scanner(System.in); 
			boolean buy = input2.nextBoolean();
			if (buy) {
				point = point - cost[n];
				personalItems.add(items[n]);
			} 
		} else {
			System.out.println("Can't find item");
		}
		
	}

	public static void main(String[] args) {
		int choice = -1; 
		while (true) {
			System.out.println("Welcome to the game, press 1 to meet new people and 2 to buy something and 0 to end game");
			Scanner input = new Scanner (System.in);
			choice = input.nextInt();
			if (choice==1) {
				sG();
			} else if (choice==2) {
				buy();
			} else if (choice ==0) {
				System.exit(0);
			}
		}
	}

		
	}

	
	
	
	

