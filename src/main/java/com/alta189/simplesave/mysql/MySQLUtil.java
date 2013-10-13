/*
 * This file is part of SimpleSave
 *
 * SimpleSave is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SimpleSave is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.alta189.simplesave.mysql;

import java.io.Serializable;
import java.sql.Timestamp;

public class MySQLUtil {
	public static String getMySQLTypeFromClass(Class<?> clazz) {
		if (clazz.equals(int.class) || clazz.equals(Integer.class)) {
			return "INT";
		} else if (clazz.equals(long.class) || clazz.equals(Long.class)) {
			return "BIGINT";
		} else if (clazz.equals(double.class) || clazz.equals(Double.class)) {
			return "DOUBLE";
		} else if (clazz.equals(String.class)) {
			return "TEXT";
		} else if (clazz.equals(boolean.class) || clazz.equals(Boolean.class)) {
			return "TINYINT";
		} else if (clazz.equals(short.class) || clazz.equals(Short.class)) {
			return "SMALLINT";
		} else if (clazz.equals(float.class) || clazz.equals(Float.class)) {
			return "FLOAT";
		} else if (clazz.equals(byte.class) || clazz.equals(Byte.class)) {
			return "TINYINT";
		} else if (clazz.equals(Timestamp.class)) {
			return "BIGINT";
		}
		Class<?> checkclazz = clazz;
		while (checkclazz!=null){
			for (Class<?> i : checkclazz.getInterfaces())
				if (i.equals(Serializable.class))
					return "BLOB";
			checkclazz = checkclazz.getSuperclass();
		}
		return null;
	}
}
