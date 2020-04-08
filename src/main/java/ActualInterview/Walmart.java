package ActualInterview;

import com.sun.tools.javac.jvm.Items;

import java.util.*;

public class Walmart {

    static class Item {
        int id;
        int price;
        int reviewCount;

        Item() {

        }

        Item Item(int id, int price, int reviewCount) {
            id = id;
            price = price;
            reviewCount = reviewCount;
            return this;
        }

        int getPrice() {
            return price;
        }

        int getReviewCount() {
            return reviewCount;
        }
    }

    private List<Item> sortedList(List<Item> items) {
        List<Item> result = new ArrayList<>();
        Set<Integer> idSet = populateSet(items);

        List<Item> priceSorted = priceSorted(items);
        List<Item> reviewSorted = reviewSorted(items);
        int size = items.size();
        int resultCounter = 0;
        int priceIndex = 0, reviewIndex = 0;
        while (resultCounter < size) {
            Item curr = priceSorted.get(priceIndex);
            if (!idSet.contains(curr.id)) {
                while (!idSet.contains(priceSorted.get(priceIndex).id) && priceIndex < size) {
                    priceIndex++;
                    curr = reviewSorted.get(priceIndex);
                }
            }
            result.add(curr);
            resultCounter++;
            idSet.remove(curr.id);
            priceIndex++;

            curr = reviewSorted.get(reviewIndex);
            if (!idSet.contains(curr.id)) {
                while (!idSet.contains(reviewSorted.get(reviewIndex).id) && reviewIndex < size) {
                    reviewIndex++;
                    curr = reviewSorted.get(reviewIndex);
                }
            }

            result.add(curr);
            resultCounter++;
            idSet.remove(curr.id);
            reviewIndex++;
        }
        return result;
    }

    private Set<Integer> populateSet(List<Item> items) {

        Set<Integer> set = new HashSet<>();
        for (Item item : items)
            set.add(item.id);
        return set;
    }

    public static void main(String[] args) {
        Item item1 = new Item();
        item1.id = 1;
        item1.price = 299;
        item1.reviewCount = 50;

        Item item2 = new Item();
        item2.id = 2;
        item2.price = 85;
        item2.reviewCount = 70;

        Item item3 = new Item();
        item3.id = 3;
        item3.price = 199;
        item3.reviewCount = 45;

        Item item4 = new Item();
        item4.id = 4;
        item4.price = 350;
        item4.reviewCount = 30;


        Walmart obj = new Walmart();
        List<Item> result = obj.sortedList(Arrays.asList(item1, item2, item3, item4));

        for (Item i : result) {
            System.out.println("Id : " + i.id + ", price: " + i.price + ", reviewCount: " + i.reviewCount);
        }
    }

    private List<Item> priceSorted(List<Item> items) {
        List<Item> sortedList = new ArrayList<>(items);
        sortedList.sort(Comparator.comparingInt(Item::getPrice).reversed());
        return sortedList;
    }

    private List<Item> reviewSorted(List<Item> items) {
        List<Item> sortedList = new ArrayList<>(items);
        sortedList.sort(Comparator.comparingInt(Item::getReviewCount));
        return sortedList;
    }


}
