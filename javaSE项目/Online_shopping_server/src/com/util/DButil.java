package com.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DButil {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://127.0.0.1:3307/tmall?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=GMT%2B8";
	private static final String username = "root";
	private static final String password = "lh0812";
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static java.sql.Timestamp d2t(java.util.Date d) {
        if (null == d)
            return null;
        return new java.sql.Timestamp(d.getTime());
    }
 
    public static java.util.Date t2d(java.sql.Timestamp t) {
        if (null == t)
            return null;
        return new java.util.Date(t.getTime());
    }
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static boolean update(Connection conn, String sql, Object... paramets) {
		PreparedStatement pstmt = null;
		try {
			pstmt = getPreparedStatement(conn, sql, paramets);
			return pstmt.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, pstmt, null);
		}
		return false;
	}

	private static PreparedStatement getPreparedStatement(Connection conn, String sql, Object...paramets) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			if(paramets==null)return pstmt;
			for (int i = 0; i < paramets.length; i++) {
				pstmt.setObject(i + 1, paramets[i]);
			}
			return pstmt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static <T> List<T> queryList(Connection conn,Class<T> c, String sql, Object...paramets) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		pstmt = getPreparedStatement(conn, sql, paramets);
		try {
			rs = pstmt.executeQuery();
			String[] arr = getCol(rs);
			while(rs.next()) {
				T t = c.newInstance();
				for (int i = 0; i < arr.length; i++) {
					Object obj = rs.getObject(arr[i]);
					if(obj==null)continue;
					Method method = t.getClass().getMethod("set"+
							arr[i].substring(0,1).toUpperCase()+
							arr[i].substring(1),
							obj.getClass());
					method.invoke(t, obj);
				}
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		return list;
	}

	private static String[] getCol(ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();
		int count = metaData.getColumnCount();
		String[] arr = new String[count];
		for (int j = 0; j < count; j++) {
			arr[j]=metaData.getColumnName(j+1);			
		}
		return arr;
	}
	public static <T> T query(Connection conn,Class<T> c, String sql, Object...paramets) {
		List<T> list = queryList(conn, c, sql, paramets);
		if(list.isEmpty())return null;
		return list.get(0);
	}
}
