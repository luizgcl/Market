package br.com.luizgcl.market.product.data;

import br.com.luizgcl.market.MarketMain;
import br.com.luizgcl.market.backend.data.Data;
import br.com.luizgcl.market.backend.mongodb.MongoConnection;
import br.com.luizgcl.market.product.Product;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class ProductData implements Data<Product> {

    MongoConnection connection = MarketMain.getMongoConnection();
    MongoCollection<Document> collection = connection.getDb().getCollection("products");

    @Override
    public Product create(Product product) {
        Document document = collection.find(Filters.eq("barCode", product.getBarCode().toLowerCase())).first();

        if (document != null) {
            collection.insertOne(Document.parse(product.toString()));
        }

        return null;
    }

    @Override
    public Product load(String barCode) {
        return null;
    }

    @Override
    public Product loadByName(String name) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

}
