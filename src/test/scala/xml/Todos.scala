package xml

import scala.xml.Elem

case class Name(value: String)
case class Task(value: String)
case class Todo(name: Name, task: Task)
case class Todos(values: Seq[Todo])

object Todos extends XmlSupport {
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
}