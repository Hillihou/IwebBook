
        $(function(){
            $("#ctr2").hide();
            function checkept(){
                // alert($(":input[name=password1]").val());
                if($(":input[name=password1]").val()!=""){
                $("#ctr2").show(300);
            }else{
                $("#ctr2").hide(300);
                $("#message2").empty();
                $(":input[name=password2]").val("");

            }
            }
            

            function checkSpan(){
         var flag=$(".message").text();
         if(flag.length==0){
            $("#submit").attr("disabled",false);
         }
     }
     function checkPwd(){
                var pwd2=$(":input[name=password2]").val();
                pwd2=$.trim(pwd2);
                
                var pwd=$(":input[name=password1]").val();
                pwd=$.trim(pwd);
                

                if(pwd!=pwd2){
                    $("#message2").empty().html("两次输入密码不一致");
                    $(":input[name='submit']").attr("disabled",true);
                }else{
                    $("#message2").empty();
                    checkSpan();
                }
            }


            $(":input[name=password1]").change(checkPwd);
            $(":input[name=password1]").change(checkept);

            $(":input[name=password2]").change(checkPwd);
        })
