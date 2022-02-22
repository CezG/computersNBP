package servlets;

import domain.Currency;
import domain.Device;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CurrencyResources;

@WebServlet(name = "currencyCheck", urlPatterns = {"/currencyCheck"})
public class CurrencyCheck extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<link rel='stylesheet' type='text/css' href='/style.css' />");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        double costUsd = Double.parseDouble(request.getParameter("costUsd"));

        LocalDate dateL = LocalDate.parse(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date deviceDate = null;
        try {
            Date sdfDate = sdf.parse(date);
            deviceDate = sdf.parse(sdf.format(sdfDate));
        } catch (ParseException ex) {
            Logger.getLogger(CurrencyCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
        CurrencyResources client = new CurrencyResources();
        Currency currency = client.getCurrency(date);
        double costPln = costUsd * currency.getSellingRate();
        Device device = new Device(id, name, deviceDate, costUsd, costPln);  
        printDeviceCostPln(response, currency, device, date, dateL);

    }

    protected void printDeviceCostPln(HttpServletResponse response, Currency curr, Device device, String date, LocalDate dateL)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CurrencyCheck</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h4>id : " + device.getId() + "</h1>");
            out.println("<h4>Nazwa: " + device.getNazwa() + "</h1>");
            out.println("<h4>date: " + device.getDataKsiegowania() + "</h1>");
            out.println("<h4>date: " + dateL + "</h4>");
            out.println("<h4>koszt USD: " + device.getKosztUsd() + "</h1>");
            out.println("<h4>koszt PLN " + device.getKosztPln() + "</h1>");
            out.println(buttonReback());
            out.println("</body>");
            out.println("</html>");
        }
    }

    private String buttonReback() {
        return "<br/> <br/><button onclick=\"location.href='/computers';\" type=\"button\"> Reback</button> ";
    }
}
