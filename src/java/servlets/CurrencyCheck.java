/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import domain.Currency;
import domain.Device;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date deviceDate = null;
        try {
            deviceDate = sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(CurrencyCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
        CurrencyResources client = new CurrencyResources();
        Currency currency = client.getCurrency(deviceDate);
//        double costPln = costUsd * currency.getSellingRate();
        Device device = new Device(id, name, deviceDate, costUsd);
//        printDeviceCostPln(response, currency, device);
        printDeviceCostPln(response, currency, device);
        out.println(buttonReback());
    }

    protected void printDeviceCostPln(HttpServletResponse response, Currency request, Device device)
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
            out.println("<h4>cost USD: " + device.getKosztUsd() + "</h1>");
//            out.println("<h1>cost PLN " + device.getKosztPln() + "</h1>");
//            out.println("<h1>getCurrency " + request.getCurrency() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private String buttonReback() {
        return "<br/> <br/><button onclick=\"location.href='/index.jsp';\" type=\"button\"> Reback</button> ";
    }
}
