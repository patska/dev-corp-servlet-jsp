package edu.lenoncristhians.terceiro.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("INSSServlet")
public class INSSServlet extends HttpServlet {

	private static final long serialVersionUID = 6921737022127476731L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String jspDestination = "calculo.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(jspDestination);
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        try {
            BigDecimal convertedSalary = moneyParse(req.getParameter("salary"), Locale.FRANCE);
            req.setAttribute("convertedSalary", convertedSalary.toString());
            requestDispatcher.forward(req, resp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }

    public static BigDecimal moneyParse(final String amount, final Locale locale) throws ParseException {
        final NumberFormat format = NumberFormat.getNumberInstance(locale);
        if (format instanceof DecimalFormat) {
            ((DecimalFormat) format).setParseBigDecimal(true);
        }
        return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]",""));
    }
    
}