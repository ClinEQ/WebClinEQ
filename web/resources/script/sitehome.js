

 $(document).ready(function(){   
     
    $('.nav-pills li a').click(function() {
          $('.nav-pills li.active').removeClass('active');
          $(this).closest('li').addClass('active');
      });
    
     $("#tableStudy").tablesorter({
        onRenderHeader: function(){
          this.prepend('<span class="icon"></span>');
        }
      });
    
//    $("#tableStudy").tablesorter( {sortList: [[0,0], [2,0], [3, 0], [5, 0]]} ); 
    
});

