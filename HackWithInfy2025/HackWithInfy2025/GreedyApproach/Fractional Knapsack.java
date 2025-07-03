import java.util.Arrays;

class Item {
    double weight, value, ratio;
    Item(double weight, double value) {
        this.weight = weight;
        this.value = value;
        this.ratio = value / weight;
    }
}

public class FractionalKnapsack {
    public static double getMaxValue(Item[] items, double capacity) {
        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item o1, Item o2) {
                return Double.compare(o2.ratio, o1.ratio); 
            }
        });

        double totalValue = 0; 
        for (Item item : items) {
            if (capacity >= item.weight) {
                capacity -= item.weight;
                totalValue += item.value;
            } else { 
                totalValue += item.value * (capacity / item.weight);
                capacity = 0; 
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120)
        };
        double capacity = 50;

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}