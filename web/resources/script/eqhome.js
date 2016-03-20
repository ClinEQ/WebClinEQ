$(document).ready(function () {
    $('.date').datepicker({
        autoclose: true,
        todayHighlight: true
    });
});
var task;
function ToggleSubform(selector, form) {
    $("." + selector).slideToggle();
    if ($("." + selector).css("display") === "block") {
        $("." + selector).load("../includes/forms/" + form + ".jsp");
    }
}





