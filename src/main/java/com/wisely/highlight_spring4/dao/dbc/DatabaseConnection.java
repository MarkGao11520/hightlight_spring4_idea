package com.wisely.highlight_spring4.dao.dbc;

import java.sql.Connection;

/**
 * Created by gaowenfeng on 2017/6/2.
 */
public interface DatabaseConnection {
    public Connection getConnection();
    public void close() throws Exception;
}
