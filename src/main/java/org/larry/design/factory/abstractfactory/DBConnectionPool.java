package org.larry.design.factory.abstractfactory;

public class DBConnectionPool extends Pool {

    private static DBConnectionPool pool = null;

    public static synchronized DBConnectionPool getInstance(){
        if(pool == null){
            pool = new DBConnectionPool() ;
        }
        return pool;
    }

    private DBConnectionPool(){
        System.out.println("DBConnectionPool 实例化。。。");
    }
    @Override
    protected void createConnection() {
        System.out.println("createConnection");
    }

    public static void main(String[] args) {
        DBConnectionPool instance = DBConnectionPool.getInstance();
        instance.createConnection();
    }
}
