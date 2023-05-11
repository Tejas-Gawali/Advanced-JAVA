<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdditionResult</title>
</head>
<body>

<%! 
int n = 5;
int fato = 1;
public int fact(int n){
	if(n<=1){
		return 1;
	}
	return n*fact(n-1);
}


%>
<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	int num3 = Integer.parseInt(request.getParameter("num3"));
	
	int sum = num1 + num2;
	int product = num1*num2;
	
	out.println("<p>The sum of "+ num1 + " and "+ num2 + " = " + sum + "</p>");
	out.println("<p>The product of "+ num1 + " and "+ num2 + " = " + product + "</p>");
	out.println("<p>The factorial of "+ num3 + fact(num3) + "</p>");


%>

</body>
</html>
