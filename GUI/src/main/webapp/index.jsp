<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <script type="text/javascript" src="jquery-1.8.2.min.js" ></script>
        <script type="text/javascript" src="jquery.utils.js" ></script>
        <script type="text/javascript" src="jquery.flot.min.js" ></script>
        <script type="text/javascript" src="main.js" ></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
        <style type="text/css">
            #Plot{
                width: 400px;
                height: 300px;
            }

        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Monitor GUI</h1>
        <h3 id="PlotName">Please select plot</h3>
        <div id="Plot"></div>
        <form action="" onsubmit="return RefreshMesurmentsButtons(this);">
            <button type="submit">Refresh mesurements list!</button>
        </form>
        <div id="MesurmentsButtons"> </div>
    </body>
</html>
