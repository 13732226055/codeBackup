#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server;

public interface ${artifactId} {
	public void function();
	public abstract String read(String key);
	public abstract int updata(String key);
}
