<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Wpisz dane do faktury </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div id= "container"> 
            <form action="currencyCheck"  method="post">

                <label> Write currency </label><br/>
                <label> Id <input type ="number" name="id"  required> </label><br/>
                <label> Nazwa <input type ="text" name="name"  required> </label><br/>
                <label> Data księgowania <input type ="date" name="date"  required> </label><br/>
                <label> Koszt USD <input type ="number" step="0.01" name="costUsd"  required> </label><br/>
                <input type="submit" name="send" value="wyślij">
            </form>
        </div>

    </body>
</html>
