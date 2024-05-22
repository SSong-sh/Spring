<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
<style>
	
	#attach-zone {
		
		border: 1px solid var(--border-color);
		background-color : var(--back-color);
		width: 300px;
		height: 100px;
		overflow: auto;
	}
	
	#attach-zone .item {
		font-size : 12px;
		margin: 5px 10px
	}

</style>
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
	
	<hr>
	
	<h1>파일 업로드(다중 > File Drop)</h1>
	
	<form method="POST" action="/file/multi_addok.do" enctype="multipart/form-data" id="form3">
		<table class="vertical">
			<tr>
				<th>텍스트</th>
				<td><input type="text" name="txt" value="홍길동"></td>
			</tr>
			<tr>
				<th>파일</th>
				<td>
				<div id="attach-zone"></div>
				<input type="file" name="attach" style="display:none;">
				</td>
			</tr>
		</table>
		
		<div>
			<button>보내기</button>
		</div>
		
	</form>
	
	
	<hr>
	
	
	<h1>파일 업로드(다중 > ajax)</h1>
	
	<form id="form4">
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
			<button type="button">보내기</button>
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
			
			
		});
	
		
		$('#form2').submit(() => {
			
			
			//첨부파일
			//alert($('#form2 input[name=attach]')[0].files.length);
			
			let totalSize = 0;
			
			Array.from($('#form2 input[name=attach]')[0].files).forEach(file => {
				//alert(file.size);
				
				//개별 파일 체크
				if(checkFile(file.name, file.size)) {
					alert('단일 파일의 크기가 10MB 이하만 가능합니다.');
					event.preventDefault();
					return false;
				}
				
				totalSize += file.size;
				
			});
			
			if(totalSize > 52428800) {
				alert('총 파일의 크기의 합이 50MB 이하만 가능합니다.');
				event.preventDefault();
				return false;
			}
			
			
		});
		
		$('#attach-zone')
			.on('dragenter', e => {
				e.preventDefault();
				e.stopPropagation();
			})
			.on('dragover', e => {
				e.preventDefault();
				e.stopPropagation();
			})
			.on('dragleave', e => {
				e.preventDefault();
				e.stopPropagation();
			})
			.on('drop', e => {
				e.preventDefault();
				
				//alert();
				
				const files = e.originalEvent.dataTransfer.files;
				
				if(files != null && files != undefined) {
					
					//기존 것은 지우고 최근에 올린 것이 나타날 수 있도록
					$('#attach-zone').empty();
					
					let temp = '';
					
					for(let i = 0; i<files.length; i++){
						
						//console.log(files[i].name);
						
						let filename = files[i].name;
						let filesize = files[i].size / 1024 / 1024; //MB
						
						filesize = filesize < 1 ? filesize.toFixed(2) : filesize.toFixed(1);
						
						temp += `
							<div class="item">
								<span>\${filename}</span>
								<span>\${filesize}MB</span>
							</div>
						`;
					}//for
					
					$('#attach-zone').append(temp);
					
					
					//drop시킨 파일들을 파일 인풋에 넣은 것
					$('#form3 input[name=attach]').prop('files', files);
					
					
				}
			});
			
		
		$('#form4 button').click(() =>{
			
			//Ajax 파일 업로드 > FormData 객체 사용
			
			const formData = new FormData();
			const files = $('#form4 input[name=attach]')[0].files;
			
			//console.log(files);
			
			for(let i=0; i<files.length; i++) {
				
				formData.append( "attach", files[i]);
			}
			
			formData.append("txt", $('#form4 input[name=txt]').val());
			
			$.ajax({
				
				type:'POST',
				url: '/file/multi_addok.do',
				data: formData,
				processData: false,
				contentType: false,
				success: function(result) {
					
				},
				
				error: function(a,b,c) {
					console.log(a,b,c);
				}
				
			});
			
		});
		
	</script>
	
</body>
</html>