package trader.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trader.*;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "CustomerController", urlPatterns = {"/CustomerController", "/AllCustomers"})
public class CustomerController extends HttpServlet {

    @EJB
    private BrokerModel model;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();
        if (path.equals("/CustomerController")) {

            String id = request.getParameter("customerIdentity");
            String name = request.getParameter("customerName");
            String address = request.getParameter("customerAddress");
            String submit = request.getParameter("submit");
            int version = 1;
            if (request.getParameter("version") != null) {
                version = Integer.parseInt(request.getParameter("version"));
            }

            try {

                if (submit.equals("Get Customer")) {
                    Customer cust = model.getCustomer(id);
                    request.setAttribute("customer", cust);
                } else if (submit.equals("Update Customer")) {
                    model.updateCustomer(new Customer(id, name, address, version));
                    Customer cust = model.getCustomer(id);
                    request.setAttribute("customer", cust);
                } else if (submit.equals("Add Customer")) {
                    model.addCustomer(new Customer(id, name, address, version));
                    Customer cust = model.getCustomer(id);
                    request.setAttribute("customer", cust);
                } else if (submit.equals("Delete Customer")) {
                    model.deleteCustomer(new Customer(id, name, address, version));
                }
            } catch (BrokerException be) {
                request.setAttribute("message", be.getMessage());
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerDetails");
            dispatcher.forward(request, response);

        } else if (path.equals("/AllCustomers")) {

            try {

                Customer[] customers = model.getAllCustomers();
                request.setAttribute("customers", customers);

            } catch (BrokerException be) {
                request.setAttribute("message", be.getMessage());
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("AllCustomers.jsp");
            dispatcher.forward(request, response);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
