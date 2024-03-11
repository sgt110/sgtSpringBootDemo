package com.sgt;

/**
 * @author ÀÔπŸÕ¡
 * @description TODO
 * @date 2024/3/6 16:15
 */
import com.sgt.bo.TestBO;
import com.sgt.bo.TestBO2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class JavaBeanToXML {

    public static String convertToXML(Object object) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // Pretty print

        StringWriter sw = new StringWriter();
        marshaller.marshal(object, sw);
        return sw.toString();
    }

    public static void main(String[] args) {
        try {
            TestBO person = new TestBO();
            person.setA(1);
            person.setC(2);
            TestBO2 testBO2 = new TestBO2(3, 4);
            person.setB(testBO2);

            String xml = convertToXML(person);
            System.out.println(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
