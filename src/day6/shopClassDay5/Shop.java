package day6.shopClassDay5;

import exercises.day5.exercise6.Category;
import exercises.day5.exercise6.ShopItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Shop<T extends ShopItem> {
    private List<T> shopItems = new ArrayList<>();

    public Shop(List<T> shopItems) {
        this.shopItems.addAll(shopItems);
    }

    public void addItem(T item) {
        shopItems.add(item);
    }

    public List<T> findByCategory(Category cat) {
        return shopItems.stream()
                .filter(a -> a.category().equals(cat))
                .toList();
    }

    public List<T> findWithLowerPrice(int maxPrice) {
        return shopItems.stream()
                .filter(a -> a.price() < maxPrice)
                .toList();
    }

    public List<T> findWithHigherPrice(int minPrice) {
        return shopItems.stream()
                .filter(a -> a.price() > minPrice)
                .toList();
    }

    public Optional<T> findByName(String name) {
        return shopItems.stream()
                .filter(a -> a.name().equals(name))
                .findAny();
    }

    public Optional<T> removeItem(String item) {
        T removedItem = shopItems.stream()
                .filter(a -> a.name().equals(item))
                .findFirst()
                .get();
        shopItems.removeIf(a -> a.name().equals(item));
        return Optional.of(removedItem);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopItems=" + shopItems +
                '}';
    }
}
