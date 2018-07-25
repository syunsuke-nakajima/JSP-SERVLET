package dao;

/**
 * Javaからクエリを発行するクラス
 * @author nakajimashunsuke
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class T_ProductDAO {

    private String driver;
    private String url;
    private String user;
    private String password;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    /**
     * コンストラクタ
     * @param driver ドライバー
     * @param url URL
     * @param user ユーザー名
     * @param password パスワード
     */
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
        url = "jdbc:mysql://localhost:8082/wbr_inventory_control";
        user = "testuser";
        password = "Testuser1%z";
    }

    /**
     * データベースへの接続を行う
     */
    public synchronized void open() throws Exception {
        Class.forName(driver);
        con = DriverManager.getConnection(url, user, password);
        ps = con.prepareStatement("insert into T_product(product_ID, product_genre_code, product_name, product_maker, product_price, product_stock, product_sales, product_remarks) values"
        		+ "?,?,?,?,?,?,?,?");
    }

    /**
     * SQL 文を実行した結果の ResultSet を返す
     * @param sql SQL 文
     */
    public ResultSet getResultSet(String sql) throws Exception {
        if ( ps.execute(sql) ) {
            return ps.getResultSet();
        }
        return null;
    }

    /**
     * SQL 文の実行
     * @param sql SQL 文
     */
    public void execute(String sql) throws Exception {
        ps.execute(sql);
    }

    /**
     * データベースへのコネクションのクローズ
     */
    public synchronized void close() throws Exception {
        if ( rs != null ) rs.close();
        if ( ps != null ) ps.close();
        if ( con != null ) con.close();
    }
}