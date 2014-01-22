package controllers

import play.api._
import play.api.mvc._
import com.tristanhunt.knockoff.DefaultDiscounter._
import com.tristanhunt.knockoff._

case class Quiz(val id: Long, val questions: Seq[Question])
case class Question(val text: String, val suggestions: Seq[Suggestion], explaination: Option[String], checkbox: Boolean)
case class Suggestion(val id: Long, val text: String, answer: Boolean)
case class Answer(val question: Int, suggestion: Int, marked: Boolean)
case class Session(val answers: Seq[Answer])

object Application extends Controller {

  implicit val codec = scala.io.Codec.UTF8

  def index = Action {
    Ok(views.html.index(title, titlePage, questions))
  }

  def question(qid: Int, answer: Seq[String]) = Action { implicit request =>
    val answers = request.queryString.getOrElse("answer", List()) map (_.toInt)
    if (answers.isEmpty)
      Ok(views.html.question(title, questions, qid))
    else {
      val correct = questions(qid).suggestions filter(_.answer) map(_.id) equals(answers)
      Ok(views.html.answer(title, questions, qid, answers, correct))      
    }
  }

  def questionAnswer(qid: Int, aid: Int) = Action {
    Ok(views.html.index(title, titlePage, questions))
  }

  def presentation = Action {
    val random = scala.util.Random.shuffle(questions.toList)
    Ok(views.html.presentation(title, titlePage, questions))
  }

  import Play.current

  val QUIZ_DESCRIPTION_REGEX = """^# ([^#])*""".r
  val QUESTIONS_REGEX = """(?s)## ([^#])*""".r
  val SUGGESTIONS_REGEX = """(?s)[☐☒☑]([^☐☒☑])*""".r
  val PREFIXES = "[☐☒☑]"
  val ANSWER = "☒☑"
  val EXPLAINATION_SEP = "---"

  def isCheckbox(source: String) =
    source.contains("☑")

  val source = for {
    quizFile <- Play.current.configuration.getString("quiz.file")
    is <- Play.application.resourceAsStream(quizFile)
    text <- scala.util.Try(scala.io.Source.fromInputStream(is).mkString("")).toOption
  } yield text

  val titlePage = QUIZ_DESCRIPTION_REGEX findFirstIn (source.getOrElse("")) map (toHtml(_)) getOrElse ("Quiz")
  val title = titlePage.replaceAll("</?[^>]*>", "")

  val questions = source.getOrElse("").split("\n##") drop(1) map { split =>
    val questionSource = if (split.startsWith("##")) split else s"##$split"
    val parts = questionSource.split(EXPLAINATION_SEP)
    val suggestionsSource = SUGGESTIONS_REGEX findAllIn (parts(0)) toList
    val question = toHtml(questionSource.split(PREFIXES)(0))
    val suggestionIds = (0 to suggestionsSource.length).iterator
    val suggestions = suggestionsSource map { suggestionSource =>
      val answer = ANSWER.contains(suggestionSource.charAt(0))
      Suggestion(suggestionIds.next, toHtml(suggestionSource.substring(1)), answer)
    } toList

    val explaination =
      if (parts.length > 1)
        Some(toHtml(parts(1)))
      else
        None

    Question(question, suggestions, explaination, isCheckbox(questionSource))
  } toList

  def toHtml(markdown: String) = {
    val fragments = markdown.split("```")
    (0 to fragments.length).zip(fragments).map { fragment =>
      val input = fragment._2
      if (fragment._1 % 2 == 0)
        markdownToHtml(input)
      else {
        val langEnd = input.indexOf("\n")
        val (lang, code) =
          if (langEnd > 0) (input.substring(0, langEnd), input.substring(langEnd + 1))
          else ("", input)
        s"<pre><code data-trim contenteditable class='$lang'>$code</code></pre>"
      }
    }.mkString
  }

  def markdownToHtml(markdown: String) =
    toXHTML(knockoff(markdown)).toString.replace("<pre><code>", "<pre><code data-trim contenteditable>")
}
