<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ProductBean, dao.T_ProductDAO, java.sql.*" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
  <link rel="stylesheet" href="./css/style.css">
  <link rel="stylesheet" href="./css/list.css">
  <title>在庫管理システム</title>
</head>
<body>
  <div id="container">
    <h1>在庫管理システム</h1>

    <div id="btn-wrapper">
      <button type="button" onclick="location.href='#'">検 索</button>
      <button type="button" onclick="location.href='./New'">新規登録</button>
    </div>

    <table border="1">
      <tr>
        <th>商品ID</th>
        <th>画像</th>
        <th>メーカー名</th>
        <th>商品名</th>
        <th>ジャンル</th>
        <th>在庫数</th>
        <th>販売個数</th>
        <th>価格</th>
        <th>更新</th>
      </tr>
      <tr>
        <td></td>
        <td><img src="img/Aandyou_SW_E07_一覧用.png" alt="商品画像"></td>
        <td>###</td>
        <td>###</td>
        <td>###</td>
        <td>###</td>
        <td>###</td>
        <td>###</td>
        <td><input type="button" value="更 新"></td>
      </tr>
    </table>
  </div>
</body>
</html>
