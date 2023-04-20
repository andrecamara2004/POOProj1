import java.util.Scanner;
import dataStructures.*;

public class Main {
    private static final String LANDMARKS = "landmarks";
    private static final String HOME = "home";
    private static final String LANDMARK = "landmark";
    private static final String HELP = "help";
    private static final String EXIT = "exit";
	private static final String FORGETFUL = "forgetful";
	private static final String GOSSIPER = "gossiper";
	private static final String SEALED = "sealed";
	private static final String PEOPLE = "people";

    public static void main(String[] args) throws Exception {
        commands();
    }

    private static void commands() {
        CommunitySystem gossip = new CommunitySystemClass();
        Scanner in = new Scanner(System.in);
        String command;
        do {
            command = in.next().toLowerCase();
            switch (command) {
                case EXIT:
                    processExitCommand();
                    break;
                case HELP:
                    processHelpCommand();
                    break;
                case LANDMARK:
                    processLandMarkCommand(in, gossip);
                    break;
                case LANDMARKS:
                    processLandMarksCommand(gossip);
                    break;
                case FORGETFUL:
                	processForgetfulCommand(in, gossip);
                case GOSSIPER:
                	processGossiperCommand(in, gossip);
                case SEALED:
                	processSealedCommand(in, gossip);
                case PEOPLE:
                	processPeopleCommand(gossip);
                default:
                    processUnkwonCommand();
                    break;

            }
        } while (!command.equals(EXIT));
    }

    private static void processPeopleCommand(CommunitySystem gossip) {
		}

	private static void processSealedCommand(Scanner in, CommunitySystem gossip) {
		String name = in.nextLine();
		
	}

	private static void processForgetfulCommand(Scanner in, CommunitySystem gossip) {
    	int gossipscapacity = in.nextInt();
		String name = in.nextLine();
		
		if(gossipscapacity <=0) {
			System.out.println("Invalid gossips capacity " + gossipscapacity + "!");
		}
		else if(gossip.hasForgetfulPerson(name)) {
			System.out.println(name + " already exists!");
		}
		else {
			gossip.addForgetfulPerson(gossipscapacity, name);
			System.out.println(name + " can only remember up to " + gossipscapacity + " gossips.");
		}
    }
	
	private static void processGossiperCommand(Scanner in, CommunitySystem gossip) {
		String name= in.nextLine();
		gossip.addGossiperPerson(null, name);
		
	}

	private static void processLandMarksCommand(CommunitySystem gossip) {
        Iterator<LandMark> it = gossip.listAll();
        while(it.hasNext()) {
            LandMark landmark = it.next();
            System.out.printf("%s: %d %d.\n", landmark.getName(), landmark.getCapacity(), landmark.getOccupation());
        }
    }

    private static void processLandMarkCommand(Scanner in, CommunitySystem gossip) {
        int capacity = in.nextInt();
        String name = in.nextLine().trim();

        if(capacity <= 0) {
            System.out.println("Invalid landmark capacity " + capacity + "!");
        } else if(name.equals(HOME)) {
            System.out.println("Cannot create a landmark called home. You know, there is no place like home!");
        } else if(gossip.hasLandMark(name)) {
            System.out.println("Landmark " + name + " already exists!");
        } else {
            gossip.addLandmark(capacity, name);
            System.out.println(name + " added.");
        }
        
    }
    
    private static void processUnkwonCommand() {
    }

    private static void processHelpCommand() {
        System.out.println("landmark - adds a new landmark to the community");
        System.out.println("landmarks - displays the list of landmarks in the community");
        System.out.println("forgetful - adds a forgetful person to the community");
        System.out.println("gossiper - adds a gossiper person to the community");
        System.out.println("sealed - adds a sealed lips person to the community");
        System.out.println("people - lists all the persons in the community");
        System.out.println("go - moves a person to a landmark, or home");
        System.out.println("join - joins a person to a group");
        System.out.println("groups - lists the groups composition in a landmark");
        System.out.println("isolate - makes a person leave the current group, but not the landmark the person is currently on");
        System.out.println("start - starts a new gossip");
        System.out.println("gossip - share a gossip within the current group in the current landmark");
        System.out.println("secrets - lists the gossip about a particular person");
        System.out.println("infotainment - lists the gossips a particular person is aware of");
        System.out.println("hottest - lists the most shared gossip");
        System.out.println("help - shows the available commands");
        System.out.println("exit - terminates the execution of the program");

    }

    private static void processExitCommand() {
        System.out.println("Bye!");
    }
}
