package com.jdbc_v3.dao;

import com.jdbc_v3.Annotation.Column;
import com.jdbc_v3.Annotation.Id;
import com.jdbc_v3.Annotation.Table;
import com.jdbc_v3.Util.ReflectionUtil;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GeneralDao<T> {
	private ConnectionDao connectionDao;
	private Class<T> type;

	// Constructor to get the class type (e.g., Employee, Teacher, Student)
	public GeneralDao(Class<T> type) {
		this.type = type;
		this.connectionDao = new ConnectionDao();
	}

	// Abstract method to convert result set into the object
	public abstract T convertToObject(ResultSet rs) throws SQLException;

	// Save method (dynamically generates SQL insert based on annotations)
	public boolean save(T t) {
		String sql = generateInsertQuery(t);
		System.out.println(sql);
		return executeUpdate(sql, getFieldValues(t));
	}

	// Find by ID (dynamically generates SQL select query)
	public T findById(int id) {
		String tableName = getTableName();
		String idColumn = getIdColumnName();
		String sql = "SELECT * FROM " + tableName + " WHERE " + idColumn + "=?";
		return executeQuery(sql, id).get(0);
	}

	// Find all (dynamically generates SQL select query)
	public List<T> findAll() {
		String tableName = getTableName();
		String sql = "SELECT * FROM " + tableName;
		return executeQuery(sql);
	}

	// Update method (dynamically generates SQL update based on annotations)
	public boolean update(T t) {
		String sql = generateUpdateQuery(t);
		return executeUpdate(sql, getFieldValues(t));
	}

	// Delete by ID
	public boolean deleteById(int id) {
		String tableName = getTableName();
		String idColumn = getIdColumnName();
		String sql = "DELETE FROM " + tableName + " WHERE " + idColumn + "=?";
		return executeUpdate(sql, id);
	}

	// Get the table name from the @Table annotation
	private String getTableName() {
		Table table = type.getAnnotation(Table.class);
		if (table != null) {
			return table.name();
		} else {
			throw new RuntimeException("Table annotation not found in class " + type.getName());
		}
	}

	// Get the ID column name from the @Id annotation
	private String getIdColumnName() {
		for (Field field : type.getDeclaredFields()) {
			if (field.isAnnotationPresent(Id.class)) {
				Id idAnnotation = field.getAnnotation(Id.class);
				return idAnnotation.name();
			}
		}
		throw new RuntimeException("No field annotated with @Id in class " + type.getName());
	}

	// Execute SQL update (for insert, update, delete)
	protected boolean executeUpdate(String sql, Object... params) {
		try (Connection connection = connectionDao.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
			setParameters(stmt, params);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

	// Execute SQL query (for select)
	protected List<T> executeQuery(String sql, Object... params) {
		List<T> result = new ArrayList<>();
		try (Connection connection = connectionDao.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
			setParameters(stmt, params);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				result.add(convertToObject(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
	}

	// Set parameters for PreparedStatement
	private void setParameters(PreparedStatement stmt, Object... params) throws SQLException {
		int index = 1;
		System.out.println("Params: " + params.length);
		for (Object param : params) {
			System.out.println("Param " + index + ": " + param);
			stmt.setObject(index++, param);
		}
	}

	// Get field values using reflection and the @Column annotation
	private Object[] getFieldValues(T t) {
		List<Field> fields = ReflectionUtil.getAllFields(t.getClass());

		List<Object> values = new ArrayList<>();
		try {
			for (Field field : fields) {
				System.out.println("Field " + field.getName() + "");
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					System.out.println("Column " + column.name() + "");
					field.setAccessible(true);
					values.add(field.get(t));
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return values.toArray();
	}

	// Generate INSERT query using @Table and @Column annotations
	private String generateInsertQuery(T t) {
		StringBuilder query = new StringBuilder("INSERT INTO ");
		query.append(getTableName()).append(" (");

		Field[] fields = ReflectionUtil.getAllFields(t.getClass()).toArray(new Field[0]);
		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				query.append(column.name()).append(", ");
			}
		}
		query.delete(query.length() - 2, query.length()); // Remove last comma
		query.append(") VALUES (");

		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class)) {
				query.append("?, ");
			}
		}
		query.delete(query.length() - 2, query.length()); // Remove last comma
		query.append(")");
		return query.toString();
	}

	// Generate UPDATE query using @Table and @Column annotations
	private String generateUpdateQuery(T t) {
		StringBuilder query = new StringBuilder("UPDATE ");
		query.append(getTableName()).append(" SET ");

		Field[] fields = t.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				query.append(column.name()).append("=?, ");
			}
		}
		query.delete(query.length() - 2, query.length()); // Remove last comma
		query.append(" WHERE ").append(getIdColumnName()).append("=?");
		return query.toString();
	}
}
