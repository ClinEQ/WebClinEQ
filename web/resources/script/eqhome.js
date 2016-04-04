var table;
$(document).ready(function () {

//    $('.date').datepicker({
//        autoclose: true,
//        todayHighlight: true
//        });
//    $('.body').append($('<form>',{
//        'style':'display:none',
//        'id':'tempForm'
//    }).append($("#tableStudy")));
//    table=$("#tempForm").find('table');

});

//toggle sub form
function ToggleSubform(selector, form) {
    $("." + selector).slideToggle();
    if ($("." + selector).css("display") === "block") {
        $("." + selector).load("../includes/forms/" + form + ".jsp");
    }
}

//dropdown filter
function changeTable(status, sponsorname) {
    debugger;
    var tbody = $("<tbody>");
    table.find('tbody').find('tr').each(function () {
        if ($(this).find('td:nth-child(4)').text().trim() === sponsorname && $(this).find('td:nth-child(4)').text().trim() === sponsorname) {
            tbody.append($(this));
        }
    });
    $("#tableStudy").find("tbody").remove();
    $("#tableStudy").append(tbody[0].outerHTML);
}









