<%@page import="org.omg.CORBA.OMGVMCID"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java4s.OngetParameter" %> 
<%@page import="java.sql.ResultSet"%>
<%@ page import="java.util.*" %>
<%@ page import = "java.io.*,java.util.*,javax.mail.*"%>
<%@ page import = "javax.mail.internet.*,javax.activation.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "java.io.*,java.util.*,javax.mail.*"%>
<%@ page import = "javax.mail.internet.*,javax.activation.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>

<%
   String result;
   
   // Recipient's email ID needs to be mentioned.
   String to1 = "madnagen@cisco.com,bprasann@cisco.com,navcheru@cisco.com,udarapan@cisco.com,labolla@cisco.com";
   
   String cc="srvuppal@cisco.com,simudigo@cisco.com";

   // Sender's email ID needs to be mentioned
   String from1 = "madnagen@cisco.com";

   // Assuming you are sending email from localhost
   String host = "outbound.cisco.com";

   // Get system properties object
   Properties properties = System.getProperties();

   // Setup mail server
   properties.setProperty("mail.smtp.host", host);

   // Get the default Session object.
   Session mailSession = Session.getDefaultInstance(properties);

   try {
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(mailSession);
      
      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from1));
      
      String[] recipientList =to1.split(",");
      
      String[] cclist=cc.split(",");
      
      InternetAddress[] internetAddresses=new InternetAddress[recipientList.length];
      int counter=0;
      for(String r:recipientList){
    	  internetAddresses[counter]=new InternetAddress(r.trim());
    	  counter++;
      }
      
      InternetAddress[] internetAddresses1=new InternetAddress[cclist.length];
      int counter1=0;
      for(String r:cclist){
    	  internetAddresses1[counter1]=new InternetAddress(r.trim());
    	  counter1++;
      }
      
      message.setRecipients(Message.RecipientType.TO, internetAddresses);
      
      message.setRecipients(Message.RecipientType.CC, internetAddresses1);
      
     
      // Set Subject: header field
      message.setSubject("To and CC Test...Ignore");
      
      // Now set the actual message
      
      StringBuilder body =new StringBuilder();
      
      body.append("<html>");
      
       body.append("<table border='5' id='intro'") ;      
      ResultSet resultSet4=(ResultSet)request.getAttribute("result1");
      
        body.append("<tr bgcolor='#4CAEE3'>");
        body.append("<td>Doc_type</td>");
        body.append("<td>Status</td>");
        body.append("<td>Total invoices received from I2C</td>");
        body.append("<td>Total Invoices sent out to GXS/E2open</td>");
        body.append("<td>Comments</td>");
        body.append("</tr>");
      while(resultSet4.next()){
    	
    	  body.append("<tr>");
    	  body.append("<td>");
    	  body.append(resultSet4.getString(2));
    	  body.append("</td>");
    	  
    	  body.append("<td>");
    	  body.append("Success");
    	  body.append("</td>");
    	  
    	  body.append("<td>");
    	  body.append(resultSet4.getString(1));
    	  body.append("</td>");
    	  
    	  body.append("<td>");
    	  body.append(resultSet4.getString(1));
    	  body.append("</td>");
    	  
    	 /* body.append("<td>");*/
    	  /*body.append(resultSet4.getString(1));*/
    	  /*body.append("</td>");*/
    	  
    	  body.append("<td>");
    	  body.append("NA");
    	  body.append("</td>");
    	  
    	  body.append("</tr>");
    	  
    	  
    	  
    	  
      }
      
      ResultSet resultSet5=(ResultSet)request.getAttribute("result2");
      
         while(resultSet5.next()){
        	 
        	 body.append("<tr>");
        	 
        	 body.append("<td>");
        	 body.append("845");
        	 body.append("</td>");
        	 
        	 body.append("<td>");
        	 body.append("Success");
        	 body.append("</td>");
        	 
        	 body.append("<td>");
        	 body.append(resultSet5.getString(1));
        	 body.append("</td>");
        	 
        	 body.append("<td>");
        	 body.append(resultSet5.getString(1));
        	 body.append("</td>");
        	 
        	 body.append("<td>");
        	 body.append("NA");
        	 body.append("</td>");
        	 
        	 body.append("</tr>");
         }
          
         body.append("</table>");
         body.append("</html>");
         
         String s=body.toString();
         
         message.setContent(s, "text/html");
         
       
      
      
      // Send message
      Transport.send(message);
      result = "Sent message successfully....";
   } catch (MessagingException mex) {
      mex.printStackTrace();
      result = "Error: unable to send message....";
      
   }
%>

<html>
<h1>Mail Sent SuccessFully..</h1>
<head>
</head>
</html>

