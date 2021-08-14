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
    * Comando funcionando perfeitamente, em breve irei fazer algumas mudanças
    * */
    @Override
    public void handle(String[] args) {
        if (args.length != 5) {
            System.out.println("Você precisa informar os argumentos!");
            System.out.println("Digite: reg (Nome do Produto) (Preço de Custo) (Porcentagem de Lucro).");
            return;
        }

        String barCode = args[1];
        String productName = args[2];
        double productValue = Double.parseDouble(args[3].replace(",", "."));
        double productProfit = Double.parseDouble(args[4].replace("%", "").replace(",", "."));

        try {
            Long.parseLong(barCode);
        } catch (NumberFormatException e) {
            System.err.println("Ocorreu algum erro ao ler código de barras!");;
        }

        System.out.println("Parabéns! Você registrou o Produto '" + productName + "'");
        System.out.println("Código de barras: " + barCode);
        System.out.println("Valor de custo: R$" + DECIMAL_FORMAT.format(productValue));
        System.out.println("Lucro de: " + DECIMAL_FORMAT.format(productProfit) + "%");

        productProfit = productProfit / 100;
        double finalValue = productValue + (productValue * productProfit);

        System.out.println("\n Valor estipulado de: R$" + DECIMAL_FORMAT.format(finalValue));

        MarketMain.getProductData().create(barCode, productName, productValue, productProfit);
    }

}
