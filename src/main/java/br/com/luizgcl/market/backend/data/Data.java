package br.com.luizgcl.market.backend.data;

import br.com.luizgcl.market.product.Product;

public interface Data<TData> {

    TData create(Product product);

    TData load(String barCode);

    TData loadByName(String name);

    void save(Product product);

}
