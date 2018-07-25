# JSP-SERVLET
JSPサーブレットのテストページ。

List.javaにリクエスト　→　ProductList.jspにフォワードする。

【ProductList.jsp】<br />
DBから情報を取得し、各セルに情報を表示する。
<ul>
  <li>「新規登録」 →　ProductInfo.jspへ遷移</li>
  <li>更新セルの「更新」ボタンを押す　→　beanクラスの値を保持し　ProductUpdate.jspに遷移。</li>
</ul>

【ProductInfo.jsp】<br />
<ul>
  <li>フォーム内に値を入れて「登録」ボタンを押す　→　フォームに入力した値を取得し、DBに格納する</li>
</ul>
【ProductUpdate.jsp】<br />
<ul>
  <li>先の「ProductList.jsp」に表示されていた値を、フォーム内に最初から表示する。</li>
<li>「更新」ボタンを押すと、情報を書き換える。</li>
</ul>
