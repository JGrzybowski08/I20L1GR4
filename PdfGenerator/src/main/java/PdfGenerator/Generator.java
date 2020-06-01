package PdfGenerator;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.IOException;
import java.util.List;



public class Generator {

    public static final String FONT = "src/main/resources/Amble-Bold.ttf";

    public static void Generuj(List<String> ListaWizyt) throws IOException {
        // Creating a PdfWriter
        PdfFont f = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H);
        String dest = "RaportWizyt.pdf";
        PdfWriter writer = new PdfWriter(dest);

        // Creating a PdfDocument
        PdfDocument pdfDoc = new PdfDocument(writer);

        // Adding a new page
        pdfDoc.addNewPage();

        // Creating a Document
        Document document = new Document(pdfDoc);

        String WizytaTytul = "Wizyty";
        String Wizyta = null;
        Paragraph WizytaP;

        Paragraph WizytaTytulP = new Paragraph(WizytaTytul).setFont(f);
        document.add(WizytaTytulP);



        for(int i=0; i < ListaWizyt.size(); i++) {
            Wizyta = ListaWizyt.get(i);
            String[] part = Wizyta.split("\\;");
            //System.out.println(part[0] + " || " + part[1]);
            String WizytaCS = "Pacjent: " + part[0] + " " + part[1] +
                    "\nLekarz: " + part[2] + " " + part[3] +
                    "\nData: " + part[4] +
                    "\nGodzina: " + part[5] +
                    "\nOpis: " + part[6] +
                    "\nStatus: " + part[7];
            WizytaP = new Paragraph(WizytaCS).setFont(f);
            document.add(WizytaP);
        }
       /*Wizyta = "ąęśćłĄĘŚĆŁ";
       WizytaP = new Paragraph(Wizyta).setFont(f);
       document.add(WizytaP);*/
        // Closing the document
        document.close();
        System.out.println("PDF Created");
    }
}
