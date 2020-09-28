<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resource/css/styles.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <title>Formul�rio INSS</title>
</head>
<body>

    <div class="DevCorp-container" style="font-family: 'Roboto', sans-serif;">
        <br/>
        <h2>C�lculo de INSS</h2>
        <br/>
        <strong>Sal�rio bruto: <%= request.getAttribute("salary") %></strong>
        <br/>
        <strong>Valor de INSS a descontar: <%= request.getAttribute("taxDiscount") %></strong>
        <br/>
        <strong>Sal�rio l�quido: <%= request.getAttribute("netSalary") %></strong>
        <br/>
        <br/>
        <%@ page import = "java.util.ArrayList" %>
        <%
            ArrayList<String> messages = (ArrayList<String>) request.getAttribute("messages");
            for(int i = 0; i < messages.size() ; i++){
                out.println(messages.get(i));
                out.println("<br/>");
            }
        %>
        <br/>
    </div>
</body>

</html>
</html>
