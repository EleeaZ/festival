

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Artist;
import model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/donate")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final double euro = 4.5;
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
    }
   
    private SessionFactory sessionFactory;
    
    public Artist getById(final int id) {
    	sessionFactory = new Configuration().configure().buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	Query query = session.createQuery("from Artist where id=:id");
    	query.setParameter("id", id);
//    	TODO make if list is empty
    	return (Artist) query.list().get(0);
    	}
    
    public double convertFromRonToEuro(final double donationInRon) {
    	return donationInRon * euro;
    }
    
    
    public void storeDonationAt(double donation, int id , String email ) {
    	sessionFactory = new Configuration().configure().buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	User user = new User();
    	user.setEmail(email);
    	user.setHowMuch(donation);
    	user.setForWho(id);
    	session.save(user);
    	session.getTransaction().commit();
    	session.close();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("artist"));
		request.setAttribute("currentArtist", getById(id));
		request.getRequestDispatcher("donate.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double value = Double.parseDouble(request.getParameter("donation"));
		double convertedValue= convertFromRonToEuro(value);
		int artistId = Integer.parseInt(request.getParameter("artist"));
		request.setAttribute("count", convertedValue);
		String userEmail = request.getParameter("email");
		storeDonationAt(convertedValue, artistId, userEmail);
		doGet(request,response);
		
	}

}
