<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="t_product_db" scope="session" class="model.ProductBean" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫管理システム - 登録画面</title>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/new.css">
</head>
<body>
	<h1>在庫管理システム</h1>
	<div id="wrapper">
		<form method="POST" action="./New">

			<div id="content1">
				<div id="form-left">
					<ul>
						<li>商品ID<br />
						<input type="text" name="item-id">
						</li>
						<li>商品名<br />
						<input type="text" name="item-name">
						</li>
						<li>金額<br />
						<input type="text" name="price">
						</li>
						<li>販売個数<br />
						<input type="text" name="number">
						</li>
					</ul>
				</div>

				<div id="form-right">
					<ul>
						<li>ジャンル<br />
							<select name="genre">
								<option value="0">指定なし</option>
								<option value="1">時計</option>
								<option value="2">電子機器</option>
								<option value="3">携帯</option>
							</select>
						</li>
						<li>メーカー名<br />
							<select name="maker">
								<option value="none">指定なし</option>
								<option value="Panasonic">パナソニック</option>
								<option value="Sony">ソニー</option>
								<option value="Sharp">シャープ</option>
							</select>
						</li>
						<li>在庫数<br />
						<input type="text" name="stock"></li>
					</ul>
				</div>
			</div>

			<div id="content2">
				備 考<br />
				<textarea cols="30" rows="5" name="remarks"></textarea>
			</div>

			<div id="content3">
				<input type="submit" value="登　録" id="submit">
			</div>
		</form>
	</div>
</body>
</html>