package com.duyngoc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.duyngoc.ui.Student;

public class AppServiceImpl implements AppService {

	@Override
	public boolean login(String username, String password) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/project?" + "user=root&password=0616253284");
			preparedStatement = con
					.prepareStatement("select username from project.account where username = ? and password= ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			result = preparedStatement.executeQuery();
			if (result.next()) {
				return true;
			}
		} catch (Exception exc) {

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public List<Student> loadStudents() {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<Student>();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/project?" + "user=root&password=0616253284");
			preparedStatement = con.prepareStatement(
					"select project.student.id,project.student.name,project.student.math_grade,project.student.english_grade,project.address.streetName as street, project.address.city from project.student left join project.address on project.student.id = project.address.studentId");
			result = preparedStatement.executeQuery();
			// int i = 0;
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				double mathGrade = result.getDouble("math_grade");
				double englishGrade = result.getDouble("english_grade");
				String street = result.getString("street");
				String city = result.getString("city");
				Student student = new Student(id, name, mathGrade, englishGrade, street, city);
				list.add(student);
				// i = i+1;
			}
			return list;
		} catch (Exception exc) {

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public void deleteStudent(Student s) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/project?" + "user=root&password=0616253284");
			preparedStatement = con.prepareStatement("delete from project.student where id = ? ");
			preparedStatement.setInt(1, s.getID());
			preparedStatement.executeUpdate();

			// int i=0;

		} catch (Exception exc) {

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void addstudent(Student s) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/project?" + "user=root&password=0616253284");
			preparedStatement = con
					.prepareStatement("insert into project.student (name,math_grade,english_grade,id) values(?,?,?,?) ");
			preparedStatement.setString(1, s.getName());
			preparedStatement.setDouble(2, s.getMath());
			preparedStatement.setDouble(3, s.getEnglish());
			preparedStatement.setInt(4, s.getID());
			preparedStatement.executeUpdate();

			// int i=0;

		} catch (Exception exc) {

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/project?" + "user=root&password=0616253284");
			preparedStatement = con.prepareStatement(
					"update project.student set math_grade = ?, english_grade = ?, id = ? where name =?  ");
			preparedStatement.setDouble(1, s.getMath());
			preparedStatement.setDouble(2, s.getEnglish());
			preparedStatement.setInt(3, s.getID());
			preparedStatement.setString(4, s.getName());
			preparedStatement.executeUpdate();

			// int i=0;

		} catch (Exception exc) {

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void updateStudentAddress(Student s) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/project?" + "user=root&password=0616253284");
			preparedStatement = con.prepareStatement(
					"update project.address set streetName = ?, city = ? where studentId = ? ");
			//preparedStatement.setDouble(1, s.getMath());
			//preparedStatement.setDouble(2, s.getEnglish());
			preparedStatement.setString(1, s.getStreet());
			preparedStatement.setString(2, s.getCity());
			preparedStatement.setInt(3, s.getID());
			preparedStatement.executeUpdate();

			// int i=0;

		} catch (Exception exc) {

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void addAddress(Student s) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/project?" + "user=root&password=0616253284");
			preparedStatement = con
					.prepareStatement("insert into project.address (streetName,city,studentId) values (?,?,?) ");
			preparedStatement.setString(1, s.getStreet());
			preparedStatement.setString(2, s.getCity());
			preparedStatement.setInt(3, s.getID());
			preparedStatement.executeUpdate();

			// int i=0;

		} catch (Exception exc) {

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}





}
