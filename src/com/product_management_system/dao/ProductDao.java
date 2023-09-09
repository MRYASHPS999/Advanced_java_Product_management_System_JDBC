package com.product_management_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.product_management_system.configuration.HelperClass;
import com.product_management_system.dto.Product;

public class ProductDao {
	HelperClass helperClass = new HelperClass();
	Connection connection = null;

	public Product saveProduct(Product product) {

		connection = helperClass.getConnection();

		String sql = "INSERT INTO product VALUES(?,?,?,?)";

		try {
			// create statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// passed the values to delimiters/placeholders --> ?
			preparedStatement.setInt(1, product.getProduct_id());
			preparedStatement.setString(2, product.getProduct_name());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setInt(4, product.getStock());

			// execute
			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return product;
	}

	public Product getAllProductData(Product product) {

		connection = helperClass.getConnection();

		String sql = "SELECT * FROM product";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getDouble(3));
				System.out.println(resultSet.getInt(4));
				System.out.println("=========================================================");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		
//		if(student!=null) {
//			return true;
//		}else {
//			return false;
//		}

		return product;
	}

	// To retrieve data of single user
	public boolean getProductDataById(int product_id) {

		connection = helperClass.getConnection();

		String sql = "SELECT * FROM product WHERE product_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, product_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getDouble(3));
				System.out.println(resultSet.getInt(4));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (product_id > 0) {
			return true;
		} else {
			return false;

		}

	}

	// To update the data
	public boolean updateProductById(int product_id) {
		connection = helperClass.getConnection();
		String sql = "UPDATE product SET product_name='dummy4',price=45.23,stock=10 WHERE product_id=?";
		int i = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, product_id);

			i = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	// to delete the student data

	public boolean deleteProductById(int product_id) {
		connection = helperClass.getConnection();
		String sql = "DELETE FROM product WHERE product_id=?";
		int i = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, product_id);

			i = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}

}
