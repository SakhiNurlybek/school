$(document).ready(
    function (){
        $("#deleteForm").on("click",function (e){
            ajaxPost(id);
        });

        function ajaxPost(id){
            $.ajax({
                type : "DELETE",
                url : "/api/v1/student/delete/"+id,
                success : function(result) {
                    if (result.status == "success") {
                        $("#postResultDiv").html(
                            "" + result.type.name
                            + " Post Successfully! <br>"
                            + "---> Congrats !!" + "</p>");
                    } else {
                        $("#postResultDiv").html("<strong>Error</strong>");
                    }
                    console.log(result);
                },
                error : function(e) {
                    alert("Error!")
                    console.log("ERROR: ", e);
                }
            });
        }
    }
)