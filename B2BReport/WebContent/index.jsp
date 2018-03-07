<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3498db;
  width: 120px;
  height: 120px;
  -webkit-animation: spin 2s linear infinite; /* Safari */
  animation: spin 2s linear infinite;
}

/* Safari */
@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style>
</head>
<body>

<font face="verdana" size="2px">
   <form action="calculate" method="post" name="myform">
      Start Date:<input type="text" name="n1" required="required"><br>
       <br/>
       End Date:<input type="text" name="n2" required="required"><br>
       <input type="submit" value="Submit" id="mybutton">
  </form>
</font>

<div class="loader" id="loader"></div>



</body>
<script type="text/javascript">
 $('#loader').hide();
$(document).ready(function() {
    $('#mybutton').click(function() {
    	
    	loader.show();
        
    });
});
</script>
</html>
