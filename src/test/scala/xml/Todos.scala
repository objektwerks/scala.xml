package xml

import java.io.StringReader

import javax.xml.transform.stream.StreamSource
import javax.xml.validation.Schema

import scala.util.Try
import scala.xml.{Elem, PrettyPrinter, XML}

case class Name(value: String)
case class Task(value: String)
case class Todo(name: Name, task: Task)
case class Todos(values: Seq[Todo])

object Todos {
  def loadXml(resource: String): Elem = XML.load(getClass.getResource(resource))

  def validateXml(schema: Schema, todos: Elem): Try[Unit] = Try {
    schema.newValidator.validate(new StreamSource(new StringReader(todos.toString)))
  }

  def fromXml(todos: Elem): Todos = Todos {
    (todos \\ "todo").map { todo =>
      val name = Name( (todo \\ "name").text )
      val task = Task( (todo \\ "task").text )
      Todo(name, task)
    }
  }

  def toXml(todos: Todos): Elem =
    <todos> { todos.values.map { todo =>
      <todo>
        <name>{todo.name.value}</name>
        <task>{todo.task.value}</task>
      </todo> } }
    </todos>

  def format(todos: Elem): String = new PrettyPrinter(80, 2).format(todos)
}