package com.gildedrose;

public class ItemFactory {
    public UpdatableItem item(String name, int initialQuality, int initialSellIn) {
        switch (name) {
            case "Aged Brie":
                return new UpdatableItem() {
                    @Override
                    public Item getItem() {
                        return new Item("");
                    }

                    @Override
                    public Item updateQuality() {
                        return null;
                    }

                };
        }
        return new UpdatableItem() {
            @Override
            public Item getItem() {
                return null;
            }

            @Override
            public Item updateQuality() {
                return null;
            }
        };
    }
}
