<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resource/css/styles.css">
    <title>Formul�rio INSS</title>
</head>

<body>
    <div class="DevCorp-container">
        Sal�rio enviado: <%= request.getAttribute("salary") %>
        Sal�rio Liquido: <%= request.getAttribute("netSalary") %>
        Desconto aplicado (TOTAL): <%= request.getAttribute("taxDiscount") %>

    </div>
</body>

</html>
</html>
