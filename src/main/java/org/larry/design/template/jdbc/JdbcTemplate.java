package org.larry.design.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {

    private DataSource dataSource ;


    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql,RowMapper<?> rowMapper,Object [] values) throws Exception{
        // 1,获取数据库连接
        Connection connection = this.getConnection() ;
        // 2,创建语句集
        PreparedStatement ps = connection.prepareStatement(sql) ;
        // 3,执行语句集
        ResultSet resultSet = this.executeQuery(ps,values);
        // 4,处理执行结果集
        List<?> result = dealResult(resultSet, rowMapper);
        // 5,关闭结果集
        closeResultSet(resultSet);
        // 6，关闭语句集合
        closePreparedStatement(ps);
        // 7, 关闭连接
        closeConnection(connection);
        return result ;
    }

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null ;
    }


    public PreparedStatement cratePreparedStatement(Connection connection,String sql) throws Exception{
        return connection.prepareStatement(sql) ;
    }


    public ResultSet executeQuery(PreparedStatement ps,Object[] objects) throws SQLException {
        for (int i = 0; i < objects.length; i++) {
            ps.setObject(i,objects[i]);
        }
        return ps.executeQuery();
    }

    public List<?> dealResult(ResultSet rs,RowMapper rowMapper) throws Exception{
        List<Object> result = new ArrayList<>();
        int rowNum = 1 ;
        while (rs.next()){
            result.add(rowMapper.mapRow(rs,rowNum++)) ;
        }
        return result ;
    }

    private void closeResultSet(ResultSet rs) throws SQLException {
        rs.close();
    }

    private void closePreparedStatement(PreparedStatement ps) throws SQLException {
        ps.close();
    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
