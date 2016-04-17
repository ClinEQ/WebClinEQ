

 $(document).ready(function(){   
     
    $('.nav-pills li a').click(function() {
          $('.nav-pills li.active').removeClass('active');
          $(this).closest('li').addClass('active');
      });
    
     $('#tableStudy').tablesorter();
    
//    $("#tableStudy").tablesorter( {sortList: [[0,0], [2,0], [3, 0], [5, 0]]} ); 
    
});

