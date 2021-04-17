<%--
  Created by IntelliJ IDEA.
  User: 25659
  Date: 2021/3/30
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>light</title>
</head>
<body>
<script>
    function changeImage()
    {
        element=document.getElementById('myimage')
        if (element.src.match("bulbon"))
        {
            element.src="images/pic_bulboff.gif";
        }
        else
        {
            element.src="images/pic_bulbon.gif";
        }
    }
</script>
<img loading="lazy" id="myimage" onclick="changeImage()" src="images/pic_bulboff.gif" width="100" height="180">
</body>
</html>
