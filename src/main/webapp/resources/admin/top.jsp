<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>后台-页眉</title>
    <base href="<%=request.getContextPath()%>/"/>
  <link type="text/css" rel="stylesheet" href="resources/css/style.css">
</head>
<body>
    <center>
    
        <table border="0" width="100%" height="93" cellspacing="0" cellpadding="0" background="resources/images/admin_top.jpg">
            <tr>
                <td width="100%" height="100%" align="right" valign="bottom">
               
				<a href="" onclick="window.parent.location.href='resources/view/indextemp.jsp'">
					<img src="resources/images/admin_index.gif" border="0">
					</a>
				<a href="logoutServlet" target="_parent">
					<img src="resources/images/admin_exit.gif" border="0">
				</a>
                </td>
            </tr>
        </table>
        
    </center>
</body>
</html>