package raytracer

import raytracer.shape.Sphere

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color._

object Main extends JFXApp {

  val WIDTH = 640
  val HEIGHT = 480

  val canvas = new Canvas(WIDTH, HEIGHT)
  val gc = canvas.getGraphicsContext2D()

  stage = new JFXApp.PrimaryStage {
    title.value = "Ray Tracer"
    width = WIDTH
    height = HEIGHT
    scene = new Scene {
      fill = Gray
      content = canvas
    }
  }

  def shapes = List(Sphere(Point(320, 240, 0), 100))

  def rayTrace(): Unit = {
    println("rayTrace begin")
    def z = Vector(0, 0, -1)
    val start = System.currentTimeMillis()
    for (x <- 0 to WIDTH) {
      for (y <- 0 to HEIGHT) {
        shapes.foreach(s => {
          def color = s.intersect(Ray(Point(x, y, -10), z))
          if (color != null) gc.getPixelWriter().setColor(x, y, color)
        }
        )
      }
    }
    println(
      "rayTrace finished in " + (System.currentTimeMillis() - start) + "ms")
  }

  rayTrace()

}
