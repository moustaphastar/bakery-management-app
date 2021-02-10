/**
 * Provides the classes necessary to convert a domain model class's
 * enum typed property value from enum value to its constant to read
 * from database and assign to property and from enum constant to its
 * value to persist to database.
 * <p>
 * Enum values are of String type and the corresponding database
 * column's data type is char(1).
 *
 * <p>
 * These classes implement javax.persistence.AttributeConverter interface.
 *
 * @author Moustapha Star
 * @version 1.0
 * @since 1.0
 */
// todo: char(1) can store only 10 numeric values. Consider another approach.
package com.bakery.management.enums.converters;
