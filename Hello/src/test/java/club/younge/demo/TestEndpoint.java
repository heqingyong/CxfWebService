package club.younge.demo;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

public class TestEndpoint {

	private static final String ADDRESS = "http://localhost:9000/hello";
	private static final String JETTY_DEPLOY_ADDRESS ="http://localhost:8080/demo/services/cxfService";

	@Test
	public void publish() throws Exception {

		System.out.println("Starting Server");
		CxfService demo = new CxfService();
		Endpoint.publish(ADDRESS, demo);
		System.out.println("Start success");
	}
	
	//Run as Java Application
	//http://localhost:9000/hello/CxfService?wsdl
	public static void main(String[] args) {
		System.out.println("Starting Server");
		CxfService demo = new CxfService();
		Endpoint.publish(ADDRESS, demo);
		System.out.println("Start success");
	}
	
	//编译时注释此段代码，因为编译时publish运行后即刻停止，测试会产生连接拒绝异常
	//请结合使用上面的main()测试无容器发布情况，双击方法Run as JUnit Test,运行时注意去掉@Test前面的双斜杠
	//@Test
	public void testClient() {

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(ICxfService.class);
		factory.setAddress(ADDRESS);
		ICxfService client = (ICxfService) factory.create();
		Student student = new Student();
		student.setNumberAndName("11", "Younge");
		client.add(student);
		student.setNumberAndName("12", "Haha");
		client.add(student);
		Student[] students = client.findStudents();
		for (int i = 0, l = students.length; i < l; i++) {
			System.out.println(students[i]);
		}
	}
	
	//编译时注释此段代码，因为编译时Jetty容器还未启动，测试产生连接拒绝异常
	//容器启动后可以双击方法Run as JUnit Test ,运行时注意去掉@Test前面的双斜杠
	//@Test
	public void testJettyClient() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(ICxfService.class);
		factory.setAddress(JETTY_DEPLOY_ADDRESS);
		ICxfService client = (ICxfService) factory.create();
		Student student = new Student();
		student.setNumberAndName("11", "Youngee");
		client.add(student);
		student.setNumberAndName("12", "Hahaa");
		client.add(student);
		Student[] students = client.findStudents();
		for (int i = 0, l = students.length; i < l; i++) {
			System.out.println(students[i]);
		}
	}

}
