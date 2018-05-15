package xml

import java.io.StringReader

import javax.xml.transform.stream.StreamSource
import javax.xml.validation.SchemaFactory
import org.scalatest.{FunSuite, Matchers}

import scala.xml.XML

class ScalaXmlTest extends FunSuite with Matchers {
  test("validate") {
    val factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema")
    val schema = factory.newSchema(getClass.getResource("/todo.xsd"))
    val validator = schema.newValidator()
    val xml = XML.load(getClass.getResource("/todo.xml")).toString
    println(xml)
    validator.validate(new StreamSource(new StringReader(xml)))
  }
}