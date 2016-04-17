

 $(document).ready(function(){   
     
    $('.nav-pills li a').click(function() {
          $('.nav-pills li.active').removeClass('active');
          $(this).closest('li').addClass('active');
      });

    $('#tblStudy').tablesorter({
       headers: {
           0: {
               sorter: false
           },
           6: {
               sorter: false
           }
       }
    });
    
    
    $('label.tree-toggler').click(function () {
        $(this).parent().children('ul.tree').toggle(300);
    });
     
     
     
     var typeaheadSource = [];
     
     $('input.typeahead').typeahead({
        source: typeaheadSource
    });
    
     
    
//    $("#tableStudy").tablesorter( {sortList: [[0,0], [2,0], [3, 0], [5, 0]]} ); 
    
});

