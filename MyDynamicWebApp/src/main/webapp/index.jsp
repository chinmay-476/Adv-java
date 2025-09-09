<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Form Entry</title></head>
<body>
  <form action="process.jsp" method="GET">
    Enter a number (n): <input type="number" name="n" min="1" required><br>
    <input type="submit" value="Submit">
  </form>
</body>
</html>