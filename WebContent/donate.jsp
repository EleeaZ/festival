<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Donate</title>
<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/Festival/css/main.css" />
</head>
<body>
<div class= "donation-content">
<div class="donate">
<div class="content-type">
<img class="img-responsive" src="css/${currentArtist.picture }">
<h3 id="mainHeader"> ${not empty count ? count : 0} / ${currentArtist.price } ${currentArtist.currency } </h3>
<progress value="${count }" max="${currentArtist.price }"></progress>
<form action="donate?artist=${currentArtist.id }" method = "POST">
<h3 id="mainHeader">Amount to donate:</h3> <input type="text" name="donation"/>
<h3 id="mainHeader">Email:</h3><input type="text" name="email" />
<div>
<input type="submit" value="Submit"/> 
</div>
</form>
</div>
</div>
</div>
</body>
</html>