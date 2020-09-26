<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>

<h2>Celsius to Fahrenheit conversion table</h2>

<table>
  <tr>
    <th>Celsius</th>
    <th>Fahrenheit</th>
  </tr>
  <tr>
    <%
     for(int i = -50 ; i <= 50 ; i += 10){
        out.println("<tr>");
        out.println("<td>");
        out.println(i);
        out.println("</td>");
        out.println("<td>");
        out.println((i * 1.8) +  32);
        out.println("</td>");
        out.println("</tr>");
     }
    %>
  </tr>
</table>
</body>
</html>