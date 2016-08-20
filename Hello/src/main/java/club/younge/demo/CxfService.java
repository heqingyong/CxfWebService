package club.younge.demo;

import java.util.List;
import java.util.Vector;

import javax.jws.WebService;


//@WebService(name = "Hello", targetNamespace = "http://www.younge.club/demo", serviceName = "Hello", portName="HelloServicePort")
//@WebService标签主要将类暴露为WebService，其中targetNamespace属性定义了自己的命名空间，
//serviceName则定义了< definitions >标签和<service>标签的name属性。
//@SOAPBinding(style = SOAPBinding.Style.RPC)
//@SOAPBinding标签定义了WSDL文档中SOAP的消息协议，其中style属性对应SOAP的文档类型，可选的有RPC和DOCUMENT
@WebService
public class CxfService implements ICxfService {

	static List<Student> repository= new Vector<Student>();
	public void add(Student student) {
		repository.add(student);
	}

	public Student[] findStudents() {
		Student[] users= new Student[repository.size()];
		repository.toArray(users);
		return users;
	}

}
