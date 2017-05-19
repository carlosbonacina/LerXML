package lerxml;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class LerXML {

    public static void main(String[] args) throws JDOMException, IOException {
        File f = new File("C:\\Users\\labin\\Desktop\\clientes.xml");

        SAXBuilder builder = new SAXBuilder();

        Document doc = builder.build(f);

        Element root = (Element) doc.getRootElement();

        List cidades = root.getChildren();

        Iterator i = cidades.iterator();

        while (i.hasNext()) {
            Element cidade = (Element) i.next();
            System.out.println("Codigo: " + cidade.getAttributeValue("codigo"));
            System.out.println("Nome: " + cidade.getAttributeValue("nome"));
            System.out.println("UF: " + cidade.getAttributeValue("uf"));
            System.out.println("\n");
            List clientes = cidade.getChildren();
            
            Iterator j = clientes.iterator();
            
            while (j.hasNext()) {
                Element cliente = (Element) j.next();
                System.out.println("Matricula: " + cliente.getChildText("matricula"));
                System.out.println("Nome: " + cliente.getChildText("nome"));
                System.out.println("Data de Nascimento: " + cliente.getChildText("nascimento"));
                System.out.println("\n");
            }
            
            

        }
    }

}
