import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

public class Generator {
    static void Generuj(List<String> ListaWizyt) throws FileNotFoundException {
        // Creating a PdfWriter
        String dest = "P:/PDFs/test.pdf";
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

        Paragraph WizytaTytulP = new Paragraph(WizytaTytul);
        document.add(WizytaTytulP);

        Iterator<String> iterator = ListaWizyt.iterator();


        for(int i=0; i < ListaWizyt.size(); i++) {
            Wizyta = ListaWizyt.get(i);
            String[] part = Wizyta.split("\\;");
            String WizytaCS = "Pacjent: " + part[0] +
                    "\nLekarz: " + part[1] +
                    "\nData: " + part[2] +
                    "\nGodzina: " + part[3] +
                    "\nOpis: " + part[4] +
                    "\nStatus: " + part[5];
            WizytaP = new Paragraph(Wizyta);
            document.add(WizytaP);
        }


        // Closing the document
        document.close();
        System.out.println("PDF Created");
    }
}
