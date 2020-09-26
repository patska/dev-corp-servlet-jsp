<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resource/css/styles.css">
    <title>Formulário INSS</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.min.js"></script>
    <script src="resource/js/jquery.maskMoney.js"></script>
    <script src="resource/js/scripts.js"></script>
</head>

<body>
    <div class="DevCorp-container">
        Sal�rio enviado: <%= request.getAttribute("convertedSalary") %>
    </div>
</body>

</html>
</html>