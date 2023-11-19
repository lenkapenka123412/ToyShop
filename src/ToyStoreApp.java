

public class ToyStoreApp {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        // Добавление игрушек в магазин
        toyStore.addToy(new Toy(1, "Кукла", 10, 20));
        toyStore.addToy(new Toy(2, "Мяч", 15, 30));
        toyStore.addToy(new Toy(3, "Машинка", 8, 15));

        // Обновление веса (частоты выпадения) игрушки
        toyStore.updateWeight(1, 25);

        // Розыгрыш игрушек
        for (int i = 0; i < 5; i++) {
            Toy drawnToy = toyStore.drawToy();
            if (drawnToy != null) {
                toyStore.saveToTextFile(drawnToy);
                System.out.println("Выиграна игрушка: " + drawnToy.getName());
            } else {
                System.out.println("Извините, все призы разыграны.");
            }
        }
    }
}
