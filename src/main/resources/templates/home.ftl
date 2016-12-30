<!doctype html>
<!--[if lt IE 8]>         <html class="no-js lt-ie8"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>Web Application</title>
        <meta name="description" content="Responsive Admin Web App">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

        <!-- Needs images, font... therefore can not be part of main.css -->
        <link rel="stylesheet" href="./fonts/themify-icons/themify-icons.min.css">
        <link rel="stylesheet" href="./fonts/font-awesome/css/font-awesome.min.css">


            <link rel="stylesheet" href="./styles/bootstrap.css">
            <link rel="stylesheet" href="./styles/ui.css">
            <link rel="stylesheet" href="./styles/main.css">

    </head>
    <body data-ng-app="app"
          id="app"
          class="app"
          data-custom-page 
          data-off-canvas-nav
          data-ng-controller="AppCtrl"
          data-ng-class=" {'layout-boxed': admin.layout === 'boxed'} "
          >
        <!--[if lt IE 9]>
            <div class="lt-ie9-bg">
                <p class="browsehappy">You are using an <strong>outdated</strong> browser.</p>
                <p>Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
            </div>
        <![endif]-->

        <section data-ng-include=" 'layout/header.html' "
                 id="header"
                 class="header-container "
                 data-ng-class="{ 'header-fixed': admin.fixedHeader,
                                  'bg-white': ['11','12','13','14','15','16','21'].indexOf(admin.skin) >= 0,
                                  'bg-dark': admin.skin === '31',
                                  'bg-primary': ['22','32'].indexOf(admin.skin) >= 0,
                                  'bg-success': ['23','33'].indexOf(admin.skin) >= 0,
                                  'bg-info-alt': ['24','34'].indexOf(admin.skin) >= 0,
                                  'bg-warning': ['25','35'].indexOf(admin.skin) >= 0,
                                  'bg-danger': ['26','36'].indexOf(admin.skin) >= 0
                 }"></section>

        <div class="main-container">
            <aside data-ng-include=" 'layout/sidebar.html' "
                   id="nav-container"
                   class="nav-container"
                   data-ng-class="{ 'nav-fixed': admin.fixedSidebar,
                                    'nav-horizontal': admin.menu === 'horizontal',
                                    'nav-vertical': admin.menu === 'vertical',
                                    'bg-white': ['31','32','33','34','35','36'].indexOf(admin.skin) >= 0,
                                    'bg-dark': ['31','32','33','34','35','36'].indexOf(admin.skin) < 0
                   }">
            </aside>

            <div id="content" class="content-container">
                <section data-ng-view
                         class="view-container {{admin.pageTransition.class}}"></section>
            </div>
        </div>

        <script src="./scripts/jquery/jquery-3.1.1.min.js"></script>
        <script src="./scripts/angular/angular.js"></script>
        <script src="./scripts/angular/angular-route/angular-route.js"></script>
        <script src="./scripts/angular/angular-aria/angular-aria.min.js"></script>
        <script src="./scripts/angular/angular-animate/angular-animate.min.js"></script>

        <script src="./scripts/angular/angular-bootstrap/ui-bootstrap-tpls.min.js"></script>
        <script src="./scripts/toastr/toastr.min.js"></script>
        <script src="./scripts/jquery/jquery.slimscroll/jquery.slimscroll.min.js"></script>
        <script src="./scripts/angular/angular-loading-bar/loading-bar.min.js"></script>
        <script src="./scripts/angular/angular-scroll/angular-scroll.min.js"></script>

        <script src="./scripts/angular/textAngular/textAngular-rangy.min.js"></script>
        <script src="./scripts/angular/textAngular/textAngular-sanitize.min.js"></script>
        <script src="./scripts/angular/textAngular/textAngular.min.js"></script>

        <script src="./scripts/angular/angular-translate/angular-translate.min.js"></script>
        <script src="./scripts/angular/angular-translate-loader-static-files/angular-translate-loader-static-files.min.js"></script>

        <script src="./scripts/angular/ng-tags-input/ng-tags-input.min.js"></script>
        <script src="./scripts/bootstrap/bootstrap-slider/bootstrap-slider.min.js"></script>
        <script src="./scripts/jquery/jquery-steps/jquery.steps.min.js"></script>
        <script src="./scripts/bootstrap/bootstrap-file-input/bootstrap.file-input.js"></script>
        <script src="./scripts/angular/angular-validation-match/angular-validation-match.min.js"></script>

        <script src="./vendors/echarts.js"></script>         
        <script src="./vendors/ngecharts.js"></script>        


		<script src="./files/scripts/files.module.js"></script>
		<script src="./files/scripts/files.controller.js"></script>
		<script src="./files/scripts/files.directive.js"></script>

		<script src="./datasources/scripts/datasources.module.js"></script>
		<script src="./datasources/scripts/datasources.controller.js"></script>
		<script src="./datasources/scripts/datasources.directive.js"></script>

        <script src="./app.module.js"></script>
        <script src="./dashboard/scripts/dashboard.module.js"></script>
        <script src="./app/task/task.module.js"></script>
        <script src="./chart/chart.module.js"></script>
        <script src="./form/form.module.js"></script>
        <script src="./form/formValidation.module.js"></script>
        <script src="./layout/nav.module.js"></script>
        <script src="./page/page.module.js"></script>
        <script src="./table/table.module.js"></script>
        <script src="./ui/ui.module.js"></script>
        <script src="./app/task/task.controller.js"></script>
        <script src="./app/task/task.directive.js"></script>
        <script src="./app/task/task.service.js"></script>
        <script src="./chart/echarts.controller.js"></script>
        <script src="./core/app.controller.js"></script>
        <script src="./core/config.route.js"></script>
        <script src="./core/i18n.js"></script>
        <script src="./dashboard/scripts/dashboard.controller.js"></script>
        <script src="./dashboard/scripts/dashboard.directive.js"></script>
        <script src="./form/form.controller.js"></script>
        <script src="./form/form.directive.js"></script>
        <script src="./form/formValidation.controller.js"></script>
        <script src="./layout/nav.directive.js"></script>
        <script src="./page/page.controller.js"></script>
        <script src="./page/page.directive.js"></script>
        <script src="./table/table.controller.js"></script>
        <script src="./ui/ui.controller.js"></script>
        <script src="./ui/ui.directive.js"></script>
        <script src="./ui/ui.service.js"></script>
        
        
        <script src="./services/events.services.js"></script>
        <script src="./services/datasources.services.js"></script>
        <script src="./services/files.services.js"></script>
    </body>
</html>
