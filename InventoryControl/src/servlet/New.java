package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.T_ProductDAO;
import model.ProductBean;
/**
 * Servlet implementation class New
 */
@WebServlet("/New")
public class New extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public New() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// list.jspからnew.jspに遷移する
		request.getRequestDispatcher("WEB-INF/jsp/new/ProductInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 今はフォームの値関係なくlist.jspに遷移する記述にしてます
		// response.sendRedirect("./List");

		T_ProductDAO dao = new T_ProductDAO();

		// DBへの接続メソッド呼び出し
		try {
			dao.open();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		// requestインスタンスからフォームの入力内容を取得
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("item-id"));
		int genreCode = Integer.parseInt(request.getParameter("genre"));
		String name = request.getParameter("item-name");
		String maker = request.getParameter("maker");
		int price = Integer.parseInt(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int number = Integer.parseInt(request.getParameter("number"));
		String remarks = request.getParameter("remarks");

		// beanクラスのオブジェクトを生成
		ProductBean info = new ProductBean();

		// beanクラスのオブジェクトにフォームの値を格納
		info.setId(id);
		info.setGenreCode(genreCode);
		info.setName(name);
		info.setMaker(maker);
		info.setPrice(price);
		info.setStock(stock);
		info.setNumber(number);
		info.setRemarks(remarks);

		// ここから、フォームの値をきちんと取得できているかのテスト
		System.out.println(request.getParameter("item-id"));
		System.out.println(Integer.parseInt(request.getParameter("genre")));
		System.out.println(request.getParameter("item-name"));
		System.out.println(request.getParameter("maker"));
		System.out.println(Integer.parseInt(request.getParameter("price")));
		System.out.println(Integer.parseInt(request.getParameter("stock")));
		System.out.println(Integer.parseInt(request.getParameter("number")));
		System.out.println(request.getParameter("remarks"));
		// ここまで

		try {
			dao.insertSQL(id, genreCode, name, maker, price, stock, number, remarks);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		response.sendRedirect("./List");
	}
}
