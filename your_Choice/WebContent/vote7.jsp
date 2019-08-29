<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

</head>

<body id="page-top">

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="sessionDel"><i class="fas fa-child"></i> Your Choice</a>
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

  <!-- Portfolio Section -->
  <section class="page-section portfolio" id="portfolio">
    <div class="container">

      <!-- Portfolio Section Heading -->
      <br><br>
      <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">둘중 예술성이 뛰어난 작품은?</h2>

      <!-- Icon Divider -->
      <div class="divider-custom">
        <div class="divider-custom-line"></div>
        <div class="divider-custom-icon">
        </div>
        <div class="divider-custom-line"></div>
      </div>

      <!-- Vote Grid Items -->
      <div class="row">

        <!-- Vote Question 1 -->
        <div class="col-md-6 col-lg-6">
          <div class="portfolio-item mx-auto" data-toggle="modal" data-target="#portfolioModal1">
            <div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
              <div class="portfolio-item-caption-content text-center text-white">
                <i class="fas fa-thumbs-up fa-3x"></i>
              </div>
            </div>
            <img class="img-fluid" src="img/portfolio/7a.jpg" alt="">
          </div>
        </div>

        <!-- Vote Question 2 -->
        <div class="col-md-6 col-lg-6">
          <div class="portfolio-item mx-auto" data-toggle="modal" data-target="#portfolioModal2">
            <div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
              <div class="portfolio-item-caption-content text-center text-white">
                <i class="fas fa-thumbs-up fa-3x"></i>
              </div>
            </div>
            <img class="img-fluid" src="img/portfolio/7h.jpg" alt="">
          </div>
        </div>
      </div>
      <!-- /.row -->

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

  <!-- Vote detail-->

  <!-- Vote detail item 1 -->
  <div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-labelledby="portfolioModal1Label" aria-hidden="true">
    <div class="modal-dialog modal-xl" role="document">
      <div class="modal-content">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">
            <i class="fas fa-times"></i>
          </span>
        </button>
        <div class="modal-body text-center">
          <div class="container">
            <div class="row justify-content-center">
              <div class="col-lg-8">
                <!-- Portfolio Modal - Image -->
                <img class="img-fluid rounded mb-5" src="img/portfolio/7a.jpg" alt="">
                <!-- =======================================================================  -->
                <form action="Con" method="post">
	 				<input type = "hidden" name = "command", value="updateVote">
	 				<input type="hidden" name="question" value="a">
	 				<input type="hidden" name="pageNumber" value="8">
	 				<button type="submit" value="Choice" class="btn btn-primary" id="sendMessageButton">
            		<i class="fas fa-check fa-fw"></i>
            		 Choice
            		</button>
                	<button class="btn btn-primary" href="#" data-dismiss="modal">
                	<i class="fas fa-times fa-fw"></i>
                	 Close
                	</button>
				</form>
                <!-- =======================================================================  -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

    
  <!-- Vote detail item -->
  <div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-labelledby="portfolioModal1Label" aria-hidden="true">
    <div class="modal-dialog modal-xl" role="document">
      <div class="modal-content">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">
            <i class="fas fa-times"></i>
          </span>
        </button>
        <div class="modal-body text-center">
          <div class="container">
            <div class="row justify-content-center">
              <div class="col-lg-8">
                <!-- Portfolio Modal - Image -->
                <img class="img-fluid rounded mb-5" src="img/portfolio/7h.jpg" alt="">
                <form action="Con" method="post">
					<input type="hidden" name = "command", value="updateVote">
	 				<input type="hidden" name="question" value="h">
	 				<input type="hidden" name="pageNumber" value="8">
	 				<button type="submit" value="Choice" class="btn btn-primary" id="sendMessageButton">
            		<i class="fas fa-check fa-fw"></i>
            		 Choice
            		</button>
                	<button class="btn btn-primary" href="#" data-dismiss="modal">
                	<i class="fas fa-times fa-fw"></i>
                	 Close
                	</button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
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