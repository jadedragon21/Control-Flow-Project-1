package com.tts;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final int MAX_MAGIC = 75;
    private static final int MAX_BALL = 60;
    private static final int BALL_PULL = 5;

    public static void main(String[] args) {
        Scanner redQueen = new Scanner(System.in);
        String humanName = "";
        String reply = "";
        boolean keepPlaying = false;

        // Establish our program's legitimacy by printing to console
        System.out.println("Hello world! Get ready for the Red Queen to take over the world!");

        // Display the valid input characters
        AsciiChars.printNumbers();
        AsciiChars.printLowerCase();
        AsciiChars.printUpperCase();

        // Ask for the user's name and display it
        System.out.println("Please enter your name human.");
        System.out.print("Type your name here human: ");
        humanName = redQueen.nextLine();
        System.out.println("Hello, " + humanName);

        // Ask if user wants to begin the interactive portion
        System.out.println("Would you like to play a game human?");
        System.out.print("(Y/N): ");
        reply = redQueen.nextLine();

        keepPlaying = (reply.equalsIgnoreCase("y") || reply.equalsIgnoreCase("yes"));
        System.out.println("Do you want to continue playing human?: " + keepPlaying);

        while (keepPlaying) {

            System.out.println("Let's create some lucky numbers!");

            // Question: Red Car Portion
            System.out.print("Do you have a red car? (yes, no): ");
            String rCar = redQueen.nextLine();
            boolean rCarBoolean = false;
            if (rCar.equalsIgnoreCase("y") || rCar.equalsIgnoreCase("yes")) {
                System.out.println("Sweet! Nice ride human!");
                rCarBoolean = true;
            } else System.out.println("Bzzt! There is no sweet ride here!");

            // Question: Favorite Pet
            String fvPet = "";
            System.out.println("What's your favorite pet's name human? : ");
            fvPet = redQueen.nextLine();
            System.out.println("Awe! A pet named " + fvPet + ", how cute!");

            //Favorite Pet Age
            System.out.println(" What's " + fvPet + " ,age in years? (##): ");
            int favPetAge = redQueen.nextInt();
            reply = redQueen.nextLine();
            System.out.println("Age of your favorite pet: " + favPetAge);

            // Question: Lucky number
            System.out.println("What's your lucky number? : ");
            int luckNumbr = redQueen.nextInt();
            reply = redQueen.nextLine();
            System.out.println("Human, your lucky number is: " + luckNumbr + "? Maybe you'll win the Lottery...or not?");

            // Question: Jersey Number
            boolean favQB = false;
            System.out.println("Do you have a favorite quarterback human? (Y/N): ");
            reply = redQueen.nextLine();
            favQB = (reply.equalsIgnoreCase("y") || reply.equalsIgnoreCase("yes"));
            if (favQB) {
                System.out.println("Sweet! Do you know their jersey number human? (##): ");

            } else System.out.println("Well human, just gimme a two-digit number! (##): ");
            int jersNum = redQueen.nextInt();
            reply = redQueen.nextLine();
            System.out.println("Zoinks! Their jersey number is " + jersNum + ", good choice!");

            // Question: Model Year of their car
            System.out.println("What are the last two digits of your car's model year? (##): ");
            int modelYr = redQueen.nextInt();
            reply = redQueen.nextLine();
            System.out.println("Ah yes, good ole '" + modelYr + ", the best year for those models numbers human!");

            // Question: Favorite Actor
            System.out.println("Who is your favorite actor or actress? (name): ");
            String favActor = redQueen.nextLine();
            System.out.println("Oh! You know of " + favActor + "? I thought they were pretty excellent in their latest film human!");

            // Question: Random Number 1-50
            System.out.println("Enter any random number between 0 and 50 human! (0-50): ");
            int randomNumber = redQueen.nextInt();
            reply = redQueen.nextLine();
            System.out.println("Human! I've been slain by the random number " + randomNumber + ", so slay we all!");

            // Generate those magic lotto numbers!
            int ball_magic = 0;
            int random_magic = (int) Math.floor(Math.random() * MAX_MAGIC) + 1;
            int random_ball1 = (int) Math.floor(Math.random() * MAX_BALL) + 1;
            int random_ball2 = (int) Math.floor(Math.random() * MAX_BALL) + 1;

            // Final Magic Ball Result
            int humanProvidedNumbr = Math.random() > 0.5 ? jersNum : randomNumber;
            int finalMagicBall = (int) (Math.floor(Math.random() * humanProvidedNumbr + 1));
            finalMagicBall = reduceMagic(finalMagicBall);

            ArrayList<Integer> resultHopper = new ArrayList<>();

            // Final Pet Ball Result
            int finalFavePet = fvPet.charAt(2);
            finalFavePet = reduceNormal(finalFavePet);
            resultHopper.add(finalFavePet);

            // Final Model Year + Lucky Number Result
            int finalModelYearAndLucky = modelYr + luckNumbr;
            finalModelYearAndLucky = reduceNormal(finalModelYearAndLucky);
            resultHopper.add(finalModelYearAndLucky);

            // Final Random Number Result
            int finalRandoNumbr = randomNumber - (Math.random() < 0.5 ? random_ball1 : random_ball2);
            finalRandoNumbr = reduceNormal(finalRandoNumbr);
            resultHopper.add(finalRandoNumbr);

            // Final Fav Actor Result
            int finalFavActor = favActor.charAt(0);
            finalFavActor = reduceNormal(finalFavActor);
            resultHopper.add(finalFavActor);

            // Final End Fav Actor Result
            int finalEndingFavActor = favActor.charAt(favActor.length() - 1);
            finalEndingFavActor = reduceNormal(finalEndingFavActor);
            resultHopper.add(finalEndingFavActor);

            // Final Stretch 42 Result
            int finalCatch42 = 42;
            finalCatch42 = reduceNormal(finalCatch42);
            resultHopper.add(finalCatch42);

            // Final Pet Age + Model Year Result
            int finalPetAgeAndModelYear = favPetAge + modelYr;
            finalPetAgeAndModelYear = reduceNormal(finalPetAgeAndModelYear);
            resultHopper.add(finalPetAgeAndModelYear);

            // Final Fav QuarterBack + Pet Age + Lucky Num Result
            int finalQbPetAgeLuckNum = jersNum + favPetAge + luckNumbr;
            finalQbPetAgeLuckNum = reduceNormal(finalQbPetAgeLuckNum);
            resultHopper.add(finalQbPetAgeLuckNum);

            // Select BALL_PULL results
            int[] yourOutcome = new int[BALL_PULL];
            for (int i = 0; i < BALL_PULL; i++) {
                int randomPull = (int) Math.floor(Math.random() * resultHopper.size());
                yourOutcome[i] = resultHopper.get(randomPull);
                resultHopper.remove(randomPull);
            }

            // Print the final results!
            System.out.print("\n\nYour lucky lotto numbers are: ");
            for (int i = 0; i < BALL_PULL; i++
            ) {
                System.out.print(yourOutcome[i]);
                if (i < BALL_PULL - 1) System.out.print(",");
                System.out.print(" ");
            }
            System.out.print("Magic Ball: " + finalMagicBall + "\n\n");

            // Try Playing again?
            System.out.println("Do you want to try again human? (Y/N): ");
            reply = redQueen.nextLine();
            keepPlaying = (reply.equalsIgnoreCase("y") || reply.equalsIgnoreCase("yes"));

        }

        System.out.println("Insert Resident Evil quote here: Red Queen Out!");
    }

    private static int reduceBall(int ballBerry, int max) {
        while (ballBerry > max) ballBerry -= max;
        return ballBerry;
    }

    private static int reduceMagic(int magicBallBerry) {
        return reduceBall(magicBallBerry, MAX_MAGIC);
    }

    private static int reduceNormal(int normalBallBerry) {
        return reduceBall(normalBallBerry, MAX_BALL);
    }
}


