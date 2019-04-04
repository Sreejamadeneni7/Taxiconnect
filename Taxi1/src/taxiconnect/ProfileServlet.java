package taxiconnect;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(urlPatterns = { "/ProfileServlet" })
public class ProfileServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 500000 * 1024;
	private int maxMemSize = 500000 * 1024;
	private File file;

	public void init() {
		// Get the file location where it would be stored.
		//
		filePath = getServletContext().getInitParameter("file-upload");

		System.out.println(filePath);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		System.out.println("Inside image upload....");

		// Check that we have a file upload request
		isMultipart = ServletFileUpload.isMultipartContent(request);

		// increase file upload size / reset file upload size

		System.out.println(isMultipart);

		response.setContentType("text/html");
		//java.io.PrintWriter out = response.getWriter();

		if (!isMultipart) {
			/*
			 * out.println("<html>"); out.println("<head>");
			 * out.println("<title>Profile upload</title>"); out.println("</head>");
			 * out.println("<body>"); out.println("<p>No file uploaded</p>");
			 * out.println("</body>"); out.println("</html>");
			 */
			return;
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();

		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);

		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("C:\\Users\\Manu\\profile_images"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);

		try {
			// Parse the request to get file items.
			List fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator i = fileItems.iterator();

			//out.println("<html>");
			//out.println("<head>");
			//out.println("<title>Servlet upload</title>");
			//out.println("</head>");
			//out.println("<body>");

			while (i.hasNext()) {

				System.out.println("Inside actual files..");
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();

					if (fileName.lastIndexOf("\\") >= 0) {
						file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
					} else {

						file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));

					}

					System.out.println(file);
					fi.write(file);
					//out.println("Uploaded Filename: " + fileName + "<br>");
				}
			}
		//	out.println("</body>");
			//out.println("</html>");
			
			
			 response.setContentType("image/jpg");  
			    ServletOutputStream outStream;  
			    outStream = response.getOutputStream();  
			    FileInputStream fin = new FileInputStream(file);  
			      
			    BufferedInputStream bin = new BufferedInputStream(fin);  
			    BufferedOutputStream bout = new BufferedOutputStream(outStream);  
			    int ch =0; ;  
			    while((ch=bin.read())!=-1)  
			    {  
			    bout.write(ch);  
			    }  
			      
			    bin.close();  
			    fin.close();  
			    bout.close();  
			    //out.close();  
			
			
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		throw new ServletException("GET method used with " + getClass().getName() + ": POST method required.");
	}
}