package xml

import java.io.StringReader

import javax.xml.transform.stream.StreamSource
import javax.xml.validation.Schema

import scala.util.Try
import scala.xml.{Elem, PrettyPrinter, XML}

trait XmlSupport {
  def loadXml(resource: String): Elem = XML.load(getClass.getResource(resource))

  def saveXml(fileName: String, elem: Elem): Try[Unit] = Try { XML.save(fileName, elem) }

  def validateXml(schema: Schema, elem: Elem): Try[Unit] = Try {
    schema.newValidator.validate(new StreamSource(new StringReader(elem.toString)))
  }

  def formatXml(elem: Elem): String = new PrettyPrinter(80, 2).format(elem)
}