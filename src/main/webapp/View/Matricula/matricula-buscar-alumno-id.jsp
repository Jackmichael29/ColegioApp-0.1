<%-- 
    Document   : alumno-index
    Created on : 2 mar. 2023, 13:03:50
    Author     : walter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        
  import= "JavaBean.Alumno, java.util.ArrayList"      
        %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@page import="org.json.simple.JSONObject"%>

<%
    JSONObject json = new JSONObject();
    json.put("alumno_id", "15");
    json.put("apellidosNombres", "rivera");
    out.print(json);
    out.flush();
%>
