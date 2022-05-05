$(document).ready(
    function (){
        $("#addForm").submit(function (event){
            event.preventDefault();
            ajaxPost();
        });
        function ajaxPost(){

            var formData = {
                url : contextPath + "api/v1/student/save",
                name : $("#name").val(),
                surname : $("#surname").val(),
                age : $("#age").val()
            }

            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "/api/v1/student/save",
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