package br.com.luizgcl.market.product.data;

import br.com.luizgcl.market.MarketMain;
import br.com.luizgcl.market.backend.data.Data;
import br.com.luizgcl.market.backend.mongodb.MongoConnection;
import br.com.luizgcl.market.product.Product;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ProductData implements Data<Product> {

    MongoConnection connection = MarketMain.getMongoConnection();
    MongoCollection<Document> collection = connection.getDb().getCollection("products");

    @Override
    public Product create(Product product) {
        Document document = collection.find(Filters.eq("barCode", product.getBarCode().toLowerCase())).first();

        product.setName(product.getName().toLowerCase());

        if (document == null) {
            collection.insertOne(Document.parse(new Gson().toJson(product)));
        } else {
            System.out.println("Já existe um produto com esse código de barras!");
            return null;
        }

        return product;
    }

    public Product create(String barCode, String name, double value, double profit) {
        return create(new Product(barCode, name, value, profit));
    }

    @Override
    public Product load(String barCode) {
        Document doc = collection.find(Filters.eq("barCode", barCode.toLowerCase())).first();

        if (doc != null) {
            return new Gson().fromJson(new Gson().toJson(doc), Product.class);
        }

        System.out.println("Produto: '" + barCode + "' não foi encontrado.");

        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Document document : collection.find(Filters.eq("name", name.toLowerCase()))) {
            products.add(new Gson().fromJson(new Gson().toJson(document), Product.class));
        }
        return products;
    }

    @Override
    public void save(Product product) {

    }

}
