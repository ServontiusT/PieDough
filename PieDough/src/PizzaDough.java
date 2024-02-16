import java.util.ArrayList;

public class PizzaDough {
    private double flourOne;
    private double flourTwo;
    private double flourThree;
    private double water;
    private double salt;
    private double yeast;
    private double oil;
    private double sugar;

    public PizzaDough(
            double pctFlourOne, double pctFlourTwo, double pctFlourThree, double pctWater, double pctSalt, double pctYeast, double pctOil, double pctSugar
    ) {
        this.flourOne = pctFlourOne;
        this.flourTwo = pctFlourTwo;
        this.flourThree = pctFlourThree;
        this.water = pctWater;
        this.salt = pctSalt;
        this.yeast = pctYeast;
        this.oil = pctOil;
        this.sugar = pctSugar;
    }

    public ArrayList<Double> calculateIngredientWeight(int numberOfBalls, double ballWeight) {
        double flourTotal = flourOne + flourTwo + flourThree;
        double ingredientPercentTotal = flourTotal + this.water + this.yeast + this.salt + this.oil + this.sugar;
        double expectedTotal = numberOfBalls * ballWeight;
        double multiplier = expectedTotal / ingredientPercentTotal;

        ArrayList<Double> ingredientWeights = new ArrayList<>();
        ArrayList<Double> ingredients = new ArrayList<>();

        ingredients.add(this.flourOne);
        ingredients.add(this.flourTwo);
        ingredients.add(this.flourThree);
        ingredients.add(this.water);
        ingredients.add(this.salt);
        ingredients.add(this.yeast);
        ingredients.add(this.oil);
        ingredients.add(this.sugar);

        for(double ingredient: ingredients) {
            ingredientWeights.add(ingredient * multiplier);
        }

        return ingredientWeights;
    }
}
