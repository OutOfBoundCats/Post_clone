/**
 * 
 */
package index;

/**
 * @author praj4
 *
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvasConstants;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

/**
 * @author praj4
 *
 */

///It prints to pdf as well as sysout
public class Cust_Printer implements pdf_print {
	 //String dest=".\\src\\main\\java\\Output\\";
	 String dest="./Output/";
	 LocalDateTime time=LocalDateTime.now();
	 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
	 String formattedDate = time.format(myFormatObj);
	 
	 PdfWriter writer;
	 PdfDocument pdfDoc;
	 public static Document document;
	 Color[] color_arr= {ColorConstants.RED,ColorConstants.ORANGE,ColorConstants.BLACK};
	 //PdfFont[] font_arr= {};
	 
	
	public static Document getDocument() {
		return document;
	}

	public void cust_print(String sentence, int para_head, int color) {
		// TODO Auto-generated method stub
		
		
		/*
		 * para_head =0 :TimeasRoman , 1 : TimesBOLD Hello
		 * color =0 : RED , 1:ORANGE , 2:BLACK
		 * sentence= what needs to be printed
		 */
		
		
		PdfFont font_TimesBOLD = null;
		PdfFont font_TimesRoman = null;
		//PdfFont[] font_arr={font_TimesBOLD,font_TimesRoman};;
		try {
			font_TimesBOLD = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
			font_TimesRoman = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
			//font_arr= {font_TimesBOLD,font_TimesRoman};
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print("Error generating fonts");
			Text error=new Text("Error generating fonts").setFont(font_TimesRoman).setFontColor(color_arr[0]).setFontSize(10);
			Paragraph error_para=new Paragraph().add(error);
			document.add(error_para);
			e.printStackTrace();
		}
		System.out.println(sentence);
		if(para_head==0) {
			
			Text sentence_text=new Text(sentence).setFont(font_TimesRoman).setFontColor(color_arr[color]).setFontSize(10);
			Paragraph sentence_para=new Paragraph().add(sentence_text);
			document.add(sentence_para);
			
		}else if(para_head ==1) {
			Text sentence_text=new Text(sentence).setFont(font_TimesBOLD).setFontColor(color_arr[color]).setFontSize(10);
			Paragraph sentence_para=new Paragraph().add(sentence_text);
			document.add(sentence_para);
		}
		

	}

	public void Initialize_print() throws FileNotFoundException {
		// TODO Auto-generated method stub
		 
		 System.out.println(dest);
		 String dest1=dest+"RajClone"+formattedDate.toString()+".pdf";
		//PdfWriter is an object that writes pdf files
		 writer=new PdfWriter(dest1);
		 //PdfWriter knows what to write because it listens to PdfDocument.It manges content added over diff pages
		 pdfDoc=new PdfDocument(writer);
		 //create document this is where we add para text and all
		 document=new Document(pdfDoc);
		PdfFont font_TimesBOLD = null;
		try {
			font_TimesBOLD = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		 // Add a Paragraph
		Text Initialise_suc=new Text("PDF Initilised Succesfully").setFont(font_TimesBOLD).setFontColor(color_arr[2]).setFontSize(10);
		
		Paragraph p=new Paragraph().add(Initialise_suc);
		document.add(p);
		 
		 
		// return document;
		
		
	}

	/**
	 * @param args
	 */
	

	

}
