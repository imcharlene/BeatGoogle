<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>googl-E</title>
<style>
div {
	text-align: center
}
</style>
<style>
input {
	border-radius: 15px;
	border-width: 0;
	outline: none
}
</style>
<script
	src="http://api.asilu.com/cdn/jquery.js,jquery.backstretch.min.js"
	type="text/javascript"></script>
</head>

<body>
	<script type="text/javascript">
$.backstretch([
		'./image/background.jpg',
		'./image/180801-taichung.jpg',
		'./image/R.jpg',
	], {
		fade : 1000, // 動畫時長
		duration : 2000 // 切換延時
});
</script>
	<table width="300" height="150">
	</table>
	<div style="line-height: 80px">
		<img src="./image/googlE.png" alt="googl-E"
			title="standing for e-sports google" width="272" height="100">
	</div>
	<div>
		<form action='${requestUri}' method='get'>
			<input type='text' name='keyword'
				placeholder='   googl-E for e-sports'
				style="width: 500px; height: 30px" /> <input type='submit'
				hidden=true value='submit' />
		</form>
	</div>
</body>
</html>
