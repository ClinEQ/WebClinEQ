

 $(document).ready(function(){   
     
    $('.nav-pills li a').click(function() {
          $('.nav-pills li.active').removeClass('active');
          $(this).closest('li').addClass('active');
      });

// tablesorter
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
    


    // tree view on subjectDetails page
    var d1 = $('#jsonData').val();
    var d2 = d1.replace(/'/g, "\"").slice(0, -1); 
    var d3 = '['+d2+']';
    var d4 = JSON.parse(d3);
    var data = [];
    
//    $('#test').append(d3);


    $.each(d4, function(i, item) {
        data.push(item);
    });
 
    var treedata = [];
    $.each(data, function(i, item) {
        var c = item.children;
        var children = [];
        $.each(c, function(j, k) {
            children.push({
                "label" : k.name,
                "subid" : k.id
            });
        });        
        treedata.push({
            "label" : data[i].name,
            "children" : children,
            "id": data[i].id
        });
    });
    
    // create tree
     $('#tree1').tree({
         data: treedata,
         dragAndDrop: true         
     });
     
     // bind 'tree.click' event
    $('#tree1').bind (
        'tree.click',
        function(event) {
            // The clicked node is 'event.node'
            var node = event.node;
            $('#iframe').attr('src', '../site/fileUploadHistory?chartSubcategoryID='+node.subid+'&eqSubjectID='+$('#subjectid').val()+'&inpUserName='+$('#userid').val());
            //alert(node.subid);
            $('#test').append(node.label);
//            $('#lblsubcatname').append(node.label);
//            $('#lblsubcatname').css('display', 'inline');
//            $('#lblselect').css('display', 'none');
//            $('#lblselect').hide();
//$('#id').show();
        }
    );
    
    
   
 
 
 });


 $('#addfile').click(function() {
        $('#addfile').hide();
        $('#formupload').show();
      });




