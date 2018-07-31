package dao;

/**
 * Javaからクエリを発行するクラス
 * @author nakajimashunsuke
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class T_ProductDAO {

    private String driver;
    private String url;
    private String user;
    private String password;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;


    public T_ProductDAO(String driver, String url, String user, String password) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    /**
     * 引数なしのコンストラクタ
     * 既定値を使用する
     */
    public T_ProductDAO() {
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/wbr_inventory_control";
        user = "testuser";
        password = "Testuser1%";
    }

    public synchronized void open() throws Exception {
        Class.forName(driver);
        con = DriverManager.getConnection(url, user, password);
    }

    // insert文を発行するメソッド
    public ResultSet insertSQL(int id, int genreCode, String name, String maker, int price, int stock, int number, String remarks) {
    	String sql = "insert into T_Product values (?,?,?,?,?,?,?,?)";
    	try {
			// 各値をセットする
    		((PreparedStatement) stmt).setInt(1, id);
    		((PreparedStatement) stmt).setInt(2, genreCode);
    		((PreparedStatement) stmt).setString(3, name);
    		((PreparedStatement) stmt).setString(4, maker);
    		((PreparedStatement) stmt).setInt(5, price);
    		((PreparedStatement) stmt).setInt(6, stock);
    		((PreparedStatement) stmt).setInt(7, number);
    		((PreparedStatement) stmt).setString(8, remarks);
    		stmt.executeUpdate(sql);
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
		} finally {
			//　終了処理
			// PreparedStatement終了
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
				stmt = null;
			}
			// Connection終了
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
				con = null;
			}
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException e) {
				}
				rs = null;
			}
		}
    return rs;
    }
}