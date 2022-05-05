$(document).ready(
    function (){
        $("#updateForm").submit(function (event){
            event.preventDefault();
            ajaxPost();
        });
        function ajaxPost(){

            var formData = {
                name : $("#name").val(),
                age : $("#age").val()
            }

            $.ajax({
                type : "PUT",
                contentType : "application/json",
                url : "/api/v1/student/update",
                data : JSON.stringify(formData),
                dataType : 'json',
                success : function(result) {
                    if (result.status == "success") {
                        $("#postResultDiv").html(
                            "" + result.data.name
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