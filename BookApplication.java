package com.bookshopproject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshopproject.Entity.BookData;
import com.bookshopproject.Model.Dao;

/**
 * Servlet implementation class BookApplication
 */
@WebServlet("/")
public class BookApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookApplication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//getting servlet url
	
		String path=request.getServletPath();
		//using switch case to handle multiple url's
		switch(path)
		{
		//register the records
		case"/register":insertBookData(request,response);
		break;
		//display the data
		case"/showdata":displayData(request,response);
		break;
		//get record based on specific id
		case"/fetchdata":getRecordData(request,response);
		break;
		//update the Bookdata
		case"/updatedata":getUpdateRecord(request,response);
		break;
		//delete the record
		case"/deletedata":getDeleteRecord(request,response);
		break;
		
		}
		
	}

/*	private void getDeleteRecord(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int bid=Integer.parseInt(request.getParameter("bid"));
		BookData bd=new BookData();
		Dao d=new Dao();
		d.getDeleteBookRecord(bd);
		request.setAttribute("deletestatus","Record Deleted SuccessFylly");
		RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
*/
	private void getDeleteRecord(HttpServletRequest request, HttpServletResponse response) {
	    int bid = Integer.parseInt(request.getParameter("bid")); // Get the bid from the request
	    BookData bd = new BookData();
	    bd.setBid(bid); // Set the bid in the BookData object

	    Dao dao = new Dao();
	    boolean isDeleted = dao.getDeleteBookRecord(bd); // DAO method returns true if deleted

	    // Set appropriate status message
	    if (isDeleted) {
	        request.setAttribute("deletestatus", "Record Deleted Successfully.");
	    } else {
	        request.setAttribute("deletestatus", "Failed to Delete Record. Record Not Found.");
	    }

	    // Forward to Home.jsp
	    RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
	    try {
	        rd.forward(request, response);
	    } catch (ServletException | IOException e) {
	        e.printStackTrace();
	    }
	}

	private void getUpdateRecord(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		        int bid=Integer.parseInt(request.getParameter("bid"));
				String bname=request.getParameter("bookname");
				String bedition=request.getParameter("bookedition");
				String bauthor=request.getParameter("bookauthor");
				String bgenre=request.getParameter("bookgenre");
				int bprice=Integer.parseInt(request.getParameter("bookprice"));
				BookData bd=new BookData(bid,bname,bedition,bauthor,bgenre,bprice);
				Dao d =new Dao();
				d.getUpdatebookRecord(bd);
				request.setAttribute("status","Data Updated Successfully");
				RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
				try {
					rd.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	private void getRecordData(HttpServletRequest request, HttpServletResponse response) {
		int bid=Integer.parseInt(request.getParameter("bid"));
		BookData bd=new BookData(bid);
		Dao d=new Dao();
		ArrayList<BookData> al=d.getBookRecord(bd);
		request.setAttribute("bookrecord", al);
		RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void displayData(HttpServletRequest request, HttpServletResponse response) {
		Dao d=new Dao();
		ArrayList<BookData> al= d.displayData();
		if(al!=null)
		{
			request.setAttribute("regdata", al);
			RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			request.setAttribute("regdata","No Records is Found");
			RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

	private void insertBookData(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//collect data from Form 
		String bookName=request.getParameter("bookname");
		String bookEdition=request.getParameter("bookedition");
		String bookAuthor=request.getParameter("bookauthor");
		String bookGenre=request.getParameter("bookgenre");
		int bookPrice=Integer.parseInt(request.getParameter("bookprice"));
		BookData bd=new BookData(bookName,bookEdition,bookAuthor,bookGenre,bookPrice);
		Dao d=new Dao();
		d.insertData(bd);
		request.setAttribute("Bookresult","Book Is registered");
		RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
