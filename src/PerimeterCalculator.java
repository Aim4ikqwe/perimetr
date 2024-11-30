import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;

public class PerimeterCalculator {

    private static int computePerimeter(HashSet<String> gaps) {
        int totalPerimeter = 0;
        int[][] movementDirections = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (String gap : gaps) {
            String[] coordinates = gap.split(" ");
            int xCoord = Integer.parseInt(coordinates[0]);
            int yCoord = Integer.parseInt(coordinates[1]);

            for (int[] direction : movementDirections) {
                if (!gaps.contains((xCoord + direction[0]) + " " + (yCoord + direction[1]))) {
                    totalPerimeter++;
                }
            }
        }
        return totalPerimeter;
    }

    public static void main(String[] args) {
        HashSet<String> gaps = new HashSet<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
            int numberOfGaps = Integer.parseInt(bufferedReader.readLine());
            System.out.println(numberOfGaps);
            for (int i = 0; i < numberOfGaps; i++) {
                gaps.add(bufferedReader.readLine());
                System.out.println(gaps);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int calculatedPerimeter = computePerimeter(gaps);

        try (BufferedWriter br = new BufferedWriter(new FileWriter("output.txt"))) {
            br.write("Общий периметр фигуры: " + calculatedPerimeter);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
