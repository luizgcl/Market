package br.com.luizgcl.market.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Product {

    String barCode;

    @Setter
    String name;
    double price;
    double profit;

    @Override
    public String toString() {
        return "{" +
                "barCode: '" + barCode + '\'' +
                ", name: '" + name + '\'' +
                ", price: " + price +
                ", profit: " + profit +
                '}';
    }
}
