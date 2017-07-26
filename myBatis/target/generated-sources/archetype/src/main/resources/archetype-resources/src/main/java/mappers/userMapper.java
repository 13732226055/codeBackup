#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.mappers;

import ${package}.model.*;

public interface userMapper {
	public User selectUserById(int id);
}
