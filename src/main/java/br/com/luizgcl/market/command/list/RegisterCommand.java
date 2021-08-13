package br.com.luizgcl.market.command.list;

import br.com.luizgcl.market.MarketMain;
import br.com.luizgcl.market.command.type.Command;
import br.com.luizgcl.market.product.Product;

import java.text.DecimalFormat;

public class RegisterCommand extends Command {

    public RegisterCommand() {
        super("register", "Registre um produto na loja.", "register", "reg");
    }

    DecimalFormat DECIMAL_FORMAT = new DecimalFormat("##.##");

    /*
    * Comando só utilizado para testes, futuramente irei adicionar a implementação
    * com o banco de dados.
    * */
    @Override
    public void handle(String[] args) {
        if (args.length != 4) {
            System.out.println("Você precisa informar os argumentos!");
            System.out.println("Digite: reg (Nome do Produto) (Preço de Custo) (Porcentagem de Lucro).");
            return;
        }

        String productName = args[1];
        double productValue = Double.parseDouble(args[2].replace(",", "."));
        double productProfit = Double.parseDouble(args[3].replace("%", "").replace(",", "."));

        System.out.println("Parabéns! Você registrou o Produto '" + productName + "'");
        System.out.println("Valor de custo: R$" + DECIMAL_FORMAT.format(productValue));
        System.out.println("Lucro de: " + DECIMAL_FORMAT.format(productProfit) + "%");

        productProfit = productProfit / 100;
        double finalValue = productValue + (productValue * productProfit);

        Product product = new Product("789000001", productName, productValue, productProfit);

        MarketMain.getProductData().create(product);

        System.out.println("\n Valor estipulado de: R$" + DECIMAL_FORMAT.format(finalValue));
    }

}
