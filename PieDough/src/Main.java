import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner systemScanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("********************** PieDough v0.1 **********************");
        System.out.println("Please choose from the options below: ");
        System.out.println("[1] Use Base Dough Recipe \n[2] Create Custom Dough Recipe");

        int menuChoice = Integer.valueOf(systemScanner.nextLine());

        clearScreen();
        ingredientCalculator(systemScanner, df, menuChoice);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void ingredientCalculator(Scanner scanner, DecimalFormat df, int receipeType) {
        String flourOneType = "AP", flourTwoType = "AP", flourThreeType = "AP";

        int flourCount;

        double flourOnePercent = 0.0;
        double flourTwoPercent = 0.0;
        double flourThreePercent = 0.0;
        double waterPercent = 65.0;
        double saltPercent = 2.0;
        double yeastPercent = 0.35;
        double oilPercent = 2.0;
        double sugarPercent = 1.0;

        double flourOneWeight = 0.0;
        double flourTwoWeight = 0.0;
        double flourThreeWeight = 0.0;
        double waterWeight = 0.0;
        double saltWeight = 0.0;
        double yeastWeight = 0.0;
        double oilWeight = 0.0;
        double sugarWeight = 0.0;

        if (receipeType == 2){
            System.out.print("Enter custom Percentage of Water: ");
            waterPercent = Double.valueOf(scanner.nextLine());
            System.out.print("Enter custom Percentage of Salt: ");
            saltPercent = Double.valueOf(scanner.nextLine());
            System.out.print("Enter custom Percentage of Yeast: ");
            yeastPercent = Double.valueOf(scanner.nextLine());
            System.out.print("Enter custom Percentage of Oil: ");
            oilPercent = Double.valueOf(scanner.nextLine());
            System.out.print("Enter custom Percentage of Sugar: ");
            sugarPercent = Double.valueOf(scanner.nextLine());
        }
        System.out.print("Number of Pizzas needed: ");
        int numOfDoughBalls = Integer.valueOf(scanner.nextLine());

        System.out.print("Weight of each Dough Ball (1oz or 28g = 1-inch): ");
        double doughBallWeight = Double.valueOf(scanner.nextLine());

        while (true) {
            System.out.print("How many flours will be used (max 3)? ");
            flourCount = Integer.valueOf(scanner.nextLine());

            if (flourCount > 3 || flourCount < 0) {
                System.out.println("Invalid number of flours. Please enter a number between 1 and 3");
                continue;
            } else {
                break;
            }
        }

        if (flourCount == 3) {
            System.out.print("Flour Type 1 and Percent: ");
            flourOneType = scanner.nextLine();
            flourOnePercent = Double.valueOf(scanner.nextLine());

            System.out.print("Flour Type 2 and Percent: ");
            flourTwoType = scanner.nextLine();
            flourTwoPercent = Double.valueOf(scanner.nextLine());

            System.out.println("Flour Type 3 and Percent: ");
            flourThreeType = scanner.nextLine();
            flourThreePercent = Double.valueOf(scanner.nextLine());
        } else if (flourCount == 2) {
            System.out.print("Flour Type 1 and Percent: ");
            flourOneType = scanner.nextLine();
            flourOnePercent = Double.valueOf(scanner.nextLine());

            System.out.print("Flour Type 2 and Percent: ");
            flourTwoType = scanner.nextLine();
            flourTwoPercent = Double.valueOf(scanner.nextLine());
        } else {
            System.out.print("Flour Type and Percent: ");
            flourOneType = scanner.nextLine();
            flourOnePercent = Double.valueOf(scanner.nextLine());
        }

        double ingredientPercentTotal = 100 + waterPercent + yeastPercent + saltPercent + oilPercent + sugarPercent;
        double expectedTotal = numOfDoughBalls * doughBallWeight;
        double multiplier = expectedTotal / ingredientPercentTotal;

        flourOneWeight = flourOnePercent * multiplier;
        flourTwoWeight = flourTwoPercent * multiplier;
        flourThreeWeight = flourThreePercent * multiplier;

        waterWeight = waterPercent * multiplier;
        saltWeight = saltPercent * multiplier;
        yeastWeight = yeastPercent * multiplier;
        oilWeight = oilPercent * multiplier;
        sugarWeight = sugarPercent * multiplier;

        clearScreen();

        System.out.println("********************** Ingredients **********************");

        if (flourCount == 3) {
            System.out.println(flourOneType + " Flour: " + df.format(flourOneWeight) + "g");
            System.out.println(flourTwoType + " Flour: " + df.format(flourTwoWeight) + "g");
            System.out.println(flourThreeType + " Flour: " + df.format(flourThreeWeight) + "g");
        } else if (flourCount == 2) {
            System.out.println(flourOneType + " Flour: " + df.format(flourOneWeight) + "g");
            System.out.println(flourTwoType + " Flour: " + df.format(flourTwoWeight) + "g");
        } else {
            System.out.println(flourOneType + " Flour: " + df.format(flourOneWeight) + "g");
        }
        System.out.println("Water: " + df.format(waterWeight) + "g");
        System.out.println("Salt: " + df.format(saltWeight) + "g");
        System.out.println("Yeast: " + df.format(yeastWeight) + "g");

        if (oilWeight > 0) {
            System.out.println("Oil: " + df.format(oilWeight) + "g");
        }
        if (sugarWeight > 0) {
            System.out.println("Sugar: " + df.format(sugarWeight) + "g");
        }
        System.out.println(" ");
        System.out.println("Expected Dough Weight: " + expectedTotal);
    }
}
