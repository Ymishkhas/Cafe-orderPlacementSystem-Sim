package Cafe_produtcts.Coffee;

import Cafe_produtcts.CafeProduct;

public class Coffee extends CafeProduct {
    @Override
    public void setSize(String size) {
        if(size.equalsIgnoreCase("s")){
            super.setPrice(getPrice() * 1);
            super.setSize("Small ");
        }
        else if(size.equalsIgnoreCase("l")){
            super.setPrice(getPrice() * 1.2);
            super.setSize("Large ");
        }
    }
}
