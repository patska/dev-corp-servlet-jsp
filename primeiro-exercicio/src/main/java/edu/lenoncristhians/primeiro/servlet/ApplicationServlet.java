package edu.lenoncristhians.primeiro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ApplicationController", urlPatterns={"/index.html"})
public class ApplicationServlet extends HttpServlet {

	private static final long serialVersionUID = 9034654774644818363L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        double miles = 10.;

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<style>");
        printWriter.println("table {");
        printWriter.println("font-family: arial, sans-serif;");
        printWriter.println("border-collapse: collapse;");
        printWriter.println("width: 100%;}");
        printWriter.println("td, th {");
        printWriter.println("border: 1px solid #dddddd;");
        printWriter.println("text-align: left;");
        printWriter.println("padding: 8px;}");
        printWriter.println("tr:nth-child(even) {");
        printWriter.println("background-color: #dddddd;}");
        printWriter.println("</style>");
        printWriter.println("<table style=\"width:100%\">");
        printWriter.println("<tr>");
        printWriter.println("<th>");
        printWriter.println("mph");
        printWriter.println("</th>");
        printWriter.println("<th>");
        printWriter.println("km/h");
        printWriter.println("</th>");
        printWriter.println("</tr>");
        for (int i = 10; i <= 200; i += 10) {
            printWriter.println("<tr>");
            printWriter.println("<td>");
            printWriter.println(miles);
            printWriter.println("</td>");
            printWriter.println("<td>");
            printWriter.println(milesToKmConverter(miles));
            printWriter.println("</td>");
            printWriter.println("</tr>");
            miles += 10;
        }
        printWriter.println("</table>");

    }

    private static double milesToKmConverter (double distanceInMiles) {
        return distanceInMiles * 1.60934;
    }
}
