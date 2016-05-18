<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Artists</title>
<link rel="stylesheet" href="/Festival/css/main.css" />
</head>
<body>
<div class="main-content">
	<div class="artists">
		<c:forEach items="${artists }" var= "artist" varStatus="loopStatus">
		<div class="${loopStatus.index % 2 == 0 ? 'odd' : 'even' }">
		<a href="/Festival/donate?artist=${artist.id }" >
		<img class="img-responsive" src="css/${artist.picture }">
		</a>
		<h3>${artist.name }<br/>
		${artist.price } ${artist.currency }</h3>
		</div>
		</c:forEach>
	</div>
</div>
</body>
</html>