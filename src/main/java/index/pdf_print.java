/**
 * 
 */
package index;

import java.io.FileNotFoundException;
import java.sql.Connection;

import com.itextpdf.layout.Document;

/**
 * @author praj4
 *
 */
public interface pdf_print {

	public void cust_print(String sentence,int para_head,int color);
	
	public Document Initialize_print() throws FileNotFoundException;
}
