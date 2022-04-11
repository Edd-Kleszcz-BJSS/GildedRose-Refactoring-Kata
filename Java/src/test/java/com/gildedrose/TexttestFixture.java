package com.gildedrose;

import com.gildedrose.factory.ItemFactory;
import com.gildedrose.factory.CreateItem;
import com.gildedrose.items.services.UpdateQuality;

public class TexttestFixture {
    public static void main(String[] args) {
        CreateItem itemFactory = new ItemFactory();

        System.out.println("OMGHAI!");

        UpdateQuality[] items = new UpdateQuality[] {
                itemFactory.createItem("+5 Dexterity Vest", 10, 20),
                itemFactory.createItem("Aged Brie", 2, 0),
                itemFactory.createItem("Elixir of the Mongoose", 5, 7),
                itemFactory.createItem("Sulfuras, Hand of Ragnaros", 0, 80),
                itemFactory.createItem("Sulfuras, Hand of Ragnaros", -1, 80),
                itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                    // this conjured item does not work properly yet
                itemFactory.createItem("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 11;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (UpdateQuality item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
