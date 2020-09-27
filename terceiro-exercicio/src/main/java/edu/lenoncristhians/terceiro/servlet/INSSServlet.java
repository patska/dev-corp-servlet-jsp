package edu.lenoncristhians.terceiro.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.math3.util.Precision;
import org.apache.log4j.Logger;

@WebServlet("INSSServlet")
public class INSSServlet extends HttpServlet {

    private static final long serialVersionUID = 6921737022127476731L;
    final static Logger logger = Logger.getLogger(INSSServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        String jspDestination = "calculo.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(jspDestination);
        ArrayList<ArrayList<Double>> aliquot = brazilianINSSAliquotMap();
        Double salary = 0.00;
        try{
            salary = stringToBRLConverter(req.getParameter("salary"));
        } catch(NumberFormatException numberFormatException){
            logger.error("[NumberFormatException] Error when converting input to double. Redirecting to homepage...");
            resp.sendRedirect("/terceiro-exercicio");
        }
        Double netSalary = 0.00;
        Double taxDiscount = 0.00;
        ArrayList<String> messages = new ArrayList<>();
        int aliquotCurrentIndex = 1;

        logger.info("[INSSServlet] INSSServlet Init.");
        logger.info("[INSSServlet] Input value: " + salary);

        for (ArrayList<Double> arrayList : aliquot) {
            logger.info("[INSSServlet] aliquot current index: " + Precision.round(netSalary, 2));
            Double temp = 0.00;
            if (salary > arrayList.get(1)) {
                temp = Precision.round((arrayList.get(1) - arrayList.get(0)) * arrayList.get(2), 2);
                taxDiscount += temp;
                logger.info("[INSSServlet] First condition for temporary tax discount value: " + temp);
                messages.add("- " + aliquotCurrentIndex + "ª Faixa Salarial: " +  brlToStringConverter(arrayList.get(1)) + " x " + arrayList.get(2) * 100 + "% = " + temp);
            }
            if (salary > arrayList.get(0) && salary <= arrayList.get(1)) {
                temp = Precision.round((salary - arrayList.get(0)) * arrayList.get(2), 2);
                taxDiscount += temp;
                logger.info("[INSSServlet] Second condition for temporary tax discount value: " + temp);
                messages.add("- " + aliquotCurrentIndex + "ª Faixa Salarial: " +  brlToStringConverter(arrayList.get(1)) + " x " + arrayList.get(2) * 100 + "% = " + temp);
            }
            aliquotCurrentIndex++;
        }
        
        netSalary = salary - taxDiscount;
        req.setAttribute("salary", brlToStringConverter(Precision.round(salary, 2)));
        req.setAttribute("netSalary", brlToStringConverter(Precision.round(netSalary, 2)));
        req.setAttribute("taxDiscount", brlToStringConverter(Precision.round(taxDiscount, 2)));
        req.setAttribute("messages", messages);
        logger.info("[INSSServlet] netSalary total: " + Precision.round(netSalary, 2));
        logger.info("[INSSServlet] taxdiscount total: " + Precision.round(taxDiscount, 2));
        requestDispatcher.forward(req, resp);
    }

    public ArrayList<ArrayList<Double>> brazilianINSSAliquotMap() {
        ArrayList<ArrayList<Double>> aliquot = new ArrayList<>();
        aliquot.add(new ArrayList<>(Arrays.asList(0.00, 1045.00, 0.075)));
        aliquot.add(new ArrayList<>(Arrays.asList(1045.00, 2089.60, 0.09)));
        aliquot.add(new ArrayList<>(Arrays.asList(2089.60, 3134.40, 0.12)));
        aliquot.add(new ArrayList<>(Arrays.asList(3134.40, 6101.06, 0.14)));
        return aliquot;
    }

    public Double stringToBRLConverter(String st) {
        st = st.substring(3);
        st = st.replace(".", "");
        st = st.replace(",", ".");
        return Double.parseDouble(st);
    }

    public String brlToStringConverter(Double value) {
        String st = "R$ " + Precision.round(value, 2);
        st = st.replace(".", ",");
        if(st.split(",")[1].length() == 1){
            st = st + "0";
        }
        logger.info("[INSSServlet - brlToStringConverter] Return value: " + st);
        return st;
    }

}