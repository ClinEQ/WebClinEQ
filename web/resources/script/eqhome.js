var tdlist=[];
$(document).ready(function () {
//    $('.date').datepicker({
//        autoclose: true,
//        todayHighlight: true
//        });

    $("#tableStudy").find('tbody').find('tr').each(function(){
        tdlist.push($(this));
    });
    
    //dropdown filter Study Status
    $('#sltStudyStatus').change(function () {
    var sponsorname=$('#sltSponsorName').val();
    var status=$(this).val();
    var tbody = $("<tbody>");
    $.each(tdlist,function(index,value){
        if(sponsorname==="All"&&status==="All"){
             tbody.append($(this));
        }
        else if(sponsorname==="All"&&value.find('td:nth-child(6)').text().trim() === status){
             tbody.append($(this));
        }
        else if(status==="All"&&value.find('td:nth-child(4)').text().trim() === sponsorname){
            tbody.append($(this));
        }
        else if (value.find('td:nth-child(4)').text().trim() === sponsorname && value.find('td:nth-child(6)').text().trim() === status) {
            tbody.append($(this));
        }
    });
    $("#tableStudy").find("tbody").remove();
    $("#tableStudy").append(tbody[0].outerHTML);
});

   //dropdown filter Sponsor Name
    $('#sltSponsorName').change(function () {
    var sponsorname=$(this).val();
    var status=$('#sltStudyStatus').val();
    var tbody = $("<tbody>");
    $.each(tdlist,function(index,value){
        if(sponsorname==="All"&&status==="All"){
             tbody.append($(this));
        }
        else if(sponsorname==="All"&&value.find('td:nth-child(6)').text().trim() === status){
             tbody.append($(this));
        }
        else if(status==="All"&&value.find('td:nth-child(4)').text().trim() === sponsorname){
            tbody.append($(this));
        }
        else if (value.find('td:nth-child(4)').text().trim() === sponsorname && value.find('td:nth-child(6)').text().trim() === status) {
            tbody.append($(this));
        }
    });
    $("#tableStudy").find("tbody").remove();
    $("#tableStudy").append(tbody[0].outerHTML);
});


});

//toggle sub form
function ToggleSubform(selector, form) {
    $("." + selector).slideToggle();
    if ($("." + selector).css("display") === "block") {
        $("." + selector).load("../includes/forms/" + form + ".jsp");
    }
}













