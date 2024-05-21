<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
</head>
<body>
	<h1>파일 업로드(단일)</h1>
	
	<form method="POST" action="/file/addok.do" enctype="multipart/form-data" id="form1">
		<table class="vertical">
			<tr>
				<th>텍스트</th>
				<td><input type="text" name="txt" value="홍길동"></td>
			</tr>
			<tr>
				<th>파일</th>
				<td><input type="file" name="attach"></td>
			</tr>
		</table>
		
		<div>
			<button>보내기</button>
		</div>
		
	</form>
	
	<hr>
	
	
	<h1>파일 업로드(다중 > multiple)</h1>
	
	<form method="POST" action="/file/multi_addok.do" enctype="multipart/form-data" id="form2">
		<table class="vertical">
			<tr>
				<th>텍스트</th>
				<td><input type="text" name="txt" value="홍길동"></td>
			</tr>
			<tr>
				<th>파일</th>
				<td><input type="file" name="attach" multiple></td>
			</tr>
		</table>
		
		<div>
			<button>보내기</button>
		</div>
		
	</form>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
	
		function checkFile(filename, filesize) {
			
			const maxsize = 10485760;
			const regex = /(.*?)\.(exe|sh)$/gi; //test.exe, test.sh 올리면 안되는 파일 지정
			
			if (filesize > maxsize) {
				alert('단일 파일의 크기가 10MB 이하만 가능합니다.');
				
				return true;
			}
			
			if(regex.test(filename)) {
				alert('해당 파일은 업로드 할 수 없습니다.')
				return true;
			}
			
			return false;
			
		}
	
	
		//폼이 전송되기 직전
		$('#form1').submit(()=>{
			
			//alert($('input[name=attach]').val());
			//alert($('input[name=attach]')[0].files[0].name);
			let filename = $('input[name=attach]')[0].files[0].name;
			
			let filesize = $('input[name=attach]')[0].files[0].size;
			
			//alert(filesize);
			
			if(checkFile(filename,filesize)) {
				
				//전송금지
				event.preventDefault();
				return false;
			}
			
			//submit 진행
			
			
		})
	
	</script>
	
</body>
</html>