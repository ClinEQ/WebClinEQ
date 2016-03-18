$(document).ready(function () {
    $('.date').datepicker({
        autoclose: true,
        todayHighlight: true
    });
});
var task;
function OpenPage() {
    $("#divTest").slideToggle();
    if ($("#divTest").css("display") === "block") {
        $("#divTest").load("../includes/forms/newjsp.jsp");
    }
}





