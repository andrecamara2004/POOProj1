import java.util.Scanner;
import dataStructures.*;

public class Main {

    private static final String INFOTAINMENT = "infotainment";
    private static final String SECRETS = "secrets";
    private static final String START = "start";
    private static final String ISOLATE = "isolate";
    private static final String GROUPS = "groups";
    private static final String JOIN = "join";
    private static final String GO = "go";
    private static final String LANDMARKS = "landmarks";
    private static final String HOME = "home";
    private static final String LANDMARK = "landmark";
    private static final String HELP = "help";
    private static final String EXIT = "exit";
    private static final String FORGETFUL = "forgetful";
    private static final String GOSSIPER = "gossiper";
    private static final String SEALED = "sealed";
    private static final String PEOPLE = "people";
    private static final String GOSSIP = "gossip";

    public static void main(String[] args) throws Exception {
        commands();
    }

    private static void commands() {
        CommunitySystem community = new CommunitySystemClass();
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
                    processLandMarkCommand(in, community);
                    break;
                case LANDMARKS:
                    processLandMarksCommand(community);
                    break;
                case FORGETFUL:
                    processForgetfulCommand(in, community);
                    break;
                case GOSSIPER:
                    processGossiperCommand(in, community);
                    break;
                case SEALED:
                    processSealedCommand(in, community);
                    break;
                case PEOPLE:
                    processPeopleCommand(community);
                    break;
                case GO:
                    processGoCommand(in, community);
                    break;
                case JOIN:
                    processJoinCommand(in, community);
                    break;
                case GROUPS:
                    processGroupsCommand(in, community);
                    break;
                case ISOLATE:
                    processIsolateCommand(in, community);
                    break;
                case START:
                    processStartCommand(in, community);
                    break;
                case GOSSIP:
                    processGossipCommand(in, community);
                    break;
                case SECRETS:
                    processSecretsCommand(in, community);
                    break;
                case INFOTAINMENT:
                    processInfotainmentCommand(in, community);
                    break;
                default:
                    processUnkwonCommand();
                    break;

            }
        } while (!command.equals(EXIT));
    }

    private static void processInfotainmentCommand(Scanner in, CommunitySystem community) {
        String name = in.nextLine().trim();
        if (!community.hasPerson(name)) {
            System.out.println(name + " does not exist!");
        } else if (community.getPerson(name).getNumOfGossips() == 0) {
            System.out.printf("%s knows nothing!\n", name);
        } else {

            System.out.printf("%s knows things:\n", name);
            Iterator<Gossip> iter = community.getPerson(name).getGossips().iterator();
            while (iter.hasNext()) {
                Gossip gossip = iter.next();
                System.out.println(gossip.getGossip());
            }
        }
    }

    private static void processSecretsCommand(Scanner in, CommunitySystem community) {
        String name = in.nextLine().trim();
        if (!community.hasPerson(name)) {
            System.out.println(name + " does not exist!");
        } else if (community.getGossipsAboutPerson(name).size() == 0) {
            System.out.println(name + " lives a very boring life!");
        } else {

            Iterator<Gossip> iter = community.getGossipsAboutPerson(name).iterator();
            while (iter.hasNext()) {
                Gossip next = iter.next();
                System.out.printf("%d %s\n", next.getListeners().size(), next.getGossip());

            }
        }
    }

    private static void processGossipCommand(Scanner in, CommunitySystem community) {
        String name = in.nextLine().trim();

        if (!community.hasPerson(name)) {
            System.out.println(name + " does not exist!");
        } else if (community.isPersonAtHome(name) || community.isPersonAlone(name)) {
            System.out.println(name + " has nobody to gossip with right now!");
        } else if (community.personKnowsNothing(name)) {
            System.out.println(name + " knows nothing!");
        } else if (community.isPersonAbleToShareAGossip(name)) {
            System.out.println(name + " does not wish to gossip right now!");
        } else {
            Iterator<Gossip> sharedGossips = community.gossip(name);
            Iterator<Person> peopleInGroupIter = community.listAllPeopleInGroup(name);
            String peopleInGroup = "";
            while (peopleInGroupIter.hasNext()) {
                peopleInGroup += peopleInGroupIter.next().getName() + ", ";

            }
            System.out.println(name + " shared with " + peopleInGroup + " some hot news!");
            while (sharedGossips.hasNext()) {
                System.out.println(sharedGossips.next().getGossip());
            }
        }
    }

    private static void processStartCommand(Scanner in, CommunitySystem community) {
        String owner = in.nextLine().trim();
        int n = in.nextInt();
        in.nextLine();
        if (n <= 0) {
            in.nextLine();
        } else {
            String[] arr = new String[n];
            Array<Person> targets = new ArrayClass<>(n);
            boolean targetExists = true;
            String targetThatDontExists = "";
            for (int i = 0; i < n; i++) {
                String target = in.nextLine();
                arr[i] = target;
            }
            for (int j = 0; j < n; j++) {
                if (community.hasPerson(arr[j])) {
                    Person person = community.getPerson(arr[j]);
                    targets.insertAt(person, j);
                } else {
                    targetThatDontExists += arr[j];
                    targetExists = false;
                    break;
                }
            }

            String result = "";
            for (int i = 0; i < arr.length; i++) {
                result += arr[i] + ", ";
            }

            String gossipString = in.nextLine();

            if (!community.hasPerson(owner)) {
                System.out.println(owner + " does not exist!");
            } else if (!targetExists) {
                System.out.println(targetThatDontExists + " does not exist!");
            } else if (community.hasGossip(owner, targets, gossipString)) {
                System.out.println("Duplicate gossip!");
            } else {
                Gossip gossip = new GossipClass(community.getPerson(owner), targets, gossipString);
                community.startGossip(gossip, community.getPerson(owner));
                System.out.printf("Have you heard about %s? %s\n", result.substring(0, result.length() - 2),
                        gossipString);

            }
        }
        if (!community.hasPerson(owner) && n <= 0) {
            System.out.println(owner + " does not exist!");
        } else if (n <= 0) {
            System.out.println("Invalid number " + n + " of gossip targets!");
        }
    }

    private static void processIsolateCommand(Scanner in, CommunitySystem gossip) {
        String name = in.nextLine().trim();
        if (!gossip.hasPerson(name)) {
            System.out.println(name + " does not exist!");
        } else if (gossip.isPersonAtHome(name)) {
            System.out.println(name + " is at home!");
        } else if (gossip.isPersonAlone(name)) {
            System.out.println(name + " is already alone!");
        } else {
            gossip.isolatePerson(name);
            System.out.println(name + " is now alone at " + gossip.getLandmarkOfPerson(name).getName() + ".");
        }

    }

    private static void processGroupsCommand(Scanner in, CommunitySystem gossip) {
        String landmark = in.nextLine().trim();
        if (landmark.equals("home")) {
            System.out.println("You must understand we have no surveillance tech at home! Privacy is our top concern!");
        } else if (!gossip.hasLandMark(landmark)) {
            System.out.printf("%s does not exist!\n", landmark);
        } else if (gossip.isLandmarkEmpty(landmark)) {
            System.out.printf("Nobody is at %s!\n", landmark);
        } else {
            int amountOfGroups = gossip.getAmountOfGroupsByLandmark(landmark);
            System.out.printf("%d groups at %s:\n", amountOfGroups, landmark);
            Iterator<Group> iter = gossip.listAllGroups(landmark);
            String result = "";
            while (iter.hasNext()) {
                Group group = iter.next();
                String listOfPeople = "";
                Iterator<Person> iterPeople = group.listAllPeople();
                while (iterPeople.hasNext()) {
                    listOfPeople += iterPeople.next().getName() + ", ";

                }

                // Remove the extra 2 chars that were added in the while
                listOfPeople = listOfPeople.substring(0, listOfPeople.length() - 2) + "\n";
                result += listOfPeople;
            }

            System.out.printf(result);
        }
    }

    private static void processJoinCommand(Scanner in, CommunitySystem gossip) {
        String name1 = in.nextLine().trim();
        String name2 = in.nextLine();
        if (name1.equals(name2)) {
            System.out.printf("%s needs company from someone else!\n", name1);
        } else if (!gossip.hasPerson(name1)) {
            System.out.printf("%s does not exist!\n", name1);
        } else if (!gossip.hasPerson(name2)) {
            System.out.printf("%s does not exist!\n", name2);
        } else if (gossip.isPersonAtHome(name1)) {
            System.out.printf("%s is at home!\n", name1);
        } else if (!gossip.isAtSameLandMark(name1, name2)) {
            System.out.printf("%s is not in %s!\n", name2, gossip.getLandmarkOfPerson(name1).getName());
        } else if (gossip.isAtSameGroup(name1, name2)) {
            System.out.printf("%s and %s are already in the same group!\n", name1, name2);
        } else {
            Iterator<Person> iter = gossip.listAllPeopleInGroup(name2);
            gossip.personJoinsGroup(name1, name2);
            String peopleInGroup = "";
            while (iter.hasNext()) {
                peopleInGroup += iter.next().getName() + ", ";

            }
            peopleInGroup = peopleInGroup.substring(0, peopleInGroup.length() - 1);
            System.out.printf("%s joined %s at the %s.\n", name1,
                    peopleInGroup, gossip.getLandmarkOfPerson(name2).getName());
        }
    }

    private static void processGoCommand(Scanner in, CommunitySystem community) {
        String name = in.nextLine().trim();
        String landmark = in.nextLine();
        if (!community.hasPerson(name)) {
            System.out.println(name + " does not exist!");
        } else if (!community.hasLandMark(landmark) || landmark.equals("home")) {
            System.out.println("Unknown place " + landmark + "!");
        } else if (community.landMarkHasPerson(name, landmark)) {
            System.out.printf("What do you mean go to %s? %s is already there!\n", name, landmark);
        } else if (community.isLandmarkFull(landmark)) {
            if (community.isPersonAtHome(name)) {
                System.out.printf("%s is too crowded! %s went home.\n", landmark, name);
            } else {
                community.personGoesHome(name);
                System.out.printf("%s is too crowded! %s went home.\n", landmark, name);
            }
        } else {
            community.movePersonToLandmark(name, landmark);
            System.out.printf("%s is now at %s.\n", name, landmark);
        }
    }

    private static void processPeopleCommand(CommunitySystem gossip) {
        Iterator<Person> it = gossip.listAllPeople();
        if (!it.hasNext()) {
            System.out.println("This community does not have any people yet!");
        } else {
            while (it.hasNext()) {
                Person person = it.next();
                String landmarkName;
                if (person.isAtHome()) {
                    landmarkName = "home";
                } else {
                    landmarkName = person.getCurrLandmark().getName();
                }
                System.out.printf("%s at %s knows %d gossips.\n", person.getName(),
                        landmarkName, person.getNumOfGossips());
            }
        }
    }

    private static void processSealedCommand(Scanner in, CommunitySystem gossip) {
        String name = in.nextLine().trim();
        if (gossip.hasPerson(name)) {
            System.out.println(name + " already exists!");
        } else {
            gossip.addSealedPerson(name);
            System.out.println(name + " lips are sealed.");
        }

    }

    private static void processForgetfulCommand(Scanner in, CommunitySystem gossip) {
        int gossipscapacity = in.nextInt();
        String name = in.nextLine().trim();

        if (gossipscapacity <= 0) {
            System.out.println("Invalid gossips capacity " + gossipscapacity + "!");
        } else if (gossip.hasPerson(name)) {
            System.out.println(name + " already exists!");
        } else {
            gossip.addForgetfulPerson(name, gossipscapacity);
            System.out.println(name + " can only remember up to " + gossipscapacity + " gossips.");
        }
    }

    private static void processGossiperCommand(Scanner in, CommunitySystem gossip) {
        String name = in.nextLine().trim();
        if (gossip.hasPerson(name)) {
            System.out.printf("%s already exists!\n", name);
        } else {
            gossip.addGossiperPerson(name);
            System.out.printf("%s is a gossiper.\n", name);
        }
    }

    private static void processLandMarksCommand(CommunitySystem gossip) {
        Iterator<LandMark> it = gossip.listAll();
        if (!it.hasNext()) {
            System.out.println("This community does not have any landmarks yet!");
        } else {
            while (it.hasNext()) {
                LandMark landmark = it.next();
                System.out.printf("%s: %d %d.\n", landmark.getName(), landmark.getCapacity(), landmark.getOccupation());
            }
        }

    }

    private static void processLandMarkCommand(Scanner in, CommunitySystem gossip) {
        int capacity = in.nextInt();
        String name = in.nextLine().trim();

        if (capacity <= 0) {
            System.out.println("Invalid landmark capacity " + capacity + "!");
        } else if (name.equals(HOME)) {
            System.out.println("Cannot create a landmark called home. You know, there is no place like home!");
        } else if (gossip.hasLandMark(name)) {
            System.out.println("Landmark " + name + " already exists!");
        } else {
            gossip.addLandmark(capacity, name);
            System.out.println(name + " added.");
        }

    }

    private static void processUnkwonCommand() {
        System.out.println("Unknown command. Type help to see available commands.");
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
        System.out.println(
                "isolate - makes a person leave the current group, but not the landmark the person is currently on");
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
