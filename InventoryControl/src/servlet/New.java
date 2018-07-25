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
		String sql = "insert into T_product(product_ID, product_genre_code, product_name, product_maker, product_price, product_stock, product_sales, product_remarks) values"
        		+ "?,?,?,?,?,?,?,?";

		// DBへの接続メソッド呼び出し
		try {
			dao.open();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		// requestインスタンスからフォームの入力内容を取得
		int id = Integer.parseInt(request.getParameter("id"));
		int genreCode = Integer.parseInt(request.getParameter("genreCode"));
		String name = request.getParameter("name");
		String maker = request.getParameter("maker");
		int price = Integer.parseInt(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int number = Integer.parseInt(request.getParameter("sales"));
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

		try {
			dao.execute(sql);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
