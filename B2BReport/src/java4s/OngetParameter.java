package java4s;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

public class OngetParameter extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Exception Exception = null;
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	 {
	 Map<String,Integer>map1=new LinkedHashMap<>();
	 
	 Map<String,Integer>map2=new LinkedHashMap<>();
	 
	 
	
	 
	 
	 Connection connection=null;
	 MyConstants constants =new MyConstants();
	 
	 try {
		
		 connection=constants.getBemspdConnection();
		String val=req.getParameter("n1");
	    String val2=req.getParameter("n2");
	    
	    System.out.println(" &&&&&&&&&&&&");
	   
		
		String selectSQL = "select count(distinct upid),document_type from XXINV_CFIR_INV_PROCESSING_TBL where b2b_received_date BETWEEN TO_DATE(?, 'mm/dd/yyyy HH24:MI:SS') AND TO_DATE (?, 'mm/dd/yyyy HH24:MI:SS')and status='SUCCESSFULLY SENT TO EPIC' group by document_type order by document_type";
		
		PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setString(1, val);
		preparedStatement.setString(2, val2);
		
		
		ResultSet resultSet1 =preparedStatement.executeQuery();
		
		
		  while(resultSet1.next())
		  {
			  System.out.print(resultSet1.getString(2)+"--");
			  System.out.println(resultSet1.getInt(1));
			  
			  map1.put(resultSet1.getString(2), resultSet1.getInt(1));
			  
		  }
		  
	     
		  
		  
		  connection.close();
		  
		
		
	 
	 } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	  
	 
		
	 
	 
	
	 
	 try {
			connection=constants.getepicprodConnection();
			
			String val=req.getParameter("n1");
		    String val2=req.getParameter("n2");
		    
		    System.out.println("&&&&&&&&&&&&");
		   
			
			String selectSQL = "select count(correlation_id) as UPID, document_type from b2b_document_store  where sub_process ='NG_INVOICE' and document_type in('810','3C3','INVOIC') and create_date BETWEEN TO_DATE(?, 'mm/dd/yyyy HH24:MI:SS') AND TO_DATE (?, 'mm/dd/yyyy HH24:MI:SS')group by document_type order by document_type";
			
			PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, val);
			preparedStatement.setString(2, val2);
			
			
			ResultSet resultSet2 =preparedStatement.executeQuery();
			
			
			  while(resultSet2.next())
			  {
				  System.out.print(resultSet2.getString(2)+"--");
				  System.out.println(resultSet2.getInt(1));
				  
				  map2.put(resultSet2.getString(2), resultSet2.getInt(1));
				 
			  }
		 
			System.out.println(map1);
					    
		    System.out.println("&&&&&&&&&&&&");
		   
			
			selectSQL = "select count(correlation_id) as UPID, document_type from b2b_document_store where sub_process like '%NG_CREDIT%' and document_type in('845') and create_date BETWEEN TO_DATE(?, 'mm/dd/yyyy HH24:MI:SS') AND TO_DATE (?, 'mm/dd/yyyy HH24:MI:SS')group by document_type order by document_type";
			
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, val);
			preparedStatement.setString(2, val2);
			
			
			ResultSet resultSet3 =preparedStatement.executeQuery();
			
			 
			  
				  
				  while(resultSet3.next())
				  {
					  System.out.print(resultSet3.getString(2)+"--");
					  System.out.println(resultSet3.getInt(1));
					  
					  map2.put(resultSet3.getString(2), resultSet3.getInt(1));			  
					 
				  }
				  
				  Set<String> set=map1.keySet();
				  
				  
				  System.out.println(map1.size()+"###"+map2.size());
				  System.out.println("get the key values:"+set);
				 
				  
				  
		  if(map1.size()==map2.size()){
			  int temp=0;
			  for(String s:set){
				  
				  System.out.println("map1 values:"+map1.get(s));
				  
				  System.out.println("map2 values:"+map2.get(s));
				  
				  int i1=map1.get(s);
				  
				  int i2=map2.get(s);
				
				 	  
				  
				  if(map1.get(s).equals(map2.get(s))|| i1 < i2){
					 temp++; 
					 
				  }
				  else 
				  {
					  System.out.println("{"+s+","+map1.get(s)+"}"+"{"+s+","+map2.get(s)+"}");
				 }
			  }
			  if(temp==map1.size()){
				 
				  System.out.println("All values matched");
				  
				  connection.close();
				
				  						  
				   }
			  
		  
		  else{
			  System.out.println("The number of data elements in Both Prods Do not Match");
			  res.sendRedirect("error.jsp");
			  
		  }
			  
			  
			  
			 connection=constants.getBemspdConnection();
			  preparedStatement=connection.prepareStatement("select count(distinct invoice_number),document_type from XXINV_CFIR_INV_PROCESSING_TBL where b2b_received_date BETWEEN TO_DATE(?, 'mm/dd/yyyy HH24:MI:SS') AND TO_DATE (?, 'mm/dd/yyyy HH24:MI:SS') and status='SUCCESSFULLY SENT TO EPIC' and document_type in ('810','3C3','INVOIC') group by document_type order by document_type");
			  preparedStatement.setString(1, val);
			  preparedStatement.setString(2, val2);
				
				
				ResultSet resultSet4 =preparedStatement.executeQuery();
				  
				req.setAttribute("result1", resultSet4);
				/*while(resultSet4.next()){
					
					System.out.print(resultSet4.getString(1)+"--");
					System.out.println(resultSet4.getString(2));
				}
				*/
				connection=constants.getBemspdConnection();
				 preparedStatement=connection.prepareStatement("select  count(distinct order_number)  from XXINV_CFIR_845_OB_DETAILS ob , XXINV_CFIR_845_OB_HEADER oh where ob.header_id=oh.header_id and ob.LAST_UPDATE_DATE BETWEEN TO_DATE(?, 'mm/dd/yyyy HH24:MI:SS') AND TO_DATE (?, 'mm/dd/yyyy HH24:MI:SS')");
				  preparedStatement.setString(1, val);
					preparedStatement.setString(2, val2);
					
					
					ResultSet resultSet5 =preparedStatement.executeQuery();
					  
					req.setAttribute("result2", resultSet5);
					/*while(resultSet5.next()){
						
						System.out.println(resultSet5.getString(1));
					}*/
		
			  
			  
			        RequestDispatcher rd=req.getRequestDispatcher("report.jsp");
			        rd.forward(req, res);
			 
				  connection.close();
				  
				  
		
	    
		  }
	 }
          
			
			
		 
		  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

	      
	 
	 
	 
	 }
	
	

}
