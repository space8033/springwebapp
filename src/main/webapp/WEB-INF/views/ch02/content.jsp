<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">
	<div class="card-header">
		Ch02. 요청 매핑 메소드
	</div>
	<div class="card-body">
		<div class="card m-2">
         <div class="card-header">
            GET 방식
         </div>
         <div class="card-body">
            <div class="m-2"><a href="${pageContext.request.contextPath}/ch02/method?bkind=free&bno=1" class="btn btn-info btn-sm">GET방식(&lt;a&gt;)</a></div>
            <hr/>
            <form class="m-2" method="get" action="${pageContext.request.contextPath}/ch02/method">
               <div class="form-group">
                   <label for="bkind">bkind</label>
                   <input type="text" class="form-control" id="bkind" name="bkind" value="free">
                   <small id="bkindHelp" class="form-text text-muted">input board kind</small>
               </div>
               
               <div class="form-group">
                   <label for="bno">bno</label>
                   <input type="text" class="form-control" id="bno" name="bno" value="1">
                   <small id="bnoHelp" class="form-text text-muted">input board no</small>
               </div>
               <input type="submit" value="GET방식(&lt;form&gt;)" class="btn btn-info btn-sm"/>
            </form>
            <hr/>
            
            <div class="m-2"><button class="btn btn-info btn-sm" onclick="requestGet()">GET방식(Ajax)</button></div>
         </div>
         <script>
            function requestGet() {
               $.ajax({
                  url:"${pageContext.request.contextPath}/ch02/method",
                  method: "GET"
               })
               .done((data) => {});
            }         
         </script>
      </div>
            
      <div class="card m-2">
         <div class="card-header">
            POST 방식
         </div>
         <div class="card-body">            
            <form class="m-2" method="post" action="${pageContext.request.contextPath}/ch02/method">
               <div class="form-group">
                   <label for="bkind">bkind</label>
                   <input type="text" class="form-control" id="bkind" name="bkind" value="free">
                   <small id="bkindHelp" class="form-text text-muted">input board kind</small>
               </div>
               
               <div class="form-group">
                   <label for="bno">bno</label>
                   <input type="text" class="form-control" id="bno" name="bno" value="1">
                   <small id="bnoHelp" class="form-text text-muted">input board no</small>
               </div>
               <input type="submit" value="POST방식(&lt;form&gt;)" class="btn btn-info btn-sm"/>
            </form>
            <hr/>
            
            <button class="btn btn-info btn-sm" onclick="requestPost()">POST방식(Ajax)</button>
         </div>
         <script>
            function requestPost() {
               $.ajax({
                  url:"${pageContext.request.contextPath}/ch02/method",
                  method: "POST"
               })
               .done((data) => {});
            }
         </script>
      </div>
            

      <div class="card m-2">
         <div class="card-header">
            PUT 방식 / DELETE 방식
         </div>
         <div class="card-body">            
            <button class="btn btn-info btn-sm" onclick="requestPut()">PUT방식(Ajax)</button>
            <button class="btn btn-info btn-sm" onclick="requestDelete()">DELETE방식(Ajax)</button>
         </div>
         <script>
            function requestPut() {
               $.ajax({
                  url:"${pageContext.request.contextPath}/ch02/method",
                  method: "PUT"
               })
               .done((data) => {});
            }
            function requestDelete() {
               $.ajax({
                  url:"${pageContext.request.contextPath}/ch02/method",
                  method: "DELETE"
               })
               .done((data) => {});
            }
         </script>         
      </div>
      
      <div class="card m-2">
         <div class="card-header">
            AJAX
         </div>
         <div class="card-body">            
            <a href="javascript:ajax1()" class="btn btn-info btn-sm">AJAX 요청(HTML 조각 얻기)</a>
            <a href="javascript:ajax2()" class="btn btn-info btn-sm">AJAX 요청(JSON)</a>
            <a href="javascript:ajax3()" class="btn btn-info btn-sm">AJAX 요청(JSON)</a>
            <a href="javascript:ajax4()" class="btn btn-info btn-sm">AJAX 요청(JSON)</a>
            <div id="content" class="mt-2"></div>
            <script>
               function ajax1() {
                  console.log("ajax1() 실행");
                  $.ajax({
                     url:"ajax1"
                  })
                  .done((data) => {
                     $("#content").html(data);
                  });
               }
               
               function ajax2() {
                  console.log("ajax2() 실행");
                  $.ajax({
                     url:"ajax2"
                  })
                  .done((data) => {
                     $("#content").html(
                        "<img src='${pageContext.request.contextPath}/resources/images/" + 
                        data.fileName + "' width='200px'/>");
                  });
               }
               
               function ajax3() {
                  console.log("ajax3() 실행");
                  $.ajax({
                     url:"ajax3"
                  })
                  .done((data) => {
                     $("#content").html(
                        "<img src='${pageContext.request.contextPath}/resources/images/" + 
                        data.fileName + "' width='200px'/>");
                  });
               }
               
               function ajax4() {
                  console.log("ajax4() 실행");
                  $.ajax({
                     url:"ajax4"
                  })
                  .done((data) => {
                     console.log(data);
                     $("#content").html(
                        "<img src='${pageContext.request.contextPath}/resources/images/" + 
                        data.fileName + "' width='200px'/>");
                  });
               }
            </script>
         </div>      
      </div>      
      
      <div class="card m-2">
         <div class="card-header">
            Filter & Interceptor
         </div>
         <div class="card-body">            
            <a href="${pageContext.request.contextPath}/ch02/filterAndInterceptor" class="btn btn-info btn-sm">Filter & Interceptor</a>
         </div>      
      </div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>