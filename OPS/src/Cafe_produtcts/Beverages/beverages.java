package Cafe_produtcts.Beverages;

import Cafe_produtcts.CafeProduct;

public abstract class beverages extends CafeProduct {
    @Override
    public void setSize(String size) {
        if(size.equalsIgnoreCase("s")){
            super.setPrice(getPrice() * 1);
            super.setSize("Small ");
        }
        else if(size.equalsIgnoreCase("l")){
            super.setPrice(getPrice() * 2);
            super.setSize("Large ");
        }
    }
}
