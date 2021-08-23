$(function(){
    $("#submit").click(function(){
        var categoryName=$("#categoryName").val();
        var description=$("#description").val();
        if($.trim(categoryName) == ""||$.trim(categoryName)==null){
            $("#message0").empty().html("请输入类别名称");
            return false;
        }else{
            $("#message0").empty();
        }
        if($.trim(description)==""||$.trim(description)==null){
            $("#message1").empty().html("请输入类别名称");
            return false;
        }else{
            $("#message1").empty();
        }
    });
    $("#categoryName").change(function () { 
        if($(this).val().length>15){
            $("#message0").html("类别名称不能超过15字");
            $("#submit").prop("disabled",true);
        }else{
            $("#message0").empty();
            checkSpan();
        }
     });

     $("#description").change(function () { 
        if($(this).val().length>30){
            $("#message1").html("类别描述不能超过30字");
            $("#submit").prop("disabled",true);
        }else{
            $("#message1").empty();
            checkSpan();
        }
     }); 

     function checkSpan(){
         var flag=$(".message").text();
         if(flag.length==0){
            $("#submit").prop("disabled",false);
         }
     }



});