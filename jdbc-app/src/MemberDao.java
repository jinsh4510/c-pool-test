import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MemberDao {
	private String url;
	private String dbid;
	private String dbpw;
	
	private void dbPropertiesInit() throws IOException {
		FileInputStream fis = new FileInputStream("d:\\db.properties");
		Properties pro = new Properties();
		pro.load(fis);
		this.url = pro.getProperty("url");
		this.dbid = pro.getProperty("dbid");
		this.dbpw = pro.getProperty("dbpw");
	}
	
	public Member selectMemberById(String id) throws ClassNotFoundException, SQLException, IOException {
		this.dbPropertiesInit();
		System.out.println(this.url);
		System.out.println(this.dbid);
		System.out.println(this.dbpw);
		// Properties db정보 가져옵니다(내부적으로 input...
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(this.url, this.dbid, this.dbpw);
		String sql = "SELECT * FROM oracle_member WHERE ora_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();
		Member member = null;
		if(rs.next()) {
			member = new Member();
			member.setId(rs.getString("ora_id"));
			member.setName(rs.getString("ora_name"));
			// ....
		}
		return member;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		MemberDao md = new MemberDao();
		Member m = md.selectMemberById("id001");
		System.out.println(m.getName().equals("홍01"));
	}
}