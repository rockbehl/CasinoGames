import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Root {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) throws InterruptedException {
        int gameChosen;
        int points;
        boolean play = true;

        System.out.print("Enter initial points value: ");
        points = sc.nextInt();
        System.out.println("---------------");
        System.out.println(points);
        System.out.println("---------------");

        while (play) {
            if (points <= 0) {
                System.out.println("==========================\n======== NO MONEY! ========\n==========================");
                System.out.println("Refill money? (1) | (2) to exit");
                int temp = sc.nextInt();
                if (temp == 1) {
                    System.out.println("Enter new points: ");
                    points = sc.nextInt();
                    System.out.println("Total points " + points);
                } else {
                    break;
                }
            }
            sc.nextLine();
            System.out.println("Choose a game!: | Balance: " + points);
            System.out.println("1. Coinflip (DOUBLE YOUR MONEY FROM 1 TOSS!)");
            System.out.println("2. Wheel of Fortunes (BEST CHANCES TO MAKE PROFIT!)");
            System.out.println("3. Guess The Number (5 TRIES TO GUESS THE NUMBER!!)");
            System.out.println("4. Black Jack (FIRST TO 21 !!!)");
            System.out.println("5. ROLL WHEELS (IF NUMBERS ADD TO EVEN YOU CAN MULTIPLY PROFIT!!)");
            System.out.println("6. ROULETTE (WIN UP TO 15 TIMES YOUR WAGER)");
            System.out.println("7. Bathe in your riches! (EXIT)");
            System.out.println("-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
            System.out.println("Choose a game: ");
            gameChosen = sc.nextInt();

            System.out.println("========================");
            switch (gameChosen) {
                case 1 -> points = coinFlip(points);
                case 2 -> points = WoF(points);
                case 3 -> points = GtN(points);
                case 4 -> points = BkJk(points);
                case 5 -> points = Roll(points);
                case 6 -> points = Game2(points);
                default -> gameChosen = 7;
            }
            if (gameChosen == 7) {
                System.out.println("Withdrawn amount: " + points);
                play = false;
            }

        }


    }

    public static int coinFlip(int points) {
        boolean playingCF = true;

        while (playingCF) {

            int playingPoints = wager(points);

            int userChoice;
            System.out.println("Heads (1) or Tails (2)");
            userChoice = sc.nextInt();

            switch (userChoice) {
                case 1 -> System.out.println("YOU SELECTED HEADS!");
                case 2 -> System.out.println("YOU SELECTED TAILS!");
            }
            System.out.println("==================");
            double compChoice = rand.nextDouble();
            if (compChoice >= 0.5 || compChoice == userChoice) {
                points = points + playingPoints;
                System.out.println("You won!");
            } else {
                points = points - playingPoints;
                System.out.println("You lost!");
            }
            System.out.println("-=-=-=-=-=-=-=-=-");
            System.out.println("Balance: " + points);
            System.out.println("-=-=-=-=-=-=-=-=-");
            if (points <= 0) {
                System.out.println("==========================\n========= NO MONEY! =========\n==========================");
                break;
            }
            System.out.println("Play again? (1) = Yes, (2) = No");
            int playAgain = sc.nextInt();
            if (playAgain == 2) {
                playingCF = false;
            }
        }

        if (points <= 0) {
            System.out.println("==========================\n========= NO MONEY! =========\n==========================");
        }
        return points;
    }

    public static int WoF(int points) throws InterruptedException {
        boolean playWoF = true;

        while (playWoF) {

            int playingPoints = wager(points);

            int wheel = rand.nextInt(100);

            System.out.println("PRESS (1) TO SPIN!");
            int temp = sc.nextInt();


            System.out.println("[+++|++++++++] 55% to lose");
            Thread.sleep(500);
            System.out.println("[++++++|+++++] 30% to double");
            Thread.sleep(500);
            System.out.println("[+++++++++|++] 10% to triple");
            Thread.sleep(500);
            System.out.println("[+++++|++++++] 5% to quadruple");
            Thread.sleep(500);
            System.out.println("[|+++++++++++] ROLLING...");


            if (wheel <= 55) {
                points = points - playingPoints;
                System.out.println("==========");
                System.out.println("YOU LOST!");
                System.out.println("==========");

            }
            if (wheel > 55 && wheel <= 85) {
                points = points + (playingPoints * 2);
                System.out.println("=======================");
                System.out.println("YOU DOUBLED YOUR POINTS");
                System.out.println("=======================");

            }
            if (wheel > 85 && wheel <= 95) {
                points = points + (playingPoints * 3);
                System.out.println("=======================");
                System.out.println("YOU TRIPLED YOUR POINTS");
                System.out.println("=======================");


            }
            if (wheel > 95) {
                points = points + (playingPoints * 4);
                System.out.println("==========================");
                System.out.println("YOU QUADRUPLED YOUR POINTS");
                System.out.println("==========================");

            }
            System.out.println("-=-=-=-=-=-=-=-=-");
            System.out.println("Balance: " + points);
            System.out.println("-=-=-=-=-=-=-=-=-");
            if (points <= 0) {
                System.out.println("==========================\n========= NO MONEY! =========\n==========================");
                break;
            }
            System.out.println("Play again? (1) = Yes, (2) = No");
            int playAgain = sc.nextInt();
            if (playAgain == 2) {
                playWoF = false;
            }
        }

        if (points <= 0) {
            System.out.println("==========================\n========= NO MONEY! =========\n==========================");
        }

        return points;
    }

    public static int GtN(int points) throws InterruptedException {
        boolean playingGtn = true;

        while (playingGtn) {

            int playingPoints = wager(points);

            int tryNumber = 1;
            int userInput = 0;
            int compChoice = (rand.nextInt(99) + 1);
            boolean guessing = true;
            System.out.println("Enter a number between 1-100, IF ITS THE SAME as the computer... you DOUBLE your wager!");
            while (guessing) {
                System.out.print("Try " + tryNumber + ": ");
                userInput = sc.nextInt();

                if (userInput == compChoice) {
                    System.out.print("YOU GUESSED THE ... ");
                    Thread.sleep(500);
                    System.out.println("THE RIGHT NUMBER!!");
                    points = points + playingPoints;
                    break;
                }
                if (userInput > compChoice) {
                    System.out.print("THE NUMBER IS ... ");
                    Thread.sleep(500);
                    System.out.println("LOWER!");
                    tryNumber++;
                }
                if (userInput < compChoice) {
                    System.out.print("THE NUMBER IS ...");
                    Thread.sleep(500);
                    System.out.println(" HIGHER!");
                    tryNumber++;
                }
                if (tryNumber < 6) {
                    System.out.println("You: " + userInput + " |0| Computer: ?");
                }
                if (tryNumber == 6) {
                    guessing = false;
                    System.out.println("Your last input: " + userInput + " |0| " + "Computer chose: " + compChoice);
                    points = points - playingPoints;
                    playingGtn = false;
                    break;
                }
            }
            System.out.println("-=-=-=-=-=-=-=-=-");
            System.out.println("Balance: " + points);
            System.out.println("-=-=-=-=-=-=-=-=-");
            if (points <= 0) {
                System.out.println("==========================\n========= NO MONEY! =========\n==========================");
                break;
            }
            System.out.println("Play again? (1) = Yes, (2) = No");
            int playAgain = sc.nextInt();
            if (playAgain == 2) {
                playingGtn = false;
            }
        }

        if (points <= 0) {
            System.out.println("==========================\n========= NO MONEY! =========\n==========================");
        }

        return points;
    }

    public static int BkJk(int points) throws InterruptedException {
        boolean playBkJk = true;
        boolean cplay = true;

        while (playBkJk) {

            int playingPoints = wager(points);

            System.out.println("BlackJack! DONT GO OVER 21!!!");
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");

            int userInput = 0;
            int[] cardArr = new int[10];
            int[] compArr = new int[10];

            cardArr[0] = rand.nextInt(9) + 1;
            cardArr[1] = rand.nextInt(9) + 1;
            compArr[0] = rand.nextInt(9) + 1;
            compArr[1] = rand.nextInt(9) + 1;
            if (cardArr[0] == 1) {
                cardArr[0]++;
            }
            if (cardArr[1] == 1) {
                cardArr[1]++;
            }
            if (compArr[0] == 1) {
                compArr[0]++;
            }
            if (compArr[1] == 1) {
                compArr[1]++;
            }

            System.out.println("Your initial cards are: " + cardArr[0] + " and " + cardArr[1]);
            System.out.println("[=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=]");
            boolean hitorstay = true;
            int indexTOadd = 2;
            int compAdd = 2;

            while (hitorstay) {
                System.out.println("Would you like Hit(1) or Stay(2) ?   |0|    Your total is: " + Arrays.stream(cardArr).sum());
                userInput = sc.nextInt();

                if (userInput == 1) {
                    for (int i = 0; i < cardArr.length; i++) {
                        if (cardArr[i] == 0) {
                            cardArr[indexTOadd] = rand.nextInt(10);
                            if (cardArr[indexTOadd] == 0) {
                                cardArr[indexTOadd]++;
                            }
                            if (cardArr[indexTOadd] == 1) {
                                cardArr[indexTOadd]++;
                            }
                        }
                    }
                    System.out.println("Your new card: " + cardArr[indexTOadd]);
                    indexTOadd++;
                }

                if (Arrays.stream(cardArr).sum() > 21) {
                    System.out.println("YOU LOSE (BUST)!");
                    points = points - playingPoints;
                    cplay = false;
                    break;
                }

                if (userInput == 2) {
                    hitorstay = false;
                }
            }

            if (cplay) {
                System.out.println("Comp hand: " + compArr[0] + ", and, " + compArr[1]);

                while (Arrays.stream(compArr).sum() < 17) {
                    System.out.println("COMP HITS!");
                    for (int i = 0; i < compArr.length; i++) {
                        if (compArr[i] == 0) {
                            compArr[compAdd] = rand.nextInt(9) + 1;
                        }
                    }
                    System.out.print("The comp's new card is: " + compArr[compAdd] + "  ");
                    Thread.sleep(200);
                    System.out.println(" |0|  Comp total: " + Arrays.stream(compArr).sum());
                    compAdd++;
                    if (Arrays.stream(compArr).sum() > 21) {
                        System.out.println("YOU WIN (COMP BUST)!");
                        points = points + playingPoints;
                        break;
                    }
                }
            }


            System.out.println("[=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=][=]");

            int userFinal = Arrays.stream(cardArr).sum();
            int compFinal = Arrays.stream(compArr).sum();
            if (userFinal == compFinal) {
                System.out.println("TIE!\nHOUSE WINS!");
                points = points - playingPoints;
            }
            if (userFinal == 21) {
                System.out.println("YOU WIN!");
                points = points + playingPoints;

            } else if (compFinal == 21) {
                System.out.println("YOU LOSE!");
                points = points - playingPoints;

            } else if (userFinal > compFinal && userFinal <= 21) {
                System.out.println("YOU WIN!");
                points = points + playingPoints;

            } else if (userFinal < compFinal && compFinal <= 21) {
                System.out.println("YOU LOSE!");
                points = points - playingPoints;

            }

            System.out.println("-=-=-=-=-=-=-=-=-");
            System.out.println("Balance: " + points);
            System.out.println("-=-=-=-=-=-=-=-=-");
            if (points <= 0) {
                System.out.println("==========================\n========= NO MONEY! =========\n==========================");
                break;
            }
            System.out.println("Play again? (1) = Yes, (2) = No");
            int playAgain = sc.nextInt();
            if (playAgain == 2) {
                playBkJk = false;
            }
        }

        if (points <= 0) {
            System.out.println("==========================\n========= NO MONEY! =========\n==========================");
        }


        return points;
    }

    public static int Roll(int points) throws InterruptedException {
        boolean playingRoll = true;

        while (playingRoll) {

            int playingPoints = wager(points);

            System.out.println("Welcome to ROLL! \n  1. You roll 3 numbers \n  2. If their sum is even you get to roll again and multiply tour reward amount! \n  3. Three identical numbers WIN!");
            System.out.println("[|-|]     [|-|]     [|-|]");
            boolean playing = true;
            int roll = 0;
            boolean even = true;
            int wheel1 = 0;
            int wheel2 = 0;
            int wheel3 = 0;
            int reward = 2;

            while (playing) {

                while (even) {
                    System.out.println("Ready? (1)");
                    int temp = sc.nextInt();

                    wheel1 = rand.nextInt(10);
                    wheel2 = rand.nextInt(10);
                    wheel3 = rand.nextInt(10);

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 1; j++) {
                            System.out.println("   [|+|]     [|+|]     [|+|]");
                            Thread.sleep(500);
                        }
                        System.out.println("   [|-|]     [|-|]     [|-|]");
                        Thread.sleep(500);
                    }


                    roll++;
                    System.out.println("Roll " + roll + ": ");
                    System.out.println("  [|" + wheel1 + "|]   " + "   [|" + wheel2 + "|]   " + "   [|" + wheel3 + "|]   ");


                    if ((wheel1 + wheel2 + wheel3) % 2 == 0) {
                        reward++;
                        System.out.println("EVEN! REWARD MULTIPLIER IS NOW: " + reward);

                    } else {
                        even = false;
                    }
                }

                if (wheel1 == wheel2 && wheel1 == wheel3) {
                    System.out.println("YOU WIN!     |0|       REWARD X: " + reward);
                    System.out.println("CONTINUE TO MAKE MORE PROFIT? (1) or (2)");
                    int temp = sc.nextInt();
                    if (temp == 2) {
                        points = points + (playingPoints * reward);
                        break;
                    } else {
                        continue;
                    }
                }
                if (wheel1 != wheel2 && wheel1 != wheel3 || (wheel1 + wheel2 + wheel3) % 2 != 0) {
                    System.out.println("You Lose");
                    points = points - playingPoints;
                    break;
                }

            }

            System.out.println("-=-=-=-=-=-=-=-=-");
            System.out.println("Balance: " + points);
            System.out.println("-=-=-=-=-=-=-=-=-");
            if (points <= 0) {
                System.out.println("==========================\n========= NO MONEY! =========\n==========================");
                break;
            }
            System.out.println("Play again? (1) = Yes, (2) = No");
            int playAgain = sc.nextInt();
            if (playAgain == 2) {
                playing = false;
            }
        }

        if (points <= 0) {
            System.out.println("==========================\n========= NO MONEY! =========\n==========================");
        }

        return points;
    }

    public static int Game2(int points) {
        boolean playing = true;

        while (playing) {
            int rewardMulti = 2;
            String[] Colors = {"Red", "Black"};

            System.out.println("====== WELCOME TO ======");
            System.out.println("====== ROULETTE!! ======");
            System.out.println("\nBET ON: COLOR, ODD OR EVEN, AND NUMBER");

            int playingPoints = wager(points);

            while (playingPoints > points) {
                System.out.println("Enter ammount you want to play with: ");
                playingPoints = sc.nextInt();
            }

            System.out.println("BET ON? \n1. COLOR(x2)\n2. COLOR AND ODD OR EVEN(x3)\n3. COLOR AND ODD OR EVEN AND EXACT NUMBER(x15)");
            int playergame = sc.nextInt();

            int colorIndex = rand.nextInt(2);
            int number = rand.nextInt(33);
            if (number == 32) {
                String zerzero = "00";
            }


            if (playergame == 1) {

                System.out.println("Choose a color to bet on:\n1. Red\n2. Black");
                int cbet = sc.nextInt();

                if (cbet == 1 && colorIndex == 0) {
                    System.out.println("YOU WIN");
                    System.out.println("COLOR CHOSEN: RED  |0|  COLOR LANDED ON: " + Colors[colorIndex]);
                    points = points + (playingPoints * rewardMulti);
                } else {
                    System.out.println("You Lose!");
                    points = points - playingPoints;
                }
                if (cbet == 2 && colorIndex == 1) {
                    System.out.println("YOU WIN");
                    System.out.println("COLOR CHOSEN: RED  |0|  COLOR LANDED ON: " + Colors[colorIndex]);
                    points = points + (playingPoints * rewardMulti);
                } else {
                    System.out.println("You Lose!");
                    points = points - playingPoints;
                }

            }
            if (playergame == 2) {

                System.out.println("Choose a color to bet on:\n1. Red\n2. Black");
                int cbet = sc.nextInt();
                System.out.println("Choose a parity (Odd and Even) to bet on:\n1. Even\n2. Odd");
                int pbet = sc.nextInt();

                if ((cbet == 1 && colorIndex == 0) || (cbet == 2 && colorIndex == 1) && (number % 2 == 0) && (pbet == 1) || (number % 2 != 0) && (pbet == 2)) {
                    rewardMulti++;
                    System.out.println("YOU WIN");
                    System.out.println("COLOR CHOSEN: RED  PARITY CHOSEN: EVEN  |0|   PARITY LANDED ON: EVEN   COLOR LANDED ON: " + Colors[colorIndex]);
                    points = points + (playingPoints * rewardMulti);
                } else {
                    System.out.println("You Lose!");
                    points = points - playingPoints;
                }

            }
            if (playergame == 3) {
                System.out.println("Choose a color to bet on:\n1. Red\n2. Black");
                int cbet = sc.nextInt();
                System.out.println("Choose a parity (Odd and Even) to bet on:\n1. Even\n2. Odd");
                int pbet = sc.nextInt();
                int nbet = 0;
                while (nbet == 0 || nbet > 31) {
                    System.out.println("Choose number to bet on:\n1. Between 1 - 31\n2. If the number is 0 or 00, HOUSE WINS!");
                    nbet = sc.nextInt();
                }
                String parity;
                if (number % 2 == 0) {
                    parity = "Even";
                } else {
                    parity = "Odd";
                }

                if (number == 32) {
                    System.out.println("You Lose! The number landed on was 00! HOUSE WINS!");
                    points = points - playingPoints;
                } else if (number == 0) {
                    System.out.println("You Lose! The number landed on was 0! HOUSE WINS!");
                    points = points - playingPoints;
                }


                if ((nbet == number) && ((cbet == 1 && colorIndex == 0) || (cbet == 2 && colorIndex == 1)) && ((number % 2 == 0) && (pbet == 1)) || ((number % 2 != 0) && (pbet == 2))) {
                    rewardMulti = 15;
                    System.out.println("YOU WIN");
                    System.out.println("PARITY LANDED ON: " + parity + " COLOR LANDED ON: " + Colors[colorIndex] + " NUMBER LANDED ON: " + number);
                    points = points + (playingPoints * rewardMulti);
                } else {
                    System.out.println("You Lose! WHEEL LANDED ON: " + number + ", " + parity + ", " + Colors[colorIndex]);
                    points = points - playingPoints;
                }
            }


            System.out.println("-=-=-=-=-=-=-=-=-");
            System.out.println("Balance: " + points);
            System.out.println("-=-=-=-=-=-=-=-=-");
            if (points <= 0) {
                System.out.println("==========================\n========= NO MONEY! =========\n==========================");
                break;
            }
            System.out.println("Play again? (1) = Yes, (2) = No");
            int playAgain = sc.nextInt();
            if (playAgain == 2) {
                playing = false;
            }
        }

        if (points <= 0) {
            System.out.println("==========================\n========= NO MONEY! =========\n==========================");
        }

        return points;
    }

    private static int wager(int points) {
        boolean end = true;
        int playingPoints = 0;

        while (end) {
            if (points <= 0) {
                System.out.println("==========================\n========= NO MONEY! =========\n==========================");
                break;
            }

            System.out.println("Enter amount you want to play with:      |       Balance: " + points);
            playingPoints = sc.nextInt();

            while (playingPoints > points || playingPoints <= 0) {
                System.out.println("Enter a valid amount you want to play with ");
                playingPoints = sc.nextInt();

            }
            end = false;
        }

        return playingPoints;
    }

}
