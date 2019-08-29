<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- EL tag 무시하지 않게 설정하기 --%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Your Choice</title>

  <!-- Custom fonts for this theme -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- Theme CSS -->
  <link href="css/freelancer.min.css" rel="stylesheet">

 <!-- Theme Google Chart ================================================================ -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
     google.charts.load('current', {packages: ['corechart', 'bar']});
      google.charts.setOnLoadCallback(drawChart);

      function drawBarColors() {
          var data = google.visualization.arrayToDataTable([
            [' ', 'Human', 'AI'],
            ['Your Choice Human vs AI', ${sessionScope.vHuman}, ${sessionScope.vAi}],
          ]);

          var options = {
            title: '${sessionScope.nickName}의 투표 결과',
            chartArea: {width: '50%'},
            colors: ['#FF0000', '#0000FF'],
            hAxis: {
              title: '투표 수',
              minValue: 0
            },
            vAxis: {
            }
          };
          var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
          chart.draw(data, options);
        }
    </script>
 <!-- Theme Google Chart End ================================================================ -->

</head>

<body id="page-top">

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="http://localhost/your_Choice/index.html"><i class="fas fa-child"></i> Your choice</a>
      <button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item mx-0 mx-lg-1">
            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="sessionDel.jsp">Logout</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  
 <!-- Main Body Section =============================================================================== -->
   <section class="page-section portfolio" id="portfolio">
    <div class="container">

  <br>
  <br>
  <h4>${sessionScope.nickName}님, 투표가 종료되었습니다.</h4>
  <h5>이 사진들중 하나는 </h5><h5 style="color:red;">사람</h5><h5>이 그린 것이고, 하나는 </h5><h5 style="color:red;">AI</h5><h5>가 그린 것 입니다.</h5>
  <h5>이 투표는 AI가 그린 그림에도 예술성이 있다는 것을 증명하기 위한 투표 입니다.</h5>
  
 

   <!-- 결과 보기 버튼 부분 -->
  
   <button class="btn btn-primary" style="margin-left:auto;margin-right:auto;display:block;margin-top:5%;margin-bottom:0%" onclick="drawBarColors()">결과 확인</button>
    </div>
  </section> 
  <hr>
 
  
    <div id="chart_div" style="width: 900px; height: 300px; margin-left:auto;margin-right:auto;display:block;"></div>

 <!-- Main Body Section End=============================================================================== -->


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