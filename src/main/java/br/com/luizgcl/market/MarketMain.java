package br.com.luizgcl.market;

import br.com.luizgcl.market.backend.Credentials;
import br.com.luizgcl.market.backend.mongodb.MongoConnection;
import br.com.luizgcl.market.command.register.CommandRegister;
import br.com.luizgcl.market.product.data.ProductData;
import br.com.luizgcl.market.thread.MarketThread;
import lombok.Getter;

import java.util.TimeZone;

public class MarketMain {

    @Getter
    protected static MongoConnection mongoConnection;

    @Getter
    protected static ProductData productData;

    public static void main(String[] args) {

        mongoConnection = new MongoConnection(new Credentials("127.0.0.1", "", "", "nordmc", 27017));

        CommandRegister.registerCommands();
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));

        mongoConnection.connect();

        Thread thread = new MarketThread();
        thread.start();

        productData = new ProductData();

        System.gc();
    }

}
