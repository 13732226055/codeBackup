#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.spring.server;

public class ${artifactId}service {
	private ${artifactId} ms;
	public ${artifactId}service(){}
	public void set${artifactId}(${artifactId} ms){
		this.ms = ms;		
	}
	public ${artifactId} get${artifactId}(){
		return this.ms;
	}
}
