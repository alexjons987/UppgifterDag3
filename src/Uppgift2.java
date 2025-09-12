import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Uppgift2 {
    public static void main(String[] args) {
        System.out.println("- Assignment 2: Recipe manager -");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Create relevant ArrayLists
        ArrayList<String> recipeNames = new ArrayList<String>();
        ArrayList<String> recipeIngredients = new ArrayList<String>();
        ArrayList<Integer> recipePortions = new ArrayList<Integer>();

        // Add some recipes
        addRecipe(recipeNames, recipeIngredients, recipePortions, "Asian Zing Chicken Noodles", "Noodles Chicken Chili Soy Ginger", random.nextInt(1, 5));
        addRecipe(recipeNames, recipeIngredients, recipePortions, "Pesto Tortellini Bake", "Pasta Eggs Pesto Sun-dried Tomato", random.nextInt(1, 5));
        addRecipe(recipeNames, recipeIngredients, recipePortions, "Italian Pasta Salad", "Capers White beans Chickpeas Shredded chicken", random.nextInt(1, 5));
        addRecipe(recipeNames, recipeIngredients, recipePortions, "Turkey Taco Bowls", "Turkey Rice Lettuce Onion Tofu", random.nextInt(1, 5));
        addRecipe(recipeNames, recipeIngredients, recipePortions, "Lemony Zucchini Pasta", "Pasta Eggs Zucchini Chicken", random.nextInt(1, 5));

        // Main menu-loop
        boolean flag = true;
        while (flag) {
            int menuChoice;
            do {
                System.out.println("\n1. Add recipe");
                System.out.println("2. Show all recipes");
                System.out.println("3. Search recipe by name");
                System.out.println("4. Search recipe by ingredients");
                System.out.println("0. Exit");
                System.out.print(": ");
            } while ((menuChoice = scanner.nextInt()) < 0 || menuChoice > 4);

            int recipeChoice;
            int[] searchResult;
            switch (menuChoice) {
                case 0:
                    flag = false;
                    break;
                case 1: // Add recipe
                    System.out.print("Recipe name: ");
                    String newRecipeName = scanner.next();
                    System.out.print("Ingredients: ");
                    String newRecipeIngredients = scanner.next();
                    System.out.print("Portions: ");
                    int newRecipePortions = scanner.nextInt();
                    addRecipe(
                            recipeNames,
                            recipeIngredients,
                            recipePortions,
                            newRecipeName,
                            newRecipeIngredients,
                            newRecipePortions
                    );
                    break;
                case 2: // Show all recipes
                    showAllRecipes(recipeNames, recipeIngredients, recipePortions);
                    break;
                case 3: // Search recipe by name
                    System.out.print("Search recipe by ingredients by name: ");
                    String searchName = scanner.next();
                    searchResult = searchRecipe(recipeNames, searchName);

                    do {
                        System.out.print("Select recipe to change (0 = exit): ");
                    } while ((recipeChoice = scanner.nextInt()) < 0 || recipeChoice > searchResult.length);

                    if (recipeChoice == 0)
                        break;

                    System.out.print("Set new portions for chosen recipe: ");
                    changeRecipePortions(recipePortions, searchResult[recipeChoice - 1], scanner.nextInt());
                    break;
                case 4: // Search recipe by ingredients
                    System.out.print("Search recipe by ingredients: ");
                    String searchIngredients = scanner.next();
                    searchResult = searchRecipeByIngredients(recipeNames, recipeIngredients, searchIngredients);

                    do {
                        System.out.print("Select recipe to change (0 = exit): ");
                    } while ((recipeChoice = scanner.nextInt()) < 0 || recipeChoice > searchResult.length);

                    if (recipeChoice == 0)
                        break;

                    System.out.print("Set new portions for chosen recipe: ");
                    changeRecipePortions(recipePortions, searchResult[recipeChoice - 1], scanner.nextInt());
                    break;
            }
        }
    }

    public static void addRecipe(
            ArrayList<String> recipeNames,
            ArrayList<String> recipeIngredients,
            ArrayList<Integer> recipePortions,
            String name,
            String ingredients,
            int portions
    ) {
        recipeNames.add(name);
        recipeIngredients.add(ingredients);
        recipePortions.add(portions);
        System.out.printf("Added new recipe for %s (portions: %d)!\n", name, portions);
    }

    public static void showAllRecipes(
            ArrayList<String> recipeNames,
            ArrayList<String> recipeIngredients,
            ArrayList<Integer> recipePortions
    ) {
        System.out.printf("All %d available recipes:\n", getRecipeCount(recipeNames));
        for (int i = 0; i < recipeNames.size(); i++) {
            System.out.printf(
                    "%d. %s - %d portion(s): %s\n",
                    i + 1,
                    recipeNames.get(i),
                    recipePortions.get(i),
                    recipeIngredients.get(i)
            );
        }
    }

    public static int[] searchRecipe(
            ArrayList<String> recipeNames,
            String searchTerm
    ) {
        ArrayList<Integer> foundRecipeIndexes = new ArrayList<Integer>();

        System.out.printf("Recipe(s) matching search term \"%s\":\n", searchTerm);
        int printIndex = 1;
        for (int i = 0; i < recipeNames.size(); i++)
            if (recipeNames.get(i).contains(searchTerm)) {
                System.out.printf("%d. %s\n", printIndex, recipeNames.get(i));
                foundRecipeIndexes.add(i);
                printIndex++;
            }

        return foundRecipeIndexes.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] searchRecipeByIngredients(
            ArrayList<String> recipeNames,
            ArrayList<String> recipeIngredients,
            String ingrediens
    ) {
        ArrayList<Integer> foundRecipeIndexes = new ArrayList<Integer>();

        System.out.printf("Recipe(s) matching ingredient search term \"%s\":\n", ingrediens);
        int printIndex = 1;
        for (int i = 0; i < recipeNames.size(); i++)
            if (recipeIngredients.get(i).contains(ingrediens)) {
                System.out.printf("%d. %s - %s\n", printIndex, recipeNames.get(i), recipeIngredients.get(i));
                foundRecipeIndexes.add(i);
                printIndex++;
            }

        return foundRecipeIndexes.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void changeRecipePortions(ArrayList<Integer> recipePortions, int recipeIndex, int newPortions) {
        int prevPortions = recipePortions.get(recipeIndex);
        recipePortions.set(recipeIndex, newPortions);
        System.out.printf("Portions changed %d -> %d\n", prevPortions, newPortions);
    }

    public static int getRecipeCount(ArrayList<String> recipeNames) {
        return recipeNames.size();
    }
}
