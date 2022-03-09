import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.List;
/*
* On peut generer le proxy avec une ligne de commande.
* wsimport -p proxy -s . http://localhost:8686/BanqueWS?wsdl
 */
public class ClientWS {
    public static void main(String[] args) {
        BanqueService stubWS = new BanqueWS().getBanqueServicePort();
        System.out.println(stubWS.conversionEuroToDH(800));
        Compte compte = stubWS.getCompte(2L);
        System.out.println(compte.getCode());
        System.out.println(compte.getSolde());
        List<Compte> comptes = stubWS.listComptes();
        comptes.forEach(c ->{
            System.out.println("------------------------");
            System.out.println(c.getCode());
            System.out.println(c.getSolde());
        });

    }
}
