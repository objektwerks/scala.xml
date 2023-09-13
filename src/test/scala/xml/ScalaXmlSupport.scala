package xml

import java.io.StringReader
import javax.xml.XMLConstants
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.{Schema, SchemaFactory}

import scala.io.Source
import scala.util.Try
import scala.xml.{Node, NodeSeq, PrettyPrinter, XML}

trait ScalaXmlSupport:
  def loadXml(xmlClasspath: String): Try[Node] = Try {
    XML.load(getClass.getResource(xmlClasspath))
  }

  def loadRawXml(xmlClasspath: String): Try[String] = Try {
    Source.fromInputStream(getClass.getResourceAsStream(xmlClasspath)).mkString
  }

  def loadValidatedXml(xsdClasspath: String, xmlClasspath: String): Try[Node] =
    for
      schema <- loadSchema(xsdClasspath)
      xml    <- loadRawXml(xmlClasspath)
      _      = schema.newValidator.validate(new StreamSource(new StringReader(xml)))
      elem   = XML.loadString(xml)
    yield elem

  def loadSchema(xsdClasspath: String): Try[Schema] = Try {
    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(getClass.getResource(xsdClasspath))
  }

  def saveXml(fileName: String, node: Node): Try[Unit] = Try {
    XML.save(fileName, node, "UTF-8", xmlDecl = true, doctype = null)
  }

  def formatXml(nodeSeq: NodeSeq): String =
    val printer = new PrettyPrinter(width = 120, step = 2)
    nodeSeq.map(node => printer.format(node))
    nodeSeq.toString

  def isXmlValid(schema: Schema, node: Node): Boolean =
    try
      schema.newValidator.validate(new StreamSource(new StringReader(node.toString)))
      true
    catch case _: Throwable => false