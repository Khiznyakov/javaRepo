<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         language="java"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Hello</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />        
        <script src="<c:url value="/resources/core/jquery-2.2.2.min.js" />"></script>      
        <script>
            function Func(datas) {
                var data = $.parseJSON(datas);
                if (data.error ==="+") {
                    $("#info").text('Stop divide by zero');
                }
                else {
                    $("#info").text('ANS: '+data.result);   
                }
            }
            $(document).ready(function () {
                var scrnumber1 = $('#number1'),
                    scrnumber2 = $('#number2');
                scrnumber1.keypress(function (event) {
                    if ((event.charCode > 57 || event.charCode < 48) && event.charCode !== 46 && event.charCode !== 45) {
                        return false;
                    }
                });
                scrnumber2.keypress(function (event) {
                    if ((event.charCode > 57 || event.charCode < 48) && event.charCode !== 46 && event.charCode !== 45) {
                        return false;
                    }
                });
                $("#calculate").click(function () {
                    var number1 = scrnumber1.val(),
                            result,
                            number2 = scrnumber2.val(),
                            operation = $('#operations').val(),
                            data = {number1: number1, number2: number2, operation: operation, result: result};
                    $.ajax({
                        url: 'calc',
                        type: 'POST',
                        data: data,
                        success: Func
                    });
                });
            });
        </script> 
    <center><h1>2ndCalc</h1><center/>
    </head>
    <body>       
        <div class="login" >
            <p><b>Input 1st NUM</b><br>
                <input  name="number1" id="number1" size="4">                
            <p><b>Input 2nd NUM</b><br>
                <input  name="number2" id="number2" size="4">
            </p>
            <p><b> Choose OP: </b><br>
                <select name="opt" id="operations">
                    <option value="0"> + </option>
                    <option value="1"> - </option>
                    <option value="2"> * </option>
                    <option value="3"> / </option>               
                </select>                                
                <br>
                <p> 
                    <input class="calcBtn" type="submit" id="calculate" value="Calculating!"> 
                </p>
            <p>           
            <a class="calcBtn" href="j_spring_security_logout">Logout</a>
        </p>
        <p>
            <b>
                 <span id="info"></span>
            </b>
        </p>
        </div>
    </body>
     <h2><a href="<c:url value="/calc" />">ADMINKA ZA 300</a></h2>
</html>