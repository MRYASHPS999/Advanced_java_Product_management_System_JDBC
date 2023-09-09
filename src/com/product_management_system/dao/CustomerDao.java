package com.product_management_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.product_management_system.configuration.HelperClass;
import com.product_management_system.dto.Customer;

public class CustomerDao {

	HelperClass helperClass = new HelperClass();
	Connection connection = null;

	public Customer saveCustomer(Customer customer) {

		connection = helperClass.getConnection();

		String sql = "INSERT INTO customer VALUES(?,?,?,?)";

		try {
			// create statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// passed the values to delimiters/placeholders --> ?
			preparedStatement.setInt(1, customer.getC_id());
			preparedStatement.setString(2, customer.getC_name());
			preparedStatement.setString(3, customer.getC_email());
			preparedStatement.setInt(4, customer.getPhone_no());

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

		return customer;
	}

	public Customer getAllCustomerData(Customer customer) {

		connection = helperClass.getConnection();

		String sql = "SELECT * FROM customer";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
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

		return customer;
	}

	// To retrieve data of single user
	public boolean getCustomerDataById(int c_id) {

		connection = helperClass.getConnection();

		String sql = "SELECT * FROM customer WHERE c_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, c_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
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

		if (c_id > 0) {
			return true;
		} else {
			return false;

		}

	}

	// To update the data
	public boolean updateCustomerById(int c_id) {
		connection = helperClass.getConnection();
		String sql = "UPDATE customer SET c_name='dummy4',c_email='dummy4@mail.com',phone_no=1234567890 WHERE c_id=?";
		int i = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, c_id);

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

	public boolean deleteCustomerById(int c_id) {
		connection = helperClass.getConnection();
		String sql = "DELETE FROM customer WHERE c_id=?";
		int i = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, c_id);

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
