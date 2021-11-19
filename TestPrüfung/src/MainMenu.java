import gmbh.kdb.hsw.gdp.Game;
import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

import java.util.List;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Game.create(studio -> {
            System.out.println("please enter a number to choose one of the following: ");
            System.out.println("1 for evaluation");
            System.out.println("2 to continue ");
            System.out.println("0 to end the game ");

            Scanner sc = new Scanner(System.in);
            var input = sc.nextInt();

            switch (input) {
                case 1: {
                    System.out.println("Evaluation: ");
                    evaluation(studio, Game.get().getEventLog());
                    break;
                }
                case 2: {
                    if ((studio.getCash().getValue().intValue() <= 0)) {
                        System.out.println("You are bankrupt!");
                        break;
                    }
                    System.out.println("the game will be continued");
                    System.out.println("----------------------------------------------------");
                    System.out.println("the following shows relevant information of your business: ");
                    System.out.println("studio-name " + studio.getName().getName()); //first .getName() returns address of name, second returns actual name
                    System.out.println("liquidity: " + studio.getCash());
                    System.out.println("amount of pending applications: " + studio.getApplications().size());
                    System.out.println("amount of offices: " + studio.getOffices().size());
                    System.out.println("----------------------------------------------------");
                    return true;

                }
                case 0: {
                    System.out.println("game stopped");
                    return false;
                }
                default: {
                    System.out.println("not a valid input. The game will be stopped.");
                }
            }
            return false;
        }).start();
    }

    public static void evaluation(GameDevStudio studio, List<String> eventLog) {
        System.out.println("choose one of the following: ");
        System.out.println("1 to show Event Log ");
        System.out.println("2 to show office-information");
        System.out.println("3 to show developer-information");
        Scanner sc = new Scanner(System.in);
        var input = sc.nextInt();


        switch (input) {
            case 1: {
                //Event log
                System.out.println("Event logs of the current game:");
                for (String st : eventLog) {
                    System.out.println(st);
                }
                break;
            }
            case 2: {
                //Office overview
                for (int i = 0; i < studio.getOffices().size(); i++) {
                    System.out.println("---------------------------------------");
                    System.out.println("name: " + studio.getOffices().get(i).getName().getName());
                    System.out.println("number of slaves: " + studio.getOffices().get(i).getDevelopers().size());
                    System.out.println("office lease: " + studio.getOffices().get(i).getLease());
                    System.out.println("---------------------------------------");
                }
                break;
            }
            case 3: {
                //Developer
                for (int i = 0; i < studio.getOffices().size(); i++) {
                    for (int j = 0; j < studio.getOffices().get(i).getDevelopers().size(); j++) {
                        System.out.println("---------------------------------------");
                        System.out.println("name: " + studio.getOffices().get(i).getDevelopers().get(j).getName().getName());
                        System.out.println("day of hire: " + studio.getOffices().get(i).getDevelopers().get(j).getDayOfHire().getNumber());
                        System.out.println("happiness: " + studio.getOffices().get(i).getDevelopers().get(j).getHappiness().get());
                        System.out.println("salary: " + studio.getOffices().get(i).getDevelopers().get(j).getSalary());
                        if (studio.getOffices().get(i).getDevelopers().get(j).getWorkingOn() != null) {
                            System.out.println("current project: " + studio.getOffices().get(i).getDevelopers().get(j).getWorkingOn().getName());
                        }
                        System.out.println("coding skills : " + studio.getOffices().get(i).getDevelopers().get(j).getSkills().getCoding());
                        System.out.println("design skills : " + studio.getOffices().get(i).getDevelopers().get(j).getSkills().getDesign());
                        System.out.println("research skills : " + studio.getOffices().get(i).getDevelopers().get(j).getSkills().getResearch());
                        System.out.println("testing skills : " + studio.getOffices().get(i).getDevelopers().get(j).getSkills().getTesting());
                        System.out.println("---------------------------------------");
                    }
                }

            }
            default:
                break;
        }
    }
}