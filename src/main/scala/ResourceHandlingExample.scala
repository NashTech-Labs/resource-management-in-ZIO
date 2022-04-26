import zio._
import scala.io.Source

object ResourceHandlingExample extends ZIOAppDefault {

  // get file path to read from
  // for example I'm using resourcePath here, it could be anything, like a file or DB operation
  val filePath = getClass.getResource("/sampleFile.txt")

  val app = ZIO.acquireReleaseWith(
    // acquire effect
    ZIO.attemptBlocking(Source.fromURL(filePath))
  )(
    // Release effect
    file => ZIO.attempt(file.close()).orDie
  ){ // usage effect
    file =>
      ZIO.attemptBlocking(file.getLines().mkString("\n"))
  }

  override def run: ZIO[zio.ZEnv with Has[ZIOAppArgs], Any, Any] = for{
    content <- app
    _ <- Console.printLine(content)
  }yield()

}
