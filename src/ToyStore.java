import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        this.toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    public Toy drawToy() {
        double randomValue = Math.random() * 100;
        double cumulativeWeight = 0;

        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (randomValue <= cumulativeWeight) {
                Toy drawnToy = new Toy(toy.getId(), toy.getName(), 1, toy.getWeight());
                toy.decreaseQuantity();
                return drawnToy;
            }
        }

        return null; // No toys available
    }

    public void saveToTextFile(Toy toy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toys.txt", true))) {
            writer.write(toy.getId() + "," + toy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

