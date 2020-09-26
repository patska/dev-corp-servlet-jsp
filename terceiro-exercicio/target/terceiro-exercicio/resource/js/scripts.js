$(document).ready(function() {
    $("#salary").maskMoney();
    $("#form").validate({
        rules: {
            salary: {
                required: true
            }
        },
        messages: {
            salary: {
                required: "O campo deve ser preenchido com um valor superior a R$ 0,00"
            }
        }
    });
});