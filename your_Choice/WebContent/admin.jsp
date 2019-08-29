<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<% String url = application.getContextPath() + "/"; %>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  
  <!-- Sidebar -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <title>Your_Choice</title>

  <!-- Custom fonts for this theme -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- Theme CSS -->
  <link href="css/freelancer.min.css" rel="stylesheet">
  
  
  <!-- Chart1 Definition -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['table']});
      google.charts.setOnLoadCallback(drawTable);

      function drawTable() {
        var data = new google.visualization.DataTable();
        data.addColumn('number', 'userNum');
        data.addColumn('string', 'nickName');
        data.addColumn('number', 'Human');
        data.addColumn('number', 'Ai');
        data.addColumn('number', 'age');
        data.addColumn('string', 'sex');
        data.addColumn('string', 'location');
        
        <c:forEach items="${sessionScope.getAllChart}" var="dataAll">
        data.addRows([
        	[${dataAll.userNum}, '${dataAll.nickName}', ${dataAll.VHuman}, ${dataAll.VAi}, ${dataAll.age}, '${dataAll.sex}', '${dataAll.location}']]);
 		 </c:forEach> 

        var table = new google.visualization.Table(document.getElementById('table_div'));

        table.draw(data, {showRowNumber: false, width: '100%', height: '100%'});
      }
    </script>

	<!-- Chart2 Definition -->
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Human',     ${sessionScope.getPieChart[0]} ],
          ['Ai',      ${sessionScope.getPieChart[1]} ]
        ]);

        var options = {
          title: 'Total vHuman / vAi'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
    
    <!-- Chart3 Definition -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawSarahChart);
      google.charts.setOnLoadCallback(drawAnthonyChart);

      function drawSarahChart() {
    	  
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
          ['Human',  ${sessionScope.getSexInfo[0]}],
          ['Ai', ${sessionScope.getSexInfo[1]}]
        ]);

        // Set options for Sarah's pie chart.
        var options = {title:'Art Propensity by Male',
        			   pieHole: 0.4,
                       width:600,
                       height:600
                       };

        // Instantiate and draw the chart for Sarah's pizza.
        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }

      // Callback that draws the pie chart for Anthony's pizza.
      function drawAnthonyChart() {
    	  
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
        	['Human',  ${sessionScope.getSexInfo[2]}],
            ['Ai', ${sessionScope.getSexInfo[3]}]
        ]);

        // Set options for Anthony's pie chart.
        var options = {title:'Art Propensity by Female',
        				pieHole: 0.4,
                       width:600,
                       height:600};

        // Instantiate and draw the chart for Anthony's pizza.
        var chart = new google.visualization.PieChart(document.getElementById('donutchart2'));
        chart.draw(data, options);
      }
    </script>
    
    <!-- Chart4 Definition -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable(
        [
          ['Age', 'Vote AI'],
          <c:forEach items="${sessionScope.getAgeInfo}" var="dataAll">
          [ ${dataAll.age},      ${dataAll.VAi}],
          </c:forEach> 
          [ 0,      0]
        ]);
        
        
        var options = {
          hAxis: {title: 'Age', minValue: 0, maxValue: 70},
          vAxis: {title: 'Vote AI', minValue: -0.1, maxValue: 10},
          legend: 'none'
        };

        var chart = new google.visualization.ScatterChart(document.getElementById('chart_div2'));

        chart.draw(data, options);
      }
    </script>

    
    <!-- Chart5 Definition -->
    <script type='text/javascript' src='https://www.gstatic.com/charts/loader.js'></script>
    <script type='text/javascript'>
    
     google.charts.load('current', {
       'packages': ['geochart'], 
       'mapsApiKey': 
     });
     google.charts.setOnLoadCallback(drawMarkersMap);
     
      function drawMarkersMap() {

      var data = google.visualization.arrayToDataTable( [
          ['City',   'AI Voting %', 'Voting Count'],
          ['Seoul',      ${sessionScope.getLocationInfo[0]},    ${sessionScope.getLocationInfo[1]}],
          ['Gangwon',    ${sessionScope.getLocationInfo[2]},    ${sessionScope.getLocationInfo[3]}],
          ['North Chungcheong',    ${sessionScope.getLocationInfo[4]},     ${sessionScope.getLocationInfo[5]}],
          ['South Chungcheong',     ${sessionScope.getLocationInfo[6]},     ${sessionScope.getLocationInfo[7]}],
          ['North Gyeongsang',   ${sessionScope.getLocationInfo[8]},     ${sessionScope.getLocationInfo[9]}],
          ['South Gyeongsang',     ${sessionScope.getLocationInfo[10]},     ${sessionScope.getLocationInfo[11]}],
          ['North Jeolla',   ${sessionScope.getLocationInfo[12]},     ${sessionScope.getLocationInfo[13]}],
          ['South Jeolla',  ${sessionScope.getLocationInfo[14]},     ${sessionScope.getLocationInfo[15]}]
        ]);
      
      var options = {
        region: 'KR',
        displayMode: 'markers',
        colorAxis: {colors: ['#F5A9A9', '#F78181', '#FF0000']}
      };

      var chart = new google.visualization.GeoChart(document.getElementById('chart_div'));
      chart.draw(data, options);
    };
    </script>
    
</head>

<body id="page-top">

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
    <div class="container">
    
      <a class="navbar-brand js-scroll-trigger" href="sessionDel.jsp"><i class="fas fa-child"></i> Your choice</a>
      <button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item mx-0 mx-lg-1">
            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#list">All list</a>
          </li>
          <li class="nav-item mx-0 mx-lg-1">
            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#age">By Age</a>
          </li>
          <li class="nav-item mx-0 mx-lg-1">
            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#gender">By Gender</a>
          </li>
          <li class="nav-item mx-0 mx-lg-1">
            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#location">By Location</a>
          </li>
          <li class="nav-item mx-0 mx-lg-1">
            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="sessionDel.jsp">Logout</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
    
  <!-- Main Contents -->
  <section class="page-section" id="contact">
    <div class="container">

  <!-- tableChart 1 -->
<br>
<br>
<br>
<div id="list" class="main">
<br>
<br>
<br>
  <h3>All Participants List</h3>
<br>
  <div id="table_div"></div>
<br>
<br>
  <!-- pieChart 2 -->
  <h3>Total Selection Result</h3>  
  <div id="piechart" style="width: 900px; height: 500px;"></div>
</div>


<br>
<br>
<br>
  <!-- multiChart 3 -->
  <div id="age" class="main">
  <br>
  <h3>By Age</h3>
  <div id="chart_div2" style="width: 900px; height: 500px;"></div>
</div>

<br>
<br>
<br>
<div id="gender" class="main">
<br>
<br>
<h3>By Gender</h3>
<br>
  <table class="columns">
      <tr>
        <td><div id="donutchart" style="border: 1px solid #ccc", style="width: 900px; height: 500px;"></div></td>
        <td><div id="donutchart2" style="border: 1px solid #ccc", style="width: 900px; height: 500px;"></div></td>
      </tr>
    </table>
</div>


<br>
<br>
<br>
  <!-- mapChart 5 -->
<div id="location" class="main">
<br>
<br>
<h3>By Location</h3>
<br>
<div id="chart_div" style="width: 900px; height: 500px;"></div>
</div>

    </div>
  </section>


  <!-- Copyright Section -->
  <section class="copyright py-4 text-center text-white">
    <div class="container">
      <small>Copyright &copy; 김동범, 남세영, 김경원</small>
    </div>
  </section>

  <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
  <div class="scroll-to-top d-lg-none position-fixed ">
    <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top">
      <i class="fa fa-chevron-up"></i>
    </a>
  </div>

  

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Contact Form JavaScript -->
  <script src="js/jqBootstrapValidation.js"></script>
  <script src="js/contact_me.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/freelancer.min.js"></script>

</body>

</html>