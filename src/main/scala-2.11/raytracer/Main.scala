package raytracer

import raytracer.shape.Sphere

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color
import scalafx.scene.paint.Color._

object Main extends JFXApp {

  val WIDTH = 640
  val HEIGHT = 480

  val canvas = new Canvas(WIDTH, HEIGHT)
  val gc = canvas.getGraphicsContext2D

  stage = new JFXApp.PrimaryStage {
    title.value = "Ray Tracer"
    width = WIDTH
    height = HEIGHT
    scene = new Scene {
      fill = Black
      content = canvas
    }
  }

  def shapes = List(Sphere(Point(320, 240, 100), 100, DarkMagenta), Sphere(Point(100, 100, -5), 20, DarkOliveGreen),
    Sphere(Point(400, 100, -5), 40, DarkBlue))

  val demoShapes = List(Sphere(Point(150, 200, 10), 50, Color.DarkOliveGreen),
    Sphere(Point(200, 300, 50), 60, Color.Blue),
    Sphere(Point(400, 100, 100), 75, Color.Coral))


  def rayTrace(): Unit = {
    println("rayTrace begin")
    def z = Vector(0, 0, 1)
    val start = System.currentTimeMillis()
    for (x <- 0 to WIDTH) {
      for (y <- 0 to HEIGHT) {
        demoShapes.foreach(s => {
          def color = s.intersect(Ray(Point(x, y, -10), z))
          if (color != null) gc.getPixelWriter.setColor(x, y, color)
        }
        )
      }
    }
    println(
      "rayTrace finished in " + (System.currentTimeMillis() - start) + "ms")
  }

  rayTrace()

}
