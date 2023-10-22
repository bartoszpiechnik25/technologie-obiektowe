import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLParser {
    @NotNull
    public static List<Map<CurrencyAttr, String>> parse(InputStream requestData) throws ParserConfigurationException,
            IOException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbFactory.newDocumentBuilder();
        Document document = builder.parse(requestData);
        NodeList nodeList = document.getElementsByTagName("pozycja");
        List<Map<CurrencyAttr, String>> currencies = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currencyNode = nodeList.item(i);
            Map<CurrencyAttr, String> currency = HashMap.newHashMap(4);
            if (currencyNode.getNodeType() == Node.ELEMENT_NODE) {
                Element currencyElement = (Element) currencyNode;
                String code = currencyElement.getElementsByTagName("kod_waluty").item(0).getTextContent().toUpperCase();
                currency.put(CurrencyAttr.CODE, code);
                currency.put(CurrencyAttr.CONVERSION_FACTOR, currencyElement.getElementsByTagName("przelicznik").item(0).getTextContent());
                currency.put(CurrencyAttr.EXCHANGE_RATE, currencyElement.getElementsByTagName("kurs_sredni").item(0).getTextContent());
                currency.put(CurrencyAttr.NAME, currencyElement.getElementsByTagName("nazwa_waluty").item(0).getTextContent());
                currencies.add(currency);
            }
        }
        return currencies;
    }

    public enum CurrencyAttr {
        CODE, CONVERSION_FACTOR, EXCHANGE_RATE, NAME
    }
}
