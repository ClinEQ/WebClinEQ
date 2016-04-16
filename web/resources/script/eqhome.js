var tdlist = [];

$(document).ready(function () {
    $("#tableStudy").find('tbody').find('tr').each(function () {
        tdlist.push($(this));
    });

    //dropdown filter Study Status
    $('#sltStudyStatus').change(function () {
        var sponsorname = $('#sltSponsorName').val();
        var status = $(this).val();
        var tbody = $("<tbody>");
        $.each(tdlist, function (index, value) {
            if (sponsorname === "All" && status === "All") {
                tbody.append($(this));
            } else if (sponsorname === "All" && value.find('td:nth-child(6)').text().trim() === status) {
                tbody.append($(this));
            } else if (status === "All" && value.find('td:nth-child(4)').text().trim() === sponsorname) {
                tbody.append($(this));
            } else if (value.find('td:nth-child(4)').text().trim() === sponsorname && value.find('td:nth-child(6)').text().trim() === status) {
                tbody.append($(this));
            }
        });
        $("#tableStudy").find("tbody").remove();
        $("#tableStudy").append(tbody[0].outerHTML);
    });

    //dropdown filter Sponsor Name
    $('#sltSponsorName').change(function () {
        var sponsorname = $(this).val();
        var status = $('#sltStudyStatus').val();
        var tbody = $("<tbody>");
        $.each(tdlist, function (index, value) {
            if (sponsorname === "All" && status === "All") {
                tbody.append($(this));
            } else if (sponsorname === "All" && value.find('td:nth-child(6)').text().trim() === status) {
                tbody.append($(this));
            } else if (status === "All" && value.find('td:nth-child(4)').text().trim() === sponsorname) {
                tbody.append($(this));
            } else if (value.find('td:nth-child(4)').text().trim() === sponsorname && value.find('td:nth-child(6)').text().trim() === status) {
                tbody.append($(this));
            }
        });
        $("#tableStudy").find("tbody").remove();
        $("#tableStudy").append(tbody[0].outerHTML);
    });
    $('.date').datepicker({
        autoclose: true,
        todayHighlight: true
    });


    //New Study Main page 
    $('#btnEqhomeNSMNext').on('click', function () {
        var studyBisicInfo = JSON.stringify($("#formEqhomeNSMStudyBasicInfo").serializeArray());
        localStorage.setItem("studyBisicInfo", studyBisicInfo);
        window.location.href="../study/newStudySponsor";
        
//        $.ajax({
//            type: 'POST',
//            url: "../study/getBasicInfo",
//            contentType: "application/json;charset=utf-8;",
//            dataType: "json",
//            data: studyBisicInfo,
//            success: function (data) {
//                alert("success");
//                //location.href("../study/newStudySponsor");
//            },
//            error:function(){
//             alert("error");   
//            }
//        });
    });




//    $('#btnNewStudySponsorNext').on('click', function () {
//        var studySponPrimary = {
//            eqSponsorId: $("#inpEqhomeNSSEqSponId").val(),
//            eqSponsorName: $('#inpeqhomeNSSSponName').val(),
//            eqSponsorNameAbbr: $('#inpeqhomeNSSSponAB').val(),
//            eqSponsorType: $('#inpeqhomeNSSSponType').val(),
//            eqSponsorCate: $('#inpeqhomeNSSSponCate').val(),
//            eqSponsorAddress1: $('#inpeqhomeNSSAddress1').val(),
//            eqSponsorAddress2: $('#inpeqhomeNSSAddress2').val(),
//            eqSponsorCity: $('#inpeqhomeNSSCity').val(),
//            eqSponsorState: $('#inpeqhomeNSSState').val(),
//            eqSponsorZip: $('#inpeqhomeNSSZip').val(),
//            eqSponsorCountry: $('#inpeqhomeNSSCountry').val(),
//            eqSponsorPhone: $('#inpeqhomeNSSPhone').val(),
//            eqSponsorFax: $('#inpeqhomeNSSFax').val(),
//            eqSponsorUrl: $('#inpeqhomeNSSSponUrl').val(),
//            eqSponsorConName: $('#inpeqhomeNSSConName').val(),
//            eqSponsorEmail: $('#inpeqhomeNSSEmail').val(),
//            eqSponsorStatus: $('#inpeqhomeNSSStudyStatus').val(),
//            eqSponsorNotes: $('#txteqhomeNSSNote').val()
//        };
//        $.ajax({
//            url: "",
//            type: 'POST',
//            contentType: 'application/json;charset=utf-8;',
//            dataType: "json",
//            data: JSON.stringify(studySponPrimary),
//            success: function (data) {
//                if (data === "Success") {
//                    var sponsorUserList;
//                    $.each($("#tblNSSSponsorUserList").find('tbody').find('tr'), function (index, value) {
//                        sponsorUserList = {
//                            equserid: value.find('td:nth-child(1)').text(),
//                        }
//                    });
//                    $.ajax({
//                        url: "",
//                        type: 'POST',
//                        contentType: 'application/json;charset=utf-8;',
//                        dataType: "json",
//                        data: JSON.stringify(sponsorUserList),
//                        success: function (data) {
//                            location.href("");
//                        }
//                    });
//                }
//            }
//        });
//    });
});


//click add new study to open a new window
function openAddNewStudy(url, width) {
    var leftPosition, topPosition;
    leftPosition = (window.screen.width / 2) - ((width / 2) + 10);
    window.open(url, "", "width=" + width + ",resizable=yes,left=" + leftPosition + ",screenX=" + leftPosition);
}

//toggle sub form
function ToggleSubform(selector, form) {
    $("." + selector).slideToggle();
    if ($("." + selector).css("display") === "block") {
        $("." + selector).load("../includes/forms/" + form + ".jsp");
    }
}

//go back to previous page
function goBack() {
    window.history.back();
}

