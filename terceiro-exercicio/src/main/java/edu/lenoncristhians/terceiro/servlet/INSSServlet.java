package edu.lenoncristhians.terceiro.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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
        Map <Integer, ArrayList<Double>> aliquot = brazilianINSSAliquotMap();
        Double salary = stringToBRLConverter(req.getParameter("salary"));

        req.setAttribute("salary", salary);
        requestDispatcher.forward(req, resp);
    }

    public Map<Integer, ArrayList<Double>> brazilianINSSAliquotMap(){
        
        Map <Integer, ArrayList<Double>> aliquot = new HashMap<>();
        aliquot.put(0, new ArrayList<>(Arrays.asList(0.01, 1045.00, 7.5)));
        aliquot.put(1, new ArrayList<>(Arrays.asList(1045.01, 2089.60, 9.0)));
        aliquot.put(2, new ArrayList<>(Arrays.asList(2089.61, 3134.40, 12.0)));
        aliquot.put(3, new ArrayList<>(Arrays.asList(3134.41, 6101.06, 14.0)));

        return aliquot;
    }

    public Double stringToBRLConverter(String st){
        st = st.substring(3);
        st = st.replace(".", "");
        st = st.replace(",", ".");
        return Double.parseDouble(st);
    }

    
    
}