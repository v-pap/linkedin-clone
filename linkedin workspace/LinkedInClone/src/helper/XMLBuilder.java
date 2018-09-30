package helper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import model.Professional;
public class XMLBuilder {

	public String createXML(Professional prof) throws JsonProcessingException
	{
		  XmlMapper xmlMapper = new XmlMapper();
		  return xmlMapper.writeValueAsString(prof);
	}
	
}
