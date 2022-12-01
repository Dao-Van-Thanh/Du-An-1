package com.example.nhom_8.Dao;

import android.util.Log;

import com.example.nhom_8.Object.DoAn;
import com.example.nhom_8.Object.LoaiDoAn;
import com.example.nhom_8.SQLsever.SQLsever;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoaiDoAnDao {
    Connection connection;
    public LoaiDoAnDao(){
        // hàm khởi tạo để mở kết nối
        SQLsever db = new SQLsever();
        connection = db.openConnect(); // tạo mới DAO thì mở kết nối CSDL
    }
    public List<String> getAllTenLoaiDoAn(){
        List<String> list = new ArrayList<>();

        try {
            if (this.connection != null) {

                String sqlQuery = "select tenLoai from LoaiDoAn";

                Statement statement = this.connection.createStatement(); // khởi tạo cấu trúc truy vấn

                ResultSet resultSet = statement.executeQuery(sqlQuery); // thực thi câu lệnh truy vấn

                while (resultSet.next()) { // đọc dữ liệu gán vào đối tượng và đưa vào list
                    list.add(resultSet.getString("tenLoai"));
                }
            } // nếu kết nối khác null thì mới select và thêm dữ liệu vào, nếu không thì trả về ds rỗng
        } catch (Exception e) {
            Log.e("zzzzzzzzzz", "getAll: Có lỗi truy vấn dữ liệu " );
            e.printStackTrace();
        }

        return  list;
    }
    public List<LoaiDoAn> getAll(){
        List<LoaiDoAn> ls = new ArrayList<>();
        try {
            if (this.connection != null) {

                String sqlQuery = "select * from LoaiDoAn";

                Statement statement = this.connection.createStatement(); // khởi tạo cấu trúc truy vấn

                ResultSet resultSet = statement.executeQuery(sqlQuery); // thực thi câu lệnh truy vấn

                while (resultSet.next()) { // đọc dữ liệu gán vào đối tượng và đưa vào list
                    LoaiDoAn loaiDoAn = new LoaiDoAn();
                    loaiDoAn.setIdLoaiDoAn(resultSet.getInt("idLoaiDoAn"));
                    loaiDoAn.setTenLoaiDoAn(resultSet.getString("tenLoai"));
                    loaiDoAn.setIdQTV(1);
                    ls.add(loaiDoAn);
                }
            } // nếu kết nối khác null thì mới select và thêm dữ liệu vào, nếu không thì trả về ds rỗng
        } catch (Exception e) {
            Log.e("zzzzzzzzzz", "getAll: Có lỗi truy vấn dữ liệu " );
            e.printStackTrace();
        }

        return  ls;
    }
}
