<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>Report</title>
    </head>
    <body>
        <h1>Report users</h1>
         <input type="submit" value="Show!" onclick="showT()"> 
         
         </br>
            <a href="/examples/admin">Go back!</a>
            <p><a href="j_spring_security_logout">Exit</a></p>
    </body>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
            var r;
            function showT() {
                    var result;            
                    $.ajax({
                        type: 'GET',
                        url: 'showT',
                        success: function(list){                            
                            result =  JSON.parse(list);
                            for(var p in result) {                         
                                var h = document.createElement("H2");
                                var t = document.createTextNode("id="+result[p].id+", login="+result[p].login +" "+ result[p].number1+ " "+result[p].operation+" "+ result[p].number2+" = " + result[p].result+" "+ result[p].datetime);
                                h.appendChild(t);
                                document.body.appendChild(h);
                            }                            
                        }
                    });
            }         
        </script>
</html>
