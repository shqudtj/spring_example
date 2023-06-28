<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>

		<form method="post" action="/lesson06/ex01/add_user">
			<div class="form-group">
				<label for="name"><b>이름</b></label> <input type="text" id="name"
					name="name" class="form-control col-3" placeholder="아이디를 입력하세요.">
			</div>
			<div class="form-group">
				<label for="yyyymmdd"><b>생년월일</b></label> <input type="text"
					id="yyyymmdd" name="yyyymmdd" class="form-control col-3"
					placeholder="예) 20010101">
			</div>
			<div class="form-group">
				<label for="email"><b>이메일</b></label> <input type="text" id="email"
					name="email" class="form-control col-3" placeholder="이메일을 입력해 주세요.">
			</div>
			<div class="form-group">
				<label for="introduce"><b>자기소개</b></label>
				<textarea id="introduce" name="introduce" class="form-control col-3"></textarea>
			</div>
			<!-- AJAX 통신으로 호출할 때는 반드시 버튼을 button 타입으로 지정한다.(form 3종세트 동작 안하기) -->
			<!-- AJAX를 할때 form태그 자체를 안해도 됨 -->
			<!-- <input type="submit" class="btn btn-info" value="회원가입"> -->
			<input type="button" id="joinBtn" class="btn btn-info" value="회원가입">
		</form>
	</div>

<script>
	$(document).ready(function() {
		// 1) form 태그 - submit
	/* 	$('form').on('submit', function(e) {
			//e.preventDefault();	// submit 되는 것을 막는다.(화면이 유지됨)
			//alert("submit 버튼 클릭");
			
			// validation
			let name = $("#name").val().trim();
			if (name == '') {
				alert("이름을 입력하세요.");
				return false;	// submit 안함, submit 이벤트일때 return이 아닌 return false를 해야함
			}
			let yyyymmdd = $("#yyyymmdd").val().trim();
			if (yyyymmdd.length < 1) {
			//if (!yyyymmdd) { -> 도 가능
				alert("생년월일을 입력하세요.")
				return false;
			}
			
			// 여기 도달시 submit 수행
			alert("서브밋 수행");
		}); */
	
		// 2) jquery의 AJAX 통신 이용하기
		$('#joinBtn').on('click', function() {
			
			// validation
			let name = $("#name").val().trim();
			if (name == '') {
				alert("이름을 입력하세요.");
				return
			}
			
			let yyyymmdd = $("#yyyymmdd").val().trim();
			if (yyyymmdd.length < 1) {
			//if (!yyyymmdd) { -> 도 가능
				alert("생년월일을 입력하세요.");
				return
			}
			
			let email = $('input[name=email]').val().trim();
			let introduce = $('#introduce').val();
			
			console.log(name);
			console.log(yyyymmdd);
			console.log(email);
			console.log(introduce);
			
			// 서버 전송 - AJAX 통신
			$.ajax({
				// request
				type:"post"
				, url:"/lesson06/ex01/add_user"
				, data:{"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce}
					
				// response
				, success:function(data) { // data param: response의 결과 응답 
					//alert(data);
					if (data == "성공") {
						location.href="/lesson06/ex01/after_add_user_view";
					} else {
						alert("회원가입 처리에 실패했습니다.");
					}
				}
				, complete:function(data) {
					alert("성공이든 실패든 완료되면 띄어진다.");					
				}
				, error:function(request, status, error) {
					alert(request);
					alert(status);
					alert(error);
				}
			});
		});
	});
</script>
</body>
</html>