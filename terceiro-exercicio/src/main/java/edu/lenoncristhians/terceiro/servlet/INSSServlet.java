package edu.lenoncristhians.terceiro.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.math3.util.Precision;

@WebServlet("INSSServlet")
public class INSSServlet extends HttpServlet {

    private static final long serialVersionUID = 6921737022127476731L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String jspDestination = "calculo.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(jspDestination);
        ArrayList<ArrayList<Double>> aliquot = brazilianINSSAliquotMap();
        Double salary = stringToBRLConverter(req.getParameter("salary"));
        System.out.println("Salário bruto: " + salary);
        Double netSalary = 0.0;
        Double taxDiscount = 0.0;

        for (ArrayList<Double> arrayList : aliquot) {
            Double temp;
            if (salary > arrayList.get(1)){
                temp = Precision.round((arrayList.get(1) - arrayList.get(0)) * arrayList.get(2), 2);
                taxDiscount += temp;
            }
            if (salary > arrayList.get(0) && salary <=arrayList.get(1)){
                temp = Precision.round((salary - arrayList.get(0)) * arrayList.get(2), 2);
                taxDiscount += temp; 
            }
        }

        
        netSalary = salary - taxDiscount;
        req.setAttribute("salary", Precision.round(salary, 2));
        req.setAttribute("netSalary", Precision.round(netSalary, 2));
        req.setAttribute("taxDiscount", Precision.round(taxDiscount, 2));

        requestDispatcher.forward(req, resp);
    }

    public ArrayList<ArrayList<Double>> brazilianINSSAliquotMap() {
        ArrayList<ArrayList<Double>> aliquot = new ArrayList<>();
        aliquot.add(new ArrayList<>(Arrays.asList(0.00, 1045.00, 0.075)));
        aliquot.add(new ArrayList<>(Arrays.asList(1045., 2089.60, 0.09)));
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

}